/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import de.ailis.gramath.MutableMatrix4d;
import de.ailis.gramath.MutableVector3d;
import de.ailis.jollada.model.*;
import de.ailis.jollada.reader.ColladaReader;


/**
 * Tests reading COLLADA files.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class FullTest
{
    /** The test document. */
    private static Document doc;


    /**
     * Reads a COLLADA document.
     *
     * @param filename
     *            The filename.
     * @return The COLLADA document
     * @throws IOException
     *             When file could not be read
     */

    private static Document readDocument(final String filename)
        throws IOException
    {
        final InputStream stream = FullTest.class.getClassLoader()
                .getResourceAsStream(filename);
        if (stream == null)
            throw new IOException("File not found: " + filename);
        try
        {
            return new ColladaReader().read(stream);
        }
        finally
        {
            stream.close();
        }
    }


    /**
     * Reads the test document.
     *
     * @throws IOException
     *             When file could not be read
     */

    @BeforeClass
    public static void readTestDocument() throws IOException
    {
        doc = readDocument("full.dae");
    }


    /**
     * Tests the image libraries.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testImageLibraries() throws Exception
    {
        // Check image libraries
        final ImageLibraries imageLibs = doc.getImageLibraries();
        assertEquals(2, imageLibs.size());

        // Check image library
        final ImageLibrary imageLib = imageLibs.get(0);
        assertEquals("image-lib-1", imageLib.getId());
        assertEquals("Image Library 1", imageLib.getName());
        assertSame(doc, imageLib.getDocument());
        assertSame(doc, imageLib.getParent());

        // Check images
        final Images images = imageLib.getImages();
        assertEquals(2, images.size());

        // Check image
        final Image image = images.get(0);
        assertEquals("image-1", image.getId());
        assertEquals("Image 1", image.getName());
        assertEquals("img-1", image.getSid());
        assertSame(doc, image.getDocument());
        assertSame(imageLib, image.getParent());

        // Check image source
        final ImageSource source = image.getSource();
        assertFalse(source.isGenerateMips());
        assertSame(image, source.getParent());
        assertSame(doc, source.getDocument());
        assertEquals(new URI("test.jpeg"), source.getRef());
    }


    /**
     * Tests the material libraries.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testMaterialLibraries() throws Exception
    {
        // Check material libraries
        final MaterialLibraries materialLibs = doc.getMaterialLibraries();
        assertEquals(2, materialLibs.size());

        // Check material library
        final MaterialLibrary materialLib = materialLibs.get(0);
        assertEquals("material-lib-1", materialLib.getId());
        assertEquals("Material Library 1", materialLib.getName());
        assertSame(doc, materialLib.getDocument());
        assertSame(doc, materialLib.getParent());

        // Check materials
        final Materials materials = materialLib.getMaterials();
        assertEquals(2, materials.size());

        // Check material
        final Material material = materials.get(0);
        assertEquals("material-1", material.getId());
        assertEquals("Material 1", material.getName());
        assertSame(doc, material.getDocument());
        assertSame(materialLib, material.getParent());

        // Check material effect instance
        final EffectInstance effectInstance = material.getEffectInstance();
        assertEquals(new URI("#effect-1"), effectInstance.getUrl());
        assertSame(doc, effectInstance.getDocument());
        assertSame(material, effectInstance.getParent());
    }


    /**
     * Tests the effect libraries.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testEffectLibraries() throws Exception
    {
        // Check effect libraries
        final EffectLibraries effectLibs = doc.getEffectLibraries();
        assertEquals(2, effectLibs.size());

        // Check effect library
        final EffectLibrary effectLib = effectLibs.get(0);
        assertEquals("effect-lib-1", effectLib.getId());
        assertEquals("Effect Library 1", effectLib.getName());
        assertSame(doc, effectLib.getDocument());
        assertSame(doc, effectLib.getParent());

        // Check effects
        final Effects effects = effectLib.getEffects();
        assertEquals(2, effects.size());

        // Check effect
        Effect effect = effects.get(0);
        assertEquals("effect-1", effect.getId());
        assertEquals("Effect 1", effect.getName());
        assertSame(doc, effect.getDocument());
        assertSame(effectLib, effect.getParent());

        // Check effect profiles
        final EffectProfiles effectProfiles = effect.getProfiles();
        assertEquals(2, effectProfiles.size());

        // Check effect profile
        final EffectProfile effectProfile = effectProfiles.get(0);
        assertEquals("common-profile-1", effectProfile.getId());
        assertSame(doc, effectProfile.getDocument());
        assertSame(effect, effectProfile.getParent());

        // Check common effect profile
        assertTrue(effectProfile instanceof CommonEffectProfile);
        final CommonEffectProfile commonEffectProfile = (CommonEffectProfile) effectProfile;

        // Check common new params
        final CommonNewParams commonNewParams = commonEffectProfile.getParams();
        assertEquals(2, commonNewParams.size());

        // Check common new param
        final CommonNewParam commonNewParam = commonNewParams.get(0);
        assertEquals("SEMANTIC-1", commonNewParam.getSemantic());
        assertEquals("common-newparam-1", commonNewParam.getSid());
        assertSame(doc, commonNewParam.getDocument());
        assertSame(effectProfile, commonNewParam.getParent());

        // Check parameter
        Param param = commonNewParam.getParameter();
        assertNotNull(param);

        // Check float parameter
        assertTrue(param instanceof FloatParam);
        final FloatParam floatParam = (FloatParam) param;
        assertEquals(1.23, floatParam.getValue(), 0.0001f);

        // Check sampler2D parameter
        param = commonNewParams.get(1).getParameter();
        assertTrue(param instanceof Sampler2DParam);
        final Sampler2DParam sampler2DParam = (Sampler2DParam) param;
        assertEquals(Wrap.BORDER, sampler2DParam.getWrapS());
        assertEquals(Wrap.CLAMP, sampler2DParam.getWrapT());
        assertEquals(Filter.NEAREST, sampler2DParam.getMinFilter());
        assertEquals(Filter.LINEAR, sampler2DParam.getMagFilter());

        // Check common effect technique
        CommonEffectTechnique commonEffectTechnique = commonEffectProfile
                .getTechnique();
        assertEquals("effect-1-common-technique", commonEffectTechnique.getId());
        assertEquals("technique", commonEffectTechnique.getSid());
        assertSame(doc, commonEffectTechnique.getDocument());
        assertSame(effectProfile, commonEffectTechnique.getParent());

        // Check shader
        Shader shader = commonEffectTechnique.getShader();
        assertSame(doc, shader.getDocument());
        assertSame(commonEffectTechnique, shader.getParent());

        // Check reflectivity
        FloatAttribute floatAttrib = shader.getReflectivity();
        assertSame(shader, floatAttrib.getParent());
        assertSame(doc, floatAttrib.getDocument());

        // Check float value
        FloatValue floatValue = floatAttrib.getFloat();
        assertSame(floatAttrib, floatValue.getParent());
        assertSame(doc, floatValue.getDocument());
        assertEquals("reflectivity-value", floatValue.getSid());
        assertEquals(0.8, floatValue.getValue(), 0.001f);

        // Check other shader values
        RGBAColor color = shader.getEmission().getColor();
        assertEquals("emission-color", color.getSid());
        assertEquals(0.5f, color.getRed(), 0.001);
        assertEquals(0.6f, color.getGreen(), 0.001);
        assertEquals(0.7f, color.getBlue(), 0.001);
        assertEquals(0.8f, color.getAlpha(), 0.001);
        color = ((PhongShader) shader).getAmbient().getColor();
        assertEquals("ambient-color", color.getSid());
        assertEquals(0.1f, color.getRed(), 0.001);
        assertEquals(0.2f, color.getGreen(), 0.001);
        assertEquals(0.3f, color.getBlue(), 0.001);
        assertEquals(0.4f, color.getAlpha(), 0.001);
        Texture texture = ((PhongShader) shader).getDiffuse()
                .getTexture();
        assertEquals("TEXCOORD", texture.getTexcoord());
        assertEquals("TEXTURE", texture.getTexture());
        color = ((PhongShader) shader).getSpecular().getColor();
        assertEquals("specular-color", color.getSid());
        assertEquals(0.4f, color.getRed(), 0.001);
        assertEquals(0.3f, color.getGreen(), 0.001);
        assertEquals(0.2f, color.getBlue(), 0.001);
        assertEquals(0.1f, color.getAlpha(), 0.001);
        floatValue = ((PhongShader) shader).getShininess().getFloat();
        assertEquals(0.95, floatValue.getValue(), 0.001);
        assertEquals("shininess-value", floatValue.getSid());
        color = ((PhongShader) shader).getReflective().getColor();
        assertEquals("reflective-color", color.getSid());
        assertEquals(0.9f, color.getRed(), 0.001);
        assertEquals(0.8f, color.getGreen(), 0.001);
        assertEquals(0.7f, color.getBlue(), 0.001);
        assertEquals(0.6f, color.getAlpha(), 0.001);
        color = ((PhongShader) shader).getTransparent().getColor();
        assertEquals("transparent-color", color.getSid());
        assertEquals(0.1f, color.getRed(), 0.001);
        assertEquals(0.8f, color.getGreen(), 0.001);
        assertEquals(0.2f, color.getBlue(), 0.001);
        assertEquals(0.6f, color.getAlpha(), 0.001);
        floatValue = shader.getTransparency().getFloat();
        assertEquals("transparency-value", floatValue.getSid());
        assertEquals(0.7, floatValue.getValue(), 0.001f);
        floatValue = shader.getIndexOfRefraction().getFloat();
        assertEquals("index_of_refraction-value", floatValue.getSid());
        assertEquals(20, floatValue.getValue(), 0.001f);

        // Check blinn shader
        effect = (Effect) doc.getById("effect-2");
        commonEffectTechnique = effect.getProfiles().getCommonProfile().getTechnique();
        shader = commonEffectTechnique.getShader();
        assertSame(doc, shader.getDocument());
        assertSame(commonEffectTechnique, shader.getParent());
        floatAttrib = shader.getReflectivity();
        assertSame(shader, floatAttrib.getParent());
        assertSame(doc, floatAttrib.getDocument());
        floatValue = floatAttrib.getFloat();
        assertSame(floatAttrib, floatValue.getParent());
        assertSame(doc, floatValue.getDocument());
        assertEquals("reflectivity-value", floatValue.getSid());
        assertEquals(0.8, floatValue.getValue(), 0.001f);
        color = shader.getEmission().getColor();
        assertEquals("emission-color", color.getSid());
        assertEquals(0.5f, color.getRed(), 0.001);
        assertEquals(0.6f, color.getGreen(), 0.001);
        assertEquals(0.7f, color.getBlue(), 0.001);
        assertEquals(0.8f, color.getAlpha(), 0.001);
        color = ((BlinnShader) shader).getAmbient().getColor();
        assertEquals("ambient-color", color.getSid());
        assertEquals(0.1f, color.getRed(), 0.001);
        assertEquals(0.2f, color.getGreen(), 0.001);
        assertEquals(0.3f, color.getBlue(), 0.001);
        assertEquals(0.4f, color.getAlpha(), 0.001);
        texture = ((BlinnShader) shader).getDiffuse()
                .getTexture();
        assertEquals("TEXCOORD", texture.getTexcoord());
        assertEquals("TEXTURE", texture.getTexture());
        color = ((BlinnShader) shader).getSpecular().getColor();
        assertEquals("specular-color", color.getSid());
        assertEquals(0.4f, color.getRed(), 0.001);
        assertEquals(0.3f, color.getGreen(), 0.001);
        assertEquals(0.2f, color.getBlue(), 0.001);
        assertEquals(0.1f, color.getAlpha(), 0.001);
        floatValue = ((BlinnShader) shader).getShininess().getFloat();
        assertEquals(0.95, floatValue.getValue(), 0.001);
        assertEquals("shininess-value", floatValue.getSid());
        color = ((BlinnShader) shader).getReflective().getColor();
        assertEquals("reflective-color", color.getSid());
        assertEquals(0.9f, color.getRed(), 0.001);
        assertEquals(0.8f, color.getGreen(), 0.001);
        assertEquals(0.7f, color.getBlue(), 0.001);
        assertEquals(0.6f, color.getAlpha(), 0.001);
        color = ((BlinnShader) shader).getTransparent().getColor();
        assertEquals("transparent-color", color.getSid());
        assertEquals(0.1f, color.getRed(), 0.001);
        assertEquals(0.8f, color.getGreen(), 0.001);
        assertEquals(0.2f, color.getBlue(), 0.001);
        assertEquals(0.6f, color.getAlpha(), 0.001);
        floatValue = shader.getTransparency().getFloat();
        assertEquals("transparency-value", floatValue.getSid());
        assertEquals(0.7, floatValue.getValue(), 0.001f);
        floatValue = shader.getIndexOfRefraction().getFloat();
        assertEquals("index_of_refraction-value", floatValue.getSid());
        assertEquals(20, floatValue.getValue(), 0.001f);
    }


    /**
     * Tests the camera libraries.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testCameraLibraries() throws Exception
    {
        // Check camera libraries
        final CameraLibraries cameraLibs = doc.getCameraLibraries();
        assertEquals(2, cameraLibs.size());

        // Check camera library
        final CameraLibrary cameraLib = cameraLibs.get(0);
        assertEquals("camera-lib-1", cameraLib.getId());
        assertEquals("Camera Library 1", cameraLib.getName());
        assertSame(doc, cameraLib.getDocument());
        assertSame(doc, cameraLib.getParent());

        // Check cameras
        final Cameras cameras = cameraLib.getCameras();
        assertEquals(2, cameras.size());

        // Check camera
        final Camera camera = cameras.get(0);
        assertEquals("camera-1", camera.getId());
        assertEquals("Camera 1", camera.getName());
        assertSame(doc, camera.getDocument());
        assertSame(cameraLib, camera.getParent());

        // Check optics
        final Optics optics = camera.getOptics();
        assertSame(doc, optics.getDocument());
        assertSame(camera, optics.getParent());

        // Check common technique
        final CommonOpticsTechnique technique = optics.getCommonTechnique();
        assertSame(doc, technique.getDocument());
        assertSame(optics, technique.getParent());

        // Check projection
        final Projection projection = technique.getProjection();
        assertSame(doc, projection.getDocument());
        assertSame(technique, projection.getParent());

        // Check znear
        FloatValue value = projection.getZNear();
        assertEquals("camera-1-znear", value.getSid());
        assertEquals(0.1, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(projection, value.getParent());

        // Check zfar
        value = projection.getZFar();
        assertEquals("camera-1-zfar", value.getSid());
        assertEquals(100.5, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(projection, value.getParent());

        // Check aspect ratio
        value = projection.getAspectRatio();
        assertNull(value);

        // Check orthographic stuff
        final Orthographic orthographic = (Orthographic) projection;
        value = orthographic.getXMag();
        assertEquals("camera-1-xmag", value.getSid());
        assertEquals(256, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(projection, value.getParent());
        value = orthographic.getYMag();
        assertEquals("camera-1-ymag", value.getSid());
        assertEquals(320, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(projection, value.getParent());

        // Check orthographic stuff
        final Perspective perspecive = (Perspective) cameras.get(1).getOptics()
                .getCommonTechnique().getProjection();
        value = perspecive.getXFov();
        assertEquals("camera-2-xfov", value.getSid());
        assertEquals(512, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(perspecive, value.getParent());
        value = perspecive.getYFov();
        assertNull(value);
        value = perspecive.getAspectRatio();
        assertEquals("camera-2-ar", value.getSid());
        assertEquals(1.5, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(perspecive, value.getParent());
    }


    /**
     * Tests the light libraries.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testLightLibraries() throws Exception
    {
        // Check camera libraries
        final LightLibraries lightLibs = doc.getLightLibraries();
        assertEquals(2, lightLibs.size());

        // Check camera library
        final LightLibrary lightLib = lightLibs.get(0);
        assertEquals("light-lib-1", lightLib.getId());
        assertEquals("Light Library 1", lightLib.getName());
        assertSame(doc, lightLib.getDocument());
        assertSame(doc, lightLib.getParent());

        // Check cameras
        final Lights lights = lightLib.getLights();
        assertEquals(3, lights.size());

        // Check light
        final Light light = lights.get(0);
        assertEquals("light-1", light.getId());
        assertEquals("Light 1", light.getName());
        assertSame(doc, light.getDocument());
        assertSame(lightLib, light.getParent());

        // Check common technique
        final CommonLightTechnique technique = light.getCommonTechnique();
        assertSame(doc, technique.getDocument());
        assertSame(light, technique.getParent());

        // Check light source
        final LightSource lightSource = technique.getLightSource();
        assertSame(doc, lightSource.getDocument());
        assertSame(technique, lightSource.getParent());

        // Check ambient light source
        final Ambient ambient = (Ambient) lightSource;
        RGBColor color = ambient.getColor();
        assertEquals(0.1, color.getRed(), 0.001);
        assertEquals(0.2, color.getGreen(), 0.001);
        assertEquals(0.3, color.getBlue(), 0.001);
        assertEquals("light-1-color", color.getSid());
        assertSame(doc, color.getDocument());
        assertSame(ambient, color.getParent());

        // Check directional light source
        final Directional directional = (Directional) lights.get(1)
                .getCommonTechnique().getLightSource();
        color = directional.getColor();
        assertEquals(0.4, color.getRed(), 0.001);
        assertEquals(0.5, color.getGreen(), 0.001);
        assertEquals(0.6, color.getBlue(), 0.001);
        assertEquals("light-2-color", color.getSid());
        assertSame(doc, color.getDocument());
        assertSame(directional, color.getParent());

        // Check point light source
        final Point point = (Point) lights.get(2).getCommonTechnique()
                .getLightSource();
        color = point.getColor();
        assertEquals(0.7, color.getRed(), 0.001);
        assertEquals(0.8, color.getGreen(), 0.001);
        assertEquals(0.9, color.getBlue(), 0.001);
        assertEquals("light-3-color", color.getSid());
        assertSame(doc, color.getDocument());
        assertSame(point, color.getParent());
        FloatValue value = point.getConstantAttenuation();
        assertEquals("light-3-constant", value.getSid());
        assertEquals(0.6, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(point, value.getParent());
        value = point.getLinearAttenuation();
        assertEquals("light-3-linear", value.getSid());
        assertEquals(0.5, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(point, value.getParent());
        value = point.getQuadraticAttenuation();
        assertEquals("light-3-quadratic", value.getSid());
        assertEquals(0.9, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(point, value.getParent());

        // Check point light source
        final Spot spot = (Spot) lightLibs.get(1).getLights().get(0)
                .getCommonTechnique().getLightSource();
        color = spot.getColor();
        assertEquals(0.1, color.getRed(), 0.001);
        assertEquals(0.3, color.getGreen(), 0.001);
        assertEquals(0.9, color.getBlue(), 0.001);
        assertEquals("light-4-color", color.getSid());
        assertSame(doc, color.getDocument());
        assertSame(spot, color.getParent());
        value = spot.getConstantAttenuation();
        assertEquals("light-4-constant", value.getSid());
        assertEquals(0.1, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(spot, value.getParent());
        value = spot.getLinearAttenuation();
        assertEquals("light-4-linear", value.getSid());
        assertEquals(0.2, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(spot, value.getParent());
        value = spot.getQuadraticAttenuation();
        assertEquals("light-4-quadratic", value.getSid());
        assertEquals(0.3, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(spot, value.getParent());
        value = spot.getFalloffAngle();
        assertEquals("light-4-angle", value.getSid());
        assertEquals(0.4, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(spot, value.getParent());
        value = spot.getFalloffExponent();
        assertEquals("light-4-exponent", value.getSid());
        assertEquals(0.5, value.getValue(), 0.001);
        assertSame(doc, value.getDocument());
        assertSame(spot, value.getParent());
    }


    /**
     * Tests the geometry libraries.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testGeometryLibraries() throws Exception
    {
        // Check geometry libraries
        final GeometryLibraries geometryLibs = doc.getGeometryLibraries();
        assertEquals(1, geometryLibs.size());

        // Check geometry library
        final GeometryLibrary geometryLib = geometryLibs.get(0);
        assertEquals("geometry-lib-1", geometryLib.getId());
        assertEquals("Geometry Library 1", geometryLib.getName());
        assertSame(doc, geometryLib.getDocument());
        assertSame(doc, geometryLib.getParent());

        // Check geometries
        final Geometries geometries = geometryLib.getGeometries();
        assertEquals(1, geometries.size());

        // Check geometry
        final Geometry geometry = geometries.get(0);
        assertEquals("geometry-1", geometry.getId());
        assertEquals("Geometry 1", geometry.getName());
        assertSame(doc, geometry.getDocument());
        assertSame(geometryLib, geometry.getParent());

        // Check geometric
        final Geometric geometric = geometry.getGeometric();
        assertSame(doc, geometric.getDocument());
        assertSame(geometry, geometric.getParent());

        // Check mesh
        final Mesh mesh = (Mesh) geometric;

        // Check sources
        final DataFlowSources sources = mesh.getSources();
        assertEquals(1, sources.size());

        // Check data flow source
        final DataFlowSource source = sources.get(0);
        assertEquals("geometry-1-source-1", source.getId());
        assertEquals("Geometry 1 Source 1", source.getName());
        assertSame(doc, source.getDocument());
        assertSame(mesh, source.getParent());

        // Check array
        final Array array = source.getArray();
        assertEquals("geometry-1-floats", array.getId());
        assertEquals("Geometry 1 Floats", array.getName());
        assertSame(doc, array.getDocument());
        assertSame(source, array.getParent());
        assertEquals(6, array.getCount());

        // Check float array
        final FloatArray floatArray = (FloatArray) array;
        assertEquals(7, floatArray.getDigits());
        assertEquals(39, floatArray.getMagnitude());
        assertEquals(0.1, floatArray.getValue(0), 0.001);
        assertEquals(0.2, floatArray.getValue(1), 0.001);
        assertEquals(0.3, floatArray.getValue(2), 0.001);
        assertEquals(0.4, floatArray.getValue(3), 0.001);
        assertEquals(0.5, floatArray.getValue(4), 0.001);
        assertEquals(0.6, floatArray.getValue(5), 0.001);

        // Check common technique
        final CommonSourceTechnique technique = source.getCommonTechnique();
        assertSame(doc, technique.getDocument());
        assertSame(source, technique.getParent());

        // Check accessor
        final Accessor accessor = technique.getAccessor();
        assertSame(doc, accessor.getDocument());
        assertSame(technique, accessor.getParent());
        assertEquals(6, accessor.getCount());
        assertEquals(0, accessor.getOffset());
        assertEquals(1, accessor.getStride());
        assertEquals(new URI("#geometry-1-floats"), accessor.getSource());

        // Check accessor params
        final DataFlowParams params = accessor.getParams();
        assertEquals(1, params.size());

        // Check accessor param
        final DataFlowParam param = params.get(0);
        assertSame(doc, param.getDocument());
        assertSame(accessor, param.getParent());
        assertEquals("SEMANTIC", param.getSemantic());
        assertEquals("V", param.getName());
        assertEquals("geometry-1-floats-param", param.getSid());
        assertEquals("float", param.getType());

        // Check vertices
        final Vertices vertices = mesh.getVertices();
        assertSame(doc, vertices.getDocument());
        assertSame(mesh, vertices.getParent());
        assertEquals("geometry-1-vertices", vertices.getId());
        assertEquals("Geometry 1 Vertices", vertices.getName());

        // Check vertex inputs
        final UnsharedInputs inputs = vertices.getInputs();
        assertEquals(1, inputs.size());

        // Check vertex input
        final UnsharedInput input = inputs.get(0);
        assertSame(doc, input.getDocument());
        assertSame(vertices, input.getParent());
        assertEquals("POSITION", input.getSemantic());
        assertEquals(new URI("#geometry-1-source"), input.getSource());

        // Check primitives
        final PrimitiveElements primitives = mesh.getPrimitives();
        assertEquals(1, primitives.size());

        // Check triangles
        final Triangles triangles = (Triangles) primitives.get(0);
        assertSame(doc, triangles.getDocument());
        assertSame(mesh, triangles.getParent());
        assertEquals(3, triangles.getCount());
        assertEquals("Triangles", triangles.getName());
        assertEquals("material-1", triangles.getMaterial());

        // Check inputs
        final SharedInputs primInputs = triangles.getInputs();
        assertEquals(2, primInputs.size());

        // Check input
        final SharedInput primInput = primInputs.get(1);
        assertSame(doc, primInput.getDocument());
        assertSame(triangles, primInput.getParent());
        assertEquals(new URI("#geometry-1-floats"), primInput.getSource());
        assertEquals("STUFF", primInput.getSemantic());
        assertEquals(2, primInput.getOffset());
        assertEquals(1, primInput.getSet());

        // Check primitive data
        final PrimitiveData data = triangles.getData();
        assertEquals(6, data.getSize());
        assertEquals(0, data.getValue(0));
        assertEquals(1, data.getValue(1));
        assertEquals(2, data.getValue(2));
        assertEquals(3, data.getValue(3));
        assertEquals(4, data.getValue(4));
        assertEquals(5, data.getValue(5));
    }


    /**
     * Tests the visual scene libraries.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testVisualSceneLibraries() throws Exception
    {
        // Check visual scene libraries
        final VisualSceneLibraries visualSceneLibs = doc
                .getVisualSceneLibraries();
        assertEquals(1, visualSceneLibs.size());

        // Check visual scene library
        final VisualSceneLibrary visualSceneLib = visualSceneLibs.get(0);
        assertEquals("visual-scene-lib-1", visualSceneLib.getId());
        assertEquals("Visual Scene Lib 1", visualSceneLib.getName());
        assertSame(doc, visualSceneLib.getDocument());
        assertSame(doc, visualSceneLib.getParent());

        // Check visual scenes
        final VisualScenes visualScenes = visualSceneLib.getVisualScenes();
        assertEquals(1, visualScenes.size());

        // Check visual scene
        final VisualScene visualScene = visualScenes.get(0);
        assertEquals("visual-scene-1", visualScene.getId());
        assertEquals("Visual Scene 1", visualScene.getName());
        assertSame(doc, visualScene.getDocument());
        assertSame(visualSceneLib, visualScene.getParent());

        // Check root nodes
        final Nodes rootNodes = visualScene.getNodes();
        assertEquals(1, rootNodes.size());

        // Check root node
        final Node rootNode = rootNodes.get(0);
        assertSame(doc, rootNode.getDocument());
        assertSame(visualScene, rootNode.getParent());
        assertEquals("node-1", rootNode.getId());
        assertEquals("Node 1", rootNode.getName());
        assertEquals(NodeType.NODE, rootNode.getType());
        assertEquals("node-a", rootNode.getSid());

        // Check layers
        final List<String> layers = rootNode.getLayers();
        assertEquals(2, layers.size());
        assertEquals("l1", layers.get(0));
        assertEquals("lay2", layers.get(1));

        // Check transformations
        final Transforms transforms = rootNode.getTransforms();
        assertEquals(6, transforms.size());

        // Check lookat transformation
        final LookAtTransform lookAtTransform = (LookAtTransform) transforms
                .get(0);
        assertSame(doc, lookAtTransform.getDocument());
        assertSame(rootNode, lookAtTransform.getParent());
        assertEquals("node-1-lookat", lookAtTransform.getSid());
        assertEquals(new MutableVector3d(1, 2, 3), lookAtTransform.getEye());
        assertEquals(new MutableVector3d(4, 5, 6), lookAtTransform.getInterest());
        assertEquals(new MutableVector3d(7, 8, 9), lookAtTransform.getUp());

        // Check matrix transformation
        final MatrixTransform matrixTransform = (MatrixTransform) transforms
                .get(1);
        assertSame(doc, matrixTransform.getDocument());
        assertSame(rootNode, matrixTransform.getParent());
        assertEquals("node-1-matrix", matrixTransform.getSid());
        assertEquals(new MutableMatrix4d(0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10,
            14, 3, 7, 11, 15), matrixTransform.getMatrix());

        // Check rotate transformation
        final RotateTransform rotateTransform = (RotateTransform) transforms
                .get(2);
        assertSame(doc, rotateTransform.getDocument());
        assertSame(rootNode, rotateTransform.getParent());
        assertEquals("node-1-rotate", rotateTransform.getSid());
        assertEquals(new MutableVector3d(1, 2, 3), rotateTransform.getAxis());
        assertEquals(4, rotateTransform.getAngle(), 0.001);

        // Check scale transformation
        final ScaleTransform scaleTransform = (ScaleTransform) transforms.get(3);
        assertSame(doc, scaleTransform.getDocument());
        assertSame(rootNode, scaleTransform.getParent());
        assertEquals("node-1-scale", scaleTransform.getSid());
        assertEquals(new MutableVector3d(4, 5, 6), scaleTransform.getScaling());

        // Check skew transformation
        final SkewTransform skewTransform = (SkewTransform) transforms.get(4);
        assertSame(doc, skewTransform.getDocument());
        assertSame(rootNode, skewTransform.getParent());
        assertEquals("node-1-skew", skewTransform.getSid());
        assertEquals(1, skewTransform.getAngle(), 0.001);
        assertEquals(new MutableVector3d(2, 3, 4), skewTransform.getRotationAxis());
        assertEquals(new MutableVector3d(5, 6, 7), skewTransform.getTranslationAxis());

        // Check translate transformation
        final TranslateTransform translateTransform = (TranslateTransform) transforms.get(5);
        assertSame(doc, translateTransform.getDocument());
        assertSame(rootNode, translateTransform.getParent());
        assertEquals("node-1-translate", translateTransform.getSid());
        assertEquals(new MutableVector3d(1, 2, 3), translateTransform.getTranslation());

        // Check sub nodes
        final Nodes nodes = rootNode.getNodes();
        assertEquals(2, nodes.size());

        // Check sub node
        final Node node = nodes.get(1);
        assertSame(doc, node.getDocument());
        assertSame(rootNode, node.getParent());
        assertEquals(0, node.getNodes().size());

        // Check camera instances
        final CameraInstances cameraInstances = rootNode.getCameraInstances();
        assertEquals(1, cameraInstances.size());

        // Check camera instance
        final CameraInstance cameraInstance = cameraInstances.get(0);
        assertSame(doc, cameraInstance.getDocument());
        assertSame(rootNode, cameraInstance.getParent());
        assertEquals("camera", cameraInstance.getSid());
        assertEquals("Camera", cameraInstance.getName());
        assertEquals(new URI("#camera-1"), cameraInstance.getUrl());

        // Check light instances
        final LightInstances lightInstances = rootNode.getLightInstances();
        assertEquals(1, lightInstances.size());

        // Check light instance
        final LightInstance lightInstance = lightInstances.get(0);
        assertSame(doc, lightInstance.getDocument());
        assertSame(rootNode, lightInstance.getParent());
        assertEquals("light", lightInstance.getSid());
        assertEquals("Light", lightInstance.getName());
        assertEquals(new URI("#light-1"), lightInstance.getUrl());

        // Check geometry instances
        final GeometryInstances geometryInstances = rootNode.getGeometryInstances();
        assertEquals(1, geometryInstances.size());

        // Check geometry instance
        final GeometryInstance geometryInstance = geometryInstances.get(0);
        assertSame(doc, geometryInstance.getDocument());
        assertSame(rootNode, geometryInstance.getParent());
        assertEquals("geometry", geometryInstance.getSid());
        assertEquals("Geometry", geometryInstance.getName());
        assertEquals(new URI("#geometry-1"), geometryInstance.getUrl());

        // Check material binding
        final MaterialBinding materialBinding = geometryInstance.getMaterialBinding();
        assertSame(doc, materialBinding.getDocument());
        assertSame(geometryInstance, materialBinding.getParent());

        // Check common technique
        final CommonMaterialBindingTechnique technique = materialBinding.getCommonTechnique();
        assertSame(doc, technique.getDocument());
        assertSame(materialBinding, technique.getParent());

        // Check material instances
        final MaterialInstances materialInstances = technique.getMaterialInstances();
        assertEquals(2, materialInstances.size());

        // Check material instance
        final MaterialInstance materialInstance = materialInstances.get(1);
        assertSame(doc, materialInstance.getDocument());
        assertSame(technique, materialInstance.getParent());
        assertEquals("RedMat Material", materialInstance.getName());
        assertEquals("redmat-material", materialInstance.getSid());
        assertEquals(new URI("beechBark"), materialInstance.getTarget());
        assertEquals("RedMat", materialInstance.getSymbol());

        // Check bind params
        final DataFlowParams params = materialBinding.getParams();
        assertEquals(1, params.size());

        // Check bind param
        final DataFlowParam param = params.get(0);
        assertSame(doc, param.getDocument());
        assertSame(materialBinding, param.getParent());
        assertEquals("Wind Amount", param.getName());
        assertEquals("WINDSPEED", param.getSemantic());
        assertEquals("windAmount", param.getSid());
        assertEquals("float3_type", param.getType());
    }


    /**
     * Tests the scene.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testScene() throws Exception
    {
        // Test the scene
        final Scene scene = doc.getScene();
        assertSame(doc, scene.getDocument());
        assertSame(doc, scene.getParent());

        // Test the visual scene instance
        final VisualSceneInstance instance = scene.getVisualSceneInstance();
        assertSame(doc, instance.getDocument());
        assertSame(scene, instance.getParent());
        assertEquals("Scene", instance.getName());
        assertEquals("scene", instance.getSid());
        assertEquals(new URI("#visual-scene-1"), instance.getUrl());
    }
}
