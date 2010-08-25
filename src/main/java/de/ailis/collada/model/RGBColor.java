/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A RGB color.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class RGBColor extends Element implements ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scope ID. */
    private String sid;

    /** The red component. */
    private double red;

    /** The green component. */
    private double green;

    /** The blue component. */
    private double blue;


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


    /**
     * Returns the red component.
     *
     * @return The red component
     */

    public double getRed()
    {
        return this.red;
    }


    /**
     * Sets the red component.
     *
     * @param red
     *            The red component to set
     */

    public void setRed(final double red)
    {
        this.red = red;
    }


    /**
     * Returns the green component.
     *
     * @return The green component
     */

    public double getGreen()
    {
        return this.green;
    }


    /**
     * Sets the green component.
     *
     * @param green
     *            The green component to set
     */

    public void setGreen(final double green)
    {
        this.green = green;
    }


    /**
     * Returns the blue component.
     *
     * @return The blue component
     */

    public double getBlue()
    {
        return this.blue;
    }


    /**
     * Sets the blue component.
     *
     * @param blue
     *            The blue component to set
     */

    public void setBlue(final double blue)
    {
        this.blue = blue;
    }
}
