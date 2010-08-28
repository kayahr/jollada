/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import de.ailis.jollada.model.Ambient;
import de.ailis.jollada.model.Directional;
import de.ailis.jollada.model.FloatValue;
import de.ailis.jollada.model.Point;
import de.ailis.jollada.model.RGBColor;
import de.ailis.jollada.model.Spot;


/**
 * Base-class for projection builders.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class LightSourceBuilder
{
    /** The next light color. */
    private RGBColor color;

    /** The next constant attenuation. */
    private FloatValue constantAttenuation;

    /** The next linear attenuation. */
    private FloatValue linearAttenuation;

    /** The next quadratic attenuation. */
    private FloatValue quadraticAttenuation;

    /** The next falloff angle. */
    private FloatValue falloffAngle;

    /** The next falloff exponent. */
    private FloatValue falloffExponent;


    /**
     * Builds an ambient light source.
     *
     * @return The ambient light source
     */

    public Ambient buildAmbient()
    {
        if (this.color == null)
            throw new IllegalStateException("color must be set");
        return new Ambient(this.color);
    }


    /**
     * Builds a directional light source.
     *
     * @return The directional light source
     */

    public Directional buildDirectional()
    {
        if (this.color == null)
            throw new IllegalStateException("color must be set");
        return new Directional(this.color);
    }


    /**
     * Builds a point light source.
     *
     * @return The point light source
     */

    public Point buildPoint()
    {
        if (this.color == null)
            throw new IllegalStateException("color must be set");
        final Point point = new Point(this.color);
        point.setConstantAttenuation(this.constantAttenuation);
        point.setLinearAttenuation(this.linearAttenuation);
        point.setQuadraticAttenuation(this.quadraticAttenuation);
        return point;
    }


    /**
     * Builds a spot light source.
     *
     * @return The spot light source
     */

    public Spot buildSpot()
    {
        if (this.color == null)
            throw new IllegalStateException("color must be set");
        final Spot spot = new Spot(this.color);
        spot.setConstantAttenuation(this.constantAttenuation);
        spot.setLinearAttenuation(this.linearAttenuation);
        spot.setQuadraticAttenuation(this.quadraticAttenuation);
        spot.setFalloffAngle(this.falloffAngle);
        spot.setFalloffExponent(this.falloffExponent);
        return spot;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.color = null;
    }


    /**
     * Returns the next color.
     *
     * @return The color. May be null if not set.
     */

    public RGBColor getColor()
    {
        return this.color;
    }


    /**
     * Sets the next color.
     *
     * @param color
     *            The color to set. Null to unset.
     */

    public void setColor(final RGBColor color)
    {
        this.color = color;
    }


    /**
     * Returns the next constant attenuation.
     *
     * @return The constant attenuation. May be null if not set.
     */

    public FloatValue getConstantAttenuation()
    {
        return this.constantAttenuation;
    }


    /**
     * Sets the next constant attenuation.
     *
     * @param constantAttenuation
     *            The constant attenuation to set. Null to unset.
     */

    public void setConstantAttenuation(final FloatValue constantAttenuation)
    {
        this.constantAttenuation = constantAttenuation;
    }


    /**
     * Returns the next linear attenuation.
     *
     * @return The linear attenuation. May be null if not set.
     */

    public FloatValue getLinearAttenuation()
    {
        return this.linearAttenuation;
    }


    /**
     * Sets the next linear attenuation.
     *
     * @param linearAttenuation
     *            The linear attenuation to set. Null to unset.
     */

    public void setLinearAttenuation(final FloatValue linearAttenuation)
    {
        this.linearAttenuation = linearAttenuation;
    }


    /**
     * Returns the next quadratic attenuation.
     *
     * @return The quadratic attenuation. May be null if not set.
     */

    public FloatValue getQuadraticAttenuation()
    {
        return this.quadraticAttenuation;
    }


    /**
     * Sets the next quadratic attenuation.
     *
     * @param quadraticAttenuation
     *            The quadratic attenuation to set. Null to unset.
     */

    public void setQuadraticAttenuation(final FloatValue quadraticAttenuation)
    {
        this.quadraticAttenuation = quadraticAttenuation;
    }


    /**
     * Returns the next falloff angle.
     *
     * @return The falloff angle. May be null if not set.
     */

    public FloatValue getFalloffAngle()
    {
        return this.falloffAngle;
    }


    /**
     * Sets the next falloff angle.
     *
     * @param falloffAngle
     *            The falloff angle to set. Null to unset.
     */

    public void setFalloffAngle(final FloatValue falloffAngle)
    {
        this.falloffAngle = falloffAngle;
    }


    /**
     * Returns the next falloff exponent.
     *
     * @return The falloff exponent. Maybe null if not set.
     */

    public FloatValue getFalloffExponent()
    {
        return this.falloffExponent;
    }


    /**
     * Sets the next falloff exponent.
     *
     * @param falloffExponent
     *            The falloff exponent to set. Null to unset.
     */

    public void setFalloffExponent(final FloatValue falloffExponent)
    {
        this.falloffExponent = falloffExponent;
    }
}
