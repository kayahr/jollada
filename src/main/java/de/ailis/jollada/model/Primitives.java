/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Base class for primitives.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Primitives extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The name */
    private String name;

    /** The number of primitives. */
    private int count;

    /** The material name. */
    private String material;

    /** The inputs */
    private final SharedInputs inputs = new SharedInputs(this);


    /**
     * Constructor.
     *
     * @param count
     *            The number of primitives
     */

    protected Primitives(final int count)
    {
        setCount(count);
    }


    /**
     * Returns the name.
     *
     * @return The name. May be null if not set.
     */

    public final String getName()
    {
        return this.name;
    }


    /**
     * Sets the name.
     *
     * @param name
     *            The name to set. Null to unset.
     */

    public final void setName(final String name)
    {
        this.name = name;
    }


    /**
     * Returns the number of primitives.
     *
     * @return The number of primitives.
     */

    public final int getCount()
    {
        return this.count;
    }


    /**
     * Returns the material name.
     *
     * @return The material name. May be null if not set.
     */

    public final String getMaterial()
    {
        return this.material;
    }


    /**
     * Sets the material name.
     *
     * @param material
     *            The material name to set. Null to unset.
     */

    public final void setMaterial(final String material)
    {
        this.material = material;
    }


    /**
     * Returns the inputs.
     *
     * @return The inputs. Never null. May be empty.
     */

    public final SharedInputs getInputs()
    {
        return this.inputs;
    }


    /**
     * Sets the number of primitives.
     *
     * @param count
     *            The number of primitives to set.
     */

    public final void setCount(final int count)
    {
        this.count = count;
    }
}
