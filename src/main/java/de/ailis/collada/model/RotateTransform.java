/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.MutableVector3f;
import de.ailis.gramath.Vector3f;


/**
 * Rotate transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class RotateTransform extends Transformation
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The rotation axis. */
    private final MutableVector3f axis = new MutableVector3f(0, 0, 0);

    /** The rotation angle in degree. */
    private float angle;


    /**
     * Sets the rotation axis.
     *
     * @param axis
     *            The rotation axis to set. Must not be null.
     * @return This transform for chaining.
     */

    public RotateTransform setAxis(final Vector3f axis)
    {
        if (axis == null)
            throw new IllegalArgumentException("axis must not be null");
        this.axis.set(axis);
        return this;
    }


    /**
     * Returns the rotation axis.
     *
     * @return The rotation axis. Never null.
     */

    public MutableVector3f getAxis()
    {
        return this.axis;
    }


    /**
     * Returns the rotation angle in degrees.
     *
     * @return The rotation angle in degrees.
     */

    public float getAngle()
    {
        return this.angle;
    }


    /**
     * Sets the rotation angle.
     *
     * @param angle
     *            The rotation angle in degrees to set.
     * @return This transform for chaining.
     */

    public RotateTransform setAngle(final float angle)
    {
        this.angle = angle;
        return this;
    }
}
