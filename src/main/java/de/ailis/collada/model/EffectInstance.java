/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.net.URI;


/**
 * A effect instance.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class EffectInstance extends Element implements ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scene name. */
    private String name;

    /** The scope ID. */
    private String sid;

    /** The URI of the location of the effect to instantiate. */
    private URI url;


    /**
     * Constructor.
     *
     * @param url
     *            The URI of the location of the effect to instantiate. Must not
     *            be null.
     */

    public EffectInstance(final URI url)
    {
        setUrl(url);
    }


    /**
     * Returns the name.
     *
     * @return The name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the name.
     *
     * @param name
     *            The name to set. Null to unset.
     */

    public void setName(final String name)
    {
        this.name = name;
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Null to unset.
     */

    @Override
    public void setSid(final String sid)
    {
        this.sid = sid;
    }


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. May be null if not set.
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }


    /**
     * Returns the URI of the location of the effect to instantiate.
     *
     * @return The effect URI. Never null.
     */

    public URI getUrl()
    {
        return this.url;
    }


    /**
     * Sets the URI of the location of the effect to instantiate.
     *
     * @param url
     *            The effect URI to set. Must not be null.
     */

    public void setUrl(final URI url)
    {
        if (url == null)
            throw new IllegalArgumentException("url must not be null");
        this.url = url;
    }
}
