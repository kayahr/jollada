/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A mesh.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Mesh extends Geometric
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The sources. */
    private final DataFlowSources sources = new DataFlowSources(this);

    /** The vertices. */
    private Vertices vertices;

    /** The list of primitives */
    private final PrimitiveElements primitives = new PrimitiveElements(this);


    /**
     * Constructor.
     *
     * @param vertices
     *            The vertices. Must not be null.
     */

    public Mesh(final Vertices vertices)
    {
        setVertices(vertices);
    }


    /**
     * Returns the list of sources.
     *
     * @return The list of sources. Never null. May be empty.
     */

    public DataFlowSources getSources()
    {
        return this.sources;
    }


    /**
     * Returns the vertices.
     *
     * @return The vertices. Never null.
     */

    public Vertices getVertices()
    {
        return this.vertices;
    }


    /**
     * Sets the vertices.
     *
     * @param vertices
     *            The vertices to set. Must not be null.
     */

    public void setVertices(final Vertices vertices)
    {
        if (vertices == null)
            throw new IllegalArgumentException("vertices must not be null");
        if (vertices != this.vertices)
        {
            if (this.vertices != null) removeChild(this.vertices);
            this.vertices = vertices;
            addChild(vertices);
        }
    }


    /**
     * Returns the primitive elements.
     *
     * @return The primitive elements. Never null. May be empty.
     */

    public PrimitiveElements getPrimitives()
    {
        return this.primitives;
    }
}
