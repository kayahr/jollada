/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import de.ailis.gramath.ImmutableMatrix4d;
import de.ailis.gramath.Matrix4d;
import de.ailis.gramath.MutableVector3d;
import de.ailis.gramath.Vector3d;


/**
 * Rotate transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class RotateTransform extends Transform
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The rotation axis. */
    private final MutableVector3d axis = new MutableVector3d(0, 0, 0);

    /** The rotation angle in degree. */
    private double angle;


    /**
     * Sets the rotation axis.
     *
     * @param axis
     *            The rotation axis to set. Must not be null.
     */

    public void setAxis(final Vector3d axis)
    {
        if (axis == null)
            throw new IllegalArgumentException("axis must not be null");
        this.axis.set(axis);
    }


    /**
     * Returns the rotation axis.
     *
     * @return The rotation axis. Never null.
     */

    public MutableVector3d getAxis()
    {
        return this.axis;
    }


    /**
     * Returns the rotation angle in degrees.
     *
     * @return The rotation angle in degrees.
     */

    public double getAngle()
    {
        return this.angle;
    }


    /**
     * Sets the rotation angle.
     *
     * @param angle
     *            The rotation angle in degrees to set.
     */

    public void setAngle(final double angle)
    {
        this.angle = angle;
    }


    /**
     * @see de.ailis.jollada.model.Transform#asMatrix()
     */

    @Override
    public Matrix4d asMatrix()
    {
        return ImmutableMatrix4d.rotation(this.axis, this.angle);
    }
}
