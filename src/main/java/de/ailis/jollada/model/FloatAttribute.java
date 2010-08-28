/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;



/**
 * A float attribute.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class FloatAttribute extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The float value */
    private FloatValue floatValue;


    /**
     * Constructs a float attribute with the specified value.
     *
     * @param value
     *            The float value. Must not be null.
     */

    public FloatAttribute(final FloatValue value)
    {
        setFloat(value);
    }


    /**
     * Returns the value.
     *
     * @return The value. May be null if an other attribute is set.
     */

    public FloatValue getFloat()
    {
        return this.floatValue;
    }


    /**
     * Sets the value. This removes the other float attributes if present.
     *
     * @param floatValue
     *            The value to set. Must not be null.
     */

    public void setFloat(final FloatValue floatValue)
    {
        if (floatValue == null)
            throw new IllegalArgumentException("value must not be null");
        if (floatValue != this.floatValue)
        {
            if (this.floatValue != null) removeChild(this.floatValue);
            this.floatValue = floatValue;
            addChild(floatValue);
        }
    }
}
