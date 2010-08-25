/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A effect.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Effect extends Element implements Identifiable,
        AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scene name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The effect profiles. */
    private final EffectProfiles profiles = new EffectProfiles(this);


    /**
     * Constructor.
     *
     * @param id
     *            The effect id. Must not be null.
     */

    public Effect(final String id)
    {
        setId(id);
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
     * Returns the name.
     *
     * @return The name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the name.
     *
     * @param name
     *            The name to set. Null to unset.
     */

    public void setName(final String name)
    {
        this.name = name;
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
     * Returns the list of effect profiles.
     *
     * @return The list of effect profiles. Never null.
     */

    public EffectProfiles getProfiles()
    {
        return this.profiles;
    }
}
