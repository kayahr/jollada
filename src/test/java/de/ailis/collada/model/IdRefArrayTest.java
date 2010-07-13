/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;


/**
 * Tests the IdRefArray class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class IdRefArrayTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final IdRefArray array = new IdRefArray(16);
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
        new IdRefArray(-1).toString();
    }


    /**
     * Tests the setCount() method.
     */

    @Test
    public void testSetCount()
    {
        final IdRefArray array = new IdRefArray(4);
        array.getData()[0] = "a";
        array.getData()[1] = "b";
        array.getData()[2] = "c";
        array.getData()[3] = "d";
        array.setCount(6);
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
        final IdRefArray array = new IdRefArray(4);
        assertNull(array.getName());
        array.setName("foo");
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
        final IdRefArray array = new IdRefArray(4);
        assertNull(array.getId());
        array.setId("foo");
        assertEquals("foo", array.getId());
        array.setId(null);
        assertNull(array.getId());
    }
}
