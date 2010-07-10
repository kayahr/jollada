
package de.ailis.collada.model;

/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */


/**
 * Binds a specific material to a piece of geometry.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class MaterialBinding extends Element
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The list of data flow parameters */
    private final DataFlowParams params = new DataFlowParams(this);

    /** The common material binding technique */
    private final CommonMaterialBindingTechnique commonTechnique = new CommonMaterialBindingTechnique(
        this);


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    MaterialBinding(final Element parent)
    {
        super(parent);
    }


    /**
     * Returns the list of data flow parameters.
     *
     * @return The list of data flow parameters. Never null. May be empty.
     */

    public DataFlowParams getParams()
    {
        return this.params;
    }


    /**
     * Returns the common material binding technique.
     *
     * @return The common material binding technique. Never null.
     */

    public CommonMaterialBindingTechnique getCommonTechnique()
    {
        return this.commonTechnique;
    }
}
