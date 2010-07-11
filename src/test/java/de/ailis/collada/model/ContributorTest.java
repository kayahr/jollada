/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;


/**
 * Tests the Contributor class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class ContributorTest
{
    /**
     * Tests the default constructor.
     */

    @Test
    public void testConstructor()
    {
        final Contributor contributor = new Contributor();
        assertNull(contributor.getAuthor());
        assertNull(contributor.getAuthorEMail());
        assertNull(contributor.getAuthoringTool());
        assertNull(contributor.getAuthorWebsite());
        assertNull(contributor.getComments());
        assertNull(contributor.getCopyright());
        assertNull(contributor.getSourceData());
    }


    /**
     * Tests the equals() method.
     */

    @Test
    public void testEquals()
    {
        final Contributor contributor1 = new Contributor().setAuthor("me");
        final Contributor contributor2 = new Contributor().setAuthor("me");
        final Contributor contributor3 = new Contributor().setAuthor("him");
        assertTrue(contributor1.equals(contributor2));
        assertTrue(contributor1.equals(contributor1));
        assertFalse(contributor1.equals(null));
        assertFalse(contributor1.equals("someOther"));
        assertFalse(contributor1.equals(contributor3));
    }


    /**
     * Tests the hashCode method.
     */

    @Test
    public void testHashCode()
    {
        final Contributor contributor1 = new Contributor().setAuthor("me");
        final Contributor contributor2 = new Contributor().setAuthor("me");
        final Contributor contributor3 = new Contributor().setAuthor("him");
        assertThat(contributor1.hashCode(), is(contributor2.hashCode()));
        assertThat(contributor1.hashCode(), not(contributor3.hashCode()));
    }


    /**
     * Tests the toString method.
     */

    @Test
    public void testToString()
    {
        assertEquals("Contributor [author=null, authorEMail=null, " +
                "authorWebsite=null, authoringTool=null, comments=null, " +
                "copyright=null, sourceData=null]",
            new Contributor().toString());
    }


    /**
     * Tests the author.
     */

    @Test
    public void testAuthor()
    {
        final Contributor contributor = new Contributor();
        assertSame(contributor, contributor.setAuthor("AUTHOR"));
        assertEquals("AUTHOR", contributor.getAuthor());
    }


    /**
     * Tests the author email.
     */

    @Test
    public void testAuthorEMail()
    {
        final Contributor contributor = new Contributor();
        assertSame(contributor, contributor.setAuthorEMail("EMAIL"));
        assertEquals("EMAIL", contributor.getAuthorEMail());
    }


    /**
     * Tests the authoring tool.
     */

    @Test
    public void testAuthoringTool()
    {
        final Contributor contributor = new Contributor();
        assertSame(contributor, contributor.setAuthoringTool("TOOL"));
        assertEquals("TOOL", contributor.getAuthoringTool());
    }


    /**
     * Tests the author website.
     *
     * @throws URISyntaxException
     *             When URI is invalid
     */

    @Test
    public void testAuthorWebsite() throws URISyntaxException
    {
        final Contributor contributor = new Contributor();
        assertSame(contributor,
            contributor.setAuthorWebsite(new URI("WEBSITE")));
        assertEquals(new URI("WEBSITE"), contributor.getAuthorWebsite());
    }


    /**
     * Tests the comments.
     */

    @Test
    public void testComments()
    {
        final Contributor contributor = new Contributor();
        assertSame(contributor, contributor.setComments("COMMENTS"));
        assertEquals("COMMENTS", contributor.getComments());
    }


    /**
     * Tests the copyright.
     */

    @Test
    public void testCopyright()
    {
        final Contributor contributor = new Contributor();
        assertSame(contributor, contributor.setCopyright("COPYRIGHT"));
        assertEquals("COPYRIGHT", contributor.getCopyright());
    }


    /**
     * Tests the source data.
     *
     * @throws URISyntaxException
     *             When URI is invalid
     */

    @Test
    public void testSourceData() throws URISyntaxException
    {
        final Contributor contributor = new Contributor();
        assertSame(contributor, contributor.setSourceData(new URI("SOURCE")));
        assertEquals(new URI("SOURCE"), contributor.getSourceData());
    }
}
