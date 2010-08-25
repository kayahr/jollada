/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import java.net.URI;

import de.ailis.collada.model.ImageSource;


/**
 * Builder for images.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class ImageSourceBuilder
{
    /** The next MIP level generation flag. */
    private boolean generateMips = true;

    /** The next ref. */
    private URI ref;


    /**
     * Builds and returns the image source.
     *
     * @return The image source. Never null.
     */

    public ImageSource build()
    {
        if (this.ref == null)
            throw new IllegalStateException("ref not set");
        final ImageSource source = new ImageSource(this.ref);
        source.setGenerateMips(this.generateMips);
        return source;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.ref = null;
        this.generateMips = true;
    }


    /**
     * Returns the next generate MIPs flag.
     *
     * @return The next generate MIPs flag.
     */

    public boolean isGenerateMips()
    {
        return this.generateMips;
    }


    /**
     * Sets the generate MIPs flag.
     *
     * @param generateMips
     *            The generate MIPs flag to set.
     */

    public void setGenerateMips(final boolean generateMips)
    {
        this.generateMips = generateMips;
    }


    /**
     * Returns the image reference.
     *
     * @return The image reference. May be null if not set.
     */

    public URI getRef()
    {
        return this.ref;
    }


    /**
     * Sets the image reference.
     *
     * @param ref
     *            The image reference to set. Null to unset.
     */

    public void setRef(final URI ref)
    {
        this.ref = ref;
    }
}
