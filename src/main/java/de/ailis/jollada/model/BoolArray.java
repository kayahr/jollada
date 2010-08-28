/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Array with boolean elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class BoolArray extends Array
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The data. */
    private boolean[] data;


    /**
     * Constructor.
     *
     * @param count
     *            The data size.
     */

    public BoolArray(final int count)
    {
        if (count < 0)
            throw new IllegalArgumentException("count must be >= 0");
        this.data = new boolean[count];
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
        final boolean[] oldData = this.data;
        this.data = new boolean[count];
        System.arraycopy(oldData, 0, this.data, 0, Math
                .min(count, oldData.length));
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
        final boolean[] values,
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
        final boolean[] values)
    {
        getValues(srcOffset, length, values, 0);
    }


    /**
     * Copies all values into the specified array.
     *
     * @param dest
     *            The destination array
     */

    public void getValues(final boolean[] dest)
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

    public boolean getValue(final int index)
    {
        return this.data[index];
    }


    /**
     * Returns a copy of the array values.
     *
     * @return The copy of the array values.
     */

    public boolean[] getValues()
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
        final boolean[] values, final int srcOffset)
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
        final boolean[] values)
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

    public void setValues(final boolean[] values)
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

    public void setValue(final int index, final boolean value)
    {
        this.data[index] = value;
    }
}
