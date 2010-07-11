/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.net.URI;


/**
 * A material instance.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class MaterialInstance extends Element implements
        ScopeIdentifiable
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The symbol to bind the material to */
    private String symbol;

    /** The URI of the location of the material element to instantiate. */
    private URI target;

    /** The scope ID */
    private String sid;

    /** The name */
    private String name;


    /**
     * Constructor.
     *
     * @param symbol
     *            The symbol to bind the material to. Must not be null.
     * @param target
     *            The URI of the location of the material element to
     *            instantiate. Must not be null.
     */

    public MaterialInstance(final String symbol, final URI target)
    {
        setSymbol(symbol);
        setTarget(target);
    }


    /**
     * Returns the symbol to bind the material to.
     *
     * @return The symbol. Never null.
     */

    public String getSymbol()
    {
        return this.symbol;
    }


    /**
     * Sets the symbol to bind the material to.
     *
     * @param symbol
     *            The symbol to set. Must not be null.
     * @return This material instance for chaining.
     */

    public MaterialInstance setSymbol(final String symbol)
    {
        if (symbol == null)
            throw new IllegalArgumentException("symbol must not be null");
        this.symbol = symbol;
        return this;
    }


    /**
     * Returns the URI of the location of the material element to instantiate.
     *
     * @return The target material URI. Never null.
     */

    public URI getTarget()
    {
        return this.target;
    }


    /**
     * Sets the URI of the location of the material element to instantiate.
     *
     * @param target
     *            The target material URI to set. Must not be null.
     * @return This material instance for chaining.
     */

    public MaterialInstance setTarget(final URI target)
    {
        if (target == null)
            throw new IllegalArgumentException("target must not be null");
        this.target = target;
        return this;
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
     * @return This material instance for chaining.
     */

    @Override
    public MaterialInstance setSid(final String sid)
    {
        this.sid = sid;
        return this;
    }


    /**
     * Returns the name.
     *
     * @return The name. May be null if unset.
     */

    public String getName()
    {
        return this.name;
    }


    /**
     * Sets the name.
     *
     * @param name
     *            The name to set. Null to unset.
     * @return This material instance for chaining.
     */

    public MaterialInstance setName(final String name)
    {
        this.name = name;
        return this;
    }
}
