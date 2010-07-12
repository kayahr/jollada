/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.ailis.collada.events.ElementAdapter;
import de.ailis.collada.events.ElementListener;


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
     * This element listener removes elements from the elements list when it was
     * removed from its parent.
     */
    private final ElementListener elementListener = new ElementAdapter()
    {
        private static final long serialVersionUID = 1L;

        @Override
        public void elementRemoved(final Element element)
        {
            removeOnly(element);
        }
    };


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
        oldElement.removeElementListener(this.elementListener);
        this.parent.removeChild(oldElement);
        super.set(index, element);
        this.parent.addChild(element);
        element.addElementListener(this.elementListener);
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
        element.addElementListener(this.elementListener);
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
        element.addElementListener(this.elementListener);
    }


    /**
     * @see java.util.ArrayList#remove(int)
     */

    @Override
    public T remove(final int index)
    {
        final T element = super.remove(index);
        element.removeElementListener(this.elementListener);
        this.parent.removeChild(element);
        return element;
    }


    /**
     * Removes the specified element only from this elements list (Not from the
     * parent). This is used internally when a removed event is received for an
     * element.
     *
     * @param element
     *            The element to remove
     */

    void removeOnly(final Element element)
    {
        super.remove(element);
        element.removeElementListener(this.elementListener);
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
            e.removeElementListener(this.elementListener);
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
            element.removeElementListener(this.elementListener);
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
        for (final Element element : elements.toArray(new Element[elements
            .size()]))
        {
            this.parent.addChild(element);
            element.addElementListener(this.elementListener);
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
        for (final Element element : elements.toArray(new Element[elements
                                                                  .size()]))
        {
            this.parent.addChild(element);
            element.addElementListener(this.elementListener);
        }
        return super.addAll(index, elements);
    }


    /**
     * @see java.util.ArrayList#removeAll(java.util.Collection)
     */

    @Override
    public boolean removeAll(final Collection<?> elements)
    {
        boolean modified = false;
        final Iterator<?> e = iterator();
        while (e.hasNext())
        {
            if (elements.contains(e.next()))
            {
                e.remove();
                modified = true;
            }
        }
        return modified;
    }


    /**
     * @see java.util.ArrayList#retainAll(java.util.Collection)
     */

    @Override
    public boolean retainAll(final Collection<?> elements)
    {
        boolean modified = false;
        final Iterator<?> e = iterator();
        while (e.hasNext())
        {
            if (!elements.contains(e.next()))
            {
                e.remove();
                modified = true;
            }
        }
        return modified;
    }
}
