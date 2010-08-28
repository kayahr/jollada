/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import de.ailis.jollada.model.FloatArray;


/**
 * Tests the FloatArray class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class FloatArrayTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final FloatArray array = new FloatArray(16);
        assertEquals(16, array.getCount());
        assertNull(array.getId());
        assertNull(array.getName());
        assertEquals(38, array.getMagnitude());
        assertEquals(6, array.getDigits());
    }


    /**
     * Tests the constructor with a negative count.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeCount()
    {
        new FloatArray(-1).toString();
    }


    /**
     * Tests the setCount() method.
     */

    @Test
    public void testSetCount()
    {
        final FloatArray array = new FloatArray(4);
        array.setValue(0, 1);
        array.setValue(1, 2);
        array.setValue(2, 3);
        array.setValue(3, 4);
        array.setCount(6);
        assertEquals(6, array.getCount());
        assertEquals(1, array.getValue(0), 0.001f);
        assertEquals(2, array.getValue(1), 0.001f);
        assertEquals(3, array.getValue(2), 0.001f);
        assertEquals(4, array.getValue(3), 0.001f);
        array.setCount(2);
        assertEquals(2, array.getCount());
        assertEquals(1, array.getValue(0), 0.001f);
        assertEquals(2, array.getValue(1), 0.001f);
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final FloatArray array = new FloatArray(4);
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
        final FloatArray array = new FloatArray(4);
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
    public void testSetDigits()
    {
        final FloatArray array = new FloatArray(4);
        array.setDigits(3);
        assertEquals(3, array.getDigits());
    }


    /**
     * Tests the maxInclusive.
     */

    @Test
    public void testSetMagnitude()
    {
        final FloatArray array = new FloatArray(4);
        array.setMagnitude(40);
        assertEquals(40, array.getMagnitude());
    }


    /**
     * Tests setting a too high magnitude.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetMagnitudeTooHigh()
    {
        new FloatArray(0).setMagnitude(0x8000);
    }


    /**
     * Tests setting a too high digits.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetDigitsTooHigh()
    {
        new FloatArray(0).setDigits(0x8000);
    }


    /**
     * Tests setting a too low digits.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetDigitsTooLow()
    {
        new FloatArray(0).setDigits(-1);
    }


    /**
     * Tests setting a too low magnitude.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetMagnitudeTooLow()
    {
        new FloatArray(0).setMagnitude(-1);
    }



    /**
     * Tests getting values.
     */

    @Test
    public void testGetValues()
    {
        final FloatArray array = new FloatArray(4);
        array.setValue(0, 1);
        array.setValue(1, 2);
        array.setValue(2, 3);
        array.setValue(3, 4);

        // Test getting copy of values
        double[] values = array.getValues();
        assertEquals(1, values[0], 0.001f);
        assertEquals(2, values[1], 0.001f);
        assertEquals(3, values[2], 0.001f);
        assertEquals(4, values[3], 0.001f);

        // Test filling array with values
        values = new double[4];
        array.getValues(values);
        assertEquals(1, values[0], 0.001f);
        assertEquals(2, values[1], 0.001f);
        assertEquals(3, values[2], 0.001f);
        assertEquals(4, values[3], 0.001f);

        // Test getting subset of array
        values = new double[4];
        array.getValues(1, 2, values);
        assertEquals(2, values[0], 0.001f);
        assertEquals(3, values[1], 0.001f);
        assertEquals(0, values[2], 0.001f);
        assertEquals(0, values[3], 0.001f);

        // Test getting subset of array and writing to specific offset
        values = new double[4];
        array.getValues(1, 2, values, 1);
        assertEquals(0, values[0], 0.001f);
        assertEquals(2, values[1], 0.001f);
        assertEquals(3, values[2], 0.001f);
        assertEquals(0, values[3], 0.001f);
    }


    /**
     * Tests setting values.
     */

    @Test
    public void testSetValues()
    {
        final FloatArray array = new FloatArray(4);
        final double[] values = new double[] { 1, 2, 3, 4 };
        array.setValues(values);
        assertEquals(1, array.getValue(0), 0.001f);
        assertEquals(2, array.getValue(1), 0.001f);
        assertEquals(3, array.getValue(2), 0.001f);
        assertEquals(4, array.getValue(3), 0.001f);

        array.setValues(1, 2, values);
        assertEquals(1, array.getValue(0), 0.001f);
        assertEquals(1, array.getValue(1), 0.001f);
        assertEquals(2, array.getValue(2), 0.001f);
        assertEquals(4, array.getValue(3), 0.001f);

        array.setValues(1, 2, values, 1);
        assertEquals(1, array.getValue(0), 0.001f);
        assertEquals(2, array.getValue(1), 0.001f);
        assertEquals(3, array.getValue(2), 0.001f);
        assertEquals(4, array.getValue(3), 0.001f);
    }
}
