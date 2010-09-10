/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.exceptions;


/**
 * Base class for all Jollada exceptions.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class JolladaException extends RuntimeException
{
    /** Serial version UID */
    private static final long serialVersionUID = 1;


    /**
     * Constructor
     */

    public JolladaException()
    {
        super();
    }

    /**
     * Constructor
     *
     * @param detailMessage
     *            The detailed error message
     * @param throwable
     *            The forwarded exception
     */

    public JolladaException(final String detailMessage, final Throwable throwable)
    {
        super(detailMessage, throwable);
    }


    /**
     * Constructor
     *
     * @param detailMessage
     *            The detailed error message
     */

    public JolladaException(final String detailMessage)
    {
        super(detailMessage);
    }
}
