/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Base class for camera optics projections.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class LightSource extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The light color. */
    private RGBColor color;


    /**
     * Constructor.
     *
     * @param color
     *            The light color. Must not be null.
     */

    public LightSource(final RGBColor color)
    {
        setColor(color);
    }


    /**
     * Returns the light color.
     *
     * @return The light color. Never null.
     */

    public RGBColor getColor()
    {
        return this.color;
    }


    /**
     * Sets the light color.
     *
     * @param color
     *            The color to set. Must not be null.
     */

    public void setColor(final RGBColor color)
    {
        if (color == null)
            throw new IllegalArgumentException("color must not be null");
        if (color != this.color)
        {
            if (this.color != null) removeChild(this.color);
            this.color = color;
            addChild(color);
        }
    }
}
