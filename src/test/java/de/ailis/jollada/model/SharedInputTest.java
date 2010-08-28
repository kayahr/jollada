/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import de.ailis.jollada.model.SharedInput;


/**
 * Tests the SharedInput class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class SharedInputTest
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
        final SharedInput input = new SharedInput("SEMANTIC", new URI(
            "SOURCE"), 53);
        assertEquals("SEMANTIC", input.getSemantic());
        assertEquals(new URI("SOURCE"), input.getSource());
        assertEquals(53, input.getOffset());
        assertEquals(0, input.getSet());
    }


    /**
     * Tests the constructor with a null source parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullSource()
    {
        new SharedInput("SEMANTIC", null, 53).toString();
    }


    /**
     * Tests the constructor with a null semantic parameter.
     *
     * @throws URISyntaxException
     *             When URI is invalid
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullSemantic() throws URISyntaxException
    {
        new SharedInput(null, new URI("SOURCE"), 53).toString();
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
        final SharedInput input = new SharedInput("SEMANTIC", new URI(
            "SOURCE"), 53);
        input.setSemantic("foo");
        assertEquals("foo", input.getSemantic());
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
        final SharedInput input = new SharedInput("SEMANTIC",
            new URI("SOURCE"), 53);
        input.setSemantic(null);
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
        final SharedInput input = new SharedInput("SEMANTIC", new URI(
            "SOURCE"), 53);
        input.setSource(new URI("SOURCE2"));
        assertEquals(new URI("SOURCE2"), input.getSource());
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
        final SharedInput input = new SharedInput("SEMANTIC",
            new URI("SOURCE"), 53);
        input.setSource(null);
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
        final SharedInput input = new SharedInput("SEMANTIC",
            new URI("SOURCE"), 53);
        input.setOffset(12);
        assertEquals(12, input.getOffset());
    }


    /**
     * Tests the set.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testSet() throws URISyntaxException
    {
        final SharedInput input = new SharedInput("SEMANTIC",
            new URI("SOURCE"), 53);
        input.setSet(13);
        assertEquals(13, input.getSet());
    }
}
