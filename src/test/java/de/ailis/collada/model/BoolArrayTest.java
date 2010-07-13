/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Tests the BoolArray class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class BoolArrayTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final BoolArray array = new BoolArray(16);
        assertEquals(16, ((Array) array).getCount());
        assertNull(((Array) array).getId());
        assertNull(((Array) array).getName());
    }


    /**
     * Tests the constructor with a negative count.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeCount()
    {
        new BoolArray(-1).toString();
    }


    /**
     * Tests the setCount() method.
     */

    @Test
    public void testSetCount()
    {
        final BoolArray array = new BoolArray(4);
        array.setValue(0, true);
        array.setValue(1, true);
        array.setValue(2, true);
        array.setValue(3, true);
        array.setCount(6);
        assertEquals(6, array.getCount());
        assertTrue(array.getValue(0));
        assertTrue(array.getValue(1));
        assertTrue(array.getValue(2));
        assertTrue(array.getValue(3));
        array.setCount(2);
        assertEquals(2, array.getCount());
        assertTrue(array.getValue(0));
        assertTrue(array.getValue(1));
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final BoolArray array = new BoolArray(4);
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
        final BoolArray array = new BoolArray(4);
        assertNull(array.getId());
        array.setId("foo");
        assertEquals("foo", array.getId());
        array.setId(null);
        assertNull(array.getId());
    }


    /**
     * Tests getting values.
     */

    @Test
    public void testGetValues()
    {
        final BoolArray array = new BoolArray(4);
        array.setValue(0, true);
        array.setValue(1, true);
        array.setValue(2, true);
        array.setValue(3, true);

        // Test getting copy of values
        boolean[] values = array.getValues();
        assertTrue(values[0]);
        assertTrue(values[1]);
        assertTrue(values[2]);
        assertTrue(values[3]);

        // Test filling array with values
        values = new boolean[4];
        array.getValues(values);
        assertTrue(values[0]);
        assertTrue(values[1]);
        assertTrue(values[2]);
        assertTrue(values[3]);

        // Test getting subset of array
        values = new boolean[4];
        array.getValues(1, 2, values);
        assertTrue(values[0]);
        assertTrue(values[1]);
        assertFalse(values[2]);
        assertFalse(values[3]);

        // Test getting subset of array and writing to specific offset
        values = new boolean[4];
        array.getValues(1, 2, values, 1);
        assertFalse(values[0]);
        assertTrue(values[1]);
        assertTrue(values[2]);
        assertFalse(values[3]);
    }


    /**
     * Tests setting values.
     */

    @Test
    public void testSetValues()
    {
        final BoolArray array = new BoolArray(4);
        final boolean[] values = new boolean[] { true, false, true, false };
        array.setValues(values);
        assertTrue(array.getValue(0));
        assertFalse(array.getValue(1));
        assertTrue(array.getValue(2));
        assertFalse(array.getValue(3));

        array.setValues(1, 2, values);
        assertTrue(array.getValue(0));
        assertTrue(array.getValue(1));
        assertFalse(array.getValue(2));
        assertFalse(array.getValue(3));

        array.setValues(1, 2, values, 1);
        assertTrue(array.getValue(0));
        assertFalse(array.getValue(1));
        assertTrue(array.getValue(2));
        assertFalse(array.getValue(3));
    }
}
