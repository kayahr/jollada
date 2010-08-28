/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ailis.jollada.model.AltitudeMode;


/**
 * Tests the AltitudeMode class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class AltitudeModeTest
{
    /**
     * Tests the valueOf method.
     */

    @Test
    public void testValueOf()
    {
        assertEquals(AltitudeMode.ABSOLUTE, AltitudeMode.valueOf("ABSOLUTE"));
        assertEquals(AltitudeMode.RELATIVE_TO_GROUND,
            AltitudeMode.valueOf("RELATIVE_TO_GROUND"));
    }
}
