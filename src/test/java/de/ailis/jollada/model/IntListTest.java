/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ailis.jollada.model.IntList;


/**
 * Tests the PrimitiveData class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class IntListTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final IntList array = new IntList(16);
        assertEquals(16, array.getSize());
    }


    /**
     * Tests the constructor with a negative count.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeSize()
    {
        new IntList(-1).toString();
    }


    /**
     * Tests the setSize() method.
     */

    @Test
    public void testSetSize()
    {
        final IntList array = new IntList(4);
        array.setValue(0, 1);
        array.setValue(1, 2);
        array.setValue(2, 3);
        array.setValue(3, 4);
        array.setSize(6);
        assertEquals(6, array.getSize());
        assertEquals(1, array.getValue(0));
        assertEquals(2, array.getValue(1));
        assertEquals(3, array.getValue(2));
        assertEquals(4, array.getValue(3));
        array.setSize(2);
        assertEquals(2, array.getSize());
        assertEquals(1, array.getValue(0));
        assertEquals(2, array.getValue(1));
    }


    /**
     * Tests getting values.
     */

    @Test
    public void testGetValues()
    {
        final IntList array = new IntList(4);
        array.setValue(0, 1);
        array.setValue(1, 2);
        array.setValue(2, 3);
        array.setValue(3, 4);

        // Test getting copy of values
        int[] values = array.getValues();
        assertEquals(1, values[0]);
        assertEquals(2, values[1]);
        assertEquals(3, values[2]);
        assertEquals(4, values[3]);

        // Test filling array with values
        values = new int[4];
        array.getValues(values);
        assertEquals(1, values[0]);
        assertEquals(2, values[1]);
        assertEquals(3, values[2]);
        assertEquals(4, values[3]);

        // Test getting subset of array
        values = new int[4];
        array.getValues(1, 2, values);
        assertEquals(2, values[0]);
        assertEquals(3, values[1]);
        assertEquals(0, values[2]);
        assertEquals(0, values[3]);

        // Test getting subset of array and writing to specific offset
        values = new int[4];
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
        final IntList array = new IntList(4);
        final int[] values = new int[] { 1, 2, 3, 4 };
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
