/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * A new parameter in the common profile.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonNewParam extends Element implements ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The purpose of the parameter */
    private String semantic;

    /** The parameter */
    private Param parameter;

    /** The scope ID */
    private String sid;


    /**
     * Constructor.
     *
     * @param sid
     *            The scope ID. Must not be null.
     * @param parameter
     *            The parameter. Must not be null.
     */

    public CommonNewParam(final String sid, final Param parameter)
    {
        setSid(sid);
        setParameter(parameter);
    }


    /**
     * Returns the semantic.
     *
     * @return The semantic. May be null if not set.
     */

    public String getSemantic()
    {
        return this.semantic;
    }


    /**
     * Sets the semantic.
     *
     * @param semantic
     *            The semantic to set. Null to unset.
     */

    public void setSemantic(final String semantic)
    {
        this.semantic = semantic;
    }


    /**
     * Returns the parameter.
     *
     * @return The parameter. Never null.
     */

    public Param getParameter()
    {
        return this.parameter;
    }


    /**
     * Sets the parameter.
     *
     * @param parameter
     *            The parameter to set. Must not be null.
     */

    public void setParameter(final Param parameter)
    {
        if (parameter == null)
            throw new IllegalArgumentException("parameter must not be null");
        if (parameter != this.parameter)
        {
            if (this.parameter != null) removeChild(this.parameter);
            this.parameter = parameter;
            addChild(parameter);
        }
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Must not be null.
     */

    @Override
    public void setSid(final String sid)
    {
        if (sid == null)
            throw new IllegalArgumentException("sid must not be null");
        this.sid = sid;
    }


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. Never null.
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }
}
