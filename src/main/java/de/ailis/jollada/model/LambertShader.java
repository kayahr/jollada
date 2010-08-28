/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * A fixed-function pipeline shader producing a diffuse surface that is
 * independent of lighting.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class LambertShader extends Shader
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The amount of ambient light reflected from the surface. */
    private ColorAttribute ambient;

    /** The amount of light diffusely reflected from the surface. */
    private ColorAttribute diffuse;


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
}
