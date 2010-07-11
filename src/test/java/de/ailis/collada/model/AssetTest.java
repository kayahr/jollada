/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
     * Tests full constructor.
     */

    @Test
    public void testFullConstructor()
    {
        final Asset asset = new Asset(12345678, 87654321);
        assertEquals(12345678, asset.getCreated());
        assertEquals(87654321, asset.getModified());
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
     * Tests up axis.
     */

    @Test
    public void testUpAxis()
    {
        final Asset asset = new Asset();
        assertSame(asset, asset.setUpAxis(UpAxis.X_UP));
        assertEquals(UpAxis.X_UP, asset.getUpAxis());
    }
}
