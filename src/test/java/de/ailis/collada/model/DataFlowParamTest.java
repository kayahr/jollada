/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;


/**
 * Tests the DataFlowParam class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class DataFlowParamTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testDefaultConstructor()
    {
        final DataFlowParam param = new DataFlowParam("int");
        assertEquals("int", param.getType());
        assertNull(param.getName());
        assertNull(param.getSid());
        assertNull(param.getSemantic());
    }


    /**
     * Tests the constructor with a null parameter.
     */

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorWithNull()
    {
        new DataFlowParam(null).toString();
    }


    /**
     * Tests the SID.
     */

    @Test
    public void testSid()
    {
        final DataFlowParam param = new DataFlowParam("int");
        assertNull(param.getSid());
        param.setSid("foo");
        assertEquals("foo", param.getSid());
        param.setSid(null);
        assertNull(param.getSid());
    }


    /**
     * Tests the name.
     */

    @Test
    public void testName()
    {
        final DataFlowParam param = new DataFlowParam("int");
        assertNull(param.getName());
        param.setName("foo");
        assertEquals("foo", param.getName());
        param.setName(null);
        assertNull(param.getName());
    }


    /**
     * Tests the name.
     */

    @Test
    public void testSemantic()
    {
        final DataFlowParam param = new DataFlowParam("int");
        assertNull(param.getSemantic());
        param.setSemantic("foo");
        assertEquals("foo", param.getSemantic());
        param.setSemantic(null);
        assertNull(param.getSemantic());
    }


    /**
     * Tests the type.
     */

    @Test
    public void testType()
    {
        final DataFlowParam param = new DataFlowParam("int");
        param.setType("float");
        assertEquals("float", param.getType());
    }


    /**
     * Tests the type with null param.
     */

    @Test(expected=IllegalArgumentException.class)
    public void testTypeWithNull()
    {
        final DataFlowParam param = new DataFlowParam("int");
        param.setType(null);
    }
}
