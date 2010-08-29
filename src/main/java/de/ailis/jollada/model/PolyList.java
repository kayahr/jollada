/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Polygon list primitives.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class PolyList extends Primitives
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The vertex count list. */
    private IntList vcount;

    /** The primitives data. */
    private IntList data;


    /**
     * Constructor.
     *
     * @param count
     *            The number of triangles.
     * @param vcount
     *            The list with the vertex counts per polygon. Must not be null.
     * @param data
     *            The polylist data. Must not be null.
     */

    public PolyList(final int count, final IntList vcount, final IntList data)
    {
        super(count);
        setVcount(vcount);
        setData(data);
    }


    /**
     * Returns the vertex count list.
     *
     * @return The vertex count list.
     */

    public IntList getVcount()
    {
        return this.vcount;
    }


    /**
     * Sets the vertex count list.
     *
     * @param vcount
     *            The vertex count list to set. Must not be null.
     */

    public void setVcount(final IntList vcount)
    {
        if (vcount == null)
            throw new IllegalArgumentException("vcount must not be null");
        this.vcount = vcount;
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
