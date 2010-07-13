/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
    public void testEmptyConstructor()
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
     * Tests the full constructor.
     *
     * @throws URISyntaxException
     *             When invalid URI has been specified
     */

    @Test
    public void testFullConstructor() throws URISyntaxException
    {
        final Contributor contributor = new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"));
        assertEquals("AUTHOR", contributor.getAuthor());
        assertEquals("EMAIL", contributor.getAuthorEMail());
        assertEquals("TOOL", contributor.getAuthoringTool());
        assertEquals(new URI("WEBSITE"), contributor.getAuthorWebsite());
        assertEquals("COMMENTS", contributor.getComments());
        assertEquals("COPYRIGHT", contributor.getCopyright());
        assertEquals(new URI("SOURCE"), contributor.getSourceData());
    }


    /**
     * Tests the equals() method.
     *
     * @throws URISyntaxException
     *             When invalid URI has been specified
     */

    @Test
    public void testEquals() throws URISyntaxException
    {
        final Contributor contributor = new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"));
        assertTrue(contributor.equals(new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"))));
        assertTrue(contributor.equals(contributor));
        assertFalse(contributor.equals(null));
        assertFalse(contributor.equals("someOther"));
        assertFalse(contributor.equals(new Contributor("AUTHOR2", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"))));
        assertFalse(contributor.equals(new Contributor("AUTHOR", "EMAIL2",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"))));
        assertFalse(contributor.equals(new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE2"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"))));
        assertFalse(contributor.equals(new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL2", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"))));
        assertFalse(contributor.equals(new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS2", "COPYRIGHT", new URI(
                "SOURCE"))));
        assertFalse(contributor.equals(new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT2", new URI(
                "SOURCE"))));
        assertFalse(contributor.equals(new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE2"))));

        assertFalse(new Contributor(null, "EMAIL", new URI("WEBSITE"), "TOOL",
            "COMMENTS", "COPYRIGHT", new URI("SOURCE")).equals(contributor));
        assertFalse(new Contributor("AUTHOR", null, new URI("WEBSITE"), "TOOL",
            "COMMENTS", "COPYRIGHT", new URI("SOURCE")).equals(contributor));
        assertFalse(new Contributor("AUTHOR", "EMAIL", null, "TOOL",
            "COMMENTS", "COPYRIGHT", new URI("SOURCE")).equals(contributor));
        assertFalse(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
            null, "COMMENTS", "COPYRIGHT", new URI("SOURCE"))
                .equals(contributor));
        assertFalse(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
            "TOOL", null, "COPYRIGHT", new URI("SOURCE")).equals(contributor));
        assertFalse(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
            "TOOL", "COMMENTS", null, new URI("SOURCE")).equals(contributor));
        assertFalse(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
            "TOOL", "COMMENTS", "COPYRIGHT", null).equals(contributor));


        assertTrue(new Contributor(null, "EMAIL", new URI("WEBSITE"), "TOOL",
            "COMMENTS", "COPYRIGHT", new URI("SOURCE")).equals(new Contributor(
            null, "EMAIL", new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT",
            new URI("SOURCE"))));
        assertTrue(new Contributor("AUTHOR", null, new URI("WEBSITE"), "TOOL",
            "COMMENTS", "COPYRIGHT", new URI("SOURCE")).equals(new Contributor(
            "AUTHOR", null, new URI("WEBSITE"), "TOOL", "COMMENTS",
            "COPYRIGHT", new URI("SOURCE"))));
        assertTrue(new Contributor("AUTHOR", "EMAIL", null, "TOOL", "COMMENTS",
            "COPYRIGHT", new URI("SOURCE")).equals(new Contributor("AUTHOR",
            "EMAIL", null, "TOOL", "COMMENTS", "COPYRIGHT", new URI("SOURCE"))));
        assertTrue(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"), null,
            "COMMENTS", "COPYRIGHT", new URI("SOURCE")).equals(new Contributor(
            "AUTHOR", "EMAIL", new URI("WEBSITE"), null, "COMMENTS",
            "COPYRIGHT", new URI("SOURCE"))));
        assertTrue(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
            "TOOL", null, "COPYRIGHT", new URI("SOURCE"))
                .equals(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
                    "TOOL", null, "COPYRIGHT", new URI("SOURCE"))));
        assertTrue(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
            "TOOL", "COMMENTS", null, new URI("SOURCE"))
                .equals(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
                    "TOOL", "COMMENTS", null, new URI("SOURCE"))));
        assertTrue(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"),
            "TOOL", "COMMENTS", "COPYRIGHT", null).equals(new Contributor(
            "AUTHOR", "EMAIL", new URI("WEBSITE"), "TOOL", "COMMENTS",
            "COPYRIGHT", null)));
    }


    /**
     * Tests the hashCode method.
     *
     * @throws URISyntaxException
     *             When invalid URI has been specified
     */

    @Test
    public void testHashCode() throws URISyntaxException
    {
        final Contributor contributor1 = new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"));
        final Contributor contributor2 = new Contributor("AUTHOR", "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE"));
        assertEquals(contributor1.hashCode(), contributor2.hashCode());
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR2",
            "EMAIL", new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT",
            new URI("SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL2", new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT",
            new URI("SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL", new URI("WEBSITE2"), "TOOL", "COMMENTS", "COPYRIGHT",
            new URI("SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL", new URI("WEBSITE"), "TOOL2", "COMMENTS", "COPYRIGHT",
            new URI("SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL", new URI("WEBSITE"), "TOOL", "COMMENTS2", "COPYRIGHT",
            new URI("SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL", new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT2",
            new URI("SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL", new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT",
            new URI("SOURCE2")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor(null, "EMAIL",
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR", null,
            new URI("WEBSITE"), "TOOL", "COMMENTS", "COPYRIGHT", new URI(
                "SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(),
            not(new Contributor("AUTHOR", "EMAIL", null, "TOOL", "COMMENTS",
                "COPYRIGHT", new URI("SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL", new URI("WEBSITE"), null, "COMMENTS", "COPYRIGHT",
            new URI("SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL", new URI("WEBSITE"), "TOOL", null, "COPYRIGHT", new URI(
                "SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(), not(new Contributor("AUTHOR",
            "EMAIL", new URI("WEBSITE"), "TOOL", "COMMENTS", null, new URI(
                "SOURCE")).hashCode()));
        assertThat(contributor1.hashCode(),
            not(new Contributor("AUTHOR", "EMAIL", new URI("WEBSITE"), "TOOL",
                "COMMENTS", "COPYRIGHT", null).hashCode()));
    }


    /**
     * Tests the toString method.
     *
     * @throws URISyntaxException
     *             When invalid URI has been specified.
     */

    @Test
    public void testToString() throws URISyntaxException
    {
        assertEquals("Contributor [author=AUTHOR, authorEMail=EMAIL, "
            + "authorWebsite=WEBSITE, authoringTool=TOOL, comments=COMMENTS, "
            + "copyright=COPYRIGHT, sourceData=SOURCE]", new Contributor(
            "AUTHOR", "EMAIL", new URI("WEBSITE"), "TOOL", "COMMENTS",
            "COPYRIGHT", new URI("SOURCE")).toString());
    }

    /**
     * Tests the author.
     */

    @Test
    public void testAuthor()
    {
        final Contributor contributor = new Contributor();
        contributor.setAuthor("AUTHOR");
        assertEquals("AUTHOR", contributor.getAuthor());
    }


    /**
     * Tests the author email.
     */

    @Test
    public void testAuthorEMail()
    {
        final Contributor contributor = new Contributor();
        contributor.setAuthorEMail("EMAIL");
        assertEquals("EMAIL", contributor.getAuthorEMail());
    }


    /**
     * Tests the authoring tool.
     */

    @Test
    public void testAuthoringTool()
    {
        final Contributor contributor = new Contributor();
        contributor.setAuthoringTool("TOOL");
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
        contributor.setAuthorWebsite(new URI("WEBSITE"));
        assertEquals(new URI("WEBSITE"), contributor.getAuthorWebsite());
    }


    /**
     * Tests the comments.
     */

    @Test
    public void testComments()
    {
        final Contributor contributor = new Contributor();
        contributor.setComments("COMMENTS");
        assertEquals("COMMENTS", contributor.getComments());
    }


    /**
     * Tests the copyright.
     */

    @Test
    public void testCopyright()
    {
        final Contributor contributor = new Contributor();
        contributor.setCopyright("COPYRIGHT");
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
        contributor.setSourceData(new URI("SOURCE"));
        assertEquals(new URI("SOURCE"), contributor.getSourceData());
    }
}
