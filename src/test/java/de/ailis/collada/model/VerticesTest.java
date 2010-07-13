/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;


/**
 * Tests the Vertices class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class VerticesTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final Vertices vertices = new Vertices("ID");
        assertEquals("ID", vertices.getId());
        assertNull(vertices.getName());
        assertEquals(0, vertices.getInputs().size());
    }


    /**
     * Tests the ID.
     */

    @Test
    public void testId()
    {
        final Vertices vertices = new Vertices("ID");
        vertices.setId("foo");
        assertEquals("foo", vertices.getId());
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final Vertices vertices = new Vertices("ID");
        assertNull(vertices.getName());
        vertices.setName("foo");
        assertEquals("foo", vertices.getName());
        vertices.setName(null);
        assertNull(vertices.getName());
    }


    /**
     * Tests the setId() method with a null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetGeometricWithNull()
    {
        final Vertices vertices = new Vertices("ID");
        vertices.setId(null);
    }
}
