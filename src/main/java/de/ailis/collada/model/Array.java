/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Base class for arrays.
 *
 * @author Klaus Reimer (k@ailis.de
 */

public abstract class Array extends Element implements Identifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Returns the ID.
     *
     * @return The ID. May be null if not set.
     */

    @Override
    public String getId()
    {
        return super.getId();
    }


    /**
     * Sets the ID.
     *
     * @param id
     *            The ID to set. Null to unset.
     * @return The ID for chaining.
     */

    @Override
    public void setId(final String id)
    {
        super.setId(id);
        //return this;
    }
}
