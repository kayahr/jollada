/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * A camera.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Camera extends Element implements Identifiable,
        AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The camera name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The camera optics. */
    private Optics optics;


    /**
     * Constructor.
     *
     * @param optics
     *            The camera optics. Must not be null.
     */

    public Camera(final Optics optics)
    {
        setOptics(optics);
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
     * Returns the camera optics.
     *
     * @return The camera optics. Never null.
     */

    public Optics getOptics()
    {
        return this.optics;
    }


    /**
     * Sets the camera optics.
     *
     * @param optics
     *            The camera optics to set. Must not be null.
     */

    public void setOptics(final Optics optics)
    {
        if (optics == null) throw new IllegalArgumentException("optics must not be null");
        if (optics != this.optics)
        {
            if (this.optics != null) removeChild(this.optics);
            this.optics = optics;
            addChild(optics);
        }
    }
}
