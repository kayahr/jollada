/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Common technique for a camera optics.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonOpticsTechnique extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The projection. */
    private Projection projection;


    /**
     * Constructor.
     *
     * @param projection
     *            The projection. Must not be null.
     */

    public CommonOpticsTechnique(final Projection projection)
    {
        setProjection(projection);
    }


    /**
     * Returns the projection.
     *
     * @return The projection. Never null.
     */

    public Projection getProjection()
    {
        return this.projection;
    }


    /**
     * Sets the projection.
     *
     * @param projection
     *            The projection to set. Must not be null.
     */

    public void setProjection(final Projection projection)
    {
        if (projection == null)
            throw new IllegalArgumentException("projection must not be null");
        if (projection != this.projection)
        {
            if (this.projection != null) removeChild(this.projection);
            this.projection = projection;
            addChild(projection);
        }
    }
}
