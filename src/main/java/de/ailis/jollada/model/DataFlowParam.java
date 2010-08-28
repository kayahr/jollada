/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Parametric information for parent element.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class DataFlowParam extends Element implements ScopeIdentifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The scope ID. */
    private String sid;

    /** The parameter name. */
    private String name;

    /** The data type. */
    private String type;

    /** The user-defined meaning of the parameter. */
    private String semantic;


    /**
     * Constructor.
     *
     * @param type
     *            The data type. Must not be null.
     */

    public DataFlowParam(final String type)
    {
        setType(type);
    }


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. May be null if not set.
     */

    @Override
    public String getSid()
    {
        return this.sid;
    }


    /**
     * Sets the scope ID.
     *
     * @param sid
     *            The scope ID to set. Null to unset.
     */

    @Override
    public void setSid(final String sid)
    {
        this.sid = sid;
    }


    /**
     * Returns the parameter name.
     *
     * @return The parameter name. May be null if not set.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the parameter name.
     *
     * @param name
     *            The parameter name to set. Null to unset.
     */

    public void setName(final String name)
    {
        this.name = name;
    }


    /**
     * Returns the data type.
     *
     * @return The data type. Never null.
     */

    public String getType()
    {
        return this.type;
    }


    /**
     * Sets the data type.
     *
     * @param type
     *            The data type to set. Must not be null.
     */

    public void setType(final String type)
    {
        if (type == null)
            throw new IllegalArgumentException("type must not be null");
        this.type = type;
    }


    /**
     * Returns the user-defined meaning of the parameter.
     *
     * @return The semantic. May be null if unset.
     */

    public String getSemantic()
    {
        return this.semantic;
    }


    /**
     * Sets the user-defined meaning of the parameter.
     *
     * @param semantic
     *            The semantic to set. Null to unset.
     */

    public void setSemantic(final String semantic)
    {
        this.semantic = semantic;
    }
}
