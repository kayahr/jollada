/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.reader;


/**
 * The parser mode.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

enum ParserMode {
    /** Parser is at root level */
    ROOT(""),

    /** Parser is in COLLADA element */
    COLLADA("COLLADA"),

    /** Parser is in library_images element */
    LIBRARY_IMAGES("library_images"),

    /** Parser is in image element */
    IMAGE("image"),

    /** Parser is in image init_from element */
    IMAGE_INIT_FROM("init_from"),

    /** Parser is in image init_from element ref */
    IMAGE_INIT_FROM_REF("ref"),

    /** Parser is in library_materials element */
    LIBRARY_MATERIALS("library_materials"),

    /** Parser is in material element */
    MATERIAL("material"),

    /** Parser is in instance_effect element */
    INSTANCE_EFFECT("instance_effect"),

    /** Parser is in library_effects element */
    LIBRARY_EFFECTS("library_effects"),

    /** Parser is in effect element */
    EFFECT("effect"),

    /** Parser is in profile_COMMON element */
    PROFILE_COMMON("profile_COMMON"),

    /** Parser is in newparam element */
    NEWPARAM("newparam"),

    /** Parser is in surface element */
    SURFACE("surface"),

    /** Parser is in surface init_from element */
    SURFACE_INIT_FROM("init_from"),

    /** Parser is in sampler 2D element */
    SAMPLER2D("sampler2D"),

    /** Parser is in sampler 2D source element */
    SAMPLER2D_SOURCE("source"),

    /** Parser is in sampler 2D minfilter element */
    SAMPLER2D_MINFILTER("minfilter"),

    /** Parser is in sampler 2D magfilter element */
    SAMPLER2D_MAGFILTER("magfilter"),

    /** Parser is in sampler 2D wrap_s element */
    SAMPLER2D_WRAP_S("wrap_s"),

    /** Parser is in sampler 2D wrap_t element */
    SAMPLER2D_WRAP_T("wrap_t"),

    /** Parser is in instance_image element. */
    INSTANCE_IMAGE("instance_image"),

    /** Parser is in technique element */
    TECHNIQUE_COMMON("technique"),

    /** Parser is in phong element */
    PHONG("phong"),

    /** Parser is in blinn element */
    BLINN("blinn"),

    /** Parser is in constant element */
    CONSTANT("constant"),

    /** Parser is in lambert element */
    LAMBERT("lambert"),

    /** Parser is in emission element */
    EMISSION("emission"),

    /** Parser is in ambient element */
    AMBIENT("ambient"),

    /** Parser is in diffuse element */
    DIFFUSE("diffuse"),

    /** Parser is in specular element */
    SPECULAR("specular"),

    /** Parser is in reflective element */
    REFLECTIVE("reflective"),

    /** Parser is in transparent element */
    TRANSPARENT("transparent"),

    /** Parser is in shininess element */
    SHININESS("shininess"),

    /** Parser is in reflectivity element */
    REFLECTIVITY("reflectivity"),

    /** Parser is in transparency element */
    TRANSPARENCY("transparency"),

    /** Parser is in index_of_refraction element */
    INDEX_OF_REFRACTION("index_of_refraction"),

    /** Parser is in color element */
    SHADING_COLOR("color"),

    /** Parser is in texture element */
    TEXTURE("texture"),

    /** Parser is in float element */
    FLOAT("float"),

    /** Parser is in library_geometries element */
    LIBRARY_GEOMETRIES("library_geometries"),

    /** Parser is in geometry element */
    GEOMETRY("geometry"),

    /** Parser is in mesh element */
    MESH("mesh"),

    /** Parser is in mesh data source element */
    MESH_DATA_SOURCE("source"),

    /** Parser is in float_array element */
    FLOAT_ARRAY("float_array"),

    /** Parser is in Name_array element */
    NAME_ARRAY("Name_array"),

    /** Parser is in source technique_common element */
    SOURCE_TECHNIQUE_COMMON("technique_common"),

    /** Parser is in accessor element */
    ACCESSOR("accessor"),

    /** Parser is in param element */
    PARAM("param"),

    /** Parser is in vertices element */
    VERTICES("vertices"),

    /** Parser is in vertices input element */
    VERTICES_INPUT("input"),

    /** Parser is in polygons element */
    POLYGONS("polygons"),

    /** Parser is in primitives input element */
    PRIMITIVES_INPUT("input"),

    /** Parser is in polygons p element */
    POLYGONS_P("p"),

    /** Parser is in triangles element */
    TRIANGLES("triangles"),

    /** Parser is in triangles p element */
    TRIANGLES_P("p"),

    /** Parser is in polylist element */
    POLYLIST("polylist"),

    /** Parser is in polylist vcount element */
    POLYLIST_VCOUNT("vcount"),

    /** Parser is in polylist p element */
    POLYLIST_P("p"),

    /** Parser is in library_animations element */
    LIBRARY_ANIMATIONS("library_animations"),

    /** Parser is in animation element */
    ANIMATION("animation"),

    /** Parser is in animation data source element */
    ANIMATION_DATA_SOURCE("source"),

    /** Parser is in sampler element */
    SAMPLER("sampler"),

    /** Parser is in sampler input element */
    SAMPLER_INPUT("input"),

    /** Parser is in channel element */
    CHANNEL("channel"),

    /** Parser is in library_lights element */
    LIBRARY_LIGHTS("library_lights"),

    /** Parser is in light element */
    LIGHT("light"),

    /** Parser is in light technique_common element */
    LIGHT_TECHNIQUE_COMMON("technique_common"),

    /** Parser is in directional light element */
    LIGHT_DIRECTIONAL("directional"),

    /** Parser is in ambient light element */
    LIGHT_AMBIENT("ambient"),

    /** Parser is in point light element */
    LIGHT_POINT("point"),

    /** Parser is in spot light element */
    LIGHT_SPOT("spot"),

    /** Parser is in light color element */
    LIGHT_COLOR("color"),

    /** Parser is in falloff_angle element */
    FALLOFF_ANGLE("falloff_angle"),

    /** Parser is in falloff_exponent element */
    FALLOFF_EXPONENT("falloff_exponent"),

    /** Parser is in constant_attenuation element */
    CONSTANT_ATTENUATION("constant_attenuation"),

    /** Parser is in linear_attenuation element */
    LINEAR_ATTENUATION("linear_attenuation"),

    /** Parser is in quadratic_attenuation element */
    QUADRATIC_ATTENUATION("quadratic_attenuation"),

    /** Parser is in library cameras element */
    LIBRARY_CAMERAS("library_cameras"),

    /** Parser is in camera element */
    CAMERA("camera"),

    /** Parser is in optics element */
    OPTICS("optics"),

    /** Parser is in optics techniq_common element */
    OPTICS_TECHNIQUE_COMMON("technique_common"),

    /** Parser is in perspective element */
    PERSPECTIVE("perspective"),

    /** Parser is in orthographic element */
    ORTHOGRAPHIC("orthographic"),

    /** Parser is in xfov element */
    XFOV("xfov"),

    /** Parser is in yfov element */
    YFOV("yfov"),

    /** Parser is in xmag element */
    XMAG("xmag"),

    /** Parser is in ymag element */
    YMAG("ymag"),

    /** Parser is in aspect_Ratio element */
    ASPECT_RATIO("aspect_ratio"),

    /** Parser is in znear element */
    ZNEAR("znear"),

    /** Parser is in zfar element */
    ZFAR("zfar"),

    /** Parser is in library_visual_scenes element */
    LIBRARY_VISUAL_SCENES("library_visual_scenes"),

    /** Parser is in visual_scene element */
    VISUAL_SCENE("visual_scene"),

    /** Parser is in visual_scene node element */
    VISUAL_SCENE_NODE("node"),

    /** Parser is in node element */
    NODE("node"),

    /** Parser is in lookat element */
    LOOKAT("lookat"),

    /** Parser is in matrix element */
    MATRIX("matrix"),

    /** Parser is in rotate element */
    ROTATE("rotate"),

    /** Parser is in scale element */
    SCALE("scale"),

    /** Parser is in skew element */
    SKEW("skew"),

    /** Parser is in translate element */
    TRANSLATE("translate"),

    /** Parser is in instance_geometry element */
    INSTANCE_GEOMETRY("instance_geometry"),

    /** Parser is in bind_material element */
    BIND_MATERIAL("bind_material"),

    /** Parser is in bind_material param element */
    BIND_MATERIAL_PARAM("param"),

    /** Parser is in bind_material technique_common element */
    BIND_MATERIAL_TECHNIQUE_COMMON("technique_common"),

    /** Parser is in instance_material element */
    INSTANCE_MATERIAL("instance_material"),

    /** Parser is in instance_light element */
    INSTANCE_LIGHT("instance_light"),

    /** Parser is in instance camera element. */
    INSTANCE_CAMERA("instance_camera"),

    /** Parser is in scene element. */
    SCENE("scene"),

    /** Parser is in instance_visual_scene element. */
    INSTANCE_VISUAL_SCENE("instance_visual_scene"),

    /** Parser is in EXTRA element. */
    EXTRA("extra"),

    /** Parser is in a float param. */
    FLOAT_PARAM("float"),

    /** Parser is in param semantic element. */
    PARAM_SEMANTIC("semantic");


    /** The tag name */
    private String tagName;

    /**
     * Constructs a new parser mode.
     *
     * @param tagName
     *            The tag name
     */

    private ParserMode(final String tagName)
    {
        this.tagName = tagName;
    }


    /**
     * Returns the tag name.
     *
     * @return The tag name
     */

    public String getTagName()
    {
        return this.tagName;
    }
}
