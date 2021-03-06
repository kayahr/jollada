/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * List of geometry instances.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class GeometryInstances extends Instances<GeometryInstance>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    GeometryInstances(final Element parent)
    {
        super(parent);
    }
}
