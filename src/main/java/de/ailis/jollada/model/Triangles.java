/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Triangle primitives.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Triangles extends Primitives
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The primitives data */
    private PrimitiveData data;


    /**
     * Constructor.
     *
     * @param count
     *            The number of triangles.
     * @param data
     *            The triangle data. Must not be null.
     */

    public Triangles(final int count, final PrimitiveData data)
    {
        super(count);
        setData(data);
    }


    /**
     * Returns the triangle data.
     *
     * @return The triangle data
     */

    public PrimitiveData getData()
    {
        return this.data;
    }


    /**
     * Sets the triangle data.
     *
     * @param data
     *            The triangle data to set. Must not be null.
     */

    public void setData(final PrimitiveData data)
    {
        if (data == null)
            throw new IllegalArgumentException("data must not be null");
        this.data = data;
    }
}
