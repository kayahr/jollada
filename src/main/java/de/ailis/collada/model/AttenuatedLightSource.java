/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Base class for attenuated light sources.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class AttenuatedLightSource extends LightSource
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The constant attenuation. */
    private FloatValue constantAttenuation;

    /** The linear attenuation. */
    private FloatValue linearAttenuation;

    /** The quadratic attenuation. */
    private FloatValue quadraticAttenuation;


    /**
     * Constructor.
     *
     * @param color
     *            The light color. Must not be null.
     */

    public AttenuatedLightSource(final RGBColor color)
    {
        super(color);
    }


    /**
     * Returns the constant attenuation. If not set then the value 1.0 must be
     * used.
     *
     * @return The constant attenuation. May be null if not set.
     */

    public FloatValue getConstantAttenuation()
    {
        return this.constantAttenuation;
    }


    /**
     * Sets the constant attenuation.
     *
     * @param constantAttenuation
     *            The constant attenuation to set. Null to unset.
     */

    public void setConstantAttenuation(final FloatValue constantAttenuation)
    {
        if (constantAttenuation != this.constantAttenuation)
        {
            if (this.constantAttenuation != null)
                removeChild(this.constantAttenuation);
            this.constantAttenuation = constantAttenuation;
            if (constantAttenuation != null) addChild(constantAttenuation);
        }
    }


    /**
     * Returns the linear attenuation. If not set then the value 0.0 must be
     * used.
     *
     * @return The linear attenuation. May be null if not set.
     */

    public FloatValue getLinearAttenuation()
    {
        return this.linearAttenuation;
    }


    /**
     * Sets the linear attenuation.
     *
     * @param linearAttenuation
     *            The linear attenuation to set. Null to unset.
     */

    public void setLinearAttenuation(final FloatValue linearAttenuation)
    {
        if (this.constantAttenuation != this.linearAttenuation)
        {
            if (this.linearAttenuation != null)
                removeChild(this.linearAttenuation);
            this.linearAttenuation = linearAttenuation;
            if (linearAttenuation != null) addChild(linearAttenuation);
        }
    }


    /**
     * Returns the quadratic attenuation. If not set then the value 0.0 must be
     * used.
     *
     * @return The quadratic attenuation. May be null if not set.
     */

    public FloatValue getQuadraticAttenuation()
    {
        return this.quadraticAttenuation;
    }


    /**
     * Sets the quadratic attenuation.
     *
     * @param quadraticAttenuation
     *            The quadratic attenuation to set. Null to unset.
     */

    public void setQuadraticAttenuation(final FloatValue quadraticAttenuation)
    {
        if (this.constantAttenuation != this.quadraticAttenuation)
        {
            if (this.quadraticAttenuation != null)
                removeChild(this.quadraticAttenuation);
            this.quadraticAttenuation = quadraticAttenuation;
            if (quadraticAttenuation != null) addChild(quadraticAttenuation);
        }
    }


    /**
     * Returns the total attenuation according to this formular: A =
     * constant_attenuation + ( Dist * linear_attenuation ) + (( Dist^2 ) *
     * quadratic_attenuation ).
     *
     * @param distance
     *            The distance.
     * @return The total attenuation.
     */

    public double getTotalAttenuation(final double distance)
    {
        final double constant = this.constantAttenuation == null ? 1
            : this.constantAttenuation.getValue();
        final double linear = this.linearAttenuation == null ? 0
            : this.linearAttenuation.getValue();
        final double quadratic = this.quadraticAttenuation == null ? 0
            : this.quadraticAttenuation.getValue();
        return constant + distance * linear + distance * distance * quadratic;
    }
}
