/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import de.ailis.collada.model.FloatValue;
import de.ailis.collada.model.Projection;


/**
 * Base-class for projection builders.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class ProjectionBuilder
{
    /** The next near clip plane distance. */
    protected FloatValue zNear;

    /** The next far clip plane distance. */
    protected FloatValue zFar;

    /** The next aspect ratio. */
    protected FloatValue aspectRatio;


    /**
     * Builds the projection.
     *
     * @return The projection.
     */

    public abstract Projection build();

    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.zNear = null;
        this.zFar = null;
        this.aspectRatio = null;
    }


    /**
     * Returns the next near clipping plane distance.
     *
     * @return The next near clipping plane distance. Null if not set.
     */

    public FloatValue getZNear()
    {
        return this.zNear;
    }


    /**
     * Sets the next near clipping plane distance.
     *
     * @param zNear
     *            The distance to set. Null to unset.
     */

    public void setZNear(final FloatValue zNear)
    {
        this.zNear = zNear;
    }


    /**
     * Returns the next far clipping plane distance.
     *
     * @return The next far clipping plane distance. Null if not set.
     */

    public FloatValue getZFar()
    {
        return this.zFar;
    }


    /**
     * Sets the next far clipping plane distance.
     *
     * @param zFar
     *            The distance to set. Null to unset.
     */

    public void setZFar(final FloatValue zFar)
    {
        this.zFar = zFar;
    }


    /**
     * Returns the next aspect ratio.
     *
     * @return The next aspect ratio. Null if not set.
     */

    public FloatValue getAspectRatio()
    {
        return this.aspectRatio;
    }


    /**
     * Sets the next aspect ratio.
     *
     * @param aspectRatio
     *            The aspect ratio to set. Null to unset.
     */

    public void setAspectRatio(final FloatValue aspectRatio)
    {
        this.aspectRatio = aspectRatio;
    }
}
