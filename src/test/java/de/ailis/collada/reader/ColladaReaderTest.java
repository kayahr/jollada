/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.junit.Test;

import de.ailis.collada.model.CommonEffectProfile;
import de.ailis.collada.model.CommonEffectTechnique;
import de.ailis.collada.model.CommonNewParam;
import de.ailis.collada.model.CommonNewParams;
import de.ailis.collada.model.Document;
import de.ailis.collada.model.Effect;
import de.ailis.collada.model.EffectInstance;
import de.ailis.collada.model.EffectLibraries;
import de.ailis.collada.model.EffectLibrary;
import de.ailis.collada.model.EffectProfile;
import de.ailis.collada.model.EffectProfiles;
import de.ailis.collada.model.Effects;
import de.ailis.collada.model.Filter;
import de.ailis.collada.model.FloatAttribute;
import de.ailis.collada.model.FloatParam;
import de.ailis.collada.model.FloatValue;
import de.ailis.collada.model.Image;
import de.ailis.collada.model.ImageLibraries;
import de.ailis.collada.model.ImageLibrary;
import de.ailis.collada.model.ImageSource;
import de.ailis.collada.model.Images;
import de.ailis.collada.model.Material;
import de.ailis.collada.model.MaterialLibraries;
import de.ailis.collada.model.MaterialLibrary;
import de.ailis.collada.model.Materials;
import de.ailis.collada.model.Param;
import de.ailis.collada.model.PhongShader;
import de.ailis.collada.model.RGBAColor;
import de.ailis.collada.model.Sampler2DParam;
import de.ailis.collada.model.Shader;
import de.ailis.collada.model.Texture;
import de.ailis.collada.model.Wrap;


/**
 * Tests reading COLLADA files.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ColladaReaderTest
{
    /**
     * Reads a COLLADA document.
     *
     * @param filename
     *            The filename.
     * @return The COLLADA document
     * @throws IOException
     *             When file could not be read
     */

    private Document readDocument(final String filename) throws IOException
    {
        final InputStream stream = getClass().getClassLoader()
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
     * Tests reading a full COLLADA file.
     *
     * @throws Exception
     *             When an error occurs.
     */

    @Test
    public void testFull() throws Exception
    {
        final Document doc = readDocument("full.dae");

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
        final Effect effect = effects.get(0);
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
        final CommonEffectTechnique commonEffectTechnique = commonEffectProfile
            .getTechnique();
        assertEquals("effect-1-common-technique", commonEffectTechnique.getId());
        assertEquals("technique", commonEffectTechnique.getSid());
        assertSame(doc, commonEffectTechnique.getDocument());
        assertSame(effectProfile, commonEffectTechnique.getParent());

        // Check shader
        final Shader shader = commonEffectTechnique.getShader();
        assertSame(doc, shader.getDocument());
        assertSame(commonEffectTechnique, shader.getParent());

        // Check reflectivity
        final FloatAttribute floatAttrib = shader.getReflectivity();
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
        final Texture texture = ((PhongShader) shader).getDiffuse().getTexture();
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
    }
}
