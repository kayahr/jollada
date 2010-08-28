/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Orthographic projection.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Perspective extends Projection
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The horizontal field of view in degrees. */
    private FloatValue xFov;

    /** The vertical field of view in degrees. */
    private FloatValue yFov;


    /**
     * Constructor.
     *
     * @param zNear
     *            The distance to the near clipping plane. Must not be null.
     * @param zFar
     *            The distance to the far clipping plane. Must not be null.
     */

    public Perspective(final FloatValue zNear, final FloatValue zFar)
    {
        super(zNear, zFar);
    }


    /**
     * Returns the horizontal field of view in degrees.
     *
     * @return The horizontal field of view. May be null if not set.
     */

    public FloatValue getXFov()
    {
        return this.xFov;
    }


    /**
     * Sets the horizontal field of view in degrees.
     *
     * @param xFov
     *            The field of view to set. Null to unset.
     */

    public void setXFov(final FloatValue xFov)
    {
        if (xFov != this.xFov)
        {
            if (this.xFov != null) removeChild(this.xFov);
            this.xFov = xFov;
            if (xFov != null) addChild(xFov);
        }
    }


    /**
     * Returns the vertical field of view in degrees.
     *
     * @return The vertical field of view. May be null if not set.
     */

    public FloatValue getYFov()
    {
        return this.yFov;
    }


    /**
     * Sets the vertical field of view in degrees.
     *
     * @param yFov
     *            The field of view to set. Null to unset.
     */

    public void setYFov(final FloatValue yFov)
    {
        if (yFov != this.yFov)
        {
            if (this.yFov != null) removeChild(this.yFov);
            this.yFov = yFov;
            if (yFov != null) addChild(yFov);
        }
    }
}
