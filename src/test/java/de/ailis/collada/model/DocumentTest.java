/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;


/**
 * Tests the Document class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class DocumentTest
{

    /**
     * Tests the getById method.
     */

    @Test
    public void testGetById()
    {
        final Document document = new Document();
        final Elements<VisualSceneLibrary> libs = document.getVisualSceneLibraries();
        final VisualSceneLibrary lib1 = new VisualSceneLibrary();
        lib1.setId("lib1");
        final VisualSceneLibrary lib2 = new VisualSceneLibrary();
        lib2.setId("lib2");

        libs.add(lib1);
        libs.add(lib2);
        assertNull(document.getById("lib3"));
        assertSame(lib1, document.getById("lib1"));
        assertSame(lib2, document.getById("lib2"));

        libs.remove(lib1);
        assertNull(document.getById("lib3"));
        assertNull(document.getById("lib1"));
        assertSame(lib2, document.getById("lib2"));

        lib2.setId("lib2new");
        assertNull(document.getById("lib2"));
        assertNull(document.getById("lib1"));
        assertSame(lib2, document.getById("lib2new"));

        final VisualScene scene = new VisualScene();
        final VisualScenes scenes = lib2.getVisualScenes();
        scenes.add(scene);
        scene.setId("scene");
        assertSame(scene, document.getById("scene"));
        scene.setId("newscene");
        assertNull(document.getById("scene"));
        assertSame(scene, document.getById("newscene"));

        final Node node1 = new Node();
        node1.setId("node1");

        final Node node2 = new Node();
        node2.setId("node2");

        node1.getNodes().add(node2);
        scene.getNodes().add(node1);

        assertSame(node1, document.getById("node1"));
        assertSame(node2, document.getById("node2"));

        libs.remove(lib2);
        assertNull(document.getById("scenenew"));
        assertNull(document.getById("node1"));
        assertNull(document.getById("node2"));
    }
}
