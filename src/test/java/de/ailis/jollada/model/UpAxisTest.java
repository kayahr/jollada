/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ailis.jollada.model.UpAxis;


/**
 * Tests the UpAxis class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class UpAxisTest
{
    /**
     * Tests the valueOf method.
     */

    @Test
    public void testValueOf()
    {
        assertEquals(UpAxis.X_UP, UpAxis.valueOf("X_UP"));
        assertEquals(UpAxis.Y_UP, UpAxis.valueOf("Y_UP"));
        assertEquals(UpAxis.Z_UP, UpAxis.valueOf("Z_UP"));
    }
}
