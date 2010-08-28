/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.events;

import java.io.Serializable;

import de.ailis.jollada.model.Element;


/**
 * Listener interface for element events.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public interface ElementListener extends Serializable
{
    /**
     * Called when element is going to be removed from it's parent element.
     *
     * @param element
     *            The element
     */

    void elementRemoved(Element element);


    /**
     * Called when node has been added to a parent element.
     *
     * @param element
     *            The element
     */

    void elementInserted(Element element);


    /**
     * Called when element is going to be removed from a document.
     *
     * @param element
     *            The element
     */

    void elementRemovedFromDocument(Element element);


    /**
     * Called when element is inserted into a document.
     *
     * @param element
     *            The element
     */

    void elementInsertedIntoDocument(Element element);
}
