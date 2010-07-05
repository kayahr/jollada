/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.util.HashMap;
import java.util.Map;


/**
 * Abstract class for COLLADA scope elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Scope extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The SID-to-Element mapping. */
    private final Map<String, Element> sidMap = new HashMap<String, Element>();


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
        return this.sidMap.get(sid);
    }


    /**
     * Registers the specified element so it can be found in this scope.
     *
     * @param element
     *            The element to register. Must not be null.
     */

    void register(final Element element)
    {
        if (element == null)
            throw new IllegalArgumentException("element must not be null");

        final String sid = element.getSid();
        if (sid != null) if (this.sidMap.put(sid, element) != null)
            throw new InternalError(
                "Element with sid '" + sid + "' already registered");
    }


    /**
     * Unregisters the specified element from this scope.
     *
     * @param element
     *            The element to unregister. Must not be null.
     */

    void unregister(final Element element)
    {
        if (element == null)
            throw new IllegalArgumentException("element must not be null");

        final String sid = element.getSid();
        if (sid != null) if (this.sidMap.remove(sid) == null)
            throw new InternalError(
                "Element with sid '" + sid + "' not registered");
    }
}
