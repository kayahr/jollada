/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import de.ailis.gramath.Matrix4d;


/**
 * Look-at transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Transform extends Element implements
        ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scope ID. */
    private String sid;


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. May be null if not set.
     */

    @Override
    public final String getSid()
    {
        return this.sid;
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Null to unset.
     */

    @Override
    public final void setSid(final String sid)
    {
        this.sid = sid;
    }


    /**
     * Returns this transformation as a transformation matrix.
     *
     * @return The transformation as a matrix. Never null.
     */

    public abstract Matrix4d asMatrix();
}
