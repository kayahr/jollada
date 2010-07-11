/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Tests the Asset class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class AssetTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testDefaultConstructor()
    {
        final long now = System.currentTimeMillis();
        final Asset asset = new Asset();
        assertEquals(0, asset.getContributors().size());
        assertNull(asset.getGeographicLocation());
        assertTrue(asset.getCreated() >= now);
        assertEquals(0, asset.getKeywords().size());
        assertTrue(asset.getModified() >= now);
        assertNull(asset.getRevision());
        assertNull(asset.getSubject());
        assertNull(asset.getTitle());
        assertEquals(new Unit(), asset.getUnit());
        assertEquals(UpAxis.Y_UP, asset.getUpAxis());
    }


    /**
     * Tests constructor with created time stamp.
     */

    @Test
    public void testConstructorWithCreated()
    {
        final Asset asset = new Asset(12345678);
        assertEquals(12345678, asset.getCreated());
        assertEquals(12345678, asset.getModified());
    }


    /**
     * Tests constructor with created and modified timestamp.
     */

    @Test
    public void testConstructorCreatedAndModified()
    {
        final Asset asset = new Asset(12345678, 87654321);
        assertEquals(12345678, asset.getCreated());
        assertEquals(87654321, asset.getModified());
    }


    /**
     * Tests full constructor.
     */

    @Test
    public void testFullConstructor()
    {
        final Asset asset = new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T");
        assertEquals(1, asset.getCreated());
        assertEquals(2, asset.getModified());
        assertEquals(new Unit(2, "m"), asset.getUnit());
        assertEquals(UpAxis.X_UP, asset.getUpAxis());
        assertEquals("R", asset.getRevision());
        assertEquals("S", asset.getSubject());
        assertEquals("T", asset.getTitle());
    }


    /**
     * Tests contributors.
     */

    @Test
    public void testContributor()
    {
        final Asset asset = new Asset();
        asset.getContributors().add(new Contributor().setAuthor("it's me"));
        assertEquals(1, asset.getContributors().size());
        asset.getContributors().clear();
        assertEquals(0, asset.getContributors().size());
    }


    /**
     * Tests created time stamp.
     */

    @Test
    public void testCreated()
    {
        final Asset asset = new Asset();
        assertSame(asset, asset.setCreated(12345678));
        assertEquals(12345678, asset.getCreated());
    }


    /**
     * Tests created time stamp.
     */

    @Test
    public void testModified()
    {
        final Asset asset = new Asset();
        assertSame(asset, asset.setModified(12345678));
        assertEquals(12345678, asset.getModified());
    }


    /**
     * Tests geographic location.
     */

    @Test
    public void testGeographicLocation()
    {
        final Asset asset = new Asset();
        assertSame(asset,
            asset.setGeographicLocation(new GeographicLocation(1, 2, 3)));
        assertEquals(new GeographicLocation(1, 2, 3),
            asset.getGeographicLocation());
    }


    /**
     * Tests keywords.
     */

    @Test
    public void testKeywords()
    {
        final Asset asset = new Asset();
        asset.getKeywords().add("test");
        assertEquals(1, asset.getKeywords().size());
        asset.getKeywords().clear();
        assertEquals(0, asset.getKeywords().size());
    }


    /**
     * Tests revision.
     */

    @Test
    public void testRevision()
    {
        final Asset asset = new Asset();
        assertSame(asset, asset.setRevision("REVISION"));
        assertEquals("REVISION", asset.getRevision());
    }


    /**
     * Tests subject.
     */

    @Test
    public void testSubject()
    {
        final Asset asset = new Asset();
        assertSame(asset, asset.setSubject("SUBJECT"));
        assertEquals("SUBJECT", asset.getSubject());
    }


    /**
     * Tests title.
     */

    @Test
    public void testTitle()
    {
        final Asset asset = new Asset();
        assertSame(asset, asset.setTitle("TITLE"));
        assertEquals("TITLE", asset.getTitle());
    }


    /**
     * Tests unit.
     */

    @Test
    public void testUnit()
    {
        final Asset asset = new Asset();
        assertSame(asset, asset.setUnit(new Unit(2, "meters")));
        assertEquals(new Unit(2, "meters"), asset.getUnit());
    }


    /**
     * Tests null unit.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testNullUnit()
    {
        new Asset().setUnit(null);
    }


    /**
     * Tests up axis.
     */

    @Test
    public void testUpAxis()
    {
        final Asset asset = new Asset();
        assertSame(asset, asset.setUpAxis(UpAxis.X_UP));
        assertEquals(UpAxis.X_UP, asset.getUpAxis());
    }


    /**
     * Tests null up-axis.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testNullUpAxis()
    {
        new Asset().setUpAxis(null);
    }


    /**
     * Tests the equals() method.
     */

    @Test
    public void testEquals()
    {
        final Asset asset = new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T");
        assertTrue(asset.equals(asset));
        assertTrue(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T")));
        assertFalse(asset.equals(null));
        assertFalse(asset.equals("something"));
        assertFalse(asset.equals(new Asset(2, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T")));
        assertFalse(asset.equals(new Asset(1, 3, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(3, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.Y_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(2, 2, 3), "R", "S", "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R2", "S", "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S2", "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T2")));

        assertFalse(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            null, "R", "S", "T").equals(asset));
        assertFalse(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), null, "S", "T").equals(asset));
        assertFalse(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", null, "T").equals(asset));
        assertFalse(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", null).equals(asset));

        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            null, "R", "S", "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), null, "S", "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", null, "T")));
        assertFalse(asset.equals(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", null)));

        assertTrue(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            null, "R", "S", "T").equals(new Asset(1,
            2, new Unit(2, "m"), UpAxis.X_UP, null, "R", "S", "T")));
        assertTrue(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), null, "S", "T").equals(new Asset(
            1,
            2, new Unit(2, "m"), UpAxis.X_UP, new GeographicLocation(1, 2, 3),
            null, "S", "T")));
        assertTrue(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", null, "T").equals(new Asset(
            1,
            2, new Unit(2, "m"), UpAxis.X_UP, new GeographicLocation(1, 2, 3),
            "R", null, "T")));
        assertTrue(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", null).equals(new Asset(
            1,
            2, new Unit(2, "m"), UpAxis.X_UP, new GeographicLocation(1, 2, 3),
            "R", "S", null)));

        final Asset asset2 = new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T");
        assertTrue(asset.equals(asset2));
        asset2.getContributors().add(new Contributor());
        assertFalse(asset.equals(asset2));
        asset2.getContributors().clear();
        assertTrue(asset.equals(asset2));
        asset2.getKeywords().add("KEYWORD");
        assertFalse(asset.equals(asset2));
        asset2.getKeywords().clear();
        assertTrue(asset.equals(asset2));
    }

    /**
     * Tests the hashCode method.
     */

    @Test
    public void testHashCode()
    {
        final int hc1 = new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T").hashCode();
        assertEquals(hc1, new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T").hashCode());
        assertThat(hc1, not(new Asset(2, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 3, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(3, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.Y_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(2, 2, 3), "R", "S", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R2", "S", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S2", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T2").hashCode()));

        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            null, "R", "S", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), null, "S", "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", null, "T").hashCode()));
        assertThat(hc1, not(new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", null).hashCode()));
    }


    /**
     * Tests the toString() method.
     */

    @Test
    public void testToString()
    {
        final Asset asset = new Asset(1, 2, new Unit(2, "m"), UpAxis.X_UP,
            new GeographicLocation(1, 2, 3), "R", "S", "T");
        asset.getKeywords().add("KEYWORD");
        assertEquals("Asset [contributors=[], created=1, modified=2, " +
                "geographicLocation=GeographicLocation [longitude=1.0, " +
                "latitude=2.0, altitude=3.0, altitudeMode=" +
                "RELATIVE_TO_GROUND], keywords=[KEYWORD], revision=R, " +
                "subject=S, title=T, unit=2.0 m, upAxis=X_UP]",
            asset.toString());
    }
}
