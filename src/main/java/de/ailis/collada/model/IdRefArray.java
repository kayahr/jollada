/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Array with IDREF elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class IdRefArray extends StringArray
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param count
     *            The data size.
     */

    public IdRefArray(final int count)
    {
        super(count);
    }
}
