/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import java.util.ArrayList;
import java.util.List;

import de.ailis.jollada.model.Primitives;
import de.ailis.jollada.model.SharedInput;


/**
 * Base-class for primitives builder.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class PrimitivesBuilder
{
    /** The number of polygons. */
    protected int count;

    /** The next material. */
    protected String material;

    /** The next name. */
    protected String name;

    /** The list of inputs. */
    protected final List<SharedInput> inputs = new ArrayList<SharedInput>();


    /**
     * Builds the primitives.
     *
     * @return The primitives. Never null.
     */

    public abstract Primitives build();


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.count = 0;
        this.material = null;
        this.name = null;
    }


    /**
     * Returns the next material.
     *
     * @return The next material. May be null if not set.
     */

    public String getMaterial()
    {
        return this.material;
    }


    /**
     * Sets the next material.
     *
     * @param material
     *            The next material to set. Null to unset.
     */

    public void setMaterial(final String material)
    {
        this.material = material;
    }


    /**
     * Returns the next name.
     *
     * @return The next name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the next name.
     *
     * @param name
     *            The next name to set. Null to unset.
     */

    public void setName(final String name)
    {
        this.name = name;
    }


    /**
     * Returns the number of triangles.
     *
     * @return The number of triangles.
     */

    public int getCount()
    {
        return this.count;
    }


    /**
     * Sets the number of triangles.
     *
     * @param count
     *            The number of triangles to set
     */

    public void setCount(final int count)
    {
        this.count = count;
    }


    /**
     * Returns the list of inputs.
     *
     * @return The list of inputs. Never null. May be empty.
     */

    public List<SharedInput> getInputs()
    {
        return this.inputs;
    }
}
