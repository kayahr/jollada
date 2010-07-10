/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * The common material binding technique.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class CommonMaterialBindingTechnique extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The list of material instances. */
    private final MaterialInstances materialInstances = new MaterialInstances(
        this);


    /**
     * Constructor
     *
     * @param parent
     *            The parent element. Must not be null.
     */

    CommonMaterialBindingTechnique(final Element parent)
    {
        super(parent);
    }


    /**
     * Returns the list of material instances.
     *
     * @return The list of material instances. Never null.
     */

    public MaterialInstances getMaterialInstances()
    {
        return this.materialInstances;
    }
}
