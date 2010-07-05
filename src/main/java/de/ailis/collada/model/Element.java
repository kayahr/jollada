/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.io.Serializable;


/**
 * Abstract base class for all COLLADA elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class Element implements Serializable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The document this element is connected to. */
    private Document document;

    /** The parent scope. */
    private Scope scope;

    /** The element id (Only used by identifiables) */
    protected String id;

    /** The element scope id (Only used by scope identifiables */
    protected String sid;


    /**
     * Sets the document.
     *
     * @param document
     *            The document to set. Null to unset.
     */

    void setDocument(final Document document)
    {
        if (document != this.document)
        {
            if (this.document != null) this.document.unregister(this);
            this.document = document;
            if (document != null) document.register(this);
        }
    }


    /**
     * Returns the document.
     *
     * @return The document. May be null if not set.
     */

    public Document getDocument()
    {
        return this.document;
    }


    /**
     * Sets the scope.
     *
     * @param scope
     *            The scope to set. Null to unset
     */

    void setScope(final Scope scope)
    {
        if (scope != this.scope)
        {
            if (this.scope != null) this.scope.unregister(this);
            this.scope = scope;
            if (scope != null) scope.register(this);
        }
    }


    /**
     * Returns the scope.
     *
     * @return The scope. May be null if not set.
     */

    public Scope getScope()
    {
        return this.scope;
    }


    /**
     * Sets the ID.
     *
     * @param id
     *            The ID to set. Null to unset.
     */

    protected void setId(final String id)
    {
        if (id != this.id)
        {
            if (this.document != null) this.document.unregister(this);
            this.id = id;
            if (this.document != null) this.document.register(this);
        }
    }


    /**
     * Returns the ID.
     *
     * @return The ID. Null if not set
     */

    String getId()
    {
        return this.id;
    }


    /**
     * Sets the scoped ID.
     *
     * @param sid
     *            The scoped ID to set. Null to unset.
     */

    protected void setSid(final String sid)
    {
        if (sid != this.sid)
        {
            if (this.scope != null) this.scope.unregister(this);
            this.sid = sid;
            if (this.scope != null) this.scope.register(this);
        }
    }


    /**
     * Returns the scoped ID.
     *
     * @return The scoped ID. Null if not set
     */

    String getSid()
    {
        return this.sid;
    }
}
