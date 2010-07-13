/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import de.ailis.collada.model.Asset;
import de.ailis.collada.model.EffectInstance;
import de.ailis.collada.model.Material;


/**
 * Builder for materials.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class MaterialBuilder
{
    /** The next effect instance. */
    private EffectInstance effectInstance;

    /** The next asset. */
    private Asset asset;

    /** The next id. */
    private String id;

    /** The next name. */
    private String name;


    /**
     * Builds and returns the material.
     *
     * @return The material. Never null.
     */

    public Material build()
    {
        if (this.effectInstance == null)
            throw new IllegalStateException("effectInstance not set");
        final Material material = new Material(this.effectInstance);
        material.setAsset(this.asset);
        material.setId(this.id);
        material.setName(this.name);
        return material;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.effectInstance = null;
        this.asset = null;
        this.id = null;
        this.name = null;
    }

    /**
     * Returns the next effect instance.
     *
     * @return The next effect instance. May be null if unset.
     */

    public EffectInstance getEffectInstance()
    {
        return this.effectInstance;
    }


    /**
     * Sets the next effect instance.
     *
     * @param effectInstance
     *            The next effect instance to set. Null to unset.
     */

    public void setEffectInstance(final EffectInstance effectInstance)
    {
        this.effectInstance = effectInstance;
    }


    /**
     * Returns the next asset-management information.
     *
     * @return The next asset-management information. May be null if unset.
     */

    public Asset getAsset()
    {
        return this.asset;
    }


    /**
     * Sets the next asset-management information.
     *
     * @param asset
     *            The next asset-management information to set. Null to unset.
     */

    public void setAsset(final Asset asset)
    {
        this.asset = asset;
    }


    /**
     * Returns the next id.
     *
     * @return The next id. May be null if not set.
     */

    public String getId()
    {
        return this.id;
    }


    /**
     * Sets the next id.
     *
     * @param id
     *            The next id to set. Null to unset.
     */

    public void setId(final String id)
    {
        this.id = id;
    }


    /**
     * Returns the next name.
     *
     * @return The next name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the next name.
     *
     * @param name
     *            The next name to set. Null to unset.
     */

    public void setName(final String name)
    {
        this.name = name;
    }
}
