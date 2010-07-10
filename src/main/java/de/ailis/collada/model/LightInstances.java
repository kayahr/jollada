/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * List of light instances.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class LightInstances extends Instances<LightInstance>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    LightInstances(final Element parent)
    {
        super(parent);
    }
}
