/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.util.ArrayList;
import java.util.List;


/**
 * A scene node.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Node extends Element implements ScopeIdentifiable,
        Identifiable, AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The asset-management information. */
    private Asset asset;

    /** The scope ID. */
    private String sid;

    /** The node name. */
    private String name;

    /** The child nodes. */
    private final Nodes nodes = new Nodes(this);

    /** The node type. */
    private NodeType type = NodeType.NODE;

    /** The list of layer names this node belongs to. */
    private final ArrayList<String> layers = new ArrayList<String>();

    /** The list of transformations. */
    private final Transforms transforms = new Transforms(this);

    /** The list of camera instances. */
    private final CameraInstances cameraInstances = new CameraInstances(this);

    /** The list of geometry instances. */
    private final GeometryInstances geometryInstances = new GeometryInstances(
        this);

    /** The list of light instances. */
    private final LightInstances lightInstances = new LightInstances(this);


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
     * @see de.ailis.jollada.model.Identifiable#getId()
     */

    @Override
    public String getId()
    {
        return this.id;
    }


    /**
     * @see de.ailis.jollada.model.Identifiable#setId(java.lang.String)
     */

    @Override
    public void setId(final String id)
    {
        super.updateId(id);
    }


    /**
     * Returns the child nodes.
     *
     * @return The child nodes. Never null. May be empty.
     */

    public Nodes getNodes()
    {
        return this.nodes;
    }


    /**
     * Sets the node name.
     *
     * @param name
     *            The node name to set. Null to unset.
     */

    public void setName(final String name)
    {
        this.name = name;
    }


    /**
     * Returns the node name.
     *
     * @return The node name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the node type.
     *
     * @param type
     *            The node type to set. Must not be null.
     */

    public void setType(final NodeType type)
    {
        if (type == null)
            throw new IllegalArgumentException("type must not be null");
        this.type = type;
    }


    /**
     * Returns the node type.
     *
     * @return The node type. Never null.
     */

    public NodeType getType()
    {
        return this.type;
    }


    /**
     * Returns the list of layer names this node belongs to.
     *
     * @return The layer names list. Never null. May be empty.
     */

    public List<String> getLayers()
    {
        return this.layers;
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
     * Returns the list of transformations.
     *
     * @return The list of transformations. Never null. May be empty.
     */

    public Transforms getTransforms()
    {
        return this.transforms;
    }


    /**
     * Returns the list of camera instances.
     *
     * @return The list of camera instances. Never null. May be empty.
     */

    public CameraInstances getCameraInstances()
    {
        return this.cameraInstances;
    }


    /**
     * Returns the list of camera instances.
     *
     * @return The list of camera instances. Never null. May be empty.
     */

    public GeometryInstances getGeometryInstances()
    {
        return this.geometryInstances;
    }


    /**
     * Returns the list of light instances.
     *
     * @return The list of light instances. Never null. May be empty.
     */

    public LightInstances getLightInstances()
    {
        return this.lightInstances;
    }
}
