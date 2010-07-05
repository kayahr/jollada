/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model.support;


/**
 * Identifiable element.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public interface Identifiable
{
    /**
     * Returns the id.
     *
     * @return The id. Maybe null if not set and element allows that.
     */

    public String getId();


    /**
     * Sets the id.
     *
     * @param id
     *            The id to set. Must not be null for elements which require an
     *            ID.
     */

    public void setId(String id);
}
