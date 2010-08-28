/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ailis.jollada.model.NodeType;


/**
 * Tests the NodeType class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class NodeTypeTest
{
    /**
     * Tests the valueOf method.
     */

    @Test
    public void testValueOf()
    {
        assertEquals(NodeType.NODE, NodeType.valueOf("NODE"));
        assertEquals(NodeType.JOINT, NodeType.valueOf("JOINT"));
    }
}
