/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.net.URI;


/**
 * A geometry instance.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class GeometryInstance extends Instance
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The material binding. */
    private final MaterialBinding materialBinding = new MaterialBinding(this);


    /**
     * Constructor.
     *
     * @param url
     *            The URL of the location of the camera element to instantiate.
     */

    public GeometryInstance(final URI url)
    {
        super(url);
    }


    /**
     * Returns the material binding.
     *
     * @return The material binding
     */

    public MaterialBinding getMaterialBinding()
    {
        return this.materialBinding;
    }
}
