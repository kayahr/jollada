/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.builders;

import de.ailis.jollada.model.CommonNewParam;
import de.ailis.jollada.model.Param;


/**
 * Builder for new param in common profile.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonNewParamBuilder
{
    /** The next parameter. */
    private Param parameter;

    /** The next semantic. */
    private String semantic;

    /** The next scope ID. */
    private String sid;


    /**
     * Builds and returns the param.
     *
     * @return The param. Never null.
     */

    public CommonNewParam build()
    {
        if (this.sid == null)
            throw new IllegalStateException("sid not set");
        if (this.parameter == null)
            throw new IllegalStateException("parameter not set");
        final CommonNewParam param = new CommonNewParam(this.sid,
            this.parameter);
        param.setSemantic(this.semantic);
        return param;
    }


    /**
     * Resets the builder.
     */

    public void reset()
    {
        this.parameter = null;
        this.semantic = null;
    }


    /**
     * Returns the next parameter.
     *
     * @return The next parameter. May be null if unset.
     */

    public Param getParameter()
    {
        return this.parameter;
    }


    /**
     * Sets the next parameter.
     *
     * @param parameter
     *            The next parameter to set. Null to unset.
     */

    public void setParameter(final Param parameter)
    {
        this.parameter = parameter;
    }


    /**
     * Returns the next semantic.
     *
     * @return The next semantic. May be null if not set.
     */

    public String getSemantic()
    {
        return this.semantic;
    }


    /**
     * Sets the next semantic.
     *
     * @param semantic
     *            The next semantic to set. Null to unset.
     */

    public void setSemantic(final String semantic)
    {
        this.semantic = semantic;
    }


    /**
     * Returns the scope ID.
     *
     * @return The scope ID. May be null if not set.
     */

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

    public void setSid(final String sid)
    {
        this.sid = sid;
    }
}
