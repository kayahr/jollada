/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import de.ailis.jollada.model.PrimitiveData;
import de.ailis.jollada.model.Triangles;


/**
 * Tests the Triangles class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class TrianglesTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testDefaultConstructor()
    {
        final PrimitiveData data = new PrimitiveData(3);
        final Triangles triangles = new Triangles(1, data);
        assertNull(triangles.getName());
        assertNull(triangles.getMaterial());
        assertEquals(0, triangles.getInputs().size());
        assertSame(data, triangles.getData());
        assertEquals(1, triangles.getCount());
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final Triangles triangles = new Triangles(1, new PrimitiveData(3));
        assertNull(triangles.getName());
        triangles.setName("foo");
        assertEquals("foo", triangles.getName());
        triangles.setName(null);
        assertNull(triangles.getName());
    }


    /**
     * Tests the material.
     */

    @Test
    public void testMaterial()
    {
        final Triangles triangles = new Triangles(1, new PrimitiveData(3));
        assertNull(triangles.getMaterial());
        triangles.setMaterial("foo");
        assertEquals("foo", triangles.getMaterial());
        triangles.setMaterial(null);
        assertNull(triangles.getMaterial());
    }


    /**
     * Tests the data.
     */

    @Test
    public void testData()
    {
        final Triangles triangles = new Triangles(1, new PrimitiveData(3));
        final PrimitiveData data = new PrimitiveData(6);
        triangles.setData(data);
        assertSame(data, triangles.getData());
    }


    /**
     * Tests the setData() method with a null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetDataWithNull()
    {
        final Triangles triangles = new Triangles(1, new PrimitiveData(3));
        triangles.setData(null);
    }


    /**
     * Tests the count.
     */

    @Test
    public void testCount()
    {
        final Triangles triangles = new Triangles(1, new PrimitiveData(3));
        triangles.setCount(3);
        assertEquals(3, triangles.getCount());
    }
}
