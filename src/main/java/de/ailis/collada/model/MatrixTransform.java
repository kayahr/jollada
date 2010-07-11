/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import de.ailis.gramath.Matrix4f;
import de.ailis.gramath.MutableMatrix4f;


/**
 * Look-at transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class MatrixTransform extends Transformation
{
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** The matrix */
    private final MutableMatrix4f matrix = MutableMatrix4f.identity();


    /**
     * Sets the matrix.
     *
     * @param matrix
     *            The matrix to set. Must not be null.
     * @return This transform for chaining.
     */

    public MatrixTransform setMatrix(final Matrix4f matrix)
    {
        if (matrix == null)
            throw new IllegalArgumentException("matrix must not be null");
        this.matrix.set(matrix);
        return this;
    }


    /**
     * Returns the matrix.
     *
     * @return The matrix. Never null.
     */

    public MutableMatrix4f getMatrix()
    {
        return this.matrix;
    }
}
