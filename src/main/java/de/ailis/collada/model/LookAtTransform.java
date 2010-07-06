/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.MutableVector3f;
import de.ailis.gramath.Vector3f;


/**
 * Look-at transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class LookAtTransform extends Transformation
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The position of the eye */
    private final MutableVector3f eye = new MutableVector3f(0, 0, 0);

    /** The position of the interest point */
    private final MutableVector3f interest = new MutableVector3f(0, 0, -1);

    /** The direction that points up */
    private final MutableVector3f up = new MutableVector3f(0, 1, 0);


    /**
     * Sets the position of the eye.
     *
     * @param eye
     *            The eye position to set. Must not be null.
     */

    public void setEye(final Vector3f eye)
    {
        if (eye == null)
            throw new IllegalArgumentException("eye must not be null");
        this.eye.set(eye);
    }


    /**
     * Returns the position of the eye.
     *
     * @return The eye position. Never null.
     */

    public MutableVector3f getEye()
    {
        return this.eye;
    }


    /**
     * Sets the position of the interest point.
     *
     * @param interest
     *            The interest point position to set. Must not be null.
     */

    public void setInterest(final Vector3f interest)
    {
        if (interest == null)
            throw new IllegalArgumentException("interest must not be null");
        this.interest.set(interest);
    }


    /**
     * Returns the position of the interest point.
     *
     * @return The interest point. Never null.
     */

    public MutableVector3f getInterest()
    {
        return this.interest;
    }


    /**
     * Sets the up direction.
     *
     * @param up
     *            The up direction. Must not be null.
     */

    public void setUp(final Vector3f up)
    {
        if (up == null)
            throw new IllegalArgumentException("up must not be null");
        this.up.set(up);
    }


    /**
     * Returns the up direction.
     *
     * @return The up direction. Never null.
     */

    public MutableVector3f getUp()
    {
        return this.up;
    }
}
