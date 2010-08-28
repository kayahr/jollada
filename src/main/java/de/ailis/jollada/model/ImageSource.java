/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.net.URI;


/**
 * A image source.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class ImageSource extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The image file reference. */
    private URI ref;

    /** If MIP levels should be generated automatically. */
    private boolean generateMips = true;


    /**
     * Constructor.
     *
     * @param ref
     *            The image file reference.
     */

    public ImageSource(final URI ref)
    {
        setRef(ref);
    }


    /**
     * Sets the image file reference.
     *
     * @param ref
     *            The image file reference to set. Must not be null.
     */

    public void setRef(final URI ref)
    {
        if (ref == null)
            throw new IllegalArgumentException("ref must not be null");
        this.ref = ref;
    }


    /**
     * Returns the image file reference.
     *
     * @return The image file reference
     */

    public URI getRef()
    {
        return this.ref;
    }


    /**
     * Checks if MIP levels should be generated automatically.
     *
     * @return True if MIP levels should be generated automatically, false if
     *         not.
     */

    public boolean isGenerateMips()
    {
        return this.generateMips;
    }


    /**
     * Sets the MIP level generation flag.
     *
     * @param generateMips
     *            True to automatically generate MIP levels, false otherwise.
     */

    public void setGenerateMips(final boolean generateMips)
    {
        this.generateMips = generateMips;
    }
}
