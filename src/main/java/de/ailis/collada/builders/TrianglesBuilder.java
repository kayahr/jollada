/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import java.util.ArrayList;
import java.util.List;

import de.ailis.collada.model.PrimitiveData;
import de.ailis.collada.model.SharedInput;
import de.ailis.collada.model.Triangles;


/**
 * Builder for triangles primitives.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class TrianglesBuilder
{
    /** The geometric element. */
    private PrimitiveData data;

    /** The number of triangles. */
    private int count;

    /** The next material. */
    private String material;

    /** The next name. */
    private String name;

    /** The list of inputs. */
    private final List<SharedInput> inputs = new ArrayList<SharedInput>();


    /**
     * Builds the triangles.
     *
     * @return The triangles. Never null.
     */

    public Triangles build()
    {
        if (this.data == null)
            throw new IllegalStateException("data not set");
        final Triangles triangles = new Triangles(this.count, this.data);
        triangles.setMaterial(this.material);
        triangles.setName(this.name);
        triangles.getInputs().addAll(this.inputs);
        return triangles;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.data = null;
        this.material = null;
        this.name = null;
    }


    /**
     * Returns the next primitive data.
     *
     * @return The next primitive data. May be null if unset.
     */

    public PrimitiveData getData()
    {
        return this.data;
    }


    /**
     * Sets the next primitive data.
     *
     * @param data
     *            The next primitive data to set. Null to unset.
     */

    public void setData(final PrimitiveData data)
    {
        this.data = data;
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
