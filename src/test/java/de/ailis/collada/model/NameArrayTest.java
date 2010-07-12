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
 * Tests the NameArray class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class NameArrayTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final NameArray array = new NameArray(16);
        assertEquals(16, array.getCount());
        assertNull(array.getId());
        assertNull(array.getName());
    }


    /**
     * Tests the constructor with a negative count.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeCount()
    {
        new NameArray(-1).toString();
    }


    /**
     * Tests the setCount() method.
     */

    @Test
    public void testSetCount()
    {
        final NameArray array = new NameArray(4);
        array.getData()[0] = "a";
        array.getData()[1] = "b";
        array.getData()[2] = "c";
        array.getData()[3] = "d";
        assertSame(array, array.setCount(6));
        assertEquals(6, array.getCount());
        assertEquals("a", array.getData()[0]);
        assertEquals("b", array.getData()[1]);
        assertEquals("c", array.getData()[2]);
        assertEquals("d", array.getData()[3]);
        array.setCount(2);
        assertEquals(2, array.getCount());
        assertEquals("a", array.getData()[0]);
        assertEquals("b", array.getData()[1]);
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final NameArray array = new NameArray(4);
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
        final NameArray array = new NameArray(4);
        assertNull(array.getId());
        assertSame(array, array.setId("foo"));
        assertEquals("foo", array.getId());
        array.setId(null);
        assertNull(array.getId());
    }
}
