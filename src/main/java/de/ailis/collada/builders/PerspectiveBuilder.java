/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import de.ailis.collada.model.FloatValue;
import de.ailis.collada.model.Perspective;


/**
 * Builder for perspective projection.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class PerspectiveBuilder extends ProjectionBuilder
{
    /** The next horizontal field of view. */
    private FloatValue xFov;

    /** The next vertical field of view. */
    private FloatValue yFov;


    /**
     * Builds and returns the perspective projection.
     *
     * @return The perspective projection. Never null.
     */

    @Override
    public Perspective build()
    {
        if (this.zNear == null)
            throw new IllegalStateException("zNear not set");
        if (this.zFar == null)
            throw new IllegalStateException("zFar not set");
        if (this.aspectRatio == null
            && (this.xFov == null || this.yFov == null))
            throw new IllegalStateException(
                "xFov and yFov must be set when no aspect ratio is given");
        if (this.aspectRatio != null
            && (this.xFov != null && this.yFov != null))
            throw new IllegalStateException(
                "Only xFov or yFov must be set when aspect ratio is given");
        final Perspective perspective = new Perspective(this.zNear, this.zFar);
        perspective.setAspectRatio(this.aspectRatio);
        perspective.setXFov(this.xFov);
        perspective.setYFov(this.yFov);
        return perspective;
    }


    /**
     * Resets the builder.
     */

    @Override
    public void reset()
    {
        super.reset();
        this.xFov = null;
        this.yFov = null;
    }


    /**
     * Returns the next horizontal field of view in degree.
     *
     * @return The next horizontal field of view. Null if not set.
     */

    public FloatValue getXFov()
    {
        return this.xFov;
    }


    /**
     * Sets the next horizontal field of view in degree.
     *
     * @param xFov
     *            The field of view to set. Null to unset.
     */

    public void setXFov(final FloatValue xFov)
    {
        this.xFov = xFov;
    }


    /**
     * Returns the next vertical field of view in degree.
     *
     * @return The next vertical field of view. Null if not set.
     */

    public FloatValue getYFov()
    {
        return this.yFov;
    }


    /**
     * Sets the next vertical field of view in degree.
     *
     * @param yFov
     *            The field of view to set. Null to unset.
     */

    public void setYFov(final FloatValue yFov)
    {
        this.yFov = yFov;
    }
}
