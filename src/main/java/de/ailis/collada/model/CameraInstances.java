/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * List of camera instances.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CameraInstances extends Instances<CameraInstance>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    CameraInstances(final Element parent)
    {
        super(parent);
    }
}
