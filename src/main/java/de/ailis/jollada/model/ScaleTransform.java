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
 * Scale transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class ScaleTransform extends Transform
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The rotation axis. */
    private final MutableVector3d scaling = new MutableVector3d();


    /**
     * Sets the scaling.
     *
     * @param scaling
     *            The scaling. Must not be null.
     */

    public void setScaling(final Vector3d scaling)
    {
        if (scaling == null)
            throw new IllegalArgumentException("scaling must not be null");
        this.scaling.set(scaling);
    }


    /**
     * Returns the scaling.
     *
     * @return The scaling. Never null.
     */

    public MutableVector3d getScaling()
    {
        return this.scaling;
    }


    /**
     * @see de.ailis.jollada.model.Transform#asMatrix()
     */

    @Override
    public Matrix4d asMatrix()
    {
        return ImmutableMatrix4d.scaling(this.scaling.getX(),
            this.scaling.getY(), this.scaling.getZ());
    }
}
