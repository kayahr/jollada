/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import de.ailis.collada.model.FloatValue;
import de.ailis.collada.model.Orthographic;


/**
 * Builder for orthographic projection.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class OrthographicBuilder extends ProjectionBuilder
{
    /** The next horizontal magnification. */
    private FloatValue xMag;

    /** The next vertical magnification. */
    private FloatValue yMag;


    /**
     * Builds and returns the perspective projection.
     *
     * @return The perspective projection. Never null.
     */

    @Override
    public Orthographic build()
    {
        if (this.zNear == null)
            throw new IllegalStateException("zNear not set");
        if (this.zFar == null)
            throw new IllegalStateException("zFar not set");
        if (this.aspectRatio == null
            && (this.xMag == null || this.yMag == null))
            throw new IllegalStateException(
                "xMag and yMag must be set when no aspect ratio is given");
        if (this.aspectRatio != null
            && (this.xMag != null && this.yMag != null))
            throw new IllegalStateException(
                "Only xMag or yMag must be set when aspect ratio is given");
        final Orthographic orthographic = new Orthographic(this.zNear, this.zFar);
        orthographic.setAspectRatio(this.aspectRatio);
        orthographic.setXMag(this.xMag);
        orthographic.setYMag(this.yMag);
        return orthographic;
    }


    /**
     * Resets the builder.
     */

    @Override
    public void reset()
    {
        super.reset();
        this.xMag = null;
        this.yMag = null;
    }


    /**
     * Returns the next horizontal magnification.
     *
     * @return The next horizontal magnification. Null if not set.
     */

    public FloatValue getXMag()
    {
        return this.xMag;
    }


    /**
     * Sets the next horizontal magnification.
     *
     * @param xMag
     *            The magnification to set. Null to unset.
     */

    public void setXMag(final FloatValue xMag)
    {
        this.xMag = xMag;
    }


    /**
     * Returns the next vertical magnification.
     *
     * @return The next vertical magnification. Null if not set.
     */

    public FloatValue getYMag()
    {
        return this.yMag;
    }


    /**
     * Sets the next vertical magnification.
     *
     * @param yMag
     *            The magnification to set. Null to unset.
     */

    public void setYMag(final FloatValue yMag)
    {
        this.yMag = yMag;
    }
}
