/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Array with double-precision floating point elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class FloatArray extends Array
{
    /** The default number of significant decimal digits. */
    public static final int DEFAULT_DIGITS = 6;

    /** The default largest exponent.  */
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
    public FloatArray setCount(final int count)
    {
        final double[] oldData = this.data;
        this.data = new double[count];
        System.arraycopy(oldData, 0, this.data, 0, Math
                .min(count, oldData.length));
        return this;
    }


    /**
     * @see de.ailis.collada.model.Array#getData()
     */

    @Override
    public double[] getData()
    {
        return this.data;
    }


    /**
     * @see de.ailis.collada.model.Array#setId(java.lang.String)
     */

    @Override
    public FloatArray setId(final String id)
    {
        super.setId(id);
        return this;
    }


    /**
     * @see de.ailis.collada.model.Array#setName(java.lang.String)
     */

    @Override
    public FloatArray setName(final String name)
    {
        super.setName(name);
        return this;
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
     * @return This array for chaining.
     */

    public FloatArray setDigits(final int digits)
    {
        if (digits < 0 || digits > 0x7fff)
            throw new IllegalArgumentException(
                "Digits out of range [0..0x7fff]");
        this.digits = digits;
        return this;
    }


    /**
     * Sets the largest exponent of the float values that can be contained in
     * the array.
     *
     * @param magnitude
     *            The largest exponent.
     * @return This array for chaining.
     */

    public FloatArray setMagnitude(final int magnitude)
    {
        if (magnitude > 0x7fff || magnitude < 0)
            throw new IllegalArgumentException(
                "Magnitude out of range [0..0x7fff]");
        this.magnitude = magnitude;
        return this;
    }
}
