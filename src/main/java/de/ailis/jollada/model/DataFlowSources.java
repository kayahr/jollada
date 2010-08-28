/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * List of data flow sources.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class DataFlowSources extends Elements<DataFlowSource>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    DataFlowSources(final Element parent)
    {
        super(parent);
    }
}
