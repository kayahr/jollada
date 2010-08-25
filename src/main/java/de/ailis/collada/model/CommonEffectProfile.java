/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Common profile for platform-independant fixed-function shader.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonEffectProfile extends EffectProfile
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The effect technique. */
    private CommonEffectTechnique technique;

    /** The parameters */
    private final CommonNewParams params = new CommonNewParams(this);


    /**
     * Constructor.
     *
     * @param technique
     *            The effect technique. Must not be null.
     */

    public CommonEffectProfile(final CommonEffectTechnique technique)
    {
        setTechnique(technique);
    }


    /**
     * Returns the technique.
     *
     * @return The technique. May be null if not set.
     */

    public CommonEffectTechnique getTechnique()
    {
        return this.technique;
    }


    /**
     * Sets the common profile.
     *
     * @param technique
     *            The common profile to set. Null to unset.
     */

    public void setTechnique(final CommonEffectTechnique technique)
    {
        if (technique == null)
            throw new IllegalArgumentException("technique must not be null");
        if (technique != this.technique)
        {
            if (this.technique != null) removeChild(this.technique);
            this.technique = technique;
            addChild(technique);
        }
    }


    /**
     * Returns the list of parameters.
     *
     * @return The list of parameters. Never null. May be empty.
     */

    public CommonNewParams getParams()
    {
        return this.params;
    }
}
