/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Base class for fixed-function pipeline shading.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Shader extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The amount of light emitted from the surface. */
    private ColorAttribute emission;

    /** The color of a perfect mirror reflection. */
    private ColorAttribute reflective;

    /**
     * The amount of perfect mirror reflection to be added to the reflected
     * light as a value between 0.0 and 1.0.
     */
    private FloatAttribute reflectivity;

    /** The color of perfectly refracted light. */
    private ColorAttribute transparent;

    /**
     * The amount of perfectly refracted light added to the reflected color as a
     * scalar value between 0.0 and 1.0.
     */
    private FloatAttribute transparency;

    /**
     * The index of refraction for perfectly refracted light as a single scalar
     * index.
     */
    private FloatAttribute indexOfRefraction;


    /**
     * Returns the amount of light emitted from the surface.
     *
     * @return The amount of light emitted from the surface. May be null if not
     *         set.
     */

    public final ColorAttribute getEmission()
    {
        return this.emission;
    }


    /**
     * Sets the amount of light emitted from the surface.
     *
     * @param emission
     *            The amount of light emitted from the surface. Null to unset.
     */

    public final void setEmission(final ColorAttribute emission)
    {
        if (emission != this.emission)
        {
            if (this.emission != null) removeChild(this.emission);
            this.emission = emission;
            if (emission != null) addChild(emission);
        }
    }


    /**
     * Returns the color of a perfect mirror reflection.
     *
     * @return the color of a perfect mirror reflection. May be null if not set.
     */

    public final ColorAttribute getReflective()
    {
        return this.reflective;
    }


    /**
     * Sets the color of a perfect mirror reflection.
     *
     * @param reflective
     *            The the color of a perfect mirror reflection. Null to unset.
     */

    public final void setReflective(final ColorAttribute reflective)
    {
        if (reflective != this.reflective)
        {
            if (this.reflective != null) removeChild(this.reflective);
            this.reflective = reflective;
            if (reflective != null) addChild(reflective);
        }
    }


    /**
     * Returns the amount of perfect mirror reflection to be added to the
     * reflected light as a value between 0.0 and 1.0.
     *
     * @return The reflectivity. May be null if not set.
     */

    public final FloatAttribute getReflectivity()
    {
        return this.reflectivity;
    }


    /**
     * Sets the amount of perfect mirror reflection to be added to the
     * reflected light as a value between 0.0 and 1.0.
     *
     * @param reflectivity
     *            The reflectivity to set. Null to unset.
     */

    public final void setReflectivity(final FloatAttribute reflectivity)
    {
        if (reflectivity != this.reflectivity)
        {
            if (this.reflectivity != null) removeChild(this.reflectivity);
            this.reflectivity = reflectivity;
            if (reflectivity != null) addChild(reflectivity);
        }
    }


    /**
     * Returns the color of perfectly refracted light.
     *
     * @return The color of perfectly refracted light. May be null if not set.
     */

    public final ColorAttribute getTransparent()
    {
        return this.transparent;
    }


    /**
     * Sets the color of perfectly refracted light.
     *
     * @param transparent
     *            The color of perfectly refracted light. Null to unset.
     */

    public final void setTransparent(final ColorAttribute transparent)
    {
        if (transparent != this.transparent)
        {
            if (this.transparent != null) removeChild(this.transparent);
            this.transparent = transparent;
            if (transparent != null) addChild(transparent);
        }
    }


    /**
     * Returns the amount of perfectly refracted light added to the reflected
     * color as a scalar value between 0.0 and 1.0.
     *
     * @return The transparency. May be null if not set.
     */

    public final FloatAttribute getTransparency()
    {
        return this.transparency;
    }


    /**
     * Sets the amount of perfectly refracted light added to the reflected color
     * as a scalar value between 0.0 and 1.0.
     *
     * @param transparency
     *            The transparency to set. Null to unset.
     */

    public final void setTransparency(final FloatAttribute transparency)
    {
        if (transparency != this.transparency)
        {
            if (this.transparency != null) removeChild(this.transparency);
            this.transparency = transparency;
            if (transparency != null) addChild(transparency);
        }
    }


    /**
     * Returns the index of refraction for perfectly refracted light as a single
     * scalar index.
     *
     * @return The index of refracton. May be null if not set.
     */

    public final FloatAttribute getIndexOfRefraction()
    {
        return this.indexOfRefraction;
    }


    /**
     * Sets the index of refraction for perfectly refracted light as a single
     * scalar index.
     *
     * @param indexOfRefraction
     *            The index of refraction to set. Null to unset.
     */

    public final void setIndexOfRefraction(final FloatAttribute indexOfRefraction)
    {
        if (indexOfRefraction != this.indexOfRefraction)
        {
            if (this.indexOfRefraction != null) removeChild(this.indexOfRefraction);
            this.indexOfRefraction = indexOfRefraction;
            if (indexOfRefraction != null) addChild(indexOfRefraction);
        }
    }
}
