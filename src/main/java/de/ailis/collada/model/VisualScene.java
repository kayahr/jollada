/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A visual scene.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class VisualScene extends Element implements Identifiable, AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scene name. */
    private String name;

    /** Asset-management information */
    private Asset asset;

    /** The list of nodes */
    private final Nodes nodes = new Nodes(this);


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
     * @return This visual scene for chaining.
     */

    @Override
    public VisualScene setId(final String id)
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
     * @return This visual scene for chaining.
     */

    public VisualScene setName(final String name)
    {
        this.name = name;
        return this;
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
     * @return This visual scene for chaining.
     */

    public VisualScene setAsset(final Asset asset)
    {
        this.asset = asset;
        return this;
    }


    /**
     * Returns the list of nodes.
     *
     * @return The list of nodes. Never null. May be empty.
     */

    public Nodes getNodes()
    {
        return this.nodes;
    }
}
