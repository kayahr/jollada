/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A geometry element.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Geometry extends Element implements Identifiable,
        AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scene name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The geometric element. */
    private Geometric geometric;


    /**
     * Constructor.
     *
     * @param geometric
     *            The geometric element. Must not be null.
     */

    public Geometry(final Geometric geometric)
    {
        setGeometric(geometric);
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
        updateId(id);
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
     * Sets the geometric element.
     *
     * @param geometric
     *            The geometric element to set. Must not be null.
     */

    public void setGeometric(final Geometric geometric)
    {
        if (geometric == null)
            throw new IllegalArgumentException(
                "geometric element must not be null");
        this.geometric = geometric;
    }


    /**
     * Returns the geometric element.
     *
     * @return The geometric element. Never null.
     */

    public Geometric getGeometric()
    {
        return this.geometric;
    }
}
