/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Polygon primitives.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Polygons extends Primitives
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The list with polygon data. */
    private final List<IntList> data;


    /**
     * Constructor.
     *
     * @param count
     *            The number of triangles.
     */

    public Polygons(final int count)
    {
        super(count);
        this.data = new ArrayList<IntList>();
    }


    /**
     * Returns the list with polygon data.
     *
     * @return The list with polygon data
     */

    public List<IntList> getData()
    {
        return this.data;
    }
}
