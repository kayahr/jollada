/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Array with double-precision floating point elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class FloatArray extends Array
{
    /** The default number of significant decimal digits. */
    public static final int DEFAULT_DIGITS = 6;

    /** The default largest exponent. */
    public static final int DEFAULT_MAGNITUDE = 38;

    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The data. */
    private double[] data;

    /**
     * The number of significant decimal digits of the float values that can be
     * contained in the array.
     */
    private int digits = DEFAULT_DIGITS;

    /**
     * The largest exponent of the float values that can be contained in the
     * array.
     */
    private int magnitude = DEFAULT_MAGNITUDE;


    /**
     * Constructor.
     *
     * @param count
     *            The data size.
     */

    public FloatArray(final int count)
    {
        if (count < 0)
            throw new IllegalArgumentException("count must be >= 0");
        this.data = new double[count];
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
        final double[] oldData = this.data;
        this.data = new double[count];
        System.arraycopy(oldData, 0, this.data, 0, Math
                .min(count, oldData.length));
    }


    /**
     * Returns the number of significant decimal digits of the float values that
     * can be contained in the array.
     *
     * @return The number of significant decimal digits.
     */

    public int getDigits()
    {
        return this.digits;
    }


    /**
     * Returns the largest exponent of the float values that value be obtained
     * in the array.
     *
     * @return The largest exponent.
     */

    public int getMagnitude()
    {
        return this.magnitude;
    }


    /**
     * Sets number of significant decimal digits of the float values that can be
     * contained in the array.
     *
     * @param digits
     *            The number of significant decimal digits.
     */

    public void setDigits(final int digits)
    {
        if (digits < 0 || digits > 0x7fff)
            throw new IllegalArgumentException(
                "Digits out of range [0..0x7fff]");
        this.digits = digits;
    }


    /**
     * Sets the largest exponent of the float values that can be contained in
     * the array.
     *
     * @param magnitude
     *            The largest exponent.
     */

    public void setMagnitude(final int magnitude)
    {
        if (magnitude > 0x7fff || magnitude < 0)
            throw new IllegalArgumentException(
                "Magnitude out of range [0..0x7fff]");
        this.magnitude = magnitude;
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
        final double[] values,
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
        final double[] values)
    {
        getValues(srcOffset, length, values, 0);
    }


    /**
     * Copies all values into the specified array.
     *
     * @param dest
     *            The destination array
     */

    public void getValues(final double[] dest)
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

    public double getValue(final int index)
    {
        return this.data[index];
    }


    /**
     * Returns a copy of the array values.
     *
     * @return The copy of the array values.
     */

    public double[] getValues()
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
        final double[] values, final int srcOffset)
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
        final double[] values)
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

    public void setValues(final double[] values)
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

    public void setValue(final int index, final double value)
    {
        this.data[index] = value;
    }
}
