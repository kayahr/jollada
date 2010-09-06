/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * A animation behavior for samplers. Indicate what the sampled value should be
 * before the first or last key.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public enum AnimationBehavior
{
    /** Values are undefined. */
    UNDEFINED,

    /** The value for the first or last key is returned. */
    CONSTANT,

    /**
     * THe value follows the line given by the first or last two keys in the
     * sample.
     */
    GRADIENT,

    /** The animation cycles. */
    CYCLE,

    /** The animation oscillates. */
    OSCILLATE,

    /** The animation continues indefinetely. */
    CYCLE_RELATIVE
}
