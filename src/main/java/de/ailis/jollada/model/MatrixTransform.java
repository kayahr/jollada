/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import de.ailis.gramath.Matrix4d;
import de.ailis.gramath.MutableMatrix4d;


/**
 * Look-at transformation.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class MatrixTransform extends Transformation
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The matrix. */
    private final MutableMatrix4d matrix = MutableMatrix4d.identity();


    /**
     * Sets the matrix.
     *
     * @param matrix
     *            The matrix to set. Must not be null.
     */

    public void setMatrix(final Matrix4d matrix)
    {
        if (matrix == null)
            throw new IllegalArgumentException("matrix must not be null");
        this.matrix.set(matrix);
    }


    /**
     * Returns the matrix.
     *
     * @return The matrix. Never null.
     */

    public MutableMatrix4d getMatrix()
    {
        return this.matrix;
    }
}
