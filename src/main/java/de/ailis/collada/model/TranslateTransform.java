/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.MutableTuple3f;
import de.ailis.gramath.Tuple3f;


/**
 * Scale transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class TranslateTransform extends Transformation
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The rotation axis */
    private final MutableTuple3f scaling = new MutableTuple3f();


    /**
     * Sets the scaling.
     *
     * @param scaling
     *            The scaling. Must not be null.
     */

    public void setScaling(final Tuple3f scaling)
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

    public MutableTuple3f getScaling()
    {
        return this.scaling;
    }
}
