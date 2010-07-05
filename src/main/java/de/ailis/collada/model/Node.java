/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Node
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class Node extends Scope implements ScopeIdentifiable, Identifiable
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The child nodes */
    private final Nodes nodes = new Nodes(this);


    /**
     * @see de.ailis.collada.model.ScopeIdentifiable#getSid()
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }


    /**
     * @see de.ailis.collada.model.ScopeIdentifiable#setSid(java.lang.String)
     */

    @Override
    public void setSid(final String sid)
    {
        super.setSid(sid);
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
        super.setId(id);
    }


    /**
     * Returns the child nodes.
     *
     * @return The child nodes. Never null. May be empty.
     */

    public Nodes getNodes()
    {
        return this.nodes;
    }



    /**
     * @see de.ailis.collada.model.Element#setDocument(de.ailis.collada.model.Document)
     */

    @Override
    void setDocument(final Document document)
    {
        super.setDocument(document);
        this.nodes.setDocument(document);
    }
}
