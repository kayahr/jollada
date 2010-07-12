/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Look-at transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Transformation extends Element implements
        ScopeIdentifiable
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The scope ID */
    private String sid;


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. May be null if not set.
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Null to unset.
     * @return This transformation for chaining.
     */

    @Override
    public Transformation setSid(final String sid)
    {
        this.sid = sid;
        return this;
    }
}
