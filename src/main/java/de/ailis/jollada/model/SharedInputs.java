/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * List of shared inputs.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class SharedInputs extends Elements<SharedInput>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    SharedInputs(final Element parent)
    {
        super(parent);
    }



    /**
     * Returns the input with the specified semantic.
     *
     * @param semantic
     *            The semantic.
     * @return The input with the specified semantic. Null if not found.
     */

    public SharedInput getBySemantic(final String semantic)
    {
        for (final SharedInput input : this)
            if (input.getSemantic().equals(semantic)) return input;
        return null;
    }
}
