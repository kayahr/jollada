/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * List of material libraries.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class MaterialLibraries extends Elements<MaterialLibrary>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element.
     */

    MaterialLibraries(final Element parent)
    {
        super(parent);
    }
}
