/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;


/**
 * Tests the MaterialInstance class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class MaterialInstanceTest
{
    /**
     * Tests the constructor.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testConstructor() throws URISyntaxException
    {
        final MaterialInstance instance = new MaterialInstance("SYMBOL",
            new URI("foo"));
        assertEquals("SYMBOL", instance.getSymbol());
        assertEquals(new URI("foo"), instance.getTarget());
        assertNull(instance.getName());
        assertNull(instance.getSid());
    }


    /**
     * Tests the constructor with first argument null.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithFirstNull() throws URISyntaxException
    {
        new MaterialInstance(null, new URI("foo")).toString();
    }


    /**
     * Tests the constructor with second argument null.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithSecondNull() throws URISyntaxException
    {
        new MaterialInstance("SYMBOL", null).toString();
    }


    /**
     * Tests the SID.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testSid() throws URISyntaxException
    {
        final MaterialInstance instance = new MaterialInstance("SYMBOL",
            new URI("foo"));
        assertNull(instance.getId());
        assertSame(instance, ((ScopeIdentifiable) instance).setSid("foo"));
        assertEquals("foo", instance.getSid());
        instance.setId(null);
        assertNull(instance.getId());
    }


    /**
     * Tests the name.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testName() throws URISyntaxException
    {
        final MaterialInstance instance = new MaterialInstance("SYMBOL",
            new URI("foo"));
        assertNull(instance.getName());
        assertSame(instance, instance.setName("foo"));
        assertEquals("foo", instance.getName());
        instance.setName(null);
        assertNull(instance.getName());
    }


    /**
     * Tests the URL.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testTarget() throws URISyntaxException
    {
        final MaterialInstance instance = new MaterialInstance("SYMBOL",
            new URI("foo"));
        assertEquals(new URI("foo"), instance.getTarget());
        assertSame(instance, instance.setTarget(new URI("bar")));
        assertEquals(new URI("bar"), instance.getTarget());
    }


    /**
     * Tests the setTarget() method with a null parameter.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testNullTarget() throws URISyntaxException
    {
        new MaterialInstance("SYMBOL", new URI("foo")).setTarget(null);
    }


    /**
     * Tests the symbol.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testSymbol() throws URISyntaxException
    {
        final MaterialInstance instance = new MaterialInstance("SYMBOL",
            new URI("foo"));
        assertEquals("SYMBOL", instance.getSymbol());
        assertSame(instance, instance.setSymbol("foo"));
        assertEquals("foo", instance.getSymbol());
    }


    /**
     * Tests the setSymbol() method with a null parameter.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testNullSymbol() throws URISyntaxException
    {
        new MaterialInstance("SYMBOL", new URI("foo")).setSymbol(null);
    }
}
