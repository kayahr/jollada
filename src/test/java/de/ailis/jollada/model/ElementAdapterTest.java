/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import org.junit.Test;

import de.ailis.jollada.events.ElementAdapter;


/**
 * Tests the ElementAdapter class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ElementAdapterTest
{
    /**
     * Tests the existence of the adapter methods.
     */

    @Test
    public void testMethods()
    {
        final ElementAdapter adapter = new ElementAdapter()
        {
            private static final long serialVersionUID = 1L;
        };
        adapter.elementInserted(null);
        adapter.elementRemoved(null);
        adapter.elementRemovedFromDocument(null);
        adapter.elementInsertedIntoDocument(null);
    }
}
