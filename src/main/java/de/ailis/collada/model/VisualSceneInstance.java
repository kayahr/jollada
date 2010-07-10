/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.net.URI;


/**
 * A visual scene instance.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class VisualSceneInstance extends Instance
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param url
     *            The URL of the location of the visual scene to instantiate.
     *            Must not be null.
     */

    public VisualSceneInstance(final URI url)
    {
        super(url);
    }


    /**
     * Returns the scene this visual scene instance is connected to.
     *
     * @return The scene. May be null if not connected to any yet.
     */

    public Scene getScene()
    {
        return (Scene) getParent();
    }
}
