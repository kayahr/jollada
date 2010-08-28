/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import de.ailis.jollada.model.Accessor;
import de.ailis.jollada.model.Array;
import de.ailis.jollada.model.Asset;
import de.ailis.jollada.model.CommonSourceTechnique;
import de.ailis.jollada.model.DataFlowSource;
import de.ailis.jollada.model.IntArray;


/**
 * Tests the DataFlowSource class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class DataFlowSourceTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testConstructor()
    {
        final DataFlowSource source = new DataFlowSource("ID");
        assertEquals("ID", source.getId());
        assertNull(source.getAsset());
        assertNull(source.getCommonTechnique());
        assertNull(source.getName());
        assertNull(source.getArray());
    }


    /**
     * Tests the constructor with null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new DataFlowSource(null).toString();
    }


    /**
     * Tests the ID.
     */

    @Test
    public void testId()
    {
        final DataFlowSource param = new DataFlowSource("ID");
        param.setId("foo");
        assertEquals("foo", param.getId());
    }


    /**
     * Tests the setId() method with null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testSetIdWithNull()
    {
        final DataFlowSource source = new DataFlowSource("ID");
        source.setId(null);
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final DataFlowSource source = new DataFlowSource("ID");
        assertNull(source.getName());
        source.setName("foo");
        assertEquals("foo", source.getName());
        source.setName(null);
        assertNull(source.getName());
    }


    /**
     * Tests the asset.
     */

    @Test
    public void testAsset()
    {
        final DataFlowSource source = new DataFlowSource("ID");
        assertNull(source.getAsset());
        source.setAsset(new Asset());
        assertNotNull(source.getAsset());
        source.setAsset(null);
        assertNull(source.getAsset());
    }


    /**
     * Tests the asset.
     */

    @Test
    public void testArray()
    {
        final DataFlowSource source = new DataFlowSource("ID");
        source.setArray(null);
        assertNull(source.getArray());
        final Array array = new IntArray(16);
        source.setArray(array);
        assertSame(array, source.getArray());
        source.setArray(null);
        assertNull(source.getArray());
    }


    /**
     * Tests the common source technique.
     *
     * @throws URISyntaxException
     *             When URI is invalid
     */

    @Test
    public void testCommonSourceTechnique() throws URISyntaxException
    {
        final DataFlowSource source = new DataFlowSource("ID");
        source.setCommonTechnique(null);
        assertNull(source.getCommonTechnique());
        final CommonSourceTechnique technique = new CommonSourceTechnique(
            new Accessor(new URI("SOURCE"), 0));
        source.setCommonTechnique(technique);
        assertSame(technique, source.getCommonTechnique());
        source.setCommonTechnique(null);
        assertNull(source.getCommonTechnique());
    }
}
