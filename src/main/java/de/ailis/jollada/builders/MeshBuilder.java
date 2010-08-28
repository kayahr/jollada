/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import java.util.ArrayList;
import java.util.List;

import de.ailis.jollada.model.DataFlowSource;
import de.ailis.jollada.model.Mesh;
import de.ailis.jollada.model.Primitives;
import de.ailis.jollada.model.Vertices;


/**
 * Builder for meshes.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class MeshBuilder
{
    /** The vertices. */
    private Vertices vertices;

    /** The list of primitives. */
    private final List<Primitives> primitives = new ArrayList<Primitives>();

    /** The list of sources. */
    private final List<DataFlowSource> sources = new ArrayList<DataFlowSource>();


    /**
     * Builds the geometric.
     *
     * @return The geometric. Never null.
     */

    public Mesh build()
    {
        if (this.vertices == null)
            throw new IllegalStateException("vertices not set");
        final Mesh mesh = new Mesh(this.vertices);
        mesh.getPrimitives().addAll(this.primitives);
        mesh.getSources().addAll(this.sources);
        return mesh;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.vertices = null;
        this.primitives.clear();
        this.sources.clear();
    }


    /**
     * Returns the next vertices.
     *
     * @return The next vertices. May be null if unset.
     */

    public Vertices getVertices()
    {
        return this.vertices;
    }


    /**
     * Sets the next vertices.
     *
     * @param vertices
     *            The next vertices to set. Null to unset.
     */

    public void setVertices(final Vertices vertices)
    {
        this.vertices = vertices;
    }


    /**
     * Returns the list of sources.
     *
     * @return The list of sources. Never null. May be empty.
     */

    public List<DataFlowSource> getSources()
    {
        return this.sources;
    }


    /**
     * Returns the list of primitives.
     *
     * @return The list of primitives. Never null. May be empty.
     */

    public List<Primitives> getPrimitives()
    {
        return this.primitives;
    }
}
