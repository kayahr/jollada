/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * An animation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Animation extends Element implements Identifiable,
        AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scene name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The child animations. */
    private final Animations animations = new Animations(this);

    /** The sources. */
    private final DataFlowSources sources = new DataFlowSources(this);

    /** The animation samplers. */
    private final AnimationSamplers samplers = new AnimationSamplers(this);

    /** The animation channels. */
    private final AnimationChannels channels = new AnimationChannels(this);


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
     * Returns child animations.
     *
     * @return The child animations. Never null. May be empty.
     */

    public Animations getAnimations()
    {
        return this.animations;
    }


    /**
     * Returns the animation samplers.
     *
     * @return The animation samplers. Never null. May be empty.
     */

    public AnimationSamplers getSamplers()
    {
        return this.samplers;
    }


    /**
     * Returns the animation channels.
     *
     * @return The animation channels. Never null. May be empty.
     */

    public AnimationChannels getChannels()
    {
        return this.channels;
    }


    /**
     * Returns the image source.
     *
     * @return The image source. May be null if not set.
     */

    public DataFlowSources getSources()
    {
        return this.sources;
    }
}
