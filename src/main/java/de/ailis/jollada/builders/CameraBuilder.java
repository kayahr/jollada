/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import de.ailis.jollada.model.Asset;
import de.ailis.jollada.model.Camera;
import de.ailis.jollada.model.CommonOpticsTechnique;
import de.ailis.jollada.model.Optics;
import de.ailis.jollada.model.Projection;


/**
 * Builder for cameras.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CameraBuilder
{
    /** The next projection for the common technique. */
    private Projection projection;

    /** The next asset. */
    private Asset asset;

    /** The next id. */
    private String id;

    /** The next name. */
    private String name;


    /**
     * Builds and returns the common effect technique.
     *
     * @return The common effect technique. Never null.
     */

    public Camera build()
    {
        if (this.projection == null)
            throw new IllegalStateException("projection not set");
        final CommonOpticsTechnique commonTechnique = new CommonOpticsTechnique(this.projection);
        final Optics optics = new Optics(commonTechnique);
        final Camera camera = new Camera(optics);
        camera.setAsset(this.asset);
        camera.setId(this.id);
        camera.setName(this.name);
        return camera;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.projection = null;
        this.asset = null;
        this.id = null;
        this.name = null;
    }


    /**
     * Returns the next projection for the common technique.
     *
     * @return The next projection. May be null if unset.
     */

    public Projection getProjection()
    {
        return this.projection;
    }


    /**
     * Sets the next projection for the common technique.
     *
     * @param projection
     *            The next projection to set. Null to unset.
     */

    public void setProjection(final Projection projection)
    {
        this.projection = projection;
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
