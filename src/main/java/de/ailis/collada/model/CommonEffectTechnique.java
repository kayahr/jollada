/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Technique for a common effect profile.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonEffectTechnique extends Element implements Identifiable,
        AssetElement, ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** Asset-management information. */
    private Asset asset;

    /** The scope ID */
    private String sid;


    /**
     * Constructor.
     *
     * @param sid
     *            The scope ID. Must not be null.
     */

    public CommonEffectTechnique(final String sid)
    {
        setSid(sid);
    }


    /**
     * Returns the id.
     *
     * @return The id. May be null if not set.
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
     *            The id to set. Null to unset.
     */

    @Override
    public void setId(final String id)
    {
        super.updateId(id);
    }


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. Never null.
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Must not be null.
     */

    @Override
    public void setSid(final String sid)
    {
        if (sid == null)
            throw new IllegalArgumentException("sid must not be null");
        this.sid = sid;
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
}
