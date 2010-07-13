/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * The vertices.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Vertices extends Element implements Identifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The name. */
    private String name;

    /** The inputs. */
    private final UnsharedInputs inputs = new UnsharedInputs(this);


    /**
     * Constructor.
     *
     * @param id
     *            The ID. Must not be null.
     */

    public Vertices(final String id)
    {
        setId(id);
    }


    /**
     * @see de.ailis.collada.model.Identifiable#getId()
     */

    @Override
    public String getId()
    {
        return this.id;
    }


    /**
     * @see de.ailis.collada.model.Identifiable#setId(java.lang.String)
     */

    @Override
    public void setId(final String id)
    {
        if (id == null)
            throw new IllegalArgumentException("id must not be null");
        updateId(id);
    }


    /**
     * Returns the inputs.
     *
     * @return The inputs. Never null. May be empty.
     */

    public UnsharedInputs getInputs()
    {
        return this.inputs;
    }


    /**
     * Sets the node name.
     *
     * @param name
     *            The node name to set. Null to unset.
     */

    public void setName(final String name)
    {
        this.name = name;
    }


    /**
     * Returns the node name.
     *
     * @return The node name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }
}
