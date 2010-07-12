/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * List of transformations.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Transformations extends Elements<Transformation>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element
     */

    Transformations(final Element parent)
    {
        super(parent);
    }
}
