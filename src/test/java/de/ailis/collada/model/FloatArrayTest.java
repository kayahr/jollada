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
        array.getData()[0] = 1;
        array.getData()[1] = 2;
        array.getData()[2] = 3;
        array.getData()[3] = 4;
        assertSame(array, array.setCount(6));
        assertEquals(6, array.getCount());
        assertEquals(1, array.getData()[0], 0.001f);
        assertEquals(2, array.getData()[1], 0.001f);
        assertEquals(3, array.getData()[2], 0.001f);
        assertEquals(4, array.getData()[3], 0.001f);
        array.setCount(2);
        assertEquals(2, array.getCount());
        assertEquals(1, array.getData()[0], 0.001f);
        assertEquals(2, array.getData()[1], 0.001f);
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final FloatArray array = new FloatArray(4);
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
        final FloatArray array = new FloatArray(4);
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
    public void testSetDigits()
    {
        final FloatArray array = new FloatArray(4);
        assertSame(array, array.setDigits(3));
        assertEquals(3, array.getDigits());
    }


    /**
     * Tests the maxInclusive.
     */

    @Test
    public void testSetMagnitude()
    {
        final FloatArray array = new FloatArray(4);
        assertSame(array, array.setMagnitude(40));
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
}
