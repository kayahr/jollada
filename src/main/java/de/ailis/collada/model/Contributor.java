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

public final class Contributor implements Serializable
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
     * @return This contributor for chaining.
     */

    public Contributor setAuthor(final String author)
    {
        this.author = author;
        return this;
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
     * @return This contributor for chaining.
     */

    public Contributor setAuthorEMail(final String authorEMail)
    {
        this.authorEMail = authorEMail;
        return this;
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
     * @return This contributor for chaining.
     */

    public Contributor setAuthorWebsite(final URI authorWebsite)
    {
        this.authorWebsite = authorWebsite;
        return this;
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
     * @return This contributor for chaining.
     */

    public Contributor setAuthoringTool(final String authoringTool)
    {
        this.authoringTool = authoringTool;
        return this;
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
     * @return This contributor for chaining.
     */

    public Contributor setComments(final String comments)
    {
        this.comments = comments;
        return this;
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
     * @return This contributor for chaining.
     */

    public Contributor setCopyright(final String copyright)
    {
        this.copyright = copyright;
        return this;
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
     * @return This contributor for chaining.
     */

    public Contributor setSourceData(final URI sourceData)
    {
        this.sourceData = sourceData;
        return this;
    }


    /**
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((this.author == null) ? 0 : this.author.hashCode());
        result = prime * result
            + ((this.authorEMail == null) ? 0 : this.authorEMail.hashCode());
        result = prime
            * result
            + ((this.authorWebsite == null) ? 0 : this.authorWebsite.hashCode());
        result = prime
            * result
            + ((this.authoringTool == null) ? 0 : this.authoringTool.hashCode());
        result = prime * result
            + ((this.comments == null) ? 0 : this.comments.hashCode());
        result = prime * result
            + ((this.copyright == null) ? 0 : this.copyright.hashCode());
        result = prime * result
            + ((this.sourceData == null) ? 0 : this.sourceData.hashCode());
        return result;
    }


    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Contributor other = (Contributor) obj;
        if (this.author == null)
        {
            if (other.author != null) return false;
        }
        else if (!this.author.equals(other.author)) return false;
        if (this.authorEMail == null)
        {
            if (other.authorEMail != null) return false;
        }
        else if (!this.authorEMail.equals(other.authorEMail)) return false;
        if (this.authorWebsite == null)
        {
            if (other.authorWebsite != null) return false;
        }
        else if (!this.authorWebsite.equals(other.authorWebsite)) return false;
        if (this.authoringTool == null)
        {
            if (other.authoringTool != null) return false;
        }
        else if (!this.authoringTool.equals(other.authoringTool)) return false;
        if (this.comments == null)
        {
            if (other.comments != null) return false;
        }
        else if (!this.comments.equals(other.comments)) return false;
        if (this.copyright == null)
        {
            if (other.copyright != null) return false;
        }
        else if (!this.copyright.equals(other.copyright)) return false;
        if (this.sourceData == null)
        {
            if (other.sourceData != null) return false;
        }
        else if (!this.sourceData.equals(other.sourceData)) return false;
        return true;
    }


    /**
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString()
    {
        return "Contributor [author=" + this.author + ", authorEMail="
            + this.authorEMail + ", authorWebsite=" + this.authorWebsite
            + ", authoringTool=" + this.authoringTool + ", comments="
            + this.comments + ", copyright=" + this.copyright + ", sourceData="
            + this.sourceData + "]";
    }
}
