/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.net.URI;


/**
 * The accessor for a data source array.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Accessor extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The number of times the array is accessed. */
    private int count = 0;

    /** The index of the first value to be read from the array. */
    private int offset = 0;

    /** The location of the array to access. */
    private URI source;

    /**
     * The number of values that are to be considered a unit during each access
     * to the array.
     */
    private int stride = 1;

    /** The data flow parameters. */
    private final DataFlowParams params = new DataFlowParams(this);


    /**
     * Minimal constructor.
     *
     * @param source
     *            The location of the array to access.
     * @param count
     *            The number of times the array is accessed.
     */

    public Accessor(final URI source, final int count)
    {
        setSource(source);
        setCount(count);
    }


    /**
     * Full constructor.
     *
     * @param source
     *            The location of the array to access.
     * @param count
     *            The number of times the array is accessed.
     * @param offset
     *            The index of the first value to be read from the array.
     * @param stride
     *            The number of values that are to be considered a unit during
     *            each access to the array.
     */

    public Accessor(final URI source, final int count, final int offset,
        final int stride)
    {
        setSource(source);
        setCount(count);
        setOffset(offset);
        setStride(stride);
    }


    /**
     * Returns the number of times the array is accessed.
     *
     * @return The number of times the array is accessed.
     */

    public int getCount()
    {
        return this.count;
    }


    /**
     * Sets the number of times the array is accessed.
     *
     * @param count
     *            The number of times to set.
     */

    public void setCount(final int count)
    {
        this.count = count;
    }


    /**
     * Returns the index of the first value to be read from the array.
     *
     * @return The index of the first value to be read from the array.
     */

    public int getOffset()
    {
        return this.offset;
    }


    /**
     * Sets the index of the first value to be read from the array.
     *
     * @param offset
     *            The offset to set.
     */

    public void setOffset(final int offset)
    {
        this.offset = offset;
    }


    /**
     * Returns the location of the array to access.
     *
     * @return The location of the array to access. Never null.
     */

    public URI getSource()
    {
        return this.source;
    }


    /**
     * Sets the location of the array to access.
     *
     * @param source
     *            The location to set. Must not be null.
     */

    public void setSource(final URI source)
    {
        if (source == null)
            throw new IllegalArgumentException("source must not be null");
        this.source = source;
    }


    /**
     * Returns the number of values that are to be considered a unit during each
     * access to the array.
     *
     * @return The number of values that are to be considered a unit during each
     *         access to the array.
     */

    public int getStride()
    {
        return this.stride;
    }


    /**
     * Sets the number of values that are to be considered a unit during each
     * access to the array.
     *
     * @param stride
     *            The stride to set.
     */

    public void setStride(final int stride)
    {
        this.stride = stride;
    }


    /**
     * Returns the parameters.
     *
     * @return The parameters. Never null.
     */

    public DataFlowParams getParams()
    {
        return this.params;
    }
}
