/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.builders;

import java.util.ArrayList;
import java.util.List;

import de.ailis.collada.model.Asset;
import de.ailis.collada.model.CommonEffectProfile;
import de.ailis.collada.model.CommonEffectTechnique;
import de.ailis.collada.model.CommonNewParam;


/**
 * Builder for common effect profiles.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonEffectProfileBuilder
{
    /** The next effect instance. */
    private CommonEffectTechnique technique;

    /** The next asset. */
    private Asset asset;

    /** The next id. */
    private String id;

    /** The parameters. */
    private final List<CommonNewParam> params = new ArrayList<CommonNewParam>();


    /**
     * Builds and returns the common effect profile.
     *
     * @return The common effect profile. Never null.
     */

    public CommonEffectProfile build()
    {
        if (this.technique == null)
            throw new IllegalStateException("technique not set");
        final CommonEffectProfile profile = new CommonEffectProfile(this.technique);
        profile.setAsset(this.asset);
        profile.setId(this.id);
        profile.getParams().addAll(this.params);
        return profile;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.technique = null;
        this.asset = null;
        this.id = null;
        this.params.clear();
    }


    /**
     * Returns the next technique.
     *
     * @return The next technique. May be null if unset.
     */

    public CommonEffectTechnique getTechnique()
    {
        return this.technique;
    }


    /**
     * Sets the next technique.
     *
     * @param technique
     *            The next technique to set. Null to unset.
     */

    public void setTechnique(final CommonEffectTechnique technique)
    {
        this.technique = technique;
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
     * Returns the list of parameters used for the next build profile.
     *
     * @return The list of parameters. Never null. May be empty.
     */

    public List<CommonNewParam> getParams()
    {
        return this.params;
    }
}
