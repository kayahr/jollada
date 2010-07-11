/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.io.Serializable;


/**
 * Measurement unit. Immutable.
 *
 * @author Klaus Reimer (k@ailis.de
 */

public final class Unit implements Serializable
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The real-world meters of the unit */
    private final float meter;

    /** The name of the unit */
    private final String name;


    /**
     * Constructs a new unit with default values (1 meter)
     */

    public Unit()
    {
        this(1f, "meter");
    }


    /**
     * Constructs a new unit with the given data.
     *
     * @param meter
     *            The real-world meters of a single unit
     * @param name
     *            The unit name. Must not be null.
     */

    public Unit(final float meter, final String name)
    {
        if (name == null)
            throw new IllegalArgumentException("name must not be null");
        this.meter = meter;
        this.name = name;
    }


    /**
     * Returns the real-world meters of a single unit.
     *
     * @return The real-world meters.
     */

    public float getMeter()
    {
        return this.meter;
    }


    /**
     * Returns the unit name.
     *
     * @return The unit name. Never null.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(this.meter);
        result = prime * result
            + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }


    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Unit other = (Unit) obj;
        if (Float.floatToIntBits(this.meter) != Float
                .floatToIntBits(other.meter)) return false;
        if (this.name == null)
        {
            if (other.name != null) return false;
        }
        else if (!this.name.equals(other.name)) return false;
        return true;
    }


    /**
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString()
    {
        return this.meter + " " + this.name;
    }
}
