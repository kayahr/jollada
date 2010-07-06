/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.MutableTuple3f;
import de.ailis.gramath.Tuple3f;


/**
 * Translate transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ScaleTransform extends Transformation
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The translation axis */
    private final MutableTuple3f translation = new MutableTuple3f();


    /**
     * Sets the translation.
     *
     * @param translation
     *            The translation to set. Must not be null.
     */

    public void setTranslation(final Tuple3f translation)
    {
        if (translation == null)
            throw new IllegalArgumentException("translation must not be null");
        this.translation.set(translation);
    }


    /**
     * Returns the translation.
     *
     * @return The translation. Never null.
     */

    public MutableTuple3f getTranslation()
    {
        return this.translation;
    }
}
