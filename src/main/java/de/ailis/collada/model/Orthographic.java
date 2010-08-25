/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Orthographic projection.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Orthographic extends Projection
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The horizontal magnification. */
    private FloatValue xMag;

    /** The vertical magnification. */
    private FloatValue yMag;


    /**
     * Constructor.
     *
     * @param zNear
     *            The distance to the near clipping plane. Must not be null.
     * @param zFar
     *            The distance to the far clipping plane. Must not be null.
     */

    public Orthographic(final FloatValue zNear, final FloatValue zFar)
    {
        super(zNear, zFar);
    }


    /**
     * Returns the horizontal magnification.
     *
     * @return The horizontal magnification. May be null if not set.
     */

    public FloatValue getXMag()
    {
        return this.xMag;
    }


    /**
     * Sets the horizontal magnification.
     *
     * @param xMag
     *            The magnification to set. Null to unset.
     */

    public void setXMag(final FloatValue xMag)
    {
        if (xMag != this.xMag)
        {
            if (this.xMag != null) removeChild(this.xMag);
            this.xMag = xMag;
            if (xMag != null) addChild(xMag);
        }
    }


    /**
     * Returns the vertical magnification.
     *
     * @return The vertical magnification. May be null if not set.
     */

    public FloatValue getYMag()
    {
        return this.yMag;
    }


    /**
     * Sets the vertical magnification.
     *
     * @param yMag
     *            The magnification to set. Null to unset.
     */

    public void setYMag(final FloatValue yMag)
    {
        if (yMag != this.yMag)
        {
            if (this.yMag != null) removeChild(this.yMag);
            this.yMag = yMag;
            if (yMag != null) addChild(yMag);
        }
    }
}
