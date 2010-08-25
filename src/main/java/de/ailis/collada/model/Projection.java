/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Base class for camera optics projections.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Projection extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The distance to the near clipping plane. */
    private FloatValue zNear;

    /** The distance to the fat clipping plane. */
    private FloatValue zFar;

    /** The aspect ratio of the field of view. */
    private FloatValue aspectRatio;


    /**
     * Constructor.
     *
     * @param zNear
     *            The distance to the near clipping plane. Must not be null.
     * @param zFar
     *            The distance to the far clipping plane. Must not be null.
     */

    public Projection(final FloatValue zNear, final FloatValue zFar)
    {
        setZNear(zNear);
        setZFar(zFar);
    }


    /**
     * Returns the distance to the near clipping plane.
     *
     * @return The distance. Never null.
     */

    public FloatValue getZNear()
    {
        return this.zNear;
    }


    /**
     * Sets the distance to the near clipping plane.
     *
     * @param zNear
     *            The distance to set. Must not be null.
     */

    public void setZNear(final FloatValue zNear)
    {
        if (zNear == null)
            throw new IllegalArgumentException("zNear must not be null");
        if (zNear != this.zNear)
        {
            if (this.zNear != null) removeChild(this.zNear);
            this.zNear = zNear;
            addChild(zNear);
        }
    }


    /**
     * Returns the distance to the far clipping plane.
     *
     * @return The distance. Never null.
     */

    public FloatValue getZFar()
    {
        return this.zFar;
    }


    /**
     * Sets the distance to the far clipping plane.
     *
     * @param zFar
     *            The distance to set. Must not be null.
     */

    public void setZFar(final FloatValue zFar)
    {
        if (zFar == null)
            throw new IllegalArgumentException("zFar must not be null");
        if (zFar != this.zFar)
        {
            if (this.zFar != null) removeChild(this.zFar);
            this.zFar = zFar;
            addChild(zFar);
        }
    }


    /**
     * Returns the aspect ratio of the field of view.
     *
     * @return The aspect ratio. May be null if not set.
     */

    public FloatValue getAspectRatio()
    {
        return this.aspectRatio;
    }


    /**
     * Sets the aspect ratio of the field of view.
     *
     * @param aspectRatio
     *            The aspect ratio to set. Null to unset.
     */

    public void setAspectRatio(final FloatValue aspectRatio)
    {
        if (aspectRatio != this.aspectRatio)
        {
            if (this.aspectRatio != null) removeChild(this.aspectRatio);
            this.aspectRatio = aspectRatio;
            if (aspectRatio != null) addChild(aspectRatio);
        }
    }
}
