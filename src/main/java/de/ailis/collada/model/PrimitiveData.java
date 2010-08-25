/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.util.Collection;


/**
 * The data defining a primitive.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class PrimitiveData
{
    /** The data. */
    private int[] data;


    /**
     * Constructor.
     *
     * @param size
     *            The data size.
     */

    public PrimitiveData(final int size)
    {
        if (size < 0)
            throw new IllegalArgumentException("size must be >= 0");
        this.data = new int[size];
    }


    /**
     * Returns the size of the data.
     *
     * @return The data size.
     */

    public int getSize()
    {
        return this.data.length;
    }


    /**
     * Sets the data size. The old data is padded or truncated to the new size.
     *
     * @param size
     *            The new data size to set.
     */

    public void setSize(final int size)
    {
        final int[] oldData = this.data;
        this.data = new int[size];
        System.arraycopy(oldData, 0, this.data, 0, Math
                .min(size, oldData.length));
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
        final int[] values,
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
        final int[] values)
    {
        getValues(srcOffset, length, values, 0);
    }


    /**
     * Copies all values into the specified array.
     *
     * @param dest
     *            The destination array
     */

    public void getValues(final int[] dest)
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

    public int getValue(final int index)
    {
        return this.data[index];
    }


    /**
     * Returns a copy of the array values.
     *
     * @return The copy of the array values.
     */

    public int[] getValues()
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
        final int[] values, final int srcOffset)
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
        final int[] values)
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

    public void setValues(final int[] values)
    {
        setValues(0, Math.min(values.length, this.data.length), values);
    }


    /**
     * Sets the values. The whole specified source array is copied into the data
     * array beginning at index 0.
     *
     * @param values
     *            The values to set
     */

    public void setValues(final Collection<? extends Number> values)
    {
        int i = 0;
        final int max = this.data.length;
        for (final Number value: values)
        {
            if (i >= max) break;
            this.data[i++] = value.intValue();
        }
    }


    /**
     * Sets the value at the specified index.
     *
     * @param index
     *            The index.
     * @param value
     *            The value to set.
     */

    public void setValue(final int index, final int value)
    {
        this.data[index] = value;
    }
}
