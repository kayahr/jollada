/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import java.util.ArrayList;
import java.util.List;

import de.ailis.jollada.model.IntList;
import de.ailis.jollada.model.Polygons;


/**
 * Builder for polygons primitives.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class PolygonsBuilder extends PrimitivesBuilder
{
    /** The polygons data. */
    private final List<IntList> data = new ArrayList<IntList>();


    /**
     * Builds the triangles.
     *
     * @return The triangles. Never null.
     */

    @Override
    public Polygons build()
    {
        if (this.data == null)
            throw new IllegalStateException("data not set");
        final Polygons polygons = new Polygons(this.count);
        polygons.getData().addAll(this.data);
        polygons.setMaterial(this.material);
        polygons.setName(this.name);
        polygons.getInputs().addAll(this.inputs);
        return polygons;
    }


    /**
     * Resets the builder.
     */

    @Override
    public void reset()
    {
        super.reset();
        this.data.clear();
        this.material = null;
        this.name = null;
    }


    /**
     * Returns the next primitive data.
     *
     * @return The next primitive data. Never null.
     */

    public List<IntList> getData()
    {
        return this.data;
    }
}
