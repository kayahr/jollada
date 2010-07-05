/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.util.ArrayList;
import java.util.Collection;

import de.ailis.collada.model.support.DocumentAware;


/**
 * An array list containing document aware elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 * @param <T>
 *            The array element type
 */

public class Elements<T extends Element> extends ArrayList<T> implements
        DocumentAware
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The document. */
    private Document document;

    /** The scope */
    private Scope scope;


    /**
     * Constructs a new document array list without an initial document and
     * scope.
     */

    public Elements()
    {
        this(null, null);
    }


    /**
     * Constructs a new document array list with the specified initial document
     * and scope.
     *
     * @param document
     *            The document. May be null to start without an initial document
     * @param scope
     *            The scope. May be null to start without an initial scope
     */

    public Elements(final Document document, final Scope scope)
    {
        super();
        this.document = document;
        this.scope = scope;
    }


    /**
     * @see java.util.ArrayList#set(int, java.lang.Object)
     */

    @Override
    public T set(final int index, final T element)
    {
        final T oldElement = get(index);
        oldElement.setDocument(null);
        oldElement.setScope(null);
        super.set(index, element);
        element.setDocument(this.document);
        element.setScope(this.scope);
        return oldElement;
    }


    /**
     * @see java.util.ArrayList#add(java.lang.Object)
     */

    @Override
    public boolean add(final T element)
    {
        final boolean result = super.add(element);
        element.setDocument(this.document);
        element.setScope(this.scope);
        return result;
    }


    /**
     * @see java.util.ArrayList#add(int, java.lang.Object)
     */

    @Override
    public void add(final int index, final T element)
    {
        super.add(index, element);
        element.setDocument(this.document);
        element.setScope(this.scope);
    }


    /**
     * @see java.util.ArrayList#remove(int)
     */

    @Override
    public T remove(final int index)
    {
        final T element = super.remove(index);
        element.setDocument(null);
        element.setScope(null);
        return element;
    }


    /**
     * @see java.util.ArrayList#remove(java.lang.Object)
     */

    @Override
    public boolean remove(final Object element)
    {
        final boolean result = super.remove(element);
        if (result)
        {
            final Element e = (Element) element;
            e.setDocument(null);
            e.setScope(null);
        }
        return result;
    }


    /**
     * @see java.util.ArrayList#clear()
     */

    @Override
    public void clear()
    {
        for (final T element : this)
        {
            element.setDocument(null);
            element.setScope(null);
        }
        super.clear();
    }


    /**
     * @see java.util.ArrayList#addAll(java.util.Collection)
     */

    @Override
    public boolean addAll(final Collection<? extends T> elements)
    {
        for (final Element element : elements)
        {
            element.setDocument(this.document);
            element.setScope(this.scope);
        }
        return super.addAll(elements);
    }


    /**
     * @see java.util.ArrayList#addAll(int, java.util.Collection)
     */

    @Override
    public boolean addAll(final int index,
        final Collection<? extends T> elements)
    {
        for (final Element element : elements)
        {
            element.setDocument(this.document);
            element.setScope(this.scope);
        }
        return super.addAll(index, elements);
    }


    /**
     * @see java.util.ArrayList#removeAll(java.util.Collection)
     */

    @Override
    public boolean removeAll(final Collection<?> elements)
    {
        final boolean result = super.removeAll(elements);
        if (result)
            for (final Object element : elements)
                if (element instanceof Element && contains(element))
                {
                    final Element e = (Element) element;
                    e.setDocument(null);
                    e.setScope(null);
                }
        return result;
    }


    /**
     * @see java.util.ArrayList#retainAll(java.util.Collection)
     */

    @Override
    public boolean retainAll(final Collection<?> elements)
    {
        final boolean result = super.retainAll(elements);
        if (result)
            for (final Object element : elements)
                if (element instanceof Element && !contains(element))
                {
                    final Element e = (Element) element;
                    e.setDocument(null);
                    e.setScope(null);
                }
        return result;
    }


    /**
     * Sets the document of all current and all future elements.
     *
     * @param document
     *            The document to set. Null to unset.
     */

    public void setDocument(final Document document)
    {
        this.document = document;
        for (final T element : this)
            element.setDocument(document);
    }


    /**
     * Sets the scope of all current and all future elements.
     *
     * @param scope
     *            The scope to set. Null to unset.
     */

    public void setScope(final Scope scope)
    {
        this.scope = scope;
        for (final T element : this)
            element.setScope(scope);
    }
}
