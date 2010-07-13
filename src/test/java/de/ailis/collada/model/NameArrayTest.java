/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        array.setValue(0, "1");
        array.setValue(1, "2");
        array.setValue(2, "3");
        array.setValue(3, "4");
        array.setCount(6);
        assertEquals(6, array.getCount());
        assertEquals("1", array.getValue(0));
        assertEquals("2", array.getValue(1));
        assertEquals("3", array.getValue(2));
        assertEquals("4", array.getValue(3));
        array.setCount(2);
        assertEquals(2, array.getCount());
        assertEquals("1", array.getValue(0));
        assertEquals("2", array.getValue(1));
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final NameArray array = new NameArray(4);
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
        final NameArray array = new NameArray(4);
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
        final NameArray array = new NameArray(4);
        array.setValue(0, "1");
        array.setValue(1, "2");
        array.setValue(2, "3");
        array.setValue(3, "4");

        // Test getting copy of values
        String[] values = array.getValues();
        assertEquals("1", values[0]);
        assertEquals("2", values[1]);
        assertEquals("3", values[2]);
        assertEquals("4", values[3]);

        // Test filling array with values
        values = new String[4];
        array.getValues(values);
        assertEquals("1", values[0]);
        assertEquals("2", values[1]);
        assertEquals("3", values[2]);
        assertEquals("4", values[3]);

        // Test getting subset of array
        values = new String[4];
        array.getValues(1, 2, values);
        assertEquals("2", values[0]);
        assertEquals("3", values[1]);
        assertNull(values[2]);
        assertNull(values[3]);

        // Test getting subset of array and writing to specific offset
        values = new String[4];
        array.getValues(1, 2, values, 1);
        assertNull(values[0]);
        assertEquals("2", values[1]);
        assertEquals("3", values[2]);
        assertNull(values[3]);
    }


    /**
     * Tests setting values.
     */

    @Test
    public void testSetValues()
    {
        final NameArray array = new NameArray(4);
        final String[] values = new String[] { "1", "2", "3", "4" };
        array.setValues(values);
        assertEquals("1", array.getValue(0));
        assertEquals("2", array.getValue(1));
        assertEquals("3", array.getValue(2));
        assertEquals("4", array.getValue(3));

        array.setValues(1, 2, values);
        assertEquals("1", array.getValue(0));
        assertEquals("1", array.getValue(1));
        assertEquals("2", array.getValue(2));
        assertEquals("4", array.getValue(3));

        array.setValues(1, 2, values, 1);
        assertEquals("1", array.getValue(0));
        assertEquals("2", array.getValue(1));
        assertEquals("3", array.getValue(2));
        assertEquals("4", array.getValue(3));
    }
}
