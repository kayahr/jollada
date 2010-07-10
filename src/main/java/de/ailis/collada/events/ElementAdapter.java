/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.events;


/**
 * Adapter with empty implementations of the element listener.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ElementAdapter implements ElementListener
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * @see de.ailis.collada.events.ElementListener#elementRemoved()
     */

    @Override
    public void elementRemoved()
    {
        // Empty
    }


    /**
     * @see de.ailis.collada.events.ElementListener#elementInserted()
     */

    @Override
    public void elementInserted()
    {
        // Empty
    }


    /**
     * @see de.ailis.collada.events.ElementListener#elementRemovedFromDocument()
     */

    @Override
    public void elementRemovedFromDocument()
    {
        // Empty
    }


    /**
     * @see de.ailis.collada.events.ElementListener#elementInsertedIntoDocument()
     */

    @Override
    public void elementInsertedIntoDocument()
    {
        // Empty
    }
}
