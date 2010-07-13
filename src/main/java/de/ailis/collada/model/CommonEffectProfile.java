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

public final class CommonEffectProfile extends Element implements Identifiable,
        AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** Asset-management information. */
    private Asset asset;

    /** The effect technique. */
    private CommonEffectTechnique technique;


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
     * Returns the id.
     *
     * @return The id. Never null.
     */

    @Override
    public String getId()
    {
        return this.id;
    }


    /**
     * Sets the id.
     *
     * @param id
     *            The id to set. Must not be null.
     */

    @Override
    public void setId(final String id)
    {
        if (id == null)
            throw new IllegalArgumentException("id must not be null");
        super.updateId(id);
    }


    /**
     * Returns the asset-management information.
     *
     * @return The asset-management information. May be null if not set.
     */

    @Override
    public Asset getAsset()
    {
        return this.asset;
    }


    /**
     * Sets the asset-management information.
     *
     * @param asset
     *            The asset-management information to set. Null to unset.
     */

    public void setAsset(final Asset asset)
    {
        this.asset = asset;
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
        this.technique = technique;
    }
}
