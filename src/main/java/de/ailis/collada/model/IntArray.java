/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Array with long integer (64bit) elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class IntArray extends Array
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The data. */
    private long[] data;

    /** The minimum value that can be present in the array. */
    private long maxInclusive = 0x7fffffff;

    /** The maximum value that can be present in the array. */
    private long minInclusive = -0x80000000;


    /**
     * Constructor.
     *
     * @param count
     *            The data size.
     */

    public IntArray(final int count)
    {
        if (count < 0)
            throw new IllegalArgumentException("count must be >= 0");
        this.data = new long[count];
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
    public IntArray setCount(final int count)
    {
        final long[] oldData = this.data;
        this.data = new long[count];
        System.arraycopy(oldData, 0, this.data, 0, Math
                .min(count, oldData.length));
        return this;
    }


    /**
     * @see de.ailis.collada.model.Array#getData()
     */

    @Override
    public long[] getData()
    {
        return this.data;
    }


    /**
     * @see de.ailis.collada.model.Array#setId(java.lang.String)
     */

    @Override
    public IntArray setId(final String id)
    {
        super.setId(id);
        return this;
    }


    /**
     * @see de.ailis.collada.model.Array#setName(java.lang.String)
     */

    @Override
    public IntArray setName(final String name)
    {
        super.setName(name);
        return this;
    }


    /**
     * Returns the maximum value that can be present in the array.
     *
     * @return The maximum value.
     */

    public long getMaxInclusive()
    {
        return this.maxInclusive;
    }


    /**
     * Returns the minimum value that can be present in the array.
     *
     * @return The minimum value.
     */

    public long getMinInclusive()
    {
        return this.minInclusive;
    }


    /**
     * Sets the maximum value that can be present in the array.
     *
     * @param maxInclusive
     *            The maximum value to set
     * @return This array for chaining.
     */

    public IntArray setMaxInclusive(final long maxInclusive)
    {
        this.maxInclusive = maxInclusive;
        return this;
    }


    /**
     * Sets the minimum value that can be present in the array.
     *
     * @param minInclusive
     *            The minimum value to set
     * @return This array for chaining.
     */

    public IntArray setMinInclusive(final long minInclusive)
    {
        this.minInclusive = minInclusive;
        return this;
    }
}
