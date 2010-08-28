/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Common technique for lights.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonLightTechnique extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The light source. */
    private LightSource lightSource;


    /**
     * Constructor.
     *
     * @param lightSource
     *            The light source. Must not be null.
     */

    public CommonLightTechnique(final LightSource lightSource)
    {
        setLightSource(lightSource);
    }


    /**
     * Returns the light source.
     *
     * @return The light source. Never null.
     */

    public LightSource getLightSource()
    {
        return this.lightSource;
    }


    /**
     * Sets the light source.
     *
     * @param lightSource
     *            The light source to set. Must not be null.
     */

    public void setLightSource(final LightSource lightSource)
    {
        if (lightSource == null)
            throw new IllegalArgumentException("projection must not be null");
        if (lightSource != this.lightSource)
        {
            if (this.lightSource != null) removeChild(this.lightSource);
            this.lightSource = lightSource;
            addChild(lightSource);
        }
    }
}
