/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model.support;

import java.util.ArrayList;
import java.util.Collection;

import de.ailis.collada.model.Document;


/**
 * An array list containing document aware elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 * @param <T>
 *            The array element type
 */

public class DocumentArrayList<T extends DocumentAware> extends ArrayList<T>
    implements DocumentList<T>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The document. */
    private Document document;


    /**
     * Constructs a new document array list without an initial document.
     */

    public DocumentArrayList()
    {
        this(null);
    }


    /**
     * Constructs a new document array list with the specified initial document.
     *
     * @param document
     *            The document. May be empty to start without an initial
     *            document
     */

    public DocumentArrayList(final Document document)
    {
        super();
        this.document = document;
    }


    /**
     * @see java.util.ArrayList#set(int, java.lang.Object)
     */

    @Override
    public T set(final int index, final T element)
    {
        final T oldElement = get(index);
        oldElement.setDocument(null);
        super.set(index, element);
        element.setDocument(this.document);
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
    }


    /**
     * @see java.util.ArrayList#remove(int)
     */

    @Override
    public T remove(final int index)
    {
        final T element = super.remove(index);
        element.setDocument(null);
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
            ((DocumentAware) element).setDocument(this.document);
        return result;
    }


    /**
     * @see java.util.ArrayList#clear()
     */

    @Override
    public void clear()
    {
        for (final T element : this)
            element.setDocument(null);
        super.clear();
    }


    /**
     * @see java.util.ArrayList#addAll(java.util.Collection)
     */

    @Override
    public boolean addAll(final Collection<? extends T> elements)
    {
        for (final DocumentAware element : elements)
            element.setDocument(this.document);
        return super.addAll(elements);
    }


    /**
     * @see java.util.ArrayList#addAll(int, java.util.Collection)
     */

    @Override
    public boolean addAll(final int index,
        final Collection<? extends T> elements)
    {
        for (final DocumentAware element : elements)
            element.setDocument(this.document);
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
                if (element instanceof DocumentAware && contains(element))
                    ((DocumentAware) element).setDocument(null);
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
                if (element instanceof DocumentAware && !contains(element))
                    ((DocumentAware) element).setDocument(null);
        return result;
    }


    /**
     * @see DocumentList#getDocument()
     */

    @Override
    public Document getDocument()
    {
        return this.document;
    }


    /**
     * @see DocumentList#setDocument(Document)
     */

    @Override
    public void setDocument(final Document document)
    {
        this.document = document;
        for (final T element : this)
            element.setDocument(document);
    }
}
