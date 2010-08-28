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

import de.ailis.jollada.model.AltitudeMode;
import de.ailis.jollada.model.GeographicLocation;


/**
 * Tests the GeographicLocation class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class GeographicLocationTest
{
    /**
     * Tests the short constructor.
     */

    @Test
    public void testShortConstructor()
    {
        final GeographicLocation location = new GeographicLocation(1, 2, 3);
        assertEquals(1, location.getLongitude(), 0.0001f);
        assertEquals(2, location.getLatitude(), 0.0001f);
        assertEquals(3, location.getAltitude(), 0.0001f);
        assertEquals(AltitudeMode.RELATIVE_TO_GROUND,
            location.getAltitudeMode());
    }


    /**
     * Tests the full constructor.
     */

    @Test
    public void testFullConstructor()
    {
        final GeographicLocation location = new GeographicLocation(1, 2, 3,
            AltitudeMode.ABSOLUTE);
        assertEquals(1, location.getLongitude(), 0.0001f);
        assertEquals(2, location.getLatitude(), 0.0001f);
        assertEquals(3, location.getAltitude(), 0.0001f);
        assertEquals(AltitudeMode.ABSOLUTE,
            location.getAltitudeMode());
    }


    /**
     * Tests constructor with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new GeographicLocation(1, 2, 3, null).toString();
    }


    /**
     * Tests the equals() method.
     */

    @Test
    public void testEquals()
    {
        final GeographicLocation location1 = new GeographicLocation(1, 2, 3);
        final GeographicLocation location2 = new GeographicLocation(1, 2, 3);
        assertTrue(location1.equals(location2));
        assertTrue(location1.equals(location1));
        assertFalse(location1.equals(null));
        assertFalse(location1.equals("someOther"));
        assertFalse(location1.equals(new GeographicLocation(2, 2, 3)));
        assertFalse(location1.equals(new GeographicLocation(1, 3, 3)));
        assertFalse(location1.equals(new GeographicLocation(1, 2, 4)));
        assertFalse(location1.equals(new GeographicLocation(1, 2, 3,
            AltitudeMode.ABSOLUTE)));
    }

    /**
     * Tests the hashCode method.
     */

    @Test
    public void testHashCode()
    {
        final GeographicLocation unit1 = new GeographicLocation(1, 2, 3);
        final GeographicLocation unit2 = new GeographicLocation(1, 2, 3);
        final GeographicLocation unit3 = new GeographicLocation(2, 3, 4);
        final GeographicLocation unit4 = new GeographicLocation(1, 2, 3,
            AltitudeMode.ABSOLUTE);
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
        assertEquals("GeographicLocation [longitude=1.0, latitude=2.0, " +
                "altitude=3.0, altitudeMode=ABSOLUTE]", new GeographicLocation(
            1, 2, 3, AltitudeMode.ABSOLUTE).toString());
    }


    /**
     * Tests the longitude.
     */

    @Test
    public void testLongitude()
    {
        final GeographicLocation location = new GeographicLocation(1, 2, 3);
        location.setLongitude(10);
        assertEquals(10, location.getLongitude(), 0.0001f);
    }


    /**
     * Tests the latitude.
     */

    @Test
    public void testLatitude()
    {
        final GeographicLocation location = new GeographicLocation(1, 2, 3);
        location.setLatitude(10);
        assertEquals(10, location.getLatitude(), 0.0001f);
    }


    /**
     * Tests the altitude.
     */

    @Test
    public void testAltitude()
    {
        final GeographicLocation location = new GeographicLocation(1, 2, 3);
        location.setAltitude(10);
        assertEquals(10, location.getAltitude(), 0.0001f);
    }


    /**
     * Tests the altitude mode.
     */

    @Test
    public void testAltitudeMode()
    {
        final GeographicLocation location = new GeographicLocation(1, 2, 3,
            AltitudeMode.ABSOLUTE);
        location.setAltitudeMode(AltitudeMode.RELATIVE_TO_GROUND);
        assertEquals(AltitudeMode.RELATIVE_TO_GROUND,
            location.getAltitudeMode());
    }


    /**
     * Tests the altitude and mode.
     */

    @Test
    public void testAltitudeAndMode()
    {
        final GeographicLocation location = new GeographicLocation(1, 2, 3,
            AltitudeMode.ABSOLUTE);
        location.setAltitude(10, AltitudeMode.RELATIVE_TO_GROUND);
        assertEquals(10, location.getAltitude(), 0.0001f);
        assertEquals(AltitudeMode.RELATIVE_TO_GROUND,
            location.getAltitudeMode());
    }
}
