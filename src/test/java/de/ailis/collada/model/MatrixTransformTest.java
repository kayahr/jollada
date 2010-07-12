/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.ailis.gramath.ImmutableMatrix4f;


/**
 * Tests the MatrixTransformation class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class MatrixTransformTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final MatrixTransform transform = new MatrixTransform();
        assertNull(transform.getSid());
        assertNotNull(transform.getMatrix());
    }


    /**
     * Tests the SID.
     */

    @Test
    public void testSid()
    {
        final MatrixTransform transform = new MatrixTransform();
        assertNull(transform.getId());
        assertSame(transform, ((ScopeIdentifiable) transform).setSid("foo"));
        assertEquals("foo", transform.getSid());
        transform.setId(null);
        assertNull(transform.getId());
    }


    /**
     * Tests the translation.
     */

    @Test
    public void testMatrix()
    {
        final MatrixTransform transform = new MatrixTransform();
        assertTrue(transform.getMatrix().isIdentity());
        final ImmutableMatrix4f translation = new ImmutableMatrix4f(0, 1, 2, 3,
            4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        assertSame(transform, transform.setMatrix(translation));
        assertEquals(translation, new ImmutableMatrix4f(transform.getMatrix()));
    }


    /**
     * Tests the translation with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixWithNull()
    {
        new MatrixTransform().setMatrix(null);
    }
}
