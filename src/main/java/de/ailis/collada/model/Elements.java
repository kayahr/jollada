/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.util.ArrayList;
import java.util.Collection;


/**
 * An array list containing parent aware elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 * @param <T>
 *            The array element type
 */

public class Elements<T extends Element> extends ArrayList<T>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The parent element to use for all list items. */
    private final Element parent;


    /**
     * Constructs a new element list with the specified parent element to be
     * used by all list items.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    Elements(final Element parent)
    {
        super();
        if (parent == null)
            throw new IllegalArgumentException("parent must not be null");
        this.parent = parent;
    }


    /**
     * @see java.util.ArrayList#set(int, java.lang.Object)
     */

    @Override
    public T set(final int index, final T element)
    {
        final T oldElement = get(index);
        this.parent.removeChild(oldElement);
        super.set(index, element);
        this.parent.addChild(element);
        return oldElement;
    }


    /**
     * @see java.util.ArrayList#add(java.lang.Object)
     */

    @Override
    public boolean add(final T element)
    {
        final boolean result = super.add(element);
        this.parent.addChild(element);
        return result;
    }


    /**
     * @see java.util.ArrayList#add(int, java.lang.Object)
     */

    @Override
    public void add(final int index, final T element)
    {
        super.add(index, element);
        this.parent.addChild(element);
    }


    /**
     * @see java.util.ArrayList#remove(int)
     */

    @Override
    public T remove(final int index)
    {
        final T element = super.remove(index);
        this.parent.removeChild(element);
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
            this.parent.removeChild(e);
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
            this.parent.removeChild(element);
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
            this.parent.addChild(element);
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
            this.parent.addChild(element);
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
                    this.parent.removeChild(e);
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
                    this.parent.removeChild(e);
                }
        return result;
    }
}
