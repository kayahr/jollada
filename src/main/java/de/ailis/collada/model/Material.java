/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A material.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Material extends Element implements Identifiable,
        AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scene name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The effect instance. */
    private EffectInstance effectInstance;


    /**
     * Constructor.
     *
     * @param effectInstance
     *            The effect instance. Must not be null.
     */

    public Material(final EffectInstance effectInstance)
    {
        setEffectInstance(effectInstance);
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
     * Returns the effect instance.
     *
     * @return The effect instance. Never null.
     */

    public EffectInstance getEffectInstance()
    {
        return this.effectInstance;
    }


    /**
     * Sets the effect instance.
     *
     * @param effectInstance
     *            The effect instance to set. Must not be null.
     */

    public void setEffectInstance(final EffectInstance effectInstance)
    {
        if (effectInstance == null)
            throw new IllegalArgumentException(
                "effectInstance must not be null");
        if (effectInstance != this.effectInstance)
        {
            if (this.effectInstance != null) removeChild(this.effectInstance);
            this.effectInstance = effectInstance;
            addChild(effectInstance);
        }
    }
}
