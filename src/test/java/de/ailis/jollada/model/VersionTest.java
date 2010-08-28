/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ailis.jollada.model.Version;


/**
 * Tests the Version class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class VersionTest
{
    /**
     * Tests the valueOf method.
     */

    @Test
    public void testValueOf()
    {
        assertEquals(Version.VERSION_1_5_0, Version.valueOf("VERSION_1_5_0"));
    }
}
