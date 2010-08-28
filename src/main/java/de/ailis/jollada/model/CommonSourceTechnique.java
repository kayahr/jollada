/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * The common source technique.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonSourceTechnique extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The list of material instances. */
    private Accessor accessor;


    /**
     * Constructs a new common source technique with the specified accessor.
     *
     * @param accessor
     *            The accessor. Must not be null.
     */

    public CommonSourceTechnique(final Accessor accessor)
    {
        setAccessor(accessor);
    }


    /**
     * Returns the accessor.
     *
     * @return The accessor. Never null.
     */

    public Accessor getAccessor()
    {
        return this.accessor;
    }


    /**
     * Sets the accessor.
     *
     * @param accessor
     *            The accessor to set. Must not be null.
     */

    public void setAccessor(final Accessor accessor)
    {
        if (accessor == null)
            throw new IllegalArgumentException("accessor must be set");
        if (accessor != this.accessor)
        {
            if (this.accessor != null) removeChild(this.accessor);
            this.accessor = accessor;
            addChild(accessor);
        }
    }
}
