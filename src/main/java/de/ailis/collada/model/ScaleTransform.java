/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.MutableVector3d;
import de.ailis.gramath.Vector3d;


/**
 * Scale transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class ScaleTransform extends Transformation
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
}
