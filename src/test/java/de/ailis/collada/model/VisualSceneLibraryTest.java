/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;


/**
 * Tests the VisualSceneLibrary class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class VisualSceneLibraryTest
{
    /**
     * Tests the asset.
     */

    @Test
    public void testAsset()
    {
        final VisualSceneLibrary lib = new VisualSceneLibrary();
        assertNull(lib.getAsset());
        lib.setAsset(new Asset());
        assertNotNull(lib.getAsset());
        lib.setAsset(null);
        assertNull(lib.getAsset());
    }


    /**
     * Tests the ID.
     */

    @Test
    public void testId()
    {
        final VisualSceneLibrary lib = new VisualSceneLibrary();
        assertNull(lib.getId());
        lib.setId("foo");
        assertEquals("foo", lib.getId());
        lib.setId(null);
        assertNull(lib.getId());
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final VisualSceneLibrary lib = new VisualSceneLibrary();
        assertNull(lib.getName());
        lib.setName("foo");
        assertEquals("foo", lib.getName());
        lib.setName(null);
        assertNull(lib.getName());
    }
}
