/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertSame;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import de.ailis.jollada.model.Accessor;
import de.ailis.jollada.model.CommonSourceTechnique;


/**
 * Tests the CommonSourceTechnique class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class CommonSourceTechniqueTest
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
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        final CommonSourceTechnique technique = new CommonSourceTechnique(
            accessor);
        assertSame(accessor, technique.getAccessor());
    }


    /**
     * Tests the constructor with null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new CommonSourceTechnique(null).toString();
    }


    /**
     * Tests the setAccessor method.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testSetAccessor() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        final CommonSourceTechnique technique = new CommonSourceTechnique(
            accessor);
        final Accessor accessor2 = new Accessor(new URI("SOURCE"), 53);
        technique.setAccessor(accessor2);
        assertSame(accessor2, technique.getAccessor());
    }


    /**
     * Tests the setAccessor method with null argument.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetAccessorWithNull() throws URISyntaxException
    {
        final Accessor accessor = new Accessor(new URI("SOURCE"), 53);
        final CommonSourceTechnique technique = new CommonSourceTechnique(
            accessor);
        technique.setAccessor(null);
    }
}
