/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Spot light source.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class Spot extends AttenuatedLightSource
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The constant attenuation. */
    private FloatValue falloffAngle;

    /** The linear attenuation. */
    private FloatValue falloffExponent;


    /**
     * Constructor.
     *
     * @param color
     *            The light color. Must not be null.
     */

    public Spot(final RGBColor color)
    {
        super(color);
    }


    /**
     * Returns the falloff angle in degree. If not set then the value 180 must be
     * used.
     *
     * @return The falloff angle. May be null if not set.
     */

    public FloatValue getFalloffAngle()
    {
        return this.falloffAngle;
    }


    /**
     * Sets the falloff angle.
     *
     * @param falloffAngle
     *            The falloff angle to set. Null to unset.
     */

    public void setFalloffAngle(final FloatValue falloffAngle)
    {
        if (falloffAngle != this.falloffAngle)
        {
            if (this.falloffAngle != null)
                removeChild(this.falloffAngle);
            this.falloffAngle = falloffAngle;
            if (falloffAngle != null) addChild(falloffAngle);
        }
    }


    /**
     * Returns the falloff exponent. If not set then the value 0.0 must be
     * used.
     *
     * @return The falloff exponent. May be null if not set.
     */

    public FloatValue getFalloffExponent()
    {
        return this.falloffExponent;
    }


    /**
     * Sets the falloff exponent.
     *
     * @param falloffExponent
     *            The falloff exponent to set. Null to unset.
     */

    public void setFalloffExponent(final FloatValue falloffExponent)
    {
        if (this.falloffAngle != this.falloffExponent)
        {
            if (this.falloffExponent != null)
                removeChild(this.falloffExponent);
            this.falloffExponent = falloffExponent;
            if (falloffExponent != null) addChild(falloffExponent);
        }
    }
}
