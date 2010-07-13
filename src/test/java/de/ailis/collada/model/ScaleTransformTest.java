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
 * Tests the ScaleTransformation class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ScaleTransformTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final ScaleTransform transform = new ScaleTransform();
        assertNull(transform.getSid());
        assertNotNull(transform.getScaling());
    }


    /**
     * Tests the SID.
     */

    @Test
    public void testSid()
    {
        final ScaleTransform transform = new ScaleTransform();
        assertNull(transform.getSid());
        transform.setSid("foo");
        assertEquals("foo", transform.getSid());
        transform.setSid(null);
        assertNull(transform.getSid());
    }


    /**
     * Tests the translation.
     */

    @Test
    public void testScaling()
    {
        final ScaleTransform transform = new ScaleTransform();
        assertTrue(transform.getScaling().isNull());
        final ImmutableVector3f translation = new ImmutableVector3f(1, 2, 3);
        transform.setScaling(translation);
        assertEquals(translation.getX(), transform.getScaling().getX(),
            0.0001f);
        assertEquals(translation.getY(), transform.getScaling().getY(),
            0.0001f);
        assertEquals(translation.getZ(), transform.getScaling().getZ(),
            0.0001f);
    }


    /**
     * Tests the translation with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testScalingWithNull()
    {
        new ScaleTransform().setScaling(null);
    }
}
