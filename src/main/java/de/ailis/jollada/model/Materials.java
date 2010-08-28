/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * List of materials.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Materials extends Elements<Material>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element
     */

    Materials(final Element parent)
    {
        super(parent);
    }
}
