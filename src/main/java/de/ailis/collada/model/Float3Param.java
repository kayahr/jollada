/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Parameter with three float values.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Float3Param extends Param
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
     */

    public Float3Param(final double value1, final double value2, final double value3)
    {
        this.values = new double[3];
        setValues(value1, value2, value3);
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
     */

    public void setValues(final double value1, final double value2, final double value3)
    {
        setValue(0, value1);
        setValue(1, value2);
        setValue(2, value3);
    }
}
