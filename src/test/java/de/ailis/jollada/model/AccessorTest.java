/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import de.ailis.jollada.model.Accessor;


/**
 * Tests the Accessor class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class AccessorTest
{
    /**
     * Tests the default constructor.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testConstructor() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        assertEquals(new URI("SOURCE"), accessor.getSource());
        assertEquals(53, accessor.getCount());
        assertEquals(1, accessor.getStride());
        assertEquals(0, accessor.getOffset());
        assertEquals(0, accessor.getParams().size());
    }


    /**
     * Tests the constructor with null URL.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new Accessor(null, 53).toString();
    }


    /**
     * Tests the full constructor.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testFullConstructor() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53, 2, 3);
        assertEquals(new URI("SOURCE"), accessor.getSource());
        assertEquals(53, accessor.getCount());
        assertEquals(2, accessor.getOffset());
        assertEquals(3, accessor.getStride());
        assertEquals(0, accessor.getParams().size());
    }


    /**
     * Tests the full constructor with null URL.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testFullConstructorWithNull()
    {
        new Accessor(null, 53, 2, 3).toString();
    }


    /**
     * Tests the count.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testCount() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        accessor.setCount(32);
        assertEquals(32, accessor.getCount());
    }


    /**
     * Tests the offset.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testOffset() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        accessor.setOffset(16);
        assertEquals(16, accessor.getOffset());
    }


    /**
     * Tests the source.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testSource() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        accessor.setSource(new URI("SOURCE2"));
        assertEquals(new URI("SOURCE2"), accessor.getSource());
    }


    /**
     * Tests the setSource() method with a null parameter.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetSourceWithNull() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        accessor.setSource(null);
    }


    /**
     * Tests the stride.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testStride() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        accessor.setStride(8);
        assertEquals(8, accessor.getStride());
    }


    /**
     * Tests the parameters.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testParams() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        assertEquals(0, accessor.getParams().size());
    }
}
