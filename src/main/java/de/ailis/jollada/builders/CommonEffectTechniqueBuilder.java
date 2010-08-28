/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import de.ailis.jollada.model.Asset;
import de.ailis.jollada.model.CommonEffectTechnique;
import de.ailis.jollada.model.Shader;


/**
 * Builder for common effect technique.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonEffectTechniqueBuilder
{
    /** The next shader. */
    private Shader shader;

    /** The next asset. */
    private Asset asset;

    /** The next id. */
    private String id;

    /** The next sid. */
    private String sid;


    /**
     * Builds and returns the common effect technique.
     *
     * @return The common effect technique. Never null.
     */

    public CommonEffectTechnique build()
    {
        if (this.shader == null)
            throw new IllegalStateException("shader not set");
        if (this.sid == null)
            throw new IllegalStateException("sid not set");
        final CommonEffectTechnique technique = new CommonEffectTechnique(this.sid, this.shader);
        technique.setAsset(this.asset);
        technique.setId(this.id);
        return technique;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.shader = null;
        this.asset = null;
        this.id = null;
        this.sid = null;
    }


    /**
     * Returns the next shader.
     *
     * @return The next shader. May be null if unset.
     */

    public Shader getShader()
    {
        return this.shader;
    }


    /**
     * Sets the next shader.
     *
     * @param shader
     *            The next shader to set. Null to unset.
     */

    public void setShader(final Shader shader)
    {
        this.shader = shader;
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
     * Returns the next scope ID.
     *
     * @return The next scope ID. May be null if not set.
     */

    public String getSid()
    {
        return this.sid;
    }


    /**
     * Sets the next scope ID.
     *
     * @param sid
     *            The next scope ID to set. Null to unset.
     */

    public void setSid(final String sid)
    {
        this.sid = sid;
    }
}
