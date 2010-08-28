/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


/**
 * COLLADA document.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Document extends Element implements AssetElement
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The COLLADA document version. */
    private final Version version;

    /** The base URI. */
    private URI base;

    /** The asset-management information. */
    private final Asset asset = new Asset();

    /** The list of image libraries. */
    private final ImageLibraries imageLibraries = new ImageLibraries(this);

    /** The list of material libraries. */
    private final MaterialLibraries materialLibraries =
            new MaterialLibraries(this);

    /** The list of effect libraries. */
    private final EffectLibraries effectLibraries =
            new EffectLibraries(this);

    /** The list of camera libraries. */
    private final CameraLibraries cameraLibraries =
            new CameraLibraries(this);

    /** The list of camera libraries. */
    private final LightLibraries lightLibraries =
            new LightLibraries(this);

    /** The list of geometry libraries. */
    private final GeometryLibraries geometryLibraries = new GeometryLibraries(
        this);

    /** The list of visual scene libraries. */
    private final VisualSceneLibraries visualSceneLibraries =
            new VisualSceneLibraries(this);

    /** The ID-to-Element mapping. */
    private final Map<String, Element> idMap = new HashMap<String, Element>();

    /** The scene. */
    private Scene scene;


    /**
     * Creates a new COLLADA document with the latest supported version.
     */

    public Document()
    {
        this(Version.VERSION_1_5_0);
    }


    /**
     * Creates a new empty COLLADA document with the specified version.
     *
     * @param version
     *            The COLLADA document version. Must not be null.
     */

    public Document(final Version version)
    {
        if (version == null)
            throw new IllegalArgumentException("version must not be null");
        this.version = version;
        setDocument(this);
    }


    /**
     * Registers an element.
     *
     * @param element
     *            The element to register
     */

    void register(final Element element)
    {
        if (element == null)
            throw new IllegalArgumentException("element must not be null");


        final String id = element.id;
        if (id != null && this.idMap.put(id, element) != null)
            throw new InternalError(
                "Element with id '" + id + "' already registered");
    }


    /**
     * Unregisters an element.
     *
     * @param element
     *            The element to unregister
     */

    void unregister(final Element element)
    {
        if (element == null)
            throw new IllegalArgumentException("element must not be null");

        final String id = element.id;
        if (id != null && this.idMap.remove(id) == null)
            throw new InternalError(
                "Element with id '" + id + "' not registered");
    }


    /**
     * Returns the version of this COLLADA document.
     *
     * @return The COLLADA document version. Never null.
     */

    public Version getVersion()
    {
        return this.version;
    }


    /**
     * Returns the base URI.
     *
     * @return The base URI. May be null if not set.
     */

    public URI getBase()
    {
        return this.base;
    }


    /**
     * Sets the base URI.
     *
     * @param base
     *            The base URI to set. null to unset.
     */

    public void setBase(final URI base)
    {
        this.base = base;
    }


    /**
     * @see de.ailis.jollada.model.AssetElement#getAsset()
     */

    @Override
    public Asset getAsset()
    {
        return this.asset;
    }


    /**
     * Returns the list of image libraries.
     *
     * @return The list of image libraries. Never null. May be empty.
     */

    public ImageLibraries getImageLibraries()
    {
        return this.imageLibraries;
    }


    /**
     * Returns the list of material libraries.
     *
     * @return The list of material libraries. Never null. May be empty.
     */

    public MaterialLibraries getMaterialLibraries()
    {
        return this.materialLibraries;
    }


    /**
     * Returns the list of effect libraries.
     *
     * @return The list of effect libraries. Never null. May be empty.
     */

    public EffectLibraries getEffectLibraries()
    {
        return this.effectLibraries;
    }


    /**
     * Returns the list of camera libraries.
     *
     * @return The list of camera libraries. Never null. May be empty.
     */

    public CameraLibraries getCameraLibraries()
    {
        return this.cameraLibraries;
    }


    /**
     * Returns the list of light libraries.
     *
     * @return The list of light libraries. Never null. May be empty.
     */

    public LightLibraries getLightLibraries()
    {
        return this.lightLibraries;
    }


    /**
     * Returns the list of geometry libraries.
     *
     * @return The list of geometry libraries. Never null. May be empty.
     */

    public GeometryLibraries getGeometryLibraries()
    {
        return this.geometryLibraries;
    }


    /**
     * Returns the list of visual scene libraries.
     *
     * @return The list of visual scene libraries. Never null. May be empty.
     */

    public VisualSceneLibraries getVisualSceneLibraries()
    {
        return this.visualSceneLibraries;
    }


    /**
     * Searches for the element with the specified ID and returns it.
     *
     * @param id
     *            The ID of the element to search.
     * @return The found element. Null when not found.
     */

    public Element getById(final String id)
    {
        return this.idMap.get(id);
    }


    /**
     * Returns the scene.
     *
     * @return The scene. May be null if not set.
     */

    public Scene getScene()
    {
        return this.scene;
    }


    /**
     * Sets the scene.
     *
     * @param scene
     *            The scene to set. Null to unset.
     */

    public void setScene(final Scene scene)
    {
        if (scene != this.scene)
        {
            // Remove old scene if present
            if (this.scene != null) removeChild(this.scene);

            if (scene != null)
            {
                // Detach new scene from previous document
                final Document document = scene.getDocument();
                if (document != null) document.setScene(null);

                // Add scene
                addChild(scene);
            }

            this.scene = scene;
        }
    }
}
