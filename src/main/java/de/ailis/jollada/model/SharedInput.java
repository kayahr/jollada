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

public final class SharedInput extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The offset into the list of indices. */
    private int offset;

    /** The user-defined meaning of the connection. */
    private String semantic;

    /** The location of the data source. */
    private URI source;

    /** Which inputs to group as a single set. */
    private int set = 0;


    /**
     * Constructor.
     *
     * @param semantic
     *            The user-defined meaning of the connection.
     * @param source
     *            The location of the data source.
     * @param offset
     *            The offset into the list of indices
     */

    public SharedInput(final String semantic, final URI source,
        final int offset)
    {
        setSemantic(semantic);
        setSource(source);
        setOffset(offset);
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


    /**
     * Returns the offset into the list of indices.
     *
     * @return The offset.
     */

    public int getOffset()
    {
        return this.offset;
    }


    /**
     * Sets the offset into the list of indices.
     *
     * @param offset
     *            The offset to set.
     */

    public void setOffset(final int offset)
    {
        this.offset = offset;
    }


    /**
     * Returns the set number. Used to group inputs.
     *
     * @return The set.
     */

    public int getSet()
    {
        return this.set;
    }


    /**
     * Sets the set number. Used to group inputs.
     *
     * @param set
     *            The set to set.
     */

    public void setSet(final int set)
    {
        this.set = set;
    }
}
