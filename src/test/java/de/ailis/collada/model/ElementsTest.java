/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * Tests the Elements class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ElementsTest
{
    /**
     * Tests the default constructor
     */

    @Test
    public void testConstructor()
    {
        final Node parent = new Node();
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node node = new Node();
        elements.add(node);
        assertSame(parent, node.getParent());
    }


    /**
     * Tests the default constructor with null parent
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new Elements<Node>(null);
    }


    /**
     * Tests adding a element.
     */

    @Test
    public void testAdd()
    {
        final Document oldDocument = new Document();
        final Node oldParent = new Node();
        oldDocument.addChild(oldParent);
        final Elements<Node> oldElements = new Elements<Node>(oldParent);

        final Document document = new Document();

        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");
        oldElements.add(child);

        elements.add(child);
        assertSame(document, child.getDocument());
        assertSame(parent, child.getParent());
        assertSame(child, document.getById("ID"));
        assertSame(child, document.getBySid("SID"));
        assertSame(child, parent.getBySid("SID"));

        // Check if node was correctly detached from old elements
        assertEquals(0, oldElements.size());
        assertNull(oldDocument.getById("ID"));
        assertNull(oldDocument.getBySid("SID"));
        assertNull(oldParent.getBySid("SID"));
    }


    /**
     * Tests inserting a element.
     */

    @Test
    public void testInsert()
    {
        final Document oldDocument = new Document();
        final Node oldParent = new Node();
        oldDocument.addChild(oldParent);
        final Elements<Node> oldElements = new Elements<Node>(oldParent);

        final Document document = new Document();

        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");
        oldElements.add(child);

        elements.add(0, child);
        assertSame(document, child.getDocument());
        assertSame(parent, child.getParent());
        assertSame(child, document.getById("ID"));
        assertSame(child, document.getBySid("SID"));
        assertSame(child, parent.getBySid("SID"));

        // Check if node was correctly detached from old elements
        assertEquals(0, oldElements.size());
        assertNull(oldDocument.getById("ID"));
        assertNull(oldDocument.getBySid("SID"));
        assertNull(oldParent.getBySid("SID"));
    }


    /**
     * Tests setting a element.
     */

    @Test
    public void testSet()
    {
        final Document oldDocument = new Document();
        final Node oldParent = new Node();
        oldDocument.addChild(oldParent);
        final Elements<Node> oldElements = new Elements<Node>(oldParent);

        final Document document = new Document();

        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");
        oldElements.add(child);

        elements.add(child);
        assertSame(child, elements.set(0, child));
        assertSame(document, child.getDocument());
        assertSame(parent, child.getParent());
        assertSame(child, document.getById("ID"));
        assertSame(child, document.getBySid("SID"));
        assertSame(child, parent.getBySid("SID"));

        // Check if node was correctly detached from old elements
        assertEquals(0, oldElements.size());
        assertNull(oldDocument.getById("ID"));
        assertNull(oldDocument.getBySid("SID"));
        assertNull(oldParent.getBySid("SID"));
    }


    /**
     * Tests removing a element.
     */

    @Test
    public void testRemove()
    {
        final Document oldDocument = new Document();
        final Node oldParent = new Node();
        oldDocument.addChild(oldParent);
        final Elements<Node> oldElements = new Elements<Node>(oldParent);

        final Document document = new Document();

        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");
        oldElements.add(child);

        elements.add(child);
        assertSame(document, child.getDocument());
        assertSame(parent, child.getParent());
        assertSame(child, document.getById("ID"));
        assertSame(child, document.getBySid("SID"));
        assertSame(child, parent.getBySid("SID"));

        assertTrue(elements.remove(child));

        // Check if node was correctly detached from elements
        assertEquals(0, elements.size());
        assertNull(child.getParent());
        assertNull(child.getDocument());
        assertNull(document.getById("ID"));
        assertNull(document.getBySid("SID"));
        assertNull(parent.getBySid("SID"));
    }


    /**
     * Tests removing a element by index.
     */

    @Test
    public void testRemoveByIndex()
    {
        final Document oldDocument = new Document();
        final Node oldParent = new Node();
        oldDocument.addChild(oldParent);
        final Elements<Node> oldElements = new Elements<Node>(oldParent);

        final Document document = new Document();

        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");
        oldElements.add(child);

        assertTrue(elements.add(child));
        assertSame(document, child.getDocument());
        assertSame(parent, child.getParent());
        assertSame(child, document.getById("ID"));
        assertSame(child, document.getBySid("SID"));
        assertSame(child, parent.getBySid("SID"));

        assertSame(child, elements.remove(0));

        // Check if node was correctly detached from elements
        assertEquals(0, elements.size());
        assertNull(child.getParent());
        assertNull(child.getDocument());
        assertNull(document.getById("ID"));
        assertNull(document.getBySid("SID"));
        assertNull(parent.getBySid("SID"));
    }


    /**
     * Tests removing a element which does not exist
     */

    @Test
    public void testRemoveNotExists()
    {
        final Node parent = new Node();
        final Elements<Node> elements = new Elements<Node>(parent);
        final Node child = new Node();

        assertFalse(elements.remove(child));
    }


    /**
     * Tests clear() method.
     */

    @Test
    public void testClear()
    {
        final Document document = new Document();
        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");

        elements.add(child);
        elements.clear();

        // Check if node was correctly detached from elements
        assertEquals(0, elements.size());
        assertNull(child.getParent());
        assertNull(child.getDocument());
        assertNull(document.getById("ID"));
        assertNull(document.getBySid("SID"));
        assertNull(parent.getBySid("SID"));
    }


    /**
     * Tests adding a list of elements.
     */

    @Test
    public void testAddAll()
    {
        final Document oldDocument = new Document();
        final Node oldParent = new Node();
        oldDocument.addChild(oldParent);
        final Elements<Node> oldElements = new Elements<Node>(oldParent);

        final Document document = new Document();

        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");
        oldElements.add(child);

        elements.addAll(oldElements);
        assertSame(document, child.getDocument());
        assertSame(parent, child.getParent());
        assertSame(child, document.getById("ID"));
        assertSame(child, document.getBySid("SID"));
        assertSame(child, parent.getBySid("SID"));

        // Check if node was correctly detached from old elements
        assertEquals(0, oldElements.size());
        assertNull(oldDocument.getById("ID"));
        assertNull(oldDocument.getBySid("SID"));
        assertNull(oldParent.getBySid("SID"));
    }


    /**
     * Tests adding a list of elements at specific index.
     */

    @Test
    public void testAddAllAtIndex()
    {
        final Document oldDocument = new Document();
        final Node oldParent = new Node();
        oldDocument.addChild(oldParent);
        final Elements<Node> oldElements = new Elements<Node>(oldParent);

        final Document document = new Document();

        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");
        oldElements.add(child);

        elements.addAll(0, oldElements);
        assertSame(document, child.getDocument());
        assertSame(parent, child.getParent());
        assertSame(child, document.getById("ID"));
        assertSame(child, document.getBySid("SID"));
        assertSame(child, parent.getBySid("SID"));

        // Check if node was correctly detached from old elements
        assertEquals(0, oldElements.size());
        assertNull(oldDocument.getById("ID"));
        assertNull(oldDocument.getBySid("SID"));
        assertNull(oldParent.getBySid("SID"));
    }


    /**
     * Tests removing a list of elements.
     */

    @Test
    public void testRemoveAll()
    {
        final Document document = new Document();
        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");

        elements.add(child);
        final List<Object> toDelete = new ArrayList<Object>();
        toDelete.add(new Node());
        toDelete.add("test");
        assertFalse(elements.removeAll(toDelete));
        assertSame(parent, child.getParent());
        toDelete.add(child);
        assertTrue(elements.removeAll(toDelete));

        // Check if node was correctly detached from elements
        assertEquals(0, elements.size());
        assertNull(child.getParent());
        assertNull(child.getDocument());
        assertNull(document.getById("ID"));
        assertNull(document.getBySid("SID"));
        assertNull(parent.getBySid("SID"));
    }


    /**
     * Tests retaining a list of elements.
     */

    @Test
    public void testRetainAll()
    {
        final Document document = new Document();
        final Node parent = new Node();
        document.addChild(parent);
        final Elements<Node> elements = new Elements<Node>(parent);

        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");

        elements.add(child);
        final List<Object> toRetain = new ArrayList<Object>();
        toRetain.add(child);
        toRetain.add(new Node());
        toRetain.add("test");
        assertFalse(elements.retainAll(toRetain));
        toRetain.remove(child);
        assertTrue(elements.retainAll(toRetain));

        // Check if node was correctly detached from elements
        assertEquals(0, elements.size());
        assertNull(child.getParent());
        assertNull(child.getDocument());
        assertNull(document.getById("ID"));
        assertNull(document.getBySid("SID"));
        assertNull(parent.getBySid("SID"));
    }
}
