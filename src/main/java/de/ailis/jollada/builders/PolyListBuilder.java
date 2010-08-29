/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import de.ailis.jollada.model.IntList;
import de.ailis.jollada.model.PolyList;


/**
 * Builder for polylist primitives.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class PolyListBuilder extends PrimitivesBuilder
{
    /** The vertex counts. */
    private IntList vcount;

    /** The primitive data. */
    private IntList data;


    /**
     * Builds the triangles.
     *
     * @return The triangles. Never null.
     */

    @Override
    public PolyList build()
    {
        if (this.vcount == null)
            throw new IllegalStateException("vcount not set");
        if (this.data == null)
            throw new IllegalStateException("data not set");
        final PolyList polyList = new PolyList(this.count, this.vcount, this.data);
        polyList.setMaterial(this.material);
        polyList.setName(this.name);
        polyList.getInputs().addAll(this.inputs);
        return polyList;
    }


    /**
     * Resets the builder.
     */

    @Override
    public void reset()
    {
        super.reset();
        this.vcount = null;
        this.data = null;
        this.material = null;
        this.name = null;
    }


    /**
     * Returns the next vertex count list.
     *
     * @return The next vertex count list. May be null if unset.
     */

    public IntList getVcount()
    {
        return this.vcount;
    }


    /**
     * Sets the next vertex count list.
     *
     * @param vcount
     *            The next vertex count list to set. Null to unset.
     */

    public void setVcount(final IntList vcount)
    {
        this.vcount = vcount;
    }


    /**
     * Returns the next primitive data.
     *
     * @return The next primitive data. May be null if unset.
     */

    public IntList getData()
    {
        return this.data;
    }


    /**
     * Sets the next primitive data.
     *
     * @param data
     *            The next primitive data to set. Null to unset.
     */

    public void setData(final IntList data)
    {
        this.data = data;
    }
}
