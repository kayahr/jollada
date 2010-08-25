/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import de.ailis.collada.model.Asset;
import de.ailis.collada.model.Geometric;
import de.ailis.collada.model.Geometry;


/**
 * Builder for geometries.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class GeometryBuilder
{
    /** The geometric element. */
    private Geometric geometric;

    /** The next asset. */
    private Asset asset;

    /** The next id. */
    private String id;

    /** The next name. */
    private String name;


    /**
     * Builds the geometric.
     *
     * @return The geometric. Never null.
     */

    public Geometry build()
    {
        if (this.geometric == null)
            throw new IllegalStateException("geometric not set");
        final Geometry geometry = new Geometry(this.geometric);
        geometry.setAsset(this.asset);
        geometry.setId(this.id);
        geometry.setName(this.name);
        return geometry;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.geometric = null;
        this.asset = null;
        this.id = null;
        this.name = null;
    }


    /**
     * Returns the next geometric element.
     *
     * @return The next geometric element. May be null if unset.
     */

    public Geometric getGeometric()
    {
        return this.geometric;
    }


    /**
     * Sets the next geometric element.
     *
     * @param geometric
     *            The next geometric element to set. Null to unset.
     */

    public void setGeometric(final Geometric geometric)
    {
        this.geometric = geometric;
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
