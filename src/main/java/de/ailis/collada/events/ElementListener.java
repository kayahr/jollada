/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.events;

import java.io.Serializable;


/**
 * Listener interface for element events.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public interface ElementListener extends Serializable
{
    /**
     * Called when element is going to be removed from it's parent element.
     */

    public void elementRemoved();


    /**
     * Called when node has been added to a parent element.
     */

    public void elementInserted();


    /**
     * Called when element is going to be removed from a document.
     */

    public void elementRemovedFromDocument();


    /**
     * Called when element is inserted into a document.
     */

    public void elementInsertedIntoDocument();
}
