/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * List of visual scene libraries.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class VisualSceneLibraries extends Elements<VisualSceneLibrary>
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor
     *
     * @param document
     *            The document. May be null if not initially set.
     */

    public VisualSceneLibraries(final Document document)
    {
        super(document, null);
    }
}
