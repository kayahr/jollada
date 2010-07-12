/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.ailis.collada.events.ElementAdapter;


/**
 * Tests the Element class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ElementTest
{
    /**
     * Tests the default constructor
     */

    @Test
    public void testDefaultConstructor()
    {
        final Node node = new Node();
        assertNull(node.getDocument());
        assertNull(node.getParent());
        assertNull(node.id);
    }


    /**
     * Tests the constructor with parent element.
     */

    @Test
    public void testConstructorWithParent()
    {
        final Node node = new Node();
        final MaterialBinding binding = new MaterialBinding(node);
        assertNull(binding.getDocument());
        assertSame(node, binding.getParent());
        assertNull(binding.id);
    }


    /**
     * Tests the constructor with parent element set to null.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullParent()
    {
        new MaterialBinding(null).toString();
    }


    /**
     * Tests the addChild method.
     */

    @Test
    public void testAddChild()
    {
        final Document oldDocument = new Document();
        final Document document = new Document();
        final Node oldParent = new Node();
        oldParent.setDocument(oldDocument);
        final Node parent = new Node();
        parent.setDocument(document);
        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");

        // Add child to old parent
        oldParent.addChild(child);
        assertSame(child, oldParent.getBySid("SID"));
        assertNull(parent.getBySid("SID"));
        assertSame(oldDocument, child.getDocument());
        assertSame(oldParent, child.getParent());

        // Add child to new parent
        parent.addChild(child);
        assertNull(oldParent.getBySid("SID"));
        assertSame(child, parent.getBySid("SID"));
        assertSame(document, child.getDocument());
        assertSame(parent, child.getParent());
    }


    /**
     * Tests the addChild method with element which is already a child.
     */

    @Test(expected = IllegalStateException.class)
    public void testAddChildAlreadyExists()
    {
        final Node parent = new Node();
        final Node child = new Node();
        parent.addChild(child);
        parent.addChild(child);
    }

    /**
     * Tests the addChild method.
     */

    @Test
    public void testRemoveChild()
    {
        final Node parent = new Node();
        final Node child = new Node();
        child.setId("ID");
        child.setSid("SID");

        // Add child to parent
        parent.addChild(child);
        assertSame(child, parent.getBySid("SID"));

        // Remove child from parent
        parent.removeChild(child);
        assertNull(parent.getBySid("SID"));
    }


    /**
     * Tests the removeChild method with element which is not a child.
     */

    @Test(expected = IllegalStateException.class)
    public void testAddChildNotExists()
    {
        final Node parent = new Node();
        final Node child = new Node();
        parent.removeChild(child);
    }


    /**
     * Tests the setId() method.
     */

    @Test
    public void testSetId()
    {
        final Document document = new Document();
        final Node node = new Node();
        node.setDocument(document);

        assertNull(document.getById("ID"));

        node.setId("ID");
        assertSame(node, document.getById("ID"));
        node.setId("ID");
        assertSame(node, document.getById("ID"));

        node.setId(null);
        assertNull(document.getById("ID"));
        node.setId(null);
        assertNull(document.getById("ID"));
    }


    /**
     * Tests the addElementListener() method with a null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testAddElementListener()
    {
        new Node().addElementListener(null);
    }


    /**
     * Tests the removeElementListener() method with a null argument.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveElementListener()
    {
        new Node().removeElementListener(null);
    }


    /**
     * Tests removing a element listener from a node which has no listeners.
     */

    @Test
    public void testRemoveElementListenerNotExists()
    {
        new Node().removeElementListener(new ElementAdapter()
        {
            private static final long serialVersionUID = 1L;
        });
    }


    /**
     * Tests the element events.
     */

    @Test
    public void testElementEvents()
    {
        final Node node = new Node();

        class TestAdapter extends ElementAdapter
        {
            private static final long serialVersionUID = -6339447807055123781L;

            public boolean removedFromDoc = false;

            public boolean insertedIntoDoc = false;

            public boolean inserted = false;

            public boolean removed = false;

            @Override
            public void elementRemovedFromDocument(final Element element)
            {
                this.removedFromDoc = true;
            }

            @Override
            public void elementRemoved(final Element element)
            {
                this.removed = true;
            }

            @Override
            public void elementInsertedIntoDocument(final Element element)
            {
                this.insertedIntoDoc = true;
            }

            @Override
            public void elementInserted(final Element element)
            {
                this.inserted = true;
            }

            public void reset()
            {
                this.removed = false;
                this.inserted = false;
                this.removedFromDoc = false;
                this.insertedIntoDoc = false;
            }
        }
        final TestAdapter adapter = new TestAdapter();
        node.addElementListener(adapter);
        assertFalse(adapter.inserted);
        assertFalse(adapter.insertedIntoDoc);
        assertFalse(adapter.removed);
        assertFalse(adapter.removedFromDoc);

        final Document doc = new Document();
        final Node parent1 = new Node();
        doc.addChild(parent1);
        final Node parent2 = new Node();
        doc.addChild(parent2);

        parent1.addChild(node);
        assertTrue(adapter.inserted);
        assertTrue(adapter.insertedIntoDoc);
        assertFalse(adapter.removed);
        assertFalse(adapter.removedFromDoc);
        adapter.reset();

        parent2.addChild(node);
        assertTrue(adapter.inserted);
        assertFalse(adapter.insertedIntoDoc);
        assertTrue(adapter.removed);
        assertFalse(adapter.removedFromDoc);
        adapter.reset();

        parent2.removeChild(node);
        assertFalse(adapter.inserted);
        assertFalse(adapter.insertedIntoDoc);
        assertTrue(adapter.removed);
        assertTrue(adapter.removedFromDoc);
    }


    /**
     * Tests the getBySid() method.
     */

    @Test
    public void testGetBySid()
    {
        final Node root = new Node();
        final Node node1a = new Node();
        final Node node1b = new Node();
        final Node node2a = new Node();
        final Node node2b = new Node();
        node2b.setSid("foo");
        final Node node3a = new Node();
        node3a.setSid("foo");
        final Node node3b = new Node();

        root.addChild(node1a);
        root.addChild(node1b);
        node1a.addChild(node2a);
        node1b.addChild(node2b);
        node2a.addChild(node3a);
        node2b.addChild(node3b);

        assertSame(node2b, root.getBySid("foo"));
    }
}
