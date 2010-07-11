/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.ailis.collada.events.ElementListener;


/**
 * Abstract base class for all COLLADA elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Element implements Serializable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The document this element is connected to. */
    private Document document;

    /** The parent element. */
    private Element parent;

    /** The child elements */
    private final List<Element> children = new ArrayList<Element>();

    /** The element id (Only used by identifiables) */
    protected String id;

    /** The list of element listeners */
    private List<ElementListener> elementListeners;


    /**
     * Constructor
     */

    protected Element()
    {
        // Empty;
    }


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    protected Element(final Element parent)
    {
        if (parent == null)
            throw new IllegalArgumentException("parent must not be null");
        parent.addChild(this);
    }


    /**
     * Adds the specified element to the child list of this element.
     *
     * @param element
     *            The element to add. Must not be null.
     */

    void addChild(final Element element)
    {
        if (element.parent == this)
            throw new IllegalStateException(
                "Element is already a child of this element");

        // Remove the element from its current parent
        if (element.parent != null) element.parent.removeChild(element);

        // Set the elements parent
        element.setParent(this);

        // Add element to child list
        this.children.add(element);
    }


    /**
     * Removes the specified element from the child list of this element.
     *
     * @param element
     *            The element to remove. Must not be null
     */

    void removeChild(final Element element)
    {
        if (element.parent != this)
            throw new IllegalStateException(
                "Element is not a child of this element");

        // Remove element from child list
        this.children.remove(element);

        // Unset the parent
        element.setParent(null);
    }


    /**
     * Sets the parent element and updates the document reference.
     *
     * @param parent
     *            The parent element to set. Null to unset.
     */

    private void setParent(final Element parent)
    {
        if (parent != this.parent)
        {
            if (this.parent != null) fireElementRemoved();
            this.parent = parent;
            setDocument(parent == null ? null : parent.document);
            if (parent != null) fireElementInserted();
        }
    }


    /**
     * Returns the parent element.
     *
     * @return The parent element. May be null if not connected to a parent.
     */

    public Element getParent()
    {
        return this.parent;
    }


    /**
     * Sets the document. Do not call this yourself. It is done automatically.
     *
     * @param document
     *            The document to set. Null to unset.
     */

    void setDocument(final Document document)
    {
        if (document != this.document)
        {
            if (this.document != null)
            {
                fireElementRemovedFromDocument();
                this.document.unregister(this);
            }
            this.document = document;
            for (final Element child : this.children)
                child.setDocument(document);
            if (document != null)
            {
                document.register(this);
                fireElementInsertedIntoDocument();
            }
        }
    }


    /**
     * Returns the document.
     *
     * @return The document. May be null if not set.
     */

    public Document getDocument()
    {
        return this.document;
    }


    /**
     * Sets the ID.
     *
     * @param id
     *            The ID to set. Null to unset.
     * @return This element for chaining.
     */

    protected Element setId(final String id)
    {
        if ((id == null && this.id != null)
            || (id != null && !id.equals(this.id)))
        {
            if (this.document != null) this.document.unregister(this);
            this.id = id;
            if (this.document != null) this.document.register(this);
        }
        return this;
    }


    /**
     * Returns the element id.
     *
     * @return The element id
     */

    String getId()
    {
        return this.id;
    }


    /**
     * Searches for the element with the specified scope ID in this scope and
     * returns it.
     *
     * @param sid
     *            The scope ID of the element to search.
     * @return The found element. Null if not found.
     */

    public Element getBySid(final String sid)
    {
        // Try to find element directly in the child list
        for (final Element child : this.children)
        {
            if (child instanceof ScopeIdentifiable &&
                sid.equals(((ScopeIdentifiable) child).getSid()))
                return child;
        }

        // If not found in the child list then ask each child instead
        for (final Element child : this.children)
        {
            final Element element = child.getBySid(sid);
            if (element != null) return element;
        }

        // Nothing found.
        return null;
    }


    /**
     * Adds the specified element listener.
     *
     * @param listener
     *            The lsitener to add. Must not be null.
     */

    public void addElementListener(final ElementListener listener)
    {
        if (listener == null)
            throw new IllegalArgumentException("listener must not be null");
        if (this.elementListeners == null)
            this.elementListeners = new ArrayList<ElementListener>();
        this.elementListeners.add(listener);
    }


    /**
     * Removes the specified element listener.
     *
     * @param listener
     *            The listener to remove. Must not be null.
     */

    public void removeElementListener(final ElementListener listener)
    {
        if (listener == null)
            throw new IllegalArgumentException("listener must not be null");
        if (this.elementListeners == null) return;
        this.elementListeners.remove(listener);
    }


    /**
     * Fires the elementInserted event.
     */

    private void fireElementInserted()
    {
        if (this.elementListeners == null) return;
        for (final ElementListener listener : this.elementListeners)
            listener.elementInserted();
    }


    /**
     * Fires the elementRemoved event.
     */

    private void fireElementRemoved()
    {
        if (this.elementListeners == null) return;
        for (final ElementListener listener : this.elementListeners)
            listener.elementRemoved();
    }


    /**
     * Fires the elementRemovedFromDocument event.
     */

    private void fireElementRemovedFromDocument()
    {
        if (this.elementListeners == null) return;
        for (final ElementListener listener : this.elementListeners)
            listener.elementRemovedFromDocument();
    }


    /**
     * Fires the elementInsertedIntoDocument event.
     */

    private void fireElementInsertedIntoDocument()
    {
        if (this.elementListeners == null) return;
        for (final ElementListener listener : this.elementListeners)
            listener.elementInsertedIntoDocument();
    }
}
