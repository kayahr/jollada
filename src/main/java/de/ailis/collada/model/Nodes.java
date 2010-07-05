/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * List of nodes.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class Nodes extends Elements<Node>
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param scope
     *            The scope.
     */

    public Nodes(final Scope scope)
    {
        super(null, scope);
    }
}
