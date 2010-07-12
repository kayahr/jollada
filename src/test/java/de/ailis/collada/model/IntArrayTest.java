/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;


/**
 * Tests the IntArray class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class IntArrayTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final IntArray array = new IntArray(16);
        assertEquals(16, array.getCount());
        assertNull(array.getId());
        assertNull(array.getName());
        assertEquals(0x7fffffff, array.getMaxInclusive());
        assertEquals(-0x80000000, array.getMinInclusive());
    }


    /**
     * Tests the constructor with a negative count.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeCount()
    {
        new IntArray(-1).toString();
    }


    /**
     * Tests the setCount() method.
     */

    @Test
    public void testSetCount()
    {
        final IntArray array = new IntArray(4);
        array.getData()[0] = 1;
        array.getData()[1] = 2;
        array.getData()[2] = 3;
        array.getData()[3] = 4;
        assertSame(array, array.setCount(6));
        assertEquals(6, array.getCount());
        assertEquals(1, array.getData()[0]);
        assertEquals(2, array.getData()[1]);
        assertEquals(3, array.getData()[2]);
        assertEquals(4, array.getData()[3]);
        array.setCount(2);
        assertEquals(2, array.getCount());
        assertEquals(1, array.getData()[0]);
        assertEquals(2, array.getData()[1]);
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final IntArray array = new IntArray(4);
        assertNull(array.getName());
        assertSame(array, array.setName("foo"));
        assertEquals("foo", array.getName());
        array.setName(null);
        assertNull(array.getName());
    }


    /**
     * Tests the ID.
     */

    @Test
    public void testId()
    {
        final IntArray array = new IntArray(4);
        assertNull(array.getId());
        assertSame(array, ((Identifiable) array).setId("foo"));
        assertEquals("foo", array.getId());
        array.setId(null);
        assertNull(array.getId());
    }


    /**
     * Tests the minInclusive.
     */

    @Test
    public void testSetMinInclusive()
    {
        final IntArray array = new IntArray(4);
        assertSame(array, array.setMinInclusive(-0x800000000L));
        assertEquals(-0x800000000L, array.getMinInclusive());
    }


    /**
     * Tests the maxInclusive.
     */

    @Test
    public void testSetMaxInclusive()
    {
        final IntArray array = new IntArray(4);
        assertSame(array, array.setMaxInclusive(0x800000000L));
        assertEquals(0x800000000L, array.getMaxInclusive());
    }
}
