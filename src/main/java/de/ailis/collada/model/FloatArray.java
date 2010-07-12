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
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The data. */
    private double[] data;

    /**
     * The number of significant decimal digits of the float values that can be
     * contained in the array.
     */
    private int digits = 6;

    /**
     * The largest exponent of the float values that can be contained in the
     * array.
     */
    private int magnitude = 38;

    /** The name. */
    private String name;


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

    public FloatArray setCount(final int count)
    {
        final double[] oldData = this.data;
        this.data = new double[count];
        System.arraycopy(oldData, 0, this.data, 0, Math
            .min(count, oldData.length));
        return this;
    }


    /**
     * Returns the data.
     *
     * @return The data.
     */

    public double[] getData()
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
    public FloatArray setId(final String id)
    {
        super.setId(id);
        return this;
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

    public FloatArray setName(final String name)
    {
        this.name = name;
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
