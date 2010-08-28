/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import de.ailis.jollada.model.Asset;
import de.ailis.jollada.model.GeometryLibrary;


/**
 * Tests the GeometryLibrary class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class GeometryLibraryTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final GeometryLibrary lib = new GeometryLibrary();
        assertNull(lib.getName());
        assertNull(lib.getAsset());
        assertEquals(0, lib.getGeometries().size());
    }


    /**
     * Tests the asset.
     */

    @Test
    public void testAsset()
    {
        final GeometryLibrary lib = new GeometryLibrary();
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
        final GeometryLibrary lib = new GeometryLibrary();
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
        final GeometryLibrary lib = new GeometryLibrary();
        assertNull(lib.getName());
        lib.setName("foo");
        assertEquals("foo", lib.getName());
        lib.setName(null);
        assertNull(lib.getName());
    }
}
