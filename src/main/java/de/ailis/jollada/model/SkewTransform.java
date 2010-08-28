/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import de.ailis.gramath.MutableVector3d;
import de.ailis.gramath.Vector3d;


/**
 * Skew transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class SkewTransform extends Transform
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The rotation axis. */
    private final MutableVector3d rotationAxis = new MutableVector3d(0, 0, 0);

    /** The translation axis. */
    private final MutableVector3d translationAxis =
            new MutableVector3d(0, 0, 0);

    /** The rotation angle in degree. */
    private double angle;


    /**
     * Sets the rotation axis.
     *
     * @param rotationAxis
     *            The rotation axis to set. Must not be null.
     */

    public void setRotationAxis(final Vector3d rotationAxis)
    {
        if (rotationAxis == null)
            throw new IllegalArgumentException("rotationAxis must not be null");
        this.rotationAxis.set(rotationAxis);
    }


    /**
     * Returns the rotation axis.
     *
     * @return The rotation axis. Never null.
     */

    public MutableVector3d getRotationAxis()
    {
        return this.rotationAxis;
    }


    /**
     * Sets the translation axis.
     *
     * @param translationAxis
     *            The translation axis to set. Must not be null.
     */

    public void setTranslationAxis(final Vector3d translationAxis)
    {
        if (translationAxis == null)
            throw new IllegalArgumentException(
                "translationAxis must not be null");
        this.translationAxis.set(translationAxis);
    }


    /**
     * Returns the translation axis.
     *
     * @return The translation axis. Never null.
     */

    public MutableVector3d getTranslationAxis()
    {
        return this.translationAxis;
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
}
