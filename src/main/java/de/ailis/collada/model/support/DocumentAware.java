/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model.support;

import de.ailis.collada.model.Document;


/**
 * Interface for elements which wants to be informed about document changes.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public interface DocumentAware
{
    /**
     * Sets the document.
     *
     * @param document
     *            The document to set. Null to unset.
     */

    public void setDocument(Document document);
}
