/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import de.ailis.jollada.model.Asset;
import de.ailis.jollada.model.Node;
import de.ailis.jollada.model.NodeType;


/**
 * Tests the Node class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class NodeTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testDefaultConstructor()
    {
        final Node node = new Node();
        assertNull(node.getId());
        assertNull(node.getAsset());
        assertNull(node.getName());
        assertNull(node.getSid());
        assertEquals(NodeType.NODE, node.getType());
        assertEquals(0, node.getLayers().size());
        assertEquals(0, node.getCameraInstances().size());
        assertEquals(0, node.getGeometryInstances().size());
        assertEquals(0, node.getLightInstances().size());
        assertEquals(0, node.getTransformations().size());
    }


    /**
     * Tests the ID.
     */

    @Test
    public void testId()
    {
        final Node node = new Node();
        assertNull(node.getId());
        node.setId("foo");
        assertEquals("foo", node.getId());
        node.setId(null);
        assertNull(node.getId());
    }


    /**
     * Tests the SID.
     */

    @Test
    public void testSid()
    {
        final Node node = new Node();
        assertNull(node.getId());
        node.setSid("foo");
        assertEquals("foo", node.getSid());
        node.setId(null);
        assertNull(node.getId());
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final Node node = new Node();
        assertNull(node.getName());
        node.setName("foo");
        assertEquals("foo", node.getName());
        node.setName(null);
        assertNull(node.getName());
    }


    /**
     * Tests the asset.
     */

    @Test
    public void testAsset()
    {
        final Node node = new Node();
        assertNull(node.getAsset());
        node.setAsset(new Asset());
        assertNotNull(node.getAsset());
        node.setAsset(null);
        assertNull(node.getAsset());
    }


    /**
     * Tests the type.
     */

    @Test
    public void testType()
    {
        final Node node = new Node();
        node.setType(NodeType.JOINT);
        assertEquals(NodeType.JOINT, node.getType());
    }


    /**
     * Tests the setType() method with a null parameter.
     */

    @Test(expected=IllegalArgumentException.class)
    public void testNullType()
    {
        new Node().setType(null);
    }
}
