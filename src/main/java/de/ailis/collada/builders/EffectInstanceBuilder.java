/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import java.net.URI;

import de.ailis.collada.model.EffectInstance;


/**
 * Builder for effect instances.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class EffectInstanceBuilder
{
    /** The next url. */
    private URI url;

    /** The next scope ID. */
    private String sid;

    /** The next name. */
    private String name;


    /**
     * Builds and returns the effect instance.
     *
     * @return The effect instance. Never null.
     */

    public EffectInstance build()
    {
        if (this.url == null)
            throw new IllegalStateException("url not set");
        final EffectInstance effectInstance = new EffectInstance(this.url);
        effectInstance.setName(this.name);
        effectInstance.setSid(this.sid);
        return effectInstance;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.url = null;
        this.sid = null;
        this.name = null;
    }


    /**
     * Returns the next URL.
     *
     * @return The next URL. May be null if unset.
     */

    public URI getUrl()
    {
        return this.url;
    }


    /**
     * Sets the next URL.
     *
     * @param url
     *            The next URL to set. Null to unset.
     */

    public void setUrl(final URI url)
    {
        this.url = url;
    }


    /**
     * Returns the next scope ID.
     *
     * @return The next scope ID. May be null if not set.
     */

    public String getSid()
    {
        return this.sid;
    }


    /**
     * Sets the next scope ID.
     *
     * @param sid
     *            The next scope ID to set. Null to unset.
     */

    public void setSid(final String sid)
    {
        this.sid = sid;
    }


    /**
     * Returns the next name.
     *
     * @return The next name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the next name.
     *
     * @param name
     *            The next name to set. Null to unset.
     */

    public void setName(final String name)
    {
        this.name = name;
    }
}
