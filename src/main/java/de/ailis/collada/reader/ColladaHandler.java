/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.reader;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sun.xml.internal.ws.wsdl.writer.document.ParamType;

import de.ailis.collada.builders.EffectInstanceBuilder;
import de.ailis.collada.builders.MaterialBuilder;
import de.ailis.collada.model.Document;
import de.ailis.collada.model.Geometry;
import de.ailis.collada.model.Image;
import de.ailis.collada.model.ImageLibrary;
import de.ailis.collada.model.ImageSource;
import de.ailis.collada.model.MaterialLibrary;
import de.ailis.collada.model.Primitives;
import de.ailis.collada.model.SharedInput;
import de.ailis.collada.model.Triangles;
import de.ailis.collada.model.UnsharedInput;
import de.ailis.collada.model.Vertices;
import de.ailis.collada.model.VisualScene;


/**
 * SAX Parser Handler for reading a Document XML file.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ColladaHandler extends DefaultHandler
{
    /** The current parser mode */
    private ParserMode mode = ParserMode.ROOT;

    /** The parser mode stack */
    private final Stack<ParserMode> modeStack = new Stack<ParserMode>();

    /** String Builder for building a string from element content */
    private StringBuilder stringBuilder;

    /** The asset */
    private final Document document;

    /** The current image */
    private Image image;

    /** The current material */
    private ColladaMaterial material;

    /** The current effect */
    private Effect effect;

    /** The current common profile */
    private CommonEffectProfile commonProfile;

    /** The current common technique */
    private CommonTechnique commonTechnique;

    /** The current phong shading information */
    private Phong phong;

    /** The current shading information */
    private Shading shading;

    /** The current color or texture */
    private ColorOrTexture colorOrTexture;

    /** The current geometry id */
    private String geometryId;

    /** The current mesh */
    private ColladaMesh mesh;

    /** The current geometry */
    private Geometry geometry;

    /** The current data source */
    private DataSource dataSource;

    /** The current sampler */
    private ColladaSampler sampler;

    /** The current data array */
    private DataArray dataArray;

    /** The chunk float reader */
    private ChunkFloatReader chunkFloatReader;

    /** The chunk string reader */
    private ChunkStringReader chunkStringReader;

    /** The chunk int reader */
    private ChunkIntReader chunkIntReader;

    /** The current vertices */
    private Vertices vertices;

    /** The current polygons */
    private Polygons polygons;

    /** The current primitives */
    private Primitives primitives;

    /** The current polygons index */
    private int polygonsIndex;

    /** The current polygon indices */
    private int[][] polygonsIndices;

    /** The current triangles */
    private Triangles triangles;

    /** The int array builder */
    private List<Integer> intArrayBuilder;

    /** The current light id */
    private String lightId;

    /** The current light */
    private ColladaLight light;

    /** The current camera */
    private ColladaCamera camera;

    /** The current optic */
    private Optic optic;

    /** The current perspective optic */
    private PerspectiveOptic perspectiveOptic;

    /** The current visual scene */
    private VisualScene visualScene;

    /** The node stack */
    private Stack<Node> nodeStack;

    /** The current node */
    private Node node;

    /** The current accessor */
    private Accessor accessor;

    /** The animation stack */
    private Stack<ColladaAnimation> animationStack;

    /** The current animation */
    private ColladaAnimation animation;

    /** The current matrix transformation */
    private MatrixTransformation matrixTransformation;

    /** The current translate transformation */
    private TranslateTransformation translateTransformation;

    /** The current instance geometry */
    private InstanceGeometry instanceGeometry;

    /** The current instance material */
    private InstanceMaterial instanceMaterial;

    /** The current instance geometry */
    private InstanceLight instanceLight;

    /** The current instance camera */
    private InstanceCamera instanceCamera;

    /** The current scene */
    private ColladaScene scene;

    /** The current parameter id */
    private String paramId;

    /** The current profile param */
    private ProfileParam profileParam;

    private ImageLibrary imageLibrary;

    private MaterialLibrary materialLibrary;

    private MaterialBuilder materialBuilder;

    private EffectInstanceBuilder effectInstanceBuilder;


    /**
     * Constructs a new parser.
     */

    public ColladaHandler()
    {
        this.document = new Document();
    }


    /**
     * @see DefaultHandler#startElement(String, String, String, Attributes)
     */

    @Override
    public void startElement(final String uri, final String localName,
            final String qName, final Attributes attributes)
            throws SAXException
    {
        switch (this.mode)
        {
            case ROOT:
                if (localName.equals("Document"))
                    enterElement(ParserMode.COLLADA);
                break;

            case COLLADA:
                if (localName.equals("library_images"))
                    enterLibraryImages(attributes);
                else if (localName.equals("library_materials"))
                    enterLibraryMaterials(attributes);
                else if (localName.equals("library_effects"))
                    enterElement(ParserMode.LIBRARY_EFFECTS);
                else if (localName.equals("library_geometries"))
                    enterElement(ParserMode.LIBRARY_GEOMETRIES);
                else if (localName.equals("library_animations"))
                    enterElement(ParserMode.LIBRARY_ANIMATIONS);
                else if (localName.equals("library_lights"))
                    enterElement(ParserMode.LIBRARY_LIGHTS);
                else if (localName.equals("library_cameras"))
                    enterElement(ParserMode.LIBRARY_CAMERAS);
                else if (localName.equals("library_visual_scenes"))
                    enterElement(ParserMode.LIBRARY_VISUAL_SCENES);
                else if (localName.equals("scene")) enterScene();
                break;

            case LIBRARY_IMAGES:
                if (localName.equals("image")) enterImage(attributes);
                break;

            case IMAGE:
                if (localName.equals("init_from"))
                    enterElement(ParserMode.IMAGE_INIT_FROM);
                break;

            case IMAGE_INIT_FROM:
                if (localName.equals("ref")) enterImageInitFromRef();
                break;

            case LIBRARY_MATERIALS:
                if (localName.equals("material")) enterMaterial(attributes);
                break;

            case MATERIAL:
                if (localName.equals("instance_effect"))
                    enterInstanceEffect(attributes);
                break;

            case LIBRARY_EFFECTS:
                if (localName.equals("effect")) enterEffect(attributes);
                break;

            case EFFECT:
                if (localName.equals("profile_COMMON")) enterProfileCommon();
                break;

            case PROFILE_COMMON:
                if (localName.equals("technique"))
                    enterTechniqueCommon(attributes);
                else if (localName.equals("newparam"))
                    enterNewParam(attributes);
                break;

            case NEWPARAM:
                if (localName.equals("sampler2D"))
                    enterSampler2D();
                else if (localName.equals("surface"))
                    enterSurface();
                break;

            case SURFACE:
                if (localName.equals("init_from"))
                    enterSurfaceInitFrom();
                break;

            case SAMPLER2D:
                if (localName.equals("source"))
                    enterSampler2DSource();
                else if (localName.equals("minfilter"))
                    enterSampler2DMinFilter();
                else if (localName.equals("magfilter"))
                    enterSampler2DMagFilter();
                break;

            case TECHNIQUE_COMMON:
                if (localName.equals("phong")) enterPhong();
                break;

            case PHONG:
                if (localName.equals("emission"))
                    enterElement(ParserMode.EMISSION);
                else if (localName.equals("ambient"))
                    enterElement(ParserMode.AMBIENT);
                else if (localName.equals("diffuse"))
                    enterElement(ParserMode.DIFFUSE);
                else if (localName.equals("specular"))
                    enterElement(ParserMode.SPECULAR);
                else if (localName.equals("reflective"))
                    enterElement(ParserMode.REFLECTIVE);
                else if (localName.equals("transparent"))
                    enterElement(ParserMode.TRANSPARENT);
                else if (localName.equals("reflectivity"))
                    enterElement(ParserMode.REFLECTIVITY);
                else if (localName.equals("shininess"))
                    enterElement(ParserMode.SHININESS);
                else if (localName.equals("transparency"))
                    enterElement(ParserMode.TRANSPARENCY);
                else if (localName.equals("index_of_refraction"))
                    enterElement(ParserMode.INDEX_OF_REFRACTION);
                break;

            case REFLECTIVITY:
            case TRANSPARENCY:
            case SHININESS:
            case INDEX_OF_REFRACTION:
                if (localName.equals("float")) enterFloat();
                break;

            case EMISSION:
            case AMBIENT:
            case DIFFUSE:
            case SPECULAR:
            case REFLECTIVE:
            case TRANSPARENT:
                if (localName.equals("color"))
                    enterShadingColor();
                else if (localName.equals("texture")) enterTexture(attributes);
                break;

            case LIBRARY_GEOMETRIES:
                if (localName.equals("geometry")) enterGeometry(attributes);
                break;

            case GEOMETRY:
                if (localName.equals("mesh")) enterMesh();
                break;

            case MESH:
                if (localName.equals("source"))
                    enterMeshDataSource(attributes);
                else if (localName.equals("vertices"))
                    enterVertices(attributes);
                else if (localName.equals("polygons"))
                    enterPolygons(attributes);
                else if (localName.equals("triangles"))
                    enterTriangles(attributes);
                break;

            case MESH_DATA_SOURCE:
            case ANIMATION_DATA_SOURCE:
                if (localName.equals("float_array"))
                    enterFloatArray(attributes);
                else if (localName.equals("Name_array"))
                    enterNameArray(attributes);
                if (localName.equals("technique_common"))
                    enterElement(ParserMode.SOURCE_TECHNIQUE_COMMON);
                break;

            case SOURCE_TECHNIQUE_COMMON:
                if (localName.equals("accessor"))
                    enterAccessor(attributes);
                break;

            case ACCESSOR:
                if (localName.equals("param"))
                    enterParam(attributes);
                break;

            case VERTICES:
                if (localName.equals("input")) enterVerticesInput(attributes);
                break;

            case POLYGONS:
                if (localName.equals("p"))
                    enterPolygonsP();
                else if (localName.equals("input"))
                    enterPrimitivesInput(attributes);
                break;

            case TRIANGLES:
                if (localName.equals("p"))
                    enterElement(ParserMode.TRIANGLES_P);
                else if (localName.equals("input"))
                    enterPrimitivesInput(attributes);
                break;

            case LIBRARY_ANIMATIONS:
                if (localName.equals("animation")) enterAnimation(attributes);
                break;

            case ANIMATION:
                if (localName.equals("source"))
                    enterAnimationDataSource(attributes);
                else if (localName.equals("animation"))
                    enterAnimation(attributes);
                else if (localName.equals("sampler"))
                    enterSampler(attributes);
                else if (localName.equals("channel"))
                    enterChannel(attributes);
                break;

            case SAMPLER:
                if (localName.equals("input")) enterSamplerInput(attributes);
                break;

            case LIBRARY_LIGHTS:
                if (localName.equals("light")) enterLight(attributes);
                break;

            case LIGHT:
                if (localName.equals("technique_common"))
                    enterElement(ParserMode.LIGHT_TECHNIQUE_COMMON);
                break;

            case LIGHT_TECHNIQUE_COMMON:
                if (localName.equals("directional"))
                    enterDirectional();
                else if (localName.equals("point"))
                    enterPoint();
                else if (localName.equals("ambient"))
                    enterAmbient();
                else if (localName.equals("spot")) enterSpot();
                break;

            case LIGHT_AMBIENT:
            case LIGHT_POINT:
            case LIGHT_DIRECTIONAL:
                if (localName.equals("color")) enterLightColor();
                break;

            case LIGHT_SPOT:
                if (localName.equals("color"))
                    enterLightColor();
                else if (localName.equals("falloff_angle"))
                    enterFalloffAngle();
                break;

            case LIBRARY_CAMERAS:
                if (localName.equals("camera")) enterCamera(attributes);
                break;

            case CAMERA:
                if (localName.equals("optics"))
                    enterElement(ParserMode.OPTICS);
                break;

            case OPTICS:
                if (localName.equals("technique_common"))
                    enterElement(ParserMode.OPTICS_TECHNIQUE_COMMON);
                break;

            case OPTICS_TECHNIQUE_COMMON:
                if (localName.equals("perspective")) enterPerspective();
                break;

            case PERSPECTIVE:
                if (localName.equals("xfov"))
                    enterPerspectiveValue(ParserMode.XFOV);
                else if (localName.equals("yfov"))
                    enterPerspectiveValue(ParserMode.YFOV);
                else if (localName.equals("aspect_ratio"))
                    enterPerspectiveValue(ParserMode.ASPECT_RATIO);
                else if (localName.equals("znear"))
                    enterPerspectiveValue(ParserMode.ZNEAR);
                else if (localName.equals("zfar"))
                    enterPerspectiveValue(ParserMode.ZFAR);
                break;

            case LIBRARY_VISUAL_SCENES:
                if (localName.equals("visual_scene"))
                    enterVisualScene(attributes);
                break;

            case VISUAL_SCENE:
                if (localName.equals("node")) enterVisualSceneNode(attributes);
                break;

            case NODE:
            case VISUAL_SCENE_NODE:
                if (localName.equals("matrix"))
                    enterMatrix();
                else if (localName.equals("translate"))
                    enterTranslate();
                else if (localName.equals("node"))
                    enterNode(attributes);
                else if (localName.equals("instance_geometry"))
                    enterInstanceGeometry(attributes);
                else if (localName.equals("instance_light"))
                    enterInstanceLight(attributes);
                else if (localName.equals("instance_camera"))
                    enterInstanceCamera(attributes);
                break;

            case INSTANCE_GEOMETRY:
                if (localName.equals("bind_material"))
                    enterElement(ParserMode.BIND_MATERIAL);
                break;

            case BIND_MATERIAL:
                if (localName.equals("technique_common"))
                    enterElement(ParserMode.BIND_MATERIAL_TECHNIQUE_COMMON);
                break;

            case BIND_MATERIAL_TECHNIQUE_COMMON:
                if (localName.equals("instance_material"))
                    enterInstanceMaterial(attributes);
                break;

            case SCENE:
                if (localName.equals("instance_visual_scene"))
                    enterInstanceVisualScene(attributes);
                break;

            default:
                // Ignored
        }
    }

    /**
     * @see DefaultHandler#endElement(String, String, String)
     */

    @Override
    public void endElement(final String uri, final String localName,
            final String qName) throws SAXException
    {
        // Ignore element when it is not the one we are currently watching
        if (!localName.equals(this.mode.getTagName())) return;

        switch (this.mode)
        {
            case IMAGE_INIT_FROM_REF:
                leaveImageInitFromRef();
                break;

            case IMAGE:
                leaveImage();
                break;

            case LIBRARY_IMAGES:
                leaveLibraryImages();
                break;

            case MATERIAL:
                leaveMaterial();
                break;

            case LIBRARY_MATERIALS:
                leaveLibraryMaterials();
                break;

            case SHADING_COLOR:
                leaveShadingColor();
                break;

            case SHININESS:
            case REFLECTIVITY:
            case TRANSPARENCY:
            case INDEX_OF_REFRACTION:
                leaveShadingFloat();
                break;

            case EMISSION:
            case AMBIENT:
            case DIFFUSE:
            case SPECULAR:
            case REFLECTIVE:
            case TRANSPARENT:
                leaveColorOrTexture();
                break;

            case PHONG:
                leavePhong();
                break;

            case TECHNIQUE_COMMON:
                leaveTechniqueCommon();
                break;

            case SAMPLER2D_MAGFILTER:
                leaveSampler2DMagFilter();
                break;

            case SAMPLER2D_MINFILTER:
                leaveSampler2DMinFilter();
                break;

            case SAMPLER2D_SOURCE:
                leaveSampler2DSource();
                break;

            case SURFACE_INIT_FROM:
                leaveSurfaceInitFrom();
                break;

            case NEWPARAM:
                leaveNewParam();
                break;

            case PROFILE_COMMON:
                leaveProfileCommon();
                break;

            case EFFECT:
                leaveEffect();
                break;

            case FLOAT_ARRAY:
                leaveFloatArray();
                break;

            case NAME_ARRAY:
                leaveNameArray();
                break;

            case ACCESSOR:
                leaveAccessor();
                break;

            case MESH_DATA_SOURCE:
                leaveMeshDataSource();
                break;

            case VERTICES:
                leaveVertices();
                break;

            case TRIANGLES:
                leaveTriangles();
                break;

            case POLYGONS_P:
                leavePolygonsP();
                break;

            case POLYGONS:
                leavePolygons();
                break;

            case MESH:
                leaveMesh();
                break;

            case GEOMETRY:
                leaveGeometry();
                break;

            case ANIMATION_DATA_SOURCE:
                leaveAnimationDataSource();
                break;

            case SAMPLER:
                leaveSampler();
                break;

            case ANIMATION:
                leaveAnimation();
                break;

            case LIGHT_COLOR:
                leaveLightColor();
                break;

            case FALLOFF_ANGLE:
                leaveFalloffAngle();
                break;

            case LIGHT:
                leaveLight();
                break;

            case CAMERA:
                leaveCamera();
                break;

            case XFOV:
                leaveXfov();
                break;

            case YFOV:
                leaveYfov();
                break;

            case ASPECT_RATIO:
                leaveAspectRatio();
                break;

            case ZFAR:
                leaveZfar();
                break;

            case ZNEAR:
                leaveZnear();
                break;

            case OPTICS:
                leaveOptics();
                break;

            case INSTANCE_MATERIAL:
                leaveInstanceMaterial();
                break;

            case MATRIX:
                leaveMatrix();
                break;

            case TRANSLATE:
                leaveTranslate();
                break;

            case INSTANCE_GEOMETRY:
                leaveInstanceGeometry();
                break;

            case INSTANCE_LIGHT:
                leaveInstanceLight();
                break;

            case INSTANCE_CAMERA:
                leaveInstanceCamera();
                break;

            case NODE:
                leaveNode();
                break;

            case VISUAL_SCENE_NODE:
                leaveVisualSceneNode();
                break;

            case VISUAL_SCENE:
                leaveVisualScene();
                break;

            case SCENE:
                leaveScene();
                break;

            default:
                leaveElement();
        }
    }


    /**
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */

    @Override
    public void characters(final char[] ch, final int start, final int length)
            throws SAXException
    {
        switch (this.mode)
        {
            case XFOV:
            case YFOV:
            case ASPECT_RATIO:
            case ZNEAR:
            case ZFAR:
            case LIGHT_COLOR:
            case SHADING_COLOR:
            case FLOAT:
            case IMAGE_INIT_FROM:
            case FALLOFF_ANGLE:
            case SURFACE_INIT_FROM:
            case SAMPLER2D_MAGFILTER:
            case SAMPLER2D_SOURCE:
            case SAMPLER2D_MINFILTER:
                this.stringBuilder.append(ch, start, length);
                break;

            case FLOAT_ARRAY:
            case MATRIX:
            case TRANSLATE:
                this.chunkFloatReader.addChunk(ch, start, length);
                break;

            case NAME_ARRAY:
                this.chunkStringReader.addChunk(ch, start, length);
                break;

            case POLYGONS_P:
            case TRIANGLES_P:
                this.chunkIntReader.addChunk(ch, start, length);
                break;

            default:
                // Ignored
        }
    }


    /**
     * Enters an element and sets the specified parser mode. The old parser mode
     * is pushed to the mode stack.
     *
     * @param newParserMode
     *            The new parser mode to set
     */

    private void enterElement(final ParserMode newParserMode)
    {
        this.modeStack.push(this.mode);
        this.mode = newParserMode;
    }


    /**
     * Leaves the current element. Pops the previous parser mode from the mode
     * stack and sets it as the current mode
     */

    private void leaveElement()
    {
        this.mode = this.modeStack.pop();
    }


    /**
     * Returns the parsed Document document.
     *
     * @return The parsed Document document
     */

    public Document getDocument()
    {
        if (this.mode != ParserMode.ROOT)
            throw new IllegalStateException("Internal parser error");
        return this.document;
    }


    /**
     * Enters a library_images element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterLibraryImages(final Attributes attributes)
    {
        this.imageLibrary = new ImageLibrary();
        final String name = attributes.getValue("name");
        final String id = attributes.getValue("id");
        if (name != null) this.imageLibrary.setName(name);
        if (id != null) this.imageLibrary.setId(id);
        enterElement(ParserMode.LIBRARY_IMAGES);
    }


    /**
     * Enters a image element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterImage(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.image = new Image();
        if (id != null) this.image.setId(id);
        enterElement(ParserMode.IMAGE);
    }


    /**
     * Enters image init_from element.
     */

    private void enterImageInitFromRef()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.IMAGE_INIT_FROM_REF);
    }


    /**
     * Leaves image init_from element.
     */

    private void leaveImageInitFromRef()
    {
        final String text = this.stringBuilder.toString();
        try
        {
            this.image.setSource(new ImageSource(new URI(text)));
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(text + " is not a valid URI: " + e, e);
        }
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Leaves an image element.
     */

    private void leaveImage()
    {
        this.imageLibrary.getImages().add(this.image);
        this.image = null;
        leaveElement();
    }


    /**
     * Leaves a library_images element.
     */

    private void leaveLibraryImages()
    {
        this.document.getImageLibraries().add(this.imageLibrary);
        this.imageLibrary = null;
    }


    /**
     * Enters a library_images element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterLibraryMaterials(final Attributes attributes)
    {
        this.materialLibrary = new MaterialLibrary();
        final String name = attributes.getValue("name");
        final String id = attributes.getValue("id");
        if (name != null) this.materialLibrary.setName(name);
        if (id != null) this.materialLibrary.setId(id);
        enterElement(ParserMode.LIBRARY_MATERIALS);
    }


    /**
     * Enters a material element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterMaterial(final Attributes attributes)
    {
        this.materialBuilder = new MaterialBuilder();
        this.materialBuilder.setId(attributes.getValue("id"));
        this.materialBuilder.setName(attributes.getValue("name"));
        enterElement(ParserMode.MATERIAL);
    }


    /**
     * Enters a instance_effect element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterInstanceEffect(final Attributes attributes)
    {
        this.effectInstanceBuilder = new EffectInstanceBuilder();
        this.effectInstanceBuilder.setUrl(new URI(attributes.getValue("url")));
        this.effectInstanceBuilder.setSid(attributes.getValue("sid"));
        this.effectInstanceBuilder.setName(attributes.getValue("name"));
        enterElement(ParserMode.INSTANCE_EFFECT);
    }


    /**
     * Leaves a instance_effect element.
     */

    private void leaveInstanceEffect()
    {
        this.materialBuilder.setEffectInstance(this.effectInstanceBuilder
                .build());
        this.effectInstanceBuilder = null;
        leaveElement();
    }


    /**
     * Leaves a material element.
     */

    private void leaveMaterial()
    {
        this.materialLibrary.getMaterials().add(this.materialBuilder.build());
        this.materialBuilder = null;
        leaveElement();
    }


    /**
     * Leaves a library_materials element.
     */

    private void leaveLibraryMaterials()
    {
        this.document.getMaterialLibraries().add(this.materialLibrary);
        this.materialLibrary = null;
    }


    /**
     * Enters a effect element.
     *
     * @param attributes
     *            The element attributes
     */

    public void enterEffect(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.effect = new Effect(id);
        enterElement(ParserMode.EFFECT);
    }


    /**
     * Enters a common_PROFILE element.
     */

    private void enterProfileCommon()
    {
        this.commonProfile = new CommonEffectProfile();
        enterElement(ParserMode.PROFILE_COMMON);
    }


    /**
     * Enters newparam element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterNewParam(final Attributes attributes)
    {
        this.paramId = attributes.getValue("sid");
        enterElement(ParserMode.NEWPARAM);
    }


    /**
     * Enters a surface element.
     */

    private void enterSurface()
    {
        this.profileParam = new SurfaceParam(this.paramId);
        this.paramId = null;
        enterElement(ParserMode.SURFACE);
    }


    /**
     * Enters surface init_from element.
     */

    private void enterSurfaceInitFrom()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.SURFACE_INIT_FROM);
    }


    /**
     * Leaves surface init_from element.
     */

    private void leaveSurfaceInitFrom()
    {
        ((SurfaceParam) this.profileParam).setImageId(this.stringBuilder
                .toString());
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Enters a ssampler2D element.
     */

    private void enterSampler2D()
    {
        this.profileParam = new Sampler2DParam(this.paramId);
        this.paramId = null;
        enterElement(ParserMode.SAMPLER2D);
    }


    /**
     * Enters sampler2D source element.
     */

    private void enterSampler2DSource()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.SAMPLER2D_SOURCE);
    }


    /**
     * Leaves sampler2D source element.
     */

    private void leaveSampler2DSource()
    {
        ((Sampler2DParam) this.profileParam).setSource(this.stringBuilder
                .toString());
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Enters sampler2D minfilter element.
     */

    private void enterSampler2DMinFilter()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.SAMPLER2D_MINFILTER);
    }


    /**
     * Leaves sampler2D minfilter element.
     */

    private void leaveSampler2DMinFilter()
    {
        ((Sampler2DParam) this.profileParam).setMinFilter(Filter
                .valueOf(this.stringBuilder.toString()));
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Enters sampler2D magfilter element.
     */

    private void enterSampler2DMagFilter()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.SAMPLER2D_MAGFILTER);
    }


    /**
     * Leaves sampler2D magfilter element.
     */

    private void leaveSampler2DMagFilter()
    {
        ((Sampler2DParam) this.profileParam).setMagFilter(Filter
                .valueOf(this.stringBuilder.toString()));
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Leaves a newparam element.
     */

    private void leaveNewParam()
    {
        this.commonProfile.getParams().add(this.profileParam);
        this.profileParam = null;
        leaveElement();
    }


    /**
     * Enters a common_PROFILE technique element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterTechniqueCommon(final Attributes attributes)
    {
        final String sid = attributes.getValue("sid");
        this.commonTechnique = new CommonTechnique(sid);
        enterElement(ParserMode.TECHNIQUE_COMMON);
    }


    /**
     * Enters a phong element.
     */

    private void enterPhong()
    {
        this.shading = this.phong = new Phong();
        enterElement(ParserMode.PHONG);
    }


    /**
     * Enters a color element.
     */

    private void enterShadingColor()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.SHADING_COLOR);
    }


    /**
     * Leaves a shadin color element.
     */

    private void leaveShadingColor()
    {
        final String[] parts = this.stringBuilder.toString().trim().split(
                "\\s+");
        final ColladaColor color = new ColladaColor(Float.parseFloat(parts[0]),
            Float
                    .parseFloat(parts[1]), Float.parseFloat(parts[2]), Float
                    .parseFloat(parts[3]));
        this.colorOrTexture = new ColorOrTexture(color);
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Enters a texture element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterTexture(final Attributes attributes)
    {
        final String texture = attributes.getValue("texture");
        final String texcoord = attributes.getValue("texcoord");
        this.colorOrTexture = new ColorOrTexture(new ColladaTexture(texture,
            texcoord));
        enterElement(ParserMode.TEXTURE);
    }


    /**
     * Leaves a colorOrTexture element
     */

    private void leaveColorOrTexture()
    {
        switch (this.mode)
        {
            case EMISSION:
                this.shading.setEmission(this.colorOrTexture);
                break;

            case AMBIENT:
                this.shading.setAmbient(this.colorOrTexture);
                break;

            case DIFFUSE:
                this.shading.setDiffuse(this.colorOrTexture);
                break;

            case SPECULAR:
                this.shading.setSpecular(this.colorOrTexture);
                break;

            case REFLECTIVE:
                this.shading.setReflective(this.colorOrTexture);
                break;

            case TRANSPARENT:
                this.shading.setTransparent(this.colorOrTexture);
                break;

            default:
                throw new ParserException(
                        "Unknown parser mode for colorOrTexture: " + this.mode);

        }
        this.colorOrTexture = null;
        leaveElement();
    }


    /**
     * Enters a float element.
     */

    private void enterFloat()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.FLOAT);
    }


    /**
     * Leaves a shading float element.
     */

    private void leaveShadingFloat()
    {
        final float value = Float.parseFloat(this.stringBuilder.toString()
                .trim());
        this.stringBuilder = null;
        switch (this.mode)
        {
            case REFLECTIVITY:
                this.shading.setReflectivity(value);
                break;

            case SHININESS:
                this.shading.setShininess(value);
                break;

            case TRANSPARENCY:
                this.shading.setTransparency(value);
                break;

            case INDEX_OF_REFRACTION:
                this.shading.setIndexOfRefraction(value);
                break;

            default:
                throw new ParserException(
                        "Unknown parser mode for a shading float: " + this.mode);
        }
        leaveElement();
    }


    /**
     * Leaves a phong element.
     */

    private void leavePhong()
    {
        this.commonTechnique.setPhong(this.phong);
        this.shading = this.phong = null;
        leaveElement();
    }


    /**
     * Leaves a common_PROFILE technique element.
     */

    private void leaveTechniqueCommon()
    {
        this.commonProfile.getTechniques().add(this.commonTechnique);
        this.commonTechnique = null;
        leaveElement();
    }


    /**
     * Leaves a common_PROFILE element.
     */

    private void leaveProfileCommon()
    {
        this.effect.getProfiles().add(this.commonProfile);
        this.commonProfile = null;
        leaveElement();
    }


    /**
     * Leaves a effect element.
     */

    private void leaveEffect()
    {
        this.document.getLibraryEffects().add(this.effect);
        this.effect = null;
        leaveElement();
    }


    /**
     * Enters a geometry element
     *
     * @param attributes
     *            The element attributes
     */

    private void enterGeometry(final Attributes attributes)
    {
        this.geometryId = attributes.getValue("id");
        enterElement(ParserMode.GEOMETRY);
    }


    /**
     * Enters a mesh element
     */

    private void enterMesh()
    {
        this.mesh = new ColladaMesh();
        enterElement(ParserMode.MESH);
    }


    /**
     * Enters a data source element
     *
     * @param attributes
     *            The element attributes
     */

    private void enterMeshDataSource(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.dataSource = new DataSource(id);
        enterElement(ParserMode.MESH_DATA_SOURCE);
    }


    /**
     * Enters a float_array element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterFloatArray(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        final int count = Integer.parseInt(attributes.getValue("count"));
        this.dataArray = new DataArray(id);
        final float[] data = new float[count];
        this.dataArray.setData(data);
        this.chunkFloatReader = new ChunkFloatReader()
        {
            private int index = 0;

            @Override
            protected void valueFound(final float value)
            {
                data[this.index++] = value;
            }
        };

        enterElement(ParserMode.FLOAT_ARRAY);
    }


    /**
     * Leaves a float_array element
     */

    private void leaveFloatArray()
    {
        this.chunkFloatReader.finish();
        this.chunkFloatReader = null;
        this.dataSource.setData(this.dataArray);
        this.dataArray = null;
        leaveElement();
    }


    /**
     * Enters a float_array element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterNameArray(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        final int count = Integer.parseInt(attributes.getValue("count"));
        this.dataArray = new DataArray(id);
        final String[] data = new String[count];
        this.dataArray.setData(data);
        this.chunkStringReader = new ChunkStringReader()
        {
            private int index = 0;

            @Override
            protected void valueFound(final String value)
            {
                data[this.index++] = value;
            }
        };

        enterElement(ParserMode.NAME_ARRAY);
    }


    /**
     * Leaves a Name_array element
     */

    private void leaveNameArray()
    {
        this.chunkStringReader.finish();
        this.chunkStringReader = null;
        this.dataSource.setData(this.dataArray);
        this.dataArray = null;
        leaveElement();
    }


    /**
     * Enters an accessor element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterAccessor(final Attributes attributes)
    {
        final String sourceStr = attributes.getValue("source");
        URI source;
        try
        {
            source = new URI(sourceStr);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(sourceStr + " is not a valid URI: " + e,
                e);
        }
        final int count = Integer.valueOf(attributes.getValue("count"));
        this.accessor = new Accessor(source, count);
        enterElement(ParserMode.ACCESSOR);
    }


    /**
     * Enters a param element.
     *
     * @param attributes
     *            The element attribtues
     */

    private void enterParam(final Attributes attributes)
    {
        final ParamType type = ParamType.valueOf(attributes.getValue("type")
                .toUpperCase());
        this.accessor.getParams().add(new Param(type));
    }


    /**
     * Leaves an accessor element.
     */

    private void leaveAccessor()
    {
        this.dataSource.setAccessor(this.accessor);
        this.accessor = null;
        leaveElement();
    }


    /**
     * Leaves a mesh data source element.
     */

    private void leaveMeshDataSource()
    {
        this.mesh.getSources().add(this.dataSource);
        this.dataSource = null;
        leaveElement();
    }


    /**
     * Enters a vertices element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterVertices(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.vertices = new Vertices(id);
        enterElement(ParserMode.VERTICES);
    }


    /**
     * Enters verticies input element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterVerticesInput(final Attributes attributes)
    {
        final Semantic semantic = Semantic.valueOf(attributes
                .getValue("semantic"));
        final String text = attributes.getValue("source");
        URI source;
        try
        {
            source = new URI(text);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(text + " is not a valid URI: " + e, e);
        }
        final UnsharedInput input = new UnsharedInput(semantic, source);
        this.vertices.getInputs().add(input);
    }


    /**
     * Leaves a vertices element
     */

    private void leaveVertices()
    {
        this.mesh.setVertices(this.vertices);
        this.vertices = null;
        leaveElement();
    }


    /**
     * Enters a polygons element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterPolygons(final Attributes attributes)
    {
        final String material = attributes.getValue("material");
        final int count = Integer.parseInt(attributes.getValue("count"));
        this.polygonsIndices = new int[count][];
        this.polygonsIndex = 0;
        this.primitives = this.polygons = new Polygons();
        this.polygons.setMaterial(material);
        this.intArrayBuilder = new ArrayList<Integer>();
        enterElement(ParserMode.POLYGONS);
    }


    /**
     * Enters a primitives input element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterPrimitivesInput(final Attributes attributes)
    {
        final String semanticString = attributes.getValue("semantic");
        final int offset = Integer.parseInt(attributes.getValue("offset"));
        final String sourceString = attributes.getValue("source");
        final String setString = attributes.getValue("set");
        final Integer set = setString == null ? null : Integer
                .parseInt(setString);
        final Semantic semantic = Semantic.valueOf(semanticString);
        URI source;
        try
        {
            source = new URI(sourceString);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(semanticString + " is not a valid URI: "
                    + e, e);
        }
        final SharedInput input = new SharedInput(semantic, offset, source);
        input.setSet(set);
        this.primitives.getInputs().add(input);
        enterElement(ParserMode.PRIMITIVES_INPUT);
    }


    /**
     * Enters a polygons p element.
     */

    private void enterPolygonsP()
    {
        final List<Integer> builder = this.intArrayBuilder;
        this.chunkIntReader = new ChunkIntReader()
        {
            @Override
            protected void valueFound(final int value)
            {
                builder.add(value);
            }
        };
        enterElement(ParserMode.POLYGONS_P);
    }


    /**
     * Leaves a polygons p element.
     */

    private void leavePolygonsP()
    {
        this.chunkIntReader.finish();
        this.chunkIntReader = null;
        int size = this.intArrayBuilder.size();
        final int[] data = this.polygonsIndices[this.polygonsIndex] = new int[size];
        while ((--size) >= 0)
            data[size] = this.intArrayBuilder.get(size);
        this.polygonsIndex++;
        this.intArrayBuilder.clear();
        leaveElement();
    }


    /**
     * Leaves a polygons element.
     */

    private void leavePolygons()
    {
        this.polygons.setIndices(this.polygonsIndices);
        this.mesh.getPrimitiveGroups().add(this.polygons);
        this.polygonsIndices = null;
        this.intArrayBuilder = null;
        this.primitives = this.polygons = null;
        leaveElement();
    }


    /**
     * Enters a triangles element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterTriangles(final Attributes attributes)
    {
        final String material = attributes.getValue("material");
        final List<Integer> builder = this.intArrayBuilder = new ArrayList<Integer>();
        this.primitives = this.triangles = new Triangles();
        this.triangles.setMaterial(material);
        this.chunkIntReader = new ChunkIntReader()
        {
            @Override
            protected void valueFound(final int value)
            {
                builder.add(value);
            }
        };
        enterElement(ParserMode.TRIANGLES);
    }


    /**
     * Leaves a polygons element.
     */

    private void leaveTriangles()
    {
        this.chunkIntReader.finish();
        this.chunkIntReader = null;
        final int size = this.intArrayBuilder.size();
        final int[] data = new int[size];
        for (int i = 0; i < size; i++)
            data[i] = this.intArrayBuilder.get(i);
        this.triangles.setIndices(data);
        this.mesh.getPrimitiveGroups().add(this.triangles);
        this.intArrayBuilder = null;
        this.primitives = this.triangles = null;
        leaveElement();
    }


    /**
     * Leaves a mesh element.
     */

    private void leaveMesh()
    {
        this.geometry = new Geometry(this.geometryId, this.mesh);
        this.mesh = null;
        leaveElement();
    }


    /**
     * Leaves a geometry element.
     */

    private void leaveGeometry()
    {
        this.document.getLibraryGeometries().add(this.geometry);
        this.geometry = null;
        leaveElement();
    }


    /**
     * Enters a mesh element
     *
     * @param attributes
     *            The element attributes
     */

    private void enterAnimation(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        if (this.animationStack == null)
            this.animationStack = new Stack<ColladaAnimation>();
        else
            this.animationStack.push(this.animation);
        this.animation = new ColladaAnimation(id);
        enterElement(ParserMode.ANIMATION);
    }


    /**
     * Enters a animation data source element
     *
     * @param attributes
     *            The element attributes
     */

    private void enterAnimationDataSource(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.dataSource = new DataSource(id);
        enterElement(ParserMode.ANIMATION_DATA_SOURCE);
    }


    /**
     * Leaves a animation data source element.
     */

    private void leaveAnimationDataSource()
    {
        this.animation.getSources().add(this.dataSource);
        this.dataSource = null;
        leaveElement();
    }


    /**
     * Enters a sampler element
     *
     * @param attributes
     *            The element attributes
     */

    private void enterSampler(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.sampler = new ColladaSampler(id);
        enterElement(ParserMode.SAMPLER);
    }


    /**
     * Enters a channel element
     *
     * @param attributes
     *            The element attributes
     */

    private void enterChannel(final Attributes attributes)
    {
        final String sourceStr = attributes.getValue("source");
        URI source;
        try
        {
            source = new URI(sourceStr);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(sourceStr + " is not a valid URI: " + e,
                e);
        }
        final String target = attributes.getValue("target");
        this.animation.getChannels().add(new Channel(source, target));
        enterElement(ParserMode.CHANNEL);
    }


    /**
     * Enters sampler input element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterSamplerInput(final Attributes attributes)
    {
        final Semantic semantic = Semantic.valueOf(attributes
                .getValue("semantic"));
        final String text = attributes.getValue("source");
        URI source;
        try
        {
            source = new URI(text);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(text + " is not a valid URI: " + e, e);
        }
        final UnsharedInput input = new UnsharedInput(semantic, source);
        this.sampler.getInputs().add(input);
    }


    /**
     * Leaves a sampler element.
     */

    private void leaveSampler()
    {
        this.animation.getSamplers().add(this.sampler);
        this.sampler = null;
        leaveElement();
    }


    /**
     * Leaves animation element
     */

    private void leaveAnimation()
    {
        if (this.animationStack.empty())
        {
            this.document.getLibraryAnimations().add(this.animation);
            this.animation = null;
            this.animationStack = null;
        }
        else
        {
            final ColladaAnimation parentAnimation = this.animationStack.pop();
            parentAnimation.getAnimations().add(this.animation);
            this.animation = parentAnimation;
        }
        leaveElement();
    }


    /**
     * Enters a light element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterLight(final Attributes attributes)
    {
        this.lightId = attributes.getValue("id");
        enterElement(ParserMode.LIGHT);
    }


    /**
     * Enters a directional light element.
     */

    private void enterDirectional()
    {
        this.light = new ColladaDirectionalLight(this.lightId);
        enterElement(ParserMode.LIGHT_DIRECTIONAL);
    }


    /**
     * Enters a ambient light element.
     */

    private void enterAmbient()
    {
        this.light = new ColladaAmbientLight(this.lightId);
        enterElement(ParserMode.LIGHT_AMBIENT);
    }


    /**
     * Enters a point light element.
     */

    private void enterPoint()
    {
        this.light = new ColladaPointLight(this.lightId);
        enterElement(ParserMode.LIGHT_POINT);
    }


    /**
     * Enters a spot light element.
     */

    private void enterSpot()
    {
        this.light = new ColladaSpotLight(this.lightId);
        enterElement(ParserMode.LIGHT_SPOT);
    }


    /**
     * Enters a light color element.
     */

    private void enterLightColor()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.LIGHT_COLOR);
    }


    /**
     * Leaves a light color element.
     */

    private void leaveLightColor()
    {
        final String[] parts = this.stringBuilder.toString().trim().split(
                "\\s+");
        final ColladaColor color = this.light.getColor();
        color.setRed(Float.parseFloat(parts[0]));
        color.setGreen(Float.parseFloat(parts[1]));
        color.setBlue(Float.parseFloat(parts[2]));
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Enters a falloff_angle element.
     */

    private void enterFalloffAngle()
    {
        this.stringBuilder = new StringBuilder();
        enterElement(ParserMode.FALLOFF_ANGLE);
    }


    /**
     * Leaves a falloff_angle element.
     */

    private void leaveFalloffAngle()
    {
        final float angle = Float.parseFloat(this.stringBuilder.toString());
        ((ColladaSpotLight) this.light).setFalloffAngle(angle);
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Leaves a light element.
     */

    private void leaveLight()
    {
        if (this.light == null)
            throw new ParserException("Internal parser error: No light created");
        this.document.getLibraryLights().add(this.light);
        this.light = null;
        this.lightId = null;
        leaveElement();
    }


    /**
     * Enters a camera element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterCamera(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.camera = new ColladaCamera(id);
        enterElement(ParserMode.CAMERA);
    }


    /**
     * Enters perspective element
     */

    private void enterPerspective()
    {
        this.optic = this.perspectiveOptic = new PerspectiveOptic();
        enterElement(ParserMode.PERSPECTIVE);
    }


    /**
     * Enters a perspective value element.
     *
     * @param mode
     *            The next parser mode
     */

    private void enterPerspectiveValue(final ParserMode mode)
    {
        this.stringBuilder = new StringBuilder();
        enterElement(mode);
    }


    /**
     * Leaves xfov element.
     */

    private void leaveXfov()
    {
        this.perspectiveOptic.setXfov(Float.parseFloat(this.stringBuilder
                .toString().trim()));
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Leaves yfov element.
     */

    private void leaveYfov()
    {
        this.perspectiveOptic.setYfov(Float.parseFloat(this.stringBuilder
                .toString().trim()));
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Leaves aspect_ratio element.
     */

    private void leaveAspectRatio()
    {
        this.perspectiveOptic.setAspectRatio(Float
                .parseFloat(this.stringBuilder.toString().trim()));
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Leaves znear element.
     */

    private void leaveZnear()
    {
        this.perspectiveOptic.setZnear(Float.parseFloat(this.stringBuilder
                .toString().trim()));
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Leaves zfar element.
     */

    private void leaveZfar()
    {
        this.perspectiveOptic.setZfar(Float.parseFloat(this.stringBuilder
                .toString().trim()));
        this.stringBuilder = null;
        leaveElement();
    }


    /**
     * Leaves optics element
     */

    private void leaveOptics()
    {
        this.camera.setOptic(this.optic);
        this.optic = null;
        this.perspectiveOptic = null;
        leaveElement();
    }


    /**
     * Leaves a camera element.
     */

    private void leaveCamera()
    {
        this.document.getLibraryCameras().add(this.camera);
        this.camera = null;
        leaveElement();
    }


    /**
     * Enters a visual_scene element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterVisualScene(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.visualScene = new VisualScene(id);
        this.nodeStack = new Stack<Node>();
        enterElement(ParserMode.VISUAL_SCENE);
    }


    /**
     * Enters a visual scene node element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterVisualSceneNode(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.node = new Node(id);
        enterElement(ParserMode.VISUAL_SCENE_NODE);
    }


    /**
     * Enters a node element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterNode(final Attributes attributes)
    {
        final String id = attributes.getValue("id");
        this.nodeStack.push(this.node);
        this.node = new Node(id);
        enterElement(ParserMode.NODE);
    }


    /**
     * Enters a matrix element
     */

    private void enterMatrix()
    {
        this.matrixTransformation = new MatrixTransformation();
        final float[] values = this.matrixTransformation.getValues();
        this.chunkFloatReader = new ChunkFloatReader()
        {
            private int index = 0;

            @Override
            protected void valueFound(final float value)
            {
                values[this.index++] = value;
            }
        };
        enterElement(ParserMode.MATRIX);
    }


    /**
     * Leaves a matrix element.
     */

    private void leaveMatrix()
    {
        this.chunkFloatReader.finish();
        this.chunkFloatReader = null;
        this.node.getTransformations().add(this.matrixTransformation);
        this.matrixTransformation = null;
        leaveElement();
    }


    /**
     * Enters a translate element
     */

    private void enterTranslate()
    {
        this.translateTransformation = new TranslateTransformation();
        final float[] values = this.translateTransformation.getValues();
        this.chunkFloatReader = new ChunkFloatReader()
        {
            private int index = 0;

            @Override
            protected void valueFound(final float value)
            {
                values[this.index++] = value;
            }
        };
        enterElement(ParserMode.TRANSLATE);
    }


    /**
     * Leaves a matrix element.
     */

    private void leaveTranslate()
    {
        this.chunkFloatReader.finish();
        this.chunkFloatReader = null;
        this.node.getTransformations().add(this.translateTransformation);
        this.translateTransformation = null;
        leaveElement();
    }


    /**
     * Enters a instance_geometry element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterInstanceGeometry(final Attributes attributes)
    {
        final String urlString = attributes.getValue("url");
        URI url;
        try
        {
            url = new URI(urlString);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(urlString + " is not a valid URI: " + e,
                    e);
        }
        this.instanceGeometry = new InstanceGeometry(url);
        enterElement(ParserMode.INSTANCE_GEOMETRY);
    }


    /**
     * Enters a instance_material element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterInstanceMaterial(final Attributes attributes)
    {
        final String symbol = attributes.getValue("symbol");
        final String targetString = attributes.getValue("target");
        URI target;
        try
        {
            target = new URI(targetString);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(targetString + " is not a valid URI: "
                    + e, e);
        }
        this.instanceMaterial = new InstanceMaterial(symbol, target);
        enterElement(ParserMode.INSTANCE_MATERIAL);
    }


    /**
     * Leaves a instance_material element.
     */

    private void leaveInstanceMaterial()
    {
        this.instanceGeometry.getInstanceMaterials().add(this.instanceMaterial);
        this.instanceMaterial = null;
        leaveElement();
    }


    /**
     * Leaves a instance_geometry element.
     */

    private void leaveInstanceGeometry()
    {
        this.node.getInstanceGeometries().add(this.instanceGeometry);
        this.instanceGeometry = null;
        leaveElement();
    }


    /**
     * Enters a instance_light element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterInstanceLight(final Attributes attributes)
    {
        final String urlString = attributes.getValue("url");
        URI url;
        try
        {
            url = new URI(urlString);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(urlString + " is not a valid URI: " + e,
                    e);
        }
        this.instanceLight = new InstanceLight(url);
        enterElement(ParserMode.INSTANCE_LIGHT);
    }


    /**
     * Leaves a instance_light element.
     */

    private void leaveInstanceLight()
    {
        this.node.getInstanceLights().add(this.instanceLight);
        this.instanceLight = null;
        leaveElement();
    }


    /**
     * Enters a instance_camera element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterInstanceCamera(final Attributes attributes)
    {
        final String urlString = attributes.getValue("url");
        URI url;
        try
        {
            url = new URI(urlString);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(urlString + " is not a valid URI: " + e,
                    e);
        }
        this.instanceCamera = new InstanceCamera(url);
        enterElement(ParserMode.INSTANCE_CAMERA);
    }


    /**
     * Leaves a instance_camera element.
     */

    private void leaveInstanceCamera()
    {
        this.node.getInstanceCameras().add(this.instanceCamera);
        this.instanceCamera = null;
        leaveElement();
    }


    /**
     * Leaves a node element.
     */

    private void leaveNode()
    {
        final Node parentNode = this.nodeStack.pop();
        parentNode.getNodes().add(this.node);
        this.node = parentNode;
        leaveElement();
    }


    /**
     * Leaves a visual scene node element.
     */

    private void leaveVisualSceneNode()
    {
        this.visualScene.getNodes().add(this.node);
        this.node = null;
        leaveElement();
    }

    /**
     * Leaves a visual_scene element.
     */

    private void leaveVisualScene()
    {
        this.document.getLibraryVisualScenes().add(this.visualScene);
        this.visualScene = null;
        this.nodeStack = null;
        leaveElement();
    }


    /**
     * Enters a scene element.
     */

    private void enterScene()
    {
        this.scene = new ColladaScene();
        enterElement(ParserMode.SCENE);
    }


    /**
     * Enters a instance_visual_scene element.
     *
     * @param attributes
     *            The element attributes
     */

    private void enterInstanceVisualScene(final Attributes attributes)
    {
        final String urlString = attributes.getValue("url");
        URI url;
        try
        {
            url = new URI(urlString);
        }
        catch (final URISyntaxException e)
        {
            throw new ParserException(urlString + " is not a valid URI: " + e,
                    e);
        }
        this.scene.setInstanceVisualScene(new InstanceVisualScene(url));
        enterElement(ParserMode.INSTANCE_VISUAL_SCENE);
    }


    /**
     * Leaves a scene element,
     */

    private void leaveScene()
    {
        this.document.setScene(this.scene);
        this.scene = null;
        leaveElement();
    }
}
