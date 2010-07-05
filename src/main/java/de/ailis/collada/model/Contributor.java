/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.io.Serializable;
import java.net.URI;


/**
 * Authoring information for asset management.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class Contributor implements Serializable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The author's name. Optional. */
    private String author;

    /** The author's full email address. Optional */
    private String authorEMail;

    /** The URL of the author's website. Optional */
    private URI authorWebsite;

    /** The name of the used authoring tool. Optional */
    private String authoringTool;

    /** Comments from this contributor. Optional */
    private String comments;

    /** The copyright information. Optional */
    private String copyright;

    /** The URI reference to the source data. Optional */
    private URI sourceData;


    /**
     * Returns the author's name.
     *
     * @return The author's name. May be null if not set.
     */

    public String getAuthor()
    {
        return this.author;
    }


    /**
     * Sets the author's name.
     *
     * @param author
     *            The author's name to set. Null to unset.
     */

    public void setAuthor(final String author)
    {
        this.author = author;
    }


    /**
     * Returns the author's E-Mail address.
     *
     * @return The author's E-Mail address. May be null if not set.
     */

    public String getAuthorEMail()
    {
        return this.authorEMail;
    }


    /**
     * Sets the author's E-Mail address.
     *
     * @param authorEMail
     *            The author's E-Mail address to set. Null to unset.
     */

    public void setAuthorEMail(final String authorEMail)
    {
        this.authorEMail = authorEMail;
    }


    /**
     * Returns the author's website.
     *
     * @return The author's website. May be null if not set.
     */

    public URI getAuthorWebsite()
    {
        return this.authorWebsite;
    }


    /**
     * Sets the author's website.
     *
     * @param authorWebsite
     *            The author's website to set. Null to unset
     */

    public void setAuthorWebsite(final URI authorWebsite)
    {
        this.authorWebsite = authorWebsite;
    }


    /**
     * Returns the name of the authoring tool.
     *
     * @return The name of the authoring tool. May be null if not set.
     */

    public String getAuthoringTool()
    {
        return this.authoringTool;
    }


    /**
     * Sets the name of the authoring tool..
     *
     * @param authoringTool
     *            The name of the authoring tool to set. Null to unset.
     */

    public void setAuthoringTool(final String authoringTool)
    {
        this.authoringTool = authoringTool;
    }


    /**
     * Returns the comments.
     *
     * @return The comments. May be null if not set.
     */

    public String getComments()
    {
        return this.comments;
    }


    /**
     * Sets the comments.
     *
     * @param comments
     *            The comments to set. Null to unset.
     */

    public void setComments(final String comments)
    {
        this.comments = comments;
    }


    /**
     * Returns the copyright.
     *
     * @return The copyright. May be null if not set.
     */

    public String getCopyright()
    {
        return this.copyright;
    }


    /**
     * Sets the copyright.
     *
     * @param copyright
     *            The copyright to set. Null to unset
     */

    public void setCopyright(final String copyright)
    {
        this.copyright = copyright;
    }


    /**
     * Returns the source data URI.
     *
     * @return The source data URI. May be null if not set.
     */

    public URI getSourceData()
    {
        return this.sourceData;
    }


    /**
     * Sets the source data URI.
     *
     * @param sourceData
     *            The source data URI to set. Null to unset.
     */

    public void setSourceData(final URI sourceData)
    {
        this.sourceData = sourceData;
    }
}
