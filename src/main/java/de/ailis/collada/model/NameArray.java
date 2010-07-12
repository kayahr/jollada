/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Array with name elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class NameArray extends Array
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The data. */
    private String[] data;


    /**
     * Constructor.
     *
     * @param count
     *            The data size.
     */

    public NameArray(final int count)
    {
        if (count < 0)
            throw new IllegalArgumentException("count must be >= 0");
        this.data = new String[count];
    }


    /**
     * @see de.ailis.collada.model.Array#getCount()
     */

    @Override
    public int getCount()
    {
        return this.data.length;
    }


    /**
     * @see de.ailis.collada.model.Array#setCount(int)
     */

    @Override
    public NameArray setCount(final int count)
    {
        final String[] oldData = this.data;
        this.data = new String[count];
        System.arraycopy(oldData, 0, this.data, 0, Math
                .min(count, oldData.length));
        return this;
    }


    /**
     * @see de.ailis.collada.model.Array#getData()
     */

    @Override
    public String[] getData()
    {
        return this.data;
    }


    /**
     * @see de.ailis.collada.model.Array#setId(java.lang.String)
     */

    @Override
    public NameArray setId(final String id)
    {
        super.setId(id);
        return this;
    }


    /**
     * @see de.ailis.collada.model.Array#setName(java.lang.String)
     */

    @Override
    public NameArray setName(final String name)
    {
        super.setName(name);
        return this;
    }
}
