/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Base class for instance lists.
 *
 * @author Klaus Reimer (k@ailis.de)
 * @param <T>
 *            The instance type
 */

public abstract class Instances<T extends Instance> extends Elements<T>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    Instances(final Element parent)
    {
        super(parent);
    }

}
