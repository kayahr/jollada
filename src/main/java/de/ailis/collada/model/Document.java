/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

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
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The COLLADA document version */
    private final Version version;

    /** The base URI */
    private URI base;

    /** The asset-management information */
    private final Asset asset = new Asset();

    /** The list of visual scene libraries */
    private final VisualSceneLibraries visualSceneLibraries = new VisualSceneLibraries(
        this);

    /** The ID-to-Element mapping */
    private final Map<String, Element> idMap = new HashMap<String, Element>();

    /** The scene */
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
        if (id != null) if (this.idMap.put(id, element) != null)
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
        if (id != null) if (this.idMap.remove(id) == null)
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
     * @return The document for chaining.
     */

    public Document setBase(final URI base)
    {
        this.base = base;
        return this;
    }


    /**
     * @see de.ailis.collada.model.AssetElement#getAsset()
     */

    @Override
    public Asset getAsset()
    {
        return this.asset;
    }


    /**
     * Returns the list of visual scene libraries.
     *
     * @return The list of visual scene libraries. Never null. May be empty.
     */

    public Elements<VisualSceneLibrary> getVisualSceneLibraries()
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
     * @return The scene. May be empty if not set.
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
     * @return The document for chaining.     */

    public Document setScene(final Scene scene)
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
        return this;
    }
}
