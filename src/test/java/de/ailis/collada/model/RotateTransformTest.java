/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.ailis.gramath.ImmutableVector3f;


/**
 * Tests the RotateTransformation class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class RotateTransformTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final RotateTransform transform = new RotateTransform();
        assertNull(transform.getSid());
        assertNotNull(transform.getAxis());
        assertEquals(0, transform.getAngle(), 0.001f);
    }


    /**
     * Tests the SID.
     */

    @Test
    public void testSid()
    {
        final RotateTransform transform = new RotateTransform();
        assertNull(transform.getSid());
        transform.setSid("foo");
        assertEquals("foo", transform.getSid());
        transform.setSid(null);
        assertNull(transform.getSid());
    }


    /**
     * Tests the angle.
     */

    @Test
    public void testAngle()
    {
        final RotateTransform transform = new RotateTransform();
        assertEquals(0, transform.getAngle(), 0.001f);
        transform.setAngle(1);
        assertEquals(1, transform.getAngle(), 0.001f);
    }


    /**
     * Tests the translation.
     */

    @Test
    public void testAxis()
    {
        final RotateTransform transform = new RotateTransform();
        assertTrue(transform.getAxis().isNull());
        final ImmutableVector3f translation = new ImmutableVector3f(1, 2, 3);
        transform.setAxis(translation);
        assertEquals(translation.getX(), transform.getAxis().getX(),
            0.0001f);
        assertEquals(translation.getY(), transform.getAxis().getY(),
            0.0001f);
        assertEquals(translation.getZ(), transform.getAxis().getZ(),
            0.0001f);
    }


    /**
     * Tests the translation with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testAxisWithNull()
    {
        new RotateTransform().setAxis(null);
    }
}
