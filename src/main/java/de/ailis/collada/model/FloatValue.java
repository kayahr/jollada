/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;



/**
 * A float value.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class FloatValue extends Element implements ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The value */
    private double value;

    /** The scope ID */
    private String sid;


    /**
     * Constructs a float attribute with the specified value.
     *
     * @param value
     *            The float value. Must not be null.
     */

    public FloatValue(final double value)
    {
        setValue(value);
    }


    /**
     * Returns the value.
     *
     * @return The value.
     */

    public double getValue()
    {
        return this.value;
    }


    /**
     * Sets the value.
     *
     * @param value
     *            The value to set.
     */

    public void setValue(final double value)
    {
        this.value = value;
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Null to unset.
     */


    @Override
    public void setSid(final String sid)
    {
        this.sid = sid;
    }


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. May be null if not set.
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }
}
