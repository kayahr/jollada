/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.ailis.collada.model.support.AssetElement;
import de.ailis.collada.model.support.DocumentArrayList;
import de.ailis.collada.model.support.Identifiable;


/**
 * COLLADA document.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class Document implements AssetElement
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
    private final List<VisualSceneLibrary> visualSceneLibraries = new DocumentArrayList<VisualSceneLibrary>(
        this);

    /** The ID-to-Element mapping */
    private final Map<String, Identifiable> idMap = new HashMap<String, Identifiable>();


    /**
     * Creates a new COLLADA document with the latest supported version.
     */

    public Document()
    {
        this(Version.VERSION_1_5_0);
    }


    /**
     * Registers an element.
     *
     * @param element
     *            The element to register
     */

    void register(final Identifiable element)
    {
        final String id = element.getId();
        if (id != null)
        {
            if (this.idMap.containsKey(id))
                throw new IllegalStateException(
                    "Document already contains an element with id '" + id + "'");
            this.idMap.put(id, element);
        }
    }


    /**
     * Unregisters an element.
     *
     * @param element
     *            The element to unregister
     */

    void unregister(final Identifiable element)
    {
        final String id = element.getId();
        if (id != null)
        {
            if (!this.idMap.containsKey(id))
                throw new IllegalStateException(
                    "Document does not contain an element with id '" + id + "'");
            this.idMap.remove(id);
        }
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
     * @see de.ailis.collada.model.support.AssetElement#getAsset()
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

    public List<VisualSceneLibrary> getVisualSceneLibraries()
    {
        return this.visualSceneLibraries;
    }
}
