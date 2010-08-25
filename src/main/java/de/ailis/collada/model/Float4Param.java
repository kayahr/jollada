/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Parameter with four float values.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Float4Param extends Param
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The values. */
    private final double[] values;


    /**
     * Constructors a new float parameter.
     *
     * @param value1
     *            The first value.
     * @param value2
     *            The second value.
     * @param value3
     *            The third value.
     * @param value4
     *            The forth value.
     */

    public Float4Param(final double value1, final double value2,
        final double value3, final double value4)
    {
        this.values = new double[4];
        setValues(value1, value2, value3, value4);
    }


    /**
     * Returns the value.
     *
     * @param index
     *            The index.
     * @return The value
     */

    public double getValue(final int index)
    {
        return this.values[index];
    }


    /**
     * Sets the value.
     *
     * @param index
     *            The index.
     * @param value
     *            The value to set
     */

    public void setValue(final int index, final double value)
    {
        this.values[index] = value;
    }


    /**
     * Sets the values.
     *
     * @param value1
     *            The first value.
     * @param value2
     *            The second value.
     * @param value3
     *            The third value.
     * @param value4
     *            The forth value.
     */

    public void setValues(final double value1, final double value2,
        final double value3, final double value4)
    {
        setValue(0, value1);
        setValue(1, value2);
        setValue(2, value3);
        setValue(3, value4);
    }
}
