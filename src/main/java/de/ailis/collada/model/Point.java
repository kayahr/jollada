/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Point light source.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class Point extends AttenuatedLightSource
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param color
     *            The light color. Must not be null.
     */

    public Point(final RGBColor color)
    {
        super(color);
    }
}
