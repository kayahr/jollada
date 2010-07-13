/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;


/**
 * Tests the UnsharedInput class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class UnsharedInputTest
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
        final UnsharedInput input = new UnsharedInput("SEMANTIC", new URI(
            "SOURCE"));
        assertEquals("SEMANTIC", input.getSemantic());
        assertEquals(new URI("SOURCE"), input.getSource());
    }


    /**
     * Tests the constructor with a null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new UnsharedInput("SEMANTIC", null).toString();
    }


    /**
     * Tests the semantic.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testSemantic() throws URISyntaxException
    {
        final UnsharedInput param = new UnsharedInput("SEMANTIC", new URI(
            "SOURCE"));
        param.setSemantic("foo");
        assertEquals("foo", param.getSemantic());
    }


    /**
     * Tests the semantic with null param.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSemanticWithNull() throws URISyntaxException
    {
        UnsharedInput param;
        param = new UnsharedInput("SEMANTIC", new URI("SOURCE"));
        param.setSemantic(null);
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
        final UnsharedInput param = new UnsharedInput("SEMANTIC", new URI(
            "SOURCE"));
        param.setSource(new URI("SOURCE2"));
        assertEquals(new URI("SOURCE2"), param.getSource());
    }


    /**
     * Tests the source with null param.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSourceWithNull() throws URISyntaxException
    {
        UnsharedInput param;
        param = new UnsharedInput("SEMANTIC", new URI("SOURCE"));
        param.setSource(null);
    }
}
