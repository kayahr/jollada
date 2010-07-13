/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A data flow source.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class DataFlowSource extends Element implements Identifiable,
    AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The asset-management information. */
    private Asset asset;

    /** The name. */
    private String name;

    /** The data array. */
    private Array array;

    /** The common source technique. */
    private CommonSourceTechnique commonTechnique;


    /**
     * Constructor.
     *
     * @param id
     *            The ID to set. Must not be null.
     */

    public DataFlowSource(final String id)
    {
        setId(id);
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
     * Sets the ID.
     *
     * @param id
     *            The ID to set. Must not be null.
     */

    @Override
    public void setId(final String id)
    {
        if (id == null)
            throw new IllegalArgumentException("id must not be null");
        super.updateId(id);
    }


    /**
     * Returns the ID.
     *
     * @return The ID. Never null.
     */

    @Override
    public String getId()
    {
        return this.id;
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
     * Returns the data array.
     *
     * @return The data array. May be null if not set.
     */

    public Array getArray()
    {
        return this.array;
    }


    /**
     * Sets the array.
     *
     * @param array
     *            The array to set. Null to unset.
     */

    public void setArray(final Array array)
    {
        if (array != this.array)
        {
            if (this.array != null) removeChild(this.array);
            this.array = array;
            if (array != null) addChild(array);
        }
    }


    /**
     * Returns the common source technique.
     *
     * @return The common source technique. May be null if not set.
     */

    public CommonSourceTechnique getCommonTechnique()
    {
        return this.commonTechnique;
    }


    /**
     * Sets the common source technique.
     *
     * @param commonTechnique
     *            The common source technique to set. Null to unset.
     */

    public void setCommonTechnique(
        final CommonSourceTechnique commonTechnique)
    {
        if (commonTechnique != this.commonTechnique)
        {
            if (this.commonTechnique != null)
                removeChild(this.commonTechnique);
            this.commonTechnique = commonTechnique;
            if (commonTechnique != null) addChild(commonTechnique);
        }
    }
}
