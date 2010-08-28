/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Array with SIDREF elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class SidRefArray extends StringArray
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param count
     *            The data size.
     */

    public SidRefArray(final int count)
    {
        super(count);
    }
}
