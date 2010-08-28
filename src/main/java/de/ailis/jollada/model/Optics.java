/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Camera optics.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Optics extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The common technique. */
    private CommonOpticsTechnique commonTechnique;


    /**
     * Constructor.
     *
     * @param commonTechnique
     *            The common technique. Must not be null.
     */

    public Optics(final CommonOpticsTechnique commonTechnique)
    {
        setCommonTechnique(commonTechnique);
    }


    /**
     * Returns the common technique.
     *
     * @return The common technique. Never null.
     */

    public CommonOpticsTechnique getCommonTechnique()
    {
        return this.commonTechnique;
    }


    /**
     * Sets the common technique.
     *
     * @param commonTechnique
     *            The common technique to set. Must not be null.
     */

    public void setCommonTechnique(final CommonOpticsTechnique commonTechnique)
    {
        if (commonTechnique == null)
            throw new IllegalArgumentException(
                "commonTechnique must not be null");
        if (commonTechnique != this.commonTechnique)
        {
            if (this.commonTechnique != null)
                removeChild(this.commonTechnique);
            this.commonTechnique = commonTechnique;
            addChild(commonTechnique);
        }
    }
}
