/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * Opaque definitions.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public enum Opaque
{
    /** Transparency from alpha channel. Value 1.0 is opaque. */
    A_ONE,

    /** Transparency from RGB where BLACK is opaque. */
    RGB_ZERO,

    /** Transparency from alpha channel. Value 0.0 is opaque. */
    A_ZERO,

    /** Transparency from RGB where WHITE is opaque. */
    RGB_ONE
}
