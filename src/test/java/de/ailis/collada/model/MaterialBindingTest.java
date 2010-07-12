/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;


/**
 * Tests the MaterialBinding class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class MaterialBindingTest
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
        final GeometryInstance instance = new GeometryInstance(new URI("foo"));
        final MaterialBinding binding = new MaterialBinding(instance);
        assertEquals(0, binding.getParams().size());
        assertNotNull(binding.getCommonTechnique());
    }


    /**
     * Tests the constructor with a null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testNullUrl()
    {
        new MaterialBinding(null).toString();
    }
}
