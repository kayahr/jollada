/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * List of data flow parameters.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class DataFlowParams extends Elements<DataFlowParam>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    DataFlowParams(final Element parent)
    {
        super(parent);
    }
}
