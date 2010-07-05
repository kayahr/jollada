/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Asset-management information.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class Asset
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The contributors who worked on the parent element */
    private final List<Contributor> contributors = new ArrayList<Contributor>();

    /** The date and time the parent element was created. */
    private Date created;

    /** The date and time the parent element was last modified. */
    private Date modified;

    /** The geographic location. */
    private GeographicLocation geographicLocation;

    /** List of keywords */
    private final List<String> keywords = new ArrayList<String>();

    /** Revision information */
    private String revision;

    /** The title */
    private String title;

    /** The unit of distance */
    private Unit unit = new Unit();

    /** The orientation of the coordinate system */
    private UpAxis upAxis = UpAxis.Y_UP;


    /**
     * Creates new asset-management information with the created and modified
     * time stamp set to the current time.
     */

    public Asset()
    {
        this(new Date());
    }


    /**
     * Creates new asset-management information with the created and modified
     * time stamp set to the specified time.
     *
     * @param created
     *            The date and time the parent element was created. Is also used
     *            for the modified time stamp.
     */

    public Asset(final Date created)
    {
        this(created, created);
    }


    /**
     * Creates new asset-management information with the created and modified
     * time stamp set to the specified times.
     *
     * @param created
     *            The date and time the parent element was created.
     * @param modified
     *            The date and time the parent element was last modified.
     */

    public Asset(final Date created, final Date modified)
    {
        this.created = created;
        this.modified = modified;
    }


    /**
     * Returns the date and time the parent element was created.
     *
     * @return The date and time the parent element was created. Never null.
     */

    public Date getCreated()
    {
        return this.created;
    }


    /**
     * Sets the date and time the parent element was created.
     *
     * @param created
     *            The date and time the parent element was created. Must not be
     *            null.
     */

    public void setCreated(final Date created)
    {
        if (created == null)
            throw new IllegalArgumentException("created must not be null");
        this.created = created;
    }


    /**
     * Returns the date and time the parent element was last modified.
     *
     * @return The date and time the parent element was last modified. Never
     *         null.
     */

    public Date getModified()
    {
        return this.modified;
    }


    /**
     * Sets the date and time the parent element was last modified.
     *
     * @param modified
     *            The date and time the parent element was last modified. Must
     *            not be null.
     */

    public void setModified(final Date modified)
    {
        if (modified == null)
            throw new IllegalArgumentException("created must not be null");
        this.modified = modified;
    }


    /**
     * Returns the list of contributors.
     *
     * @return The list of contributors. Never null. May be empty.
     */

    public List<Contributor> getContributors()
    {
        return this.contributors;
    }


    /**
     * Returns the geographic location.
     *
     * @return The geographic location. May be null if not set.
     */

    public GeographicLocation getGeographicLocation()
    {
        return this.geographicLocation;
    }


    /**
     * Sets the geographic location.
     *
     * @param geographicLocation
     *            The geographic location to set. Null to unset.
     */

    public void setGeographicLocation(
        final GeographicLocation geographicLocation)
    {
        this.geographicLocation = geographicLocation;
    }


    /**
     * Returns the list of keywords.
     *
     * @return The list of keywords. Never null. May be empty.
     */

    public List<String> getKeywords()
    {
        return this.keywords;
    }


    /**
     * Returns the revision.
     *
     * @return The revision. May be null if not set.
     */

    public String getRevision()
    {
        return this.revision;
    }


    /**
     * Sets the revision.
     *
     * @param revision
     *            The revision to set. Null to unset.
     */

    public void setRevision(final String revision)
    {
        this.revision = revision;
    }


    /**
     * Returns the title.
     *
     * @return The title. May be null if not set.
     */

    public String getTitle()
    {
        return this.title;
    }


    /**
     * Sets the title.
     *
     * @param title
     *            The title to set. Null to unset.
     */

    public void setTitle(final String title)
    {
        this.title = title;
    }


    /**
     * Returns the unit of distance.
     *
     * @return The unit of distance. Never null.
     */

    public Unit getUnit()
    {
        return this.unit;
    }


    /**
     * Sets the unit of distance.
     *
     * @param unit
     *            The unit of distance to set. Most not be null.
     */

    public void setUnit(final Unit unit)
    {
        if (unit == null)
            throw new IllegalArgumentException("unit must not be null");
        this.unit = unit;
    }


    /**
     * Returns the orientation of the coordinate system.
     *
     * @return The orientation of the coordinate system. Never null.
     */

    public UpAxis getUpAxis()
    {
        return this.upAxis;
    }


    /**
     * Sets the orientation of the coordinate system.
     *
     * @param upAxis
     *            The coordinate system orientation to set. Most nut be null.
     */

    public void setUpAxis(final UpAxis upAxis)
    {
        if (upAxis == null)
            throw new IllegalArgumentException("upAxis must not be null");
        this.upAxis = upAxis;
    }
}
