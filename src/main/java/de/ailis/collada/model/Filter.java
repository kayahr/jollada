/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * Filter mode.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public enum Filter
{
    /** No filter. */
    NONE,

    /** Bilinear filter. */
    NEAREST,

    /** Trilinear filter. */
    LINEAR,

    /** Anisotopic filter. */
    ANISOTROPIC
}
