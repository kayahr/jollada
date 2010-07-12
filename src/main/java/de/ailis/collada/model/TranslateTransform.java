/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.MutableVector3f;
import de.ailis.gramath.Vector3f;


/**
 * Translate transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class TranslateTransform extends Transformation
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The translation axis */
    private final MutableVector3f translation = new MutableVector3f();


    /**
     * Sets the translation.
     *
     * @param translation
     *            The translation to set. Must not be null.
     * @return This transform for chaining.
     */

    public TranslateTransform setTranslation(final Vector3f translation)
    {
        if (translation == null)
            throw new IllegalArgumentException("translation must not be null");
        this.translation.set(translation);
        return this;
    }


    /**
     * Returns the translation.
     *
     * @return The translation. Never null.
     */

    public MutableVector3f getTranslation()
    {
        return this.translation;
    }
}
