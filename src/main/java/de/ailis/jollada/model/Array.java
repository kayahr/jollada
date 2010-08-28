/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Base class for arrays.
 *
 * @author Klaus Reimer (k@ailis.de
 */

public abstract class Array extends Element implements Identifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The name. */
    protected String name;


    /**
     * Returns the size of the data.
     *
     * @return The data size.
     */

    public abstract int getCount();


    /**
     * Sets the data size. Internally this creates a new data array and copies
     * the old data over to the new one (Truncating the data if necessary).
     *
     * @param count
     *            The new data size
     */

    public abstract void setCount(final int count);


    /**
     * Returns the ID.
     *
     * @return The ID. May be null if not set.
     */

    @Override
    public final String getId()
    {
        return this.id;
    }


    /**
     * Sets the ID.
     *
     * @param id
     *            The ID to set. Null to unset.
     */

    @Override
    public final void setId(final String id)
    {
        super.updateId(id);
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
}
