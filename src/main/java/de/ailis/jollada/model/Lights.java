/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * List of lights.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Lights extends Elements<Light>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element
     */

    Lights(final Element parent)
    {
        super(parent);
    }
}
