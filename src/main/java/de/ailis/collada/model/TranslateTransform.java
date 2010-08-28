/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.MutableVector3d;
import de.ailis.gramath.Vector3d;


/**
 * Translate transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class TranslateTransform extends Transformation
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The translation axis. */
    private final MutableVector3d translation = new MutableVector3d();


    /**
     * Sets the translation.
     *
     * @param translation
     *            The translation to set. Must not be null.
     */

    public void setTranslation(final Vector3d translation)
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

    public MutableVector3d getTranslation()
    {
        return this.translation;
    }
}
