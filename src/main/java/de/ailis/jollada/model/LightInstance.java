/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.net.URI;


/**
 * A light instance.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class LightInstance extends Instance
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param url
     *            The URL of the location of the light element to instantiate.
     */

    public LightInstance(final URI url)
    {
        super(url);
    }
}
