/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.io.Serializable;


/**
 * Polygon data.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class PolygonData implements Serializable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The primitives data. */
    private IntList data;


    /**
     * Constructor.
     *
     * @param data
     *            The polylist data. Must not be null.
     */

    public PolygonData(final IntList data)
    {
        setData(data);
    }


    /**
     * Returns the triangle data.
     *
     * @return The triangle data
     */

    public IntList getData()
    {
        return this.data;
    }


    /**
     * Sets the triangle data.
     *
     * @param data
     *            The triangle data to set. Must not be null.
     */

    public void setData(final IntList data)
    {
        if (data == null)
            throw new IllegalArgumentException("data must not be null");
        this.data = data;
    }
}
