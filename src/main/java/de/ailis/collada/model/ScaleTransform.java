/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.MutableVector3f;
import de.ailis.gramath.Vector3f;


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
    private final MutableVector3f scaling = new MutableVector3f();


    /**
     * Sets the scaling.
     *
     * @param scaling
     *            The scaling. Must not be null.
     * @return This transform for chaining.
     */

    public ScaleTransform setScaling(final Vector3f scaling)
    {
        if (scaling == null)
            throw new IllegalArgumentException("scaling must not be null");
        this.scaling.set(scaling);
        return this;
    }


    /**
     * Returns the scaling.
     *
     * @return The scaling. Never null.
     */

    public MutableVector3f getScaling()
    {
        return this.scaling;
    }
}
