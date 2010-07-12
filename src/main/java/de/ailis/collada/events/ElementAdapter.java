/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.events;

import de.ailis.collada.model.Element;


/**
 * Adapter with empty implementations of the element listener.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class ElementAdapter implements ElementListener
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * @see de.ailis.collada.events.ElementListener#elementRemoved(Element)
     */

    @Override
    public void elementRemoved(final Element element)
    {
        // Empty
    }


    /**
     * @see de.ailis.collada.events.ElementListener#elementInserted(Element)
     */

    @Override
    public void elementInserted(final Element element)
    {
        // Empty
    }


    /**
     * @see de.ailis.collada.events.ElementListener#elementRemovedFromDocument(Element)
     */

    @Override
    public void elementRemovedFromDocument(final Element element)
    {
        // Empty
    }


    /**
     * @see de.ailis.collada.events.ElementListener#elementInsertedIntoDocument(Element)
     */

    @Override
    public void elementInsertedIntoDocument(final Element element)
    {
        // Empty
    }
}
