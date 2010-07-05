/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.io.Serializable;
import java.util.List;

import de.ailis.collada.model.support.AssetElement;
import de.ailis.collada.model.support.DocumentArrayList;
import de.ailis.collada.model.support.DocumentAware;
import de.ailis.collada.model.support.DocumentList;
import de.ailis.collada.model.support.Identifiable;


/**
 * Library of visual scenes.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class VisualSceneLibrary implements Serializable, AssetElement,
    Identifiable, DocumentAware
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private String id;

    /** The name. */
    private String name;

    /** Asset-management information. */
    private Asset asset;

    /** The list of visual scenes. */
    private final DocumentList<VisualScene> visualScenes = new DocumentArrayList<VisualScene>();

    /** The document this library is currently connected to */
    private Document document;


    /**
     * @see de.ailis.collada.model.support.AssetElement#getAsset()
     */

    @Override
    public Asset getAsset()
    {
        return this.asset;
    }


    /**
     * Sets the asset-management information
     *
     * @param asset
     *            The asset-management information to set. Null to unset.
     */

    public void setAsset(final Asset asset)
    {
        this.asset = asset;
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
     *            The id to set. null to unset.
     */

    @Override
    public void setId(final String id)
    {
        if (id != this.id)
        {
            if (this.document != null) this.document.unregister(this);
            this.id = id;
            if (this.document != null) this.document.register(this);
        }
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
     * Returns the list of visual scenes.
     *
     * @return The list of visual scenes. Never null. May be empty.
     */

    public List<VisualScene> getVisualScenes()
    {
        return this.visualScenes;
    }


    /**
     * @see DocumentAware#getDocument()
     */

    @Override
    public Document getDocument()
    {
        return this.document;
    }


    /**
     * @see DocumentAware#setDocument(Document)
     */

    @Override
    public void setDocument(final Document document)
    {
        if (document != this.document)
        {
            if (this.document != null) this.document.unregister(this);
            this.document = document;
            if (document != null) document.register(this);
            this.visualScenes.setDocument(document);
        }
    }
}
