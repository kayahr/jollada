/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import de.ailis.jollada.model.IntArray;


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
        array.setValue(0, 1);
        array.setValue(1, 2);
        array.setValue(2, 3);
        array.setValue(3, 4);
        array.setCount(6);
        assertEquals(6, array.getCount());
        assertEquals(1, array.getValue(0));
        assertEquals(2, array.getValue(1));
        assertEquals(3, array.getValue(2));
        assertEquals(4, array.getValue(3));
        array.setCount(2);
        assertEquals(2, array.getCount());
        assertEquals(1, array.getValue(0));
        assertEquals(2, array.getValue(1));
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final IntArray array = new IntArray(4);
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
        final IntArray array = new IntArray(4);
        assertNull(array.getId());
        array.setId("foo");
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
        array.setMinInclusive(-0x800000000L);
        assertEquals(-0x800000000L, array.getMinInclusive());
    }


    /**
     * Tests the maxInclusive.
     */

    @Test
    public void testSetMaxInclusive()
    {
        final IntArray array = new IntArray(4);
        array.setMaxInclusive(0x800000000L);
        assertEquals(0x800000000L, array.getMaxInclusive());
    }


    /**
     * Tests getting values.
     */

    @Test
    public void testGetValues()
    {
        final IntArray array = new IntArray(4);
        array.setValue(0, 1);
        array.setValue(1, 2);
        array.setValue(2, 3);
        array.setValue(3, 4);

        // Test getting copy of values
        long[] values = array.getValues();
        assertEquals(1, values[0]);
        assertEquals(2, values[1]);
        assertEquals(3, values[2]);
        assertEquals(4, values[3]);

        // Test filling array with values
        values = new long[4];
        array.getValues(values);
        assertEquals(1, values[0]);
        assertEquals(2, values[1]);
        assertEquals(3, values[2]);
        assertEquals(4, values[3]);

        // Test getting subset of array
        values = new long[4];
        array.getValues(1, 2, values);
        assertEquals(2, values[0]);
        assertEquals(3, values[1]);
        assertEquals(0, values[2]);
        assertEquals(0, values[3]);

        // Test getting subset of array and writing to specific offset
        values = new long[4];
        array.getValues(1, 2, values, 1);
        assertEquals(0, values[0]);
        assertEquals(2, values[1]);
        assertEquals(3, values[2]);
        assertEquals(0, values[3]);
    }


    /**
     * Tests setting values.
     */

    @Test
    public void testSetValues()
    {
        final IntArray array = new IntArray(4);
        final long[] values = new long[] { 1, 2, 3, 4 };
        array.setValues(values);
        assertEquals(1, array.getValue(0));
        assertEquals(2, array.getValue(1));
        assertEquals(3, array.getValue(2));
        assertEquals(4, array.getValue(3));

        array.setValues(1, 2, values);
        assertEquals(1, array.getValue(0));
        assertEquals(1, array.getValue(1));
        assertEquals(2, array.getValue(2));
        assertEquals(4, array.getValue(3));

        array.setValues(1, 2, values, 1);
        assertEquals(1, array.getValue(0));
        assertEquals(2, array.getValue(1));
        assertEquals(3, array.getValue(2));
        assertEquals(4, array.getValue(3));
    }
}
