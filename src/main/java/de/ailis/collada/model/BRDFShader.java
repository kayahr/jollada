/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Base-class for fixed-function pipeline shaders using a BRDF approximation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class BRDFShader extends Shader
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The amount of ambient light reflected from the surface. */
    private ColorAttribute ambient;

    /** The amount of light diffusely reflected from the surface. */
    private ColorAttribute diffuse;

    /** The color of light specularly reflected from the surface. */
    private ColorAttribute specular;

    /** The specularity or roughness. */
    private FloatAttribute shininess;


    /**
     * Returns the amount of ambient light reflected from the surface.
     *
     * @return The amount of ambient light reflected from the surface. May be
     *         null if not set.
     */

    public ColorAttribute getAmbient()
    {
        return this.ambient;
    }


    /**
     * Sets the amount of ambient light reflected from the surface.
     *
     * @param ambient
     *            The amount of ambient light reflected from the surface. Null
     *            to unset.
     */

    public void setAmbient(final ColorAttribute ambient)
    {
        if (ambient != this.ambient)
        {
            if (this.ambient != null) removeChild(this.ambient);
            this.ambient = ambient;
            if (ambient != null) addChild(ambient);
        }
    }


    /**
     * Returns the amount of light diffusely reflected from the surface.
     *
     * @return The amount of light diffusely reflected from the surface. May be
     *         null if not set.
     */

    public ColorAttribute getDiffuse()
    {
        return this.diffuse;
    }


    /**
     * Sets the amount of light diffusely reflected from the surface.
     *
     * @param diffuse
     *            The amount of light diffusely reflected from the surface. Null
     *            to unset.
     */

    public void setDiffuse(final ColorAttribute diffuse)
    {
        if (diffuse != this.diffuse)
        {
            if (this.diffuse != null) removeChild(this.diffuse);
            this.diffuse = diffuse;
            if (diffuse != null) addChild(diffuse);
        }
    }


    /**
     * Returns the color of light specularly reflected from the surface.
     *
     * @return The color of light specularly reflected from the surface. May be
     *         null if not set.
     */

    public ColorAttribute getSpecular()
    {
        return this.specular;
    }


    /**
     * Sets the color of light specularly reflected from the surface.
     *
     * @param specular
     *            The color of light specularly reflected from the surface. Null
     *            to unset.
     */

    public void setSpecular(final ColorAttribute specular)
    {
        if (specular != this.specular)
        {
            if (this.specular != null) removeChild(this.specular);
            this.specular = specular;
            if (specular != null) addChild(specular);
        }
    }


    /**
     * Returns the specularity or roughness.
     *
     * @return The specularity or roughness. May be null if not set.
     */

    public FloatAttribute getShininess()
    {
        return this.shininess;
    }


    /**
     * Sets the specularity or roughness.
     *
     * @param shininess
     *            The specularity or roughness. Null to unset.
     */

    public void setShininess(final FloatAttribute shininess)
    {
        if (shininess != this.shininess)
        {
            if (this.shininess != null) removeChild(this.shininess);
            this.shininess = shininess;
            if (shininess != null) addChild(shininess);
        }
    }
}
