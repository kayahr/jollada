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

public class Unit implements Serializable
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
}
