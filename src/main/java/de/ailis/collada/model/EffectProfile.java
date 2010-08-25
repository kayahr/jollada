/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Base-class for effect profiles.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class EffectProfile extends Element implements Identifiable,
        AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** Asset-management information. */
    private Asset asset;


    /**
     * Returns the id.
     *
     * @return The id. May be null if not set.
     */

    @Override
    public final String getId()
    {
        return this.id;
    }


    /**
     * Sets the id.
     *
     * @param id
     *            The id to set. Null to unset.
     */

    @Override
    public final void setId(final String id)
    {
        super.updateId(id);
    }


    /**
     * Returns the asset-management information.
     *
     * @return The asset-management information. May be null if not set.
     */

    @Override
    public final Asset getAsset()
    {
        return this.asset;
    }


    /**
     * Sets the asset-management information.
     *
     * @param asset
     *            The asset-management information to set. Null to unset.
     */

    public final void setAsset(final Asset asset)
    {
        this.asset = asset;
    }
}
