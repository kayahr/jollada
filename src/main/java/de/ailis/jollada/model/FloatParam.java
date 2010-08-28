/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Parameter with a single float value.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class FloatParam extends Param
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The value. */
    private double value;


    /**
     * Constructors a new float parameter.
     *
     * @param value
     *            The value.
     */

    public FloatParam(final double value)
    {
        setValue(value);
    }


    /**
     * Returns the value.
     *
     * @return The value
     */

    public double getValue()
    {
        return this.value;
    }


    /**
     * Sets the value.
     *
     * @param value
     *            The value to set
     */

    public void setValue(final double value)
    {
        this.value = value;
    }
}
