/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Array with long integer (64bit) elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class IntArray extends Array
{
    /** The default maximum value. */
    public static final long DEFAULT_MAX_INCLUSIVE = 0x7fffffff;

    /** The default maximum value. */
    public static final long DEFAULT_MIN_INCLUSIVE = -0x80000000;

    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The data. */
    private long[] data;

    /** The maximum value that can be present in the array. */
    private long maxInclusive = DEFAULT_MAX_INCLUSIVE;

    /** The minimum value that can be present in the array. */
    private long minInclusive = DEFAULT_MIN_INCLUSIVE;


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
     * @see de.ailis.jollada.model.Array#getCount()
     */

    @Override
    public int getCount()
    {
        return this.data.length;
    }


    /**
     * @see de.ailis.jollada.model.Array#setCount(int)
     */

    @Override
    public void setCount(final int count)
    {
        final long[] oldData = this.data;
        this.data = new long[count];
        System.arraycopy(oldData, 0, this.data, 0, Math
                .min(count, oldData.length));
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
     */

    public void setMaxInclusive(final long maxInclusive)
    {
        this.maxInclusive = maxInclusive;
    }


    /**
     * Sets the minimum value that can be present in the array.
     *
     * @param minInclusive
     *            The minimum value to set
     */

    public void setMinInclusive(final long minInclusive)
    {
        this.minInclusive = minInclusive;
    }


    /**
     * Copies a subset of the values to the specified destination array.
     *
     * @param srcOffset
     *            The starting index in the source data.
     * @param length
     *            The number of values to copy.
     * @param values
     *            The destination array to write the values to.
     * @param dstOffset
     *            The starting index in the destination array.
     */

    public void getValues(final int srcOffset, final int length,
        final long[] values,
        final int dstOffset)
    {
        System.arraycopy(this.data, srcOffset, values, dstOffset, length);
    }


    /**
     * Copies a subset of the values to the specified destination array.
     *
     * @param srcOffset
     *            The starting index in the source data.
     * @param length
     *            The number of values to copy.
     * @param values
     *            The destination array to write the values to.
     */

    public void getValues(final int srcOffset, final int length,
        final long[] values)
    {
        getValues(srcOffset, length, values, 0);
    }


    /**
     * Copies all values into the specified array.
     *
     * @param dest
     *            The destination array
     */

    public void getValues(final long[] dest)
    {
        getValues(0, Math.min(this.data.length, dest.length), dest);
    }


    /**
     * Returns the value at the specified index.
     *
     * @param index
     *            The index.
     * @return The value.
     */

    public long getValue(final int index)
    {
        return this.data[index];
    }


    /**
     * Returns a copy of the array values.
     *
     * @return The copy of the array values.
     */

    public long[] getValues()
    {
        return this.data.clone();
    }


    /**
     * Sets a subset of values.
     *
     * @param offset
     *            The starting offset.
     * @param length
     *            The number of values to copy.
     * @param values
     *            The source array with the values to set.
     * @param srcOffset
     *            The starting offset in the values array.
     */

    public void setValues(final int offset, final int length,
        final long[] values, final int srcOffset)
    {
        System.arraycopy(values, srcOffset, this.data, offset, length);
    }


    /**
     * Sets a subset of values.
     *
     * @param offset
     *            The starting offset.
     * @param length
     *            The number of values to copy.
     * @param values
     *            The source array with the values to set.
     */

    public void setValues(final int offset, final int length,
        final long[] values)
    {
        setValues(offset, length, values, 0);
    }


    /**
     * Sets the values. The whole specified source array is copied into the data
     * array beginning at index 0.
     *
     * @param values
     *            The values to set
     */

    public void setValues(final long[] values)
    {
        setValues(0, Math.min(values.length, this.data.length), values);
    }


    /**
     * Sets the value at the specified index.
     *
     * @param index
     *            The index.
     * @param value
     *            The value to set.
     */

    public void setValue(final int index, final long value)
    {
        this.data[index] = value;
    }
}
