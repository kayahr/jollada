/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A image.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Image extends Element implements Identifiable,
        AssetElement, ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scene name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The scope ID. */
    private String sid;

    /** The image source. */
    private ImageSource source;


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
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Null to unset.
     */

    @Override
    public void setSid(final String sid)
    {
        this.sid = sid;
    }


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. May be null if not set.
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }


    /**
     * Returns the image source.
     *
     * @return The image source. May be null if not set.
     */

    public ImageSource getSource()
    {
        return this.source;
    }


    /**
     * Sets the image source.
     *
     * @param source
     *            The image source to set. Null to unset.
     */

    public void setSource(final ImageSource source)
    {
        if (source != this.source)
        {
            if (this.source != null) removeChild(this.source);
            this.source = source;
            if (source != null) addChild(source);
        }
    }
}
