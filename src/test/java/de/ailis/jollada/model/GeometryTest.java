/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import de.ailis.jollada.model.Asset;
import de.ailis.jollada.model.Geometry;
import de.ailis.jollada.model.Mesh;
import de.ailis.jollada.model.Vertices;


/**
 * Tests the Geometry class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class GeometryTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testDefaultConstructor()
    {
        final Vertices vertices = new Vertices("ID");
        final Mesh mesh = new Mesh(vertices);
        final Geometry geometry = new Geometry(mesh);
        assertNull(geometry.getId());
        assertNull(geometry.getAsset());
        assertNull(geometry.getName());
        assertSame(mesh, geometry.getGeometric());
    }


    /**
     * Tests the ID.
     */

    @Test
    public void testId()
    {
        final Geometry geometry = new Geometry(new Mesh(new Vertices("ID")));
        assertNull(geometry.getId());
        geometry.setId("foo");
        assertEquals("foo", geometry.getId());
        geometry.setId(null);
        assertNull(geometry.getId());
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final Geometry geometry = new Geometry(new Mesh(new Vertices("ID")));
        assertNull(geometry.getName());
        geometry.setName("foo");
        assertEquals("foo", geometry.getName());
        geometry.setName(null);
        assertNull(geometry.getName());
    }


    /**
     * Tests the asset.
     */

    @Test
    public void testAsset()
    {
        final Geometry geometry = new Geometry(new Mesh(new Vertices("ID")));
        assertNull(geometry.getAsset());
        geometry.setAsset(new Asset());
        assertNotNull(geometry.getAsset());
        geometry.setAsset(null);
        assertNull(geometry.getAsset());
    }


    /**
     * Tests the geometric.
     */

    @Test
    public void testGeometric()
    {
        final Geometry geometry = new Geometry(new Mesh(new Vertices("ID")));
        final Mesh mesh = new Mesh(new Vertices("ID2"));
        geometry.setGeometric(mesh);
        assertSame(mesh, geometry.getGeometric());
    }


    /**
     * Tests the setGeometric() method with a null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetGeometricWithNull()
    {
        final Geometry geometry = new Geometry(new Mesh(new Vertices("ID")));
        geometry.setGeometric(null);
    }
}
