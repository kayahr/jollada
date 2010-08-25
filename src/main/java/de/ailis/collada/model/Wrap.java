/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Wrap mode.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public enum Wrap
{
    /** Tiles the texture at every integer junction. */
    WRAP,

    /** Flips the texture at every integer junction. */
    MIRROR,

    /**
     * Texture coordinates reaching or exceeding the range [0.0, 1.0] are set
     * just within 0.0 or 1.0 so that the border is not sampled.
     */
    CLAMP,

    /**
     * Much like CLAMP, except texture coordinates outside the range [0.0, 1.0]
     * are set to the border color.
     */
    BORDER,

    /**
     * Takes the absolute value of the texture coordinate (thus, mirroring
     * around 0), and then clamps to the maximum value.
     */
    MIRROR_ONCE
}
