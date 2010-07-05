/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model.support;

import de.ailis.collada.model.Document;


/**
 * Document-aware element.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public interface DocumentAware
{
    /**
     * Returns the document this element is currently connected to.
     *
     * @return The document. May be null if not set.
     */

    public Document getDocument();


    /**
     * Sets the document. Don't call this method yourself! This is done
     * automatically by the library.
     *
     * @param document
     *            The document to set. Null to unset.
     */

    public void setDocument(Document document);
}
