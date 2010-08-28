/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Technique for a common effect profile.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonEffectTechnique extends Element implements
    Identifiable,
        AssetElement, ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** Asset-management information. */
    private Asset asset;

    /** The scope ID */
    private String sid;

    /** The shader. */
    private Shader shader;


    /**
     * Constructor.
     *
     * @param sid
     *            The scope ID. Must not be null.
     * @param shader
     *            The shader. Must noot be null.
     */

    public CommonEffectTechnique(final String sid, final Shader shader)
    {
        setSid(sid);
        setShader(shader);
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
     * Returns the scope ID.
     *
     * @return The scope ID. Never null.
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Must not be null.
     */

    @Override
    public void setSid(final String sid)
    {
        if (sid == null)
            throw new IllegalArgumentException("sid must not be null");
        this.sid = sid;
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
     * Returns the shader.
     *
     * @return The shader. Never null.
     */

    public Shader getShader()
    {
        return this.shader;
    }


    /**
     * Sets the shader.
     *
     * @param shader
     *            The shader to set. Must not be null.
     */

    public void setShader(final Shader shader)
    {
        if (shader == null)
            throw new IllegalArgumentException("shader must not be null");
        if (shader != this.shader)
        {
            if (this.shader != null) removeChild(this.shader);
            this.shader = shader;
            addChild(shader);
        }
    }
}
