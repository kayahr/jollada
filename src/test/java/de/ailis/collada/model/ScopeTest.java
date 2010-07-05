/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;


/**
 * Tests the Scope class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ScopeTest
{
    /**
     * Tests the getBySid method.
     */

    @Test
    public void testGetBySid()
    {
        final VisualScene scene = new VisualScene();
        final Nodes nodes = scene.getNodes();

        final Node node1 = new Node();
        node1.setSid("node.1");
        nodes.add(node1);

        final Node node2 = new Node();
        node2.setSid("node.2");
        nodes.add(node2);

        final Node node21 = new Node();
        node21.setSid("node.2.1");
        node2.getNodes().add(node21);

        final Node node22 = new Node();
        node22.setSid("node.2.2");
        node2.getNodes().add(node22);

        assertNull(node1.getBySid("node.2.1"));
        assertNull(node1.getBySid("node.2.1"));
        assertSame(node21, node2.getBySid("node.2.1"));
        assertSame(node22, node2.getBySid("node.2.2"));

        node22.setSid("node.2.2b");
        assertNull(node21.getBySid("node.2.2"));
        assertSame(node22, node2.getBySid("node.2.2b"));

        node2.getNodes().remove(node22);
        assertNull(node21.getBySid("node.2.2b"));
    }
}
