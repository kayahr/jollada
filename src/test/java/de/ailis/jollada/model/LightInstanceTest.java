/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import de.ailis.jollada.model.LightInstance;


/**
 * Tests the LightInstance class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class LightInstanceTest
{
    /**
     * Tests the default constructor.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testDefaultConstructor() throws URISyntaxException
    {
        final LightInstance instance = new LightInstance(new URI("foo"));
        assertEquals(new URI("foo"), instance.getUrl());
        assertNull(instance.getName());
        assertNull(instance.getSid());
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
        final LightInstance instance = new LightInstance(new URI("foo"));
        assertNull(instance.getSid());
        instance.setSid("foo");
        assertEquals("foo", instance.getSid());
        instance.setSid(null);
        assertNull(instance.getSid());
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
        final LightInstance instance = new LightInstance(new URI("foo"));
        assertNull(instance.getName());
        instance.setName("foo");
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
    public void testUrl() throws URISyntaxException
    {
        final LightInstance instance = new LightInstance(new URI("foo"));
        assertEquals(new URI("foo"), instance.getUrl());
        instance.setUrl(new URI("bar"));
        assertEquals(new URI("bar"), instance.getUrl());
    }

    /**
     * Tests the setType() method with a null parameter.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testNullUrl() throws URISyntaxException
    {
        new LightInstance(new URI("foo")).setUrl(null);
    }
}
