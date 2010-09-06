/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.net.URI;


/**
 * An animation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class AnimationChannel extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The referenced animation sampler. */
    private URI source;

    /** The animation target. */
    private String target;


    /**
     * Constructor.
     *
     * @param source
     *            The reference to the animation sampler.
     * @param target
     *            The SID of the animation target.
     */

    public AnimationChannel(final URI source, final String target)
    {
        setSource(source);
        setTarget(target);
    }


    /**
     * Returns the reference to the animation sampler.
     *
     * @return The reference to the animation sampler. Never null.
     */

    public URI getSource()
    {
        return this.source;
    }


    /**
     * Sets the reference to the animation sampler..
     *
     * @param source
     *            The reference to set. Must not be null.
     */

    public void setSource(final URI source)
    {
        if (source == null)
            throw new IllegalArgumentException("source must not be null");
        this.source = source;
    }


    /**
     * Returns the SID of the animation target.
     *
     * @return The SID of the animation target. Never null.
     */

    public String getTarget()
    {
        return this.target;
    }


    /**
     * Sets the SID of the animation target.
     *
     * @param target
     *            The SID of the animation target to set. Must not be null.
     */

    public void setTarget(final String target)
    {
        if (target == null)
            throw new IllegalArgumentException("target must not be null");
        this.target = target;
    }
}
