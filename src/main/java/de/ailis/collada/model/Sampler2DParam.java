/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Parameter with a single float value.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Sampler2DParam extends Param
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** Controls texture repeating and clamping of the S coordinate. */
    private Wrap wrapS = Wrap.WRAP;

    /** Controls texture repeating and clamping of the T coordinate. */
    private Wrap wrapT = Wrap.WRAP;

    /** The minification filter. */
    private Filter minFilter = Filter.LINEAR;

    /** The magnification filter. */
    private Filter magFilter = Filter.LINEAR;


    /**
     * Returns the wrap mode for the S coordinate.
     *
     * @return The wrap mode for the S coordinate. Never null.
     */

    public Wrap getWrapS()
    {
        return this.wrapS;
    }


    /**
     * Sets the wrap mode for the S coordinate.
     *
     * @param wrapS
     *            The wrap mode for the S coordinate to set. Must not be null.
     */

    public void setWrapS(final Wrap wrapS)
    {
        if (wrapS == null)
            throw new IllegalArgumentException("wrapS must not be null");
        this.wrapS = wrapS;
    }


    /**
     * Returns the wrap mode for the T coordinate.
     *
     * @return The wrap mode for the T coordinate. Never null.
     */

    public Wrap getWrapT()
    {
        return this.wrapT;
    }


    /**
     * Sets the wrap mode for the T coordinate.
     *
     * @param wrapT
     *            The wrap mode for the T coordinate to set. Must not be mull.
     */

    public void setWrapT(final Wrap wrapT)
    {
        if (wrapT == null)
            throw new IllegalArgumentException("wrapT must not be null");
        this.wrapT = wrapT;
    }


    /**
     * Returns the minification filter.
     *
     * @return The minification filter. Never null.
     */

    public Filter getMinFilter()
    {
        return this.minFilter;
    }


    /**
     * Sets the minification filter.
     *
     * @param minFilter
     *            The minification filter to set. Must not be null.
     */

    public void setMinFilter(final Filter minFilter)
    {
        if (minFilter == null)
            throw new IllegalArgumentException("minFilter must not be null");
        this.minFilter = minFilter;
    }


    /**
     * Returns the magnification filter.
     *
     * @return The magnification filter. Never null.
     */

    public Filter getMagFilter()
    {
        return this.magFilter;
    }


    /**
     * Sets the magnification filter.
     *
     * @param magFilter
     *            The magnification filter to set. Must not be null.
     */

    public void setMagFilter(final Filter magFilter)
    {
        if (magFilter == null)
            throw new IllegalArgumentException("magFilter must not be null");
        this.magFilter = magFilter;
    }
}
