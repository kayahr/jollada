/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A light.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Light extends Element implements Identifiable,
        AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The light name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The common technique. */
    private CommonLightTechnique commonTechnique;


    /**
     * Constructor.
     *
     * @param commonTechnique
     *            The common light technique. Must not be null.
     */

    public Light(final CommonLightTechnique commonTechnique)
    {
        setCommonTechnique(commonTechnique);
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
     * Returns the common technique.
     *
     * @return The common technique. Never null.
     */

    public CommonLightTechnique getCommonTechnique()
    {
        return this.commonTechnique;
    }


    /**
     * Sets the common technique.
     *
     * @param commonTechnique
     *            The common technique to set. Must not be null.
     */

    public void setCommonTechnique(final CommonLightTechnique commonTechnique)
    {
        if (commonTechnique == null)
            throw new IllegalArgumentException(
                "commonTechnique must not be null");
        if (commonTechnique != this.commonTechnique)
        {
            if (this.commonTechnique != null)
                removeChild(this.commonTechnique);
            this.commonTechnique = commonTechnique;
            addChild(commonTechnique);
        }
    }
}
