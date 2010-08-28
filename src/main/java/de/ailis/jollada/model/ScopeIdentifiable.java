/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Element identifiable in a scope.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public interface ScopeIdentifiable
{
    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set.
     */

    void setSid(String sid);


    /**
     * Returns the scope ID.
     *
     * @return The scope ID.
     */

    String getSid();
}
