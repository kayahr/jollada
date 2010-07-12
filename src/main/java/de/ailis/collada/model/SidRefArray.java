/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Array with SIDREF elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class SidRefArray extends Array
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The data. */
    private String[] data;

    /** The name. */
    private String name;


    /**
     * Constructor.
     *
     * @param count
     *            The data size.
     */

    public SidRefArray(final int count)
    {
        if (count < 0)
            throw new IllegalArgumentException("count must be >= 0");
        this.data = new String[count];
    }


    /**
     * Returns the size of the data.
     *
     * @return The data size.
     */

    public int getCount()
    {
        return this.data.length;
    }


    /**
     * Sets the data size. Internally this creates a new data array and copies
     * the old data over to the new one (Truncating the data if necessary).
     *
     * @param count
     *            The new data size
     * @return This array for chaining.
     */

    public SidRefArray setCount(final int count)
    {
        final String[] oldData = this.data;
        this.data = new String[count];
        System.arraycopy(oldData, 0, this.data, 0, Math
            .min(count, oldData.length));
        return this;
    }


    /**
     * Returns the data.
     *
     * @return The data.
     */

    public String[] getData()
    {
        return this.data;
    }


    /**
     * Sets the ID.
     *
     * @param id
     *            The ID to set. Null to unset.
     * @return This array for chaining.
     */

    @Override
    public void setId(final String id)
    {
        super.setId(id);
        // TODO return this;
    }


    /**
     * Returns the ID.
     *
     * @return The ID. May be null if not set.
     */

    @Override
    public String getId()
    {
        return this.id;
    }


    /**
     * Returns the name.
     *
     * @return The name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the name.
     *
     * @param name
     *            The name to set. Null to unset.
     * @return This array for chaining.
     */

    public SidRefArray setName(final String name)
    {
        this.name = name;
        return this;
    }
}
