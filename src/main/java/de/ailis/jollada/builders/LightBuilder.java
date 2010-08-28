/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import de.ailis.jollada.model.Asset;
import de.ailis.jollada.model.CommonLightTechnique;
import de.ailis.jollada.model.Light;
import de.ailis.jollada.model.LightSource;


/**
 * Builder for lights.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class LightBuilder
{
    /** The next light source for the common technique. */
    private LightSource lightSource;

    /** The next asset. */
    private Asset asset;

    /** The next id. */
    private String id;

    /** The next name. */
    private String name;


    /**
     * Builds and returns light.
     *
     * @return The light. Never null.
     */

    public Light build()
    {
        if (this.lightSource == null)
            throw new IllegalStateException("lightSource not set");
        final CommonLightTechnique commonTechnique = new CommonLightTechnique(this.lightSource);
        final Light light = new Light(commonTechnique);
        light.setAsset(this.asset);
        light.setId(this.id);
        light.setName(this.name);
        return light;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.lightSource = null;
        this.asset = null;
        this.id = null;
        this.name = null;
    }


    /**
     * Returns the next light source for the common technique.
     *
     * @return The next light source. May be null if unset.
     */

    public LightSource getLightSource()
    {
        return this.lightSource;
    }


    /**
     * Sets the next light source for the common technique.
     *
     * @param lightSource
     *            The next light source to set. Null to unset.
     */

    public void setLightSource(final LightSource lightSource)
    {
        this.lightSource = lightSource;
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
