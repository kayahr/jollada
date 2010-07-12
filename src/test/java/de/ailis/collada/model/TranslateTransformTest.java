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

import de.ailis.gramath.ImmutableVector3f;


/**
 * Tests the TranslateTransformation class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class TranslateTransformTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final TranslateTransform transform = new TranslateTransform();
        assertNull(transform.getSid());
        assertNotNull(transform.getTranslation());
    }


    /**
     * Tests the SID.
     */

    @Test
    public void testSid()
    {
        final TranslateTransform transform = new TranslateTransform();
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
    public void testTranslation()
    {
        final TranslateTransform transform = new TranslateTransform();
        assertTrue(transform.getTranslation().isNull());
        final ImmutableVector3f translation = new ImmutableVector3f(1, 2, 3);
        assertSame(transform, transform.setTranslation(translation));
        assertEquals(translation.getX(), transform.getTranslation().getX(),
            0.0001f);
        assertEquals(translation.getY(), transform.getTranslation().getY(),
            0.0001f);
        assertEquals(translation.getZ(), transform.getTranslation().getZ(),
            0.0001f);
    }


    /**
     * Tests the translation with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testTranslationWithNull()
    {
        new TranslateTransform().setTranslation(null);
    }
}
