/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;


/**
 * Tests the VisualScene class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class VisualSceneTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testDefaultConstructor()
    {
        final VisualScene scene = new VisualScene();
        assertNull(scene.getId());
        assertNull(scene.getAsset());
        assertNull(scene.getName());
        assertEquals(0, scene.getNodes().size());
    }


    /**
     * Tests the ID.
     */

    @Test
    public void testId()
    {
        final VisualScene scene = new VisualScene();
        assertNull(scene.getId());
        scene.setId("foo");
        assertEquals("foo", scene.getId());
        scene.setId(null);
        assertNull(scene.getId());
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final VisualScene scene = new VisualScene();
        assertNull(scene.getName());
        scene.setName("foo");
        assertEquals("foo", scene.getName());
        scene.setName(null);
        assertNull(scene.getName());
    }


    /**
     * Tests the asset.
     */

    @Test
    public void testAsset()
    {
        final VisualScene scene = new VisualScene();
        assertNull(scene.getAsset());
        scene.setAsset(new Asset());
        assertNotNull(scene.getAsset());
        scene.setAsset(null);
        assertNull(scene.getAsset());
    }
}
