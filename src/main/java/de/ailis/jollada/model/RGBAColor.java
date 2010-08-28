/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import de.ailis.gramath.Color4d;
import de.ailis.gramath.Color4f;
import de.ailis.gramath.ImmutableColor4d;
import de.ailis.gramath.ImmutableColor4f;


/**
 * A RGBA color.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class RGBAColor extends Element implements ScopeIdentifiable
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

    /** The alpha component. */
    private double alpha;

    /**
     * Default constructor.
     */

    public RGBAColor()
    {
        // Empty
    }


    /**
     * Constructor.
     *
     * @param red
     *            The red component.
     * @param green
     *            The green component.
     * @param blue
     *            The blue component.
     * @param alpha
     *            The alpha component.
     */

    public RGBAColor(final float red, final float green, final float blue,
        final float alpha)
    {
        setRed(red);
        setGreen(green);
        setBlue(blue);
        setAlpha(alpha);
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


    /**
     * Returns the alpha component.
     *
     * @return The alpha component
     */

    public double getAlpha()
    {
        return this.alpha;
    }


    /**
     * Sets the alpha component.
     *
     * @param alpha
     *            The alpha component to set
     */

    public void setAlpha(final double alpha)
    {
        this.alpha = alpha;
    }


    /**
     * Returns the color as a Color4d type.
     *
     * @return The color as a Color4d type. Never null.
     */

    public Color4d asColor4d()
    {
        return new ImmutableColor4d(this.red, this.green, this.blue, this.alpha);
    }


    /**
     * Returns the color as a Color4f type.
     *
     * @return The color as a Color4f type. Never null.
     */

    public Color4f asColor4f()
    {
        return new ImmutableColor4f((float) this.red, (float) this.green,
            (float) this.blue, (float) this.alpha);
    }
}
