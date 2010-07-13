/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;


/**
 * Tests the Mesh class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class MeshTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final Vertices vertices = new Vertices("ID");
        final Mesh mesh = new Mesh(vertices);
        assertEquals(0, mesh.getSources().size());
        assertEquals(0, mesh.getPrimitives().size());
        assertSame(vertices, mesh.getVertices());
    }


    /**
     * Tests the constructor with a null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new Mesh(null).toString();
    }


    /**
     * Tests setting new vertices.
     */

    @Test
    public void testSetVertices()
    {
        Vertices vertices = new Vertices("ID");
        final Mesh mesh = new Mesh(vertices);
        vertices = new Vertices("ID2");
        mesh.setVertices(vertices);
        assertSame(vertices, mesh.getVertices());
    }


    /**
     * Tests setting the same vertices again.
     */

    @Test
    public void testVerticesAgain()
    {
        final Vertices vertices = new Vertices("ID");
        final Mesh mesh = new Mesh(vertices);
        mesh.setVertices(vertices);
        assertSame(vertices, mesh.getVertices());
    }
}
