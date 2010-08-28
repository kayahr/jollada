/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.ailis.jollada.model.Unit;


/**
 * Tests the Unit class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class UnitTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testDefaultConstructor()
    {
        final Unit unit = new Unit();
        assertEquals(1, unit.getMeter(), 0.0001f);
        assertEquals("meter", unit.getName());
    }


    /**
     * Tests the full constructor.
     */

    @Test
    public void testFullConstructor()
    {
        final Unit unit = new Unit(2, "meters");
        assertEquals(2, unit.getMeter(), 0.0001f);
        assertEquals("meters", unit.getName());
    }

    /**
     * Tests constructor with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new Unit(2, null).toString();
    }


    /**
     * Tests the equals() method.
     */

    @Test
    public void testEquals()
    {
        final Unit unit1 = new Unit(2, "meters");
        final Unit unit2 = new Unit(2, "meters");
        final Unit unit3 = new Unit(3, "meters");
        final Unit unit4 = new Unit(2, "kilometers");
        assertTrue(unit1.equals(unit2));
        assertTrue(unit1.equals(unit1));
        assertFalse(unit1.equals(null));
        assertFalse(unit1.equals("someOther"));
        assertFalse(unit1.equals(unit3));
        assertFalse(unit1.equals(unit4));
    }


    /**
     * Tests the hashCode method.
     */

    @Test
    public void testHashCode()
    {
        final Unit unit1 = new Unit(2, "meters");
        final Unit unit2 = new Unit(2, "meters");
        final Unit unit3 = new Unit(3, "meters");
        final Unit unit4 = new Unit(2, "kilometers");
        assertThat(unit1.hashCode(), is(unit2.hashCode()));
        assertThat(unit1.hashCode(), not(unit3.hashCode()));
        assertThat(unit1.hashCode(), not(unit4.hashCode()));
    }


    /**
     * Tests the toString method.
     */

    @Test
    public void testToString()
    {
        assertThat(new Unit(2, "meters").toString(), is("2.0 meters"));
    }
}
