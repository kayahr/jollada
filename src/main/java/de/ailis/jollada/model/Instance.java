/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.net.URI;


/**
 * Base class for instances.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Instance extends Element implements ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scope id. */
    private String sid;

    /** The name. */
    private String name;

    /** The URL of the location of the element to instantiate. */
    private URI url;


    /**
     * Constructor.
     *
     * @param url
     *            The URL of the location of the element to instantiate
     */

    Instance(final URI url)
    {
        setUrl(url);
    }


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. May be null if not set.
     */

    @Override
    public final String getSid()
    {
        return this.sid;
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Null to unset.
     */

    @Override
    public final void setSid(final String sid)
    {
        this.sid = sid;
    }


    /**
     * Returns the URL of the location of the element to instantiate.
     *
     * @return The URL. Never null.
     */

    public final URI getUrl()
    {
        return this.url;
    }


    /**
     * Sets the URL of the location of the element to instantiate.
     *
     * @param url
     *            The URL to set. Must not be null.
     */

    public final void setUrl(final URI url)
    {
        if (url == null)
            throw new IllegalArgumentException("url must not be null");
        this.url = url;
    }


    /**
     * Returns the name.
     *
     * @return The name. May be null if not set.
     */

    public final String getName()
    {
        return this.name;
    }


    /**
     * Sets the name.
     *
     * @param name
     *            The name to set. Null to unset.
     */

    public final void setName(final String name)
    {
        this.name = name;
    }
}
