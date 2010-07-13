/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;


/**
 * Tests the Scene class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class SceneTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testDefaultConstructor()
    {
        final Scene scene = new Scene();
        assertNull(scene.getVisualSceneInstance());
    }


    /**
     * Tests the visual scene instance.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testVisualSceneInstance() throws URISyntaxException
    {
        final Scene scene = new Scene();
        final VisualSceneInstance instance = new VisualSceneInstance(
            new URI("foo"));
        assertNull(instance.getScene());
        scene.setVisualSceneInstance(instance);
        assertSame(scene, instance.getScene());
        assertSame(instance, scene.getVisualSceneInstance());
        assertNotNull(scene.getVisualSceneInstance());
        scene.setVisualSceneInstance(null);
        assertNull(scene.getVisualSceneInstance());
    }


    /**
     * Tests setting a visual scene instance which was already attached to a
     * different scene.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testAttachedVisualSceneInstance() throws URISyntaxException
    {
        final Scene oldScene = new Scene();
        final Scene scene = new Scene();
        final VisualSceneInstance instance = new VisualSceneInstance(
            new URI("foo"));
        oldScene.setVisualSceneInstance(instance);
        scene.setVisualSceneInstance(instance);
        assertNull(oldScene.getVisualSceneInstance());
        assertSame(scene, instance.getScene());
        assertSame(instance, scene.getVisualSceneInstance());
        assertNotNull(scene.getVisualSceneInstance());
        scene.setVisualSceneInstance(null);
        assertNull(scene.getVisualSceneInstance());

    }


    /**
     * Tests setting the same visual scene instance again.
     *
     * @throws URISyntaxException
     *             When URI is invalid.
     */

    @Test
    public void testSameVisualSceneInstance() throws URISyntaxException
    {
        final Scene scene = new Scene();
        final VisualSceneInstance instance = new VisualSceneInstance(new URI(
            "foo"));
        scene.setVisualSceneInstance(instance);
        assertSame(scene, instance.getScene());
        assertSame(instance, scene.getVisualSceneInstance());
        scene.setVisualSceneInstance(instance); // Set the same
        assertSame(scene, instance.getScene());
        assertSame(instance, scene.getVisualSceneInstance());
    }
}
