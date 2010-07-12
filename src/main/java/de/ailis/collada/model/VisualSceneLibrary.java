/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Library of visual scenes.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class VisualSceneLibrary extends Element implements AssetElement,
        Identifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The list of visual scenes. */
    private final VisualScenes visualScenes = new VisualScenes(this);


    /**
     * @see de.ailis.collada.model.AssetElement#getAsset()
     */

    @Override
    public Asset getAsset()
    {
        return this.asset;
    }


    /**
     * Sets the asset-management information
     *
     * @param asset
     *            The asset-management information to set. Null to unset.
     * @return This visual scene library for chaining.
     */

    public VisualSceneLibrary setAsset(final Asset asset)
    {
        this.asset = asset;
        return this;
    }


    /**
     * Returns the id.
     *
     * @return The id. May be null if not set.
     */

    @Override
    public String getId()
    {
        return super.getId();
    }


    /**
     * Sets the id.
     *
     * @param id
     *            The id to set. Null to unset.
     * @return This visual scene library for chaining.
     */

    @Override
    public VisualSceneLibrary setId(final String id)
    {
        super.setId(id);
        return this;
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
     * @return This visual scene library for chaining.
     */

    public VisualSceneLibrary setName(final String name)
    {
        this.name = name;
        return this;
    }


    /**
     * Returns the list of visual scenes.
     *
     * @return The list of visual scenes. Never null. May be empty.
     */

    public VisualScenes getVisualScenes()
    {
        return this.visualScenes;
    }
}
