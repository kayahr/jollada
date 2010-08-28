/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.net.URI;


/**
 * Declares input semantics of a data source and connects a consumer to that
 * source.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class UnsharedInput extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The user-defined meaning of the connection. */
    private String semantic;

    /** The location of the data source. */
    private URI source;


    /**
     * Constructor.
     *
     * @param semantic
     *            The user-defined meaning of the connection.
     * @param source
     *            The location of the data source.
     */

    public UnsharedInput(final String semantic, final URI source)
    {
        setSemantic(semantic);
        setSource(source);
    }


    /**
     * Returns the user-defined meaning of the connection.
     *
     * @return The user-defined meaning of the connection. Never null.
     */

    public String getSemantic()
    {
        return this.semantic;
    }


    /**
     * Sets the user-defined meaning of the connection.
     *
     * @param semantic
     *            The user-defined meaning of the connection to set. Must not be
     *            null.
     */

    public void setSemantic(final String semantic)
    {
        if (semantic == null)
            throw new IllegalArgumentException("semantic must not be null");
        this.semantic = semantic;
    }


    /**
     * Returns the location of the data source.
     *
     * @return The location of the data source. Never null.
     */

    public URI getSource()
    {
        return this.source;
    }


    /**
     * Sets the location of the data source.
     *
     * @param source
     *            The location of the data source to set. Must not be null.
     */

    public void setSource(final URI source)
    {
        if (source == null)
            throw new IllegalArgumentException("source must not be null");
        this.source = source;
    }
}
