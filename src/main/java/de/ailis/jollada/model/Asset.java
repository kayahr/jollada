/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Asset-management information.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Asset implements Serializable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The contributors who worked on the parent element. */
    private final ArrayList<Contributor> contributors =
            new ArrayList<Contributor>();

    /** The creation time stamp. */
    private long created;

    /** The time stamp of the last modification. */
    private long modified;

    /** The geographic location. */
    private GeographicLocation geographicLocation;

    /** List of keywords. */
    private final ArrayList<String> keywords = new ArrayList<String>();

    /** Revision information. */
    private String revision;

    /** The description of the topical subject. */
    private String subject;

    /** The title. */
    private String title;

    /** The unit of distance. */
    private Unit unit = new Unit();

    /** The orientation of the coordinate system. */
    private UpAxis upAxis = UpAxis.Y_UP;


    /**
     * Creates new asset-management information with the created and modified
     * time stamp set to the current time.
     */

    public Asset()
    {
        this(System.currentTimeMillis());
    }


    /**
     * Creates new asset-management information with the created and modified
     * time stamp set to the specified time.
     *
     * @param created
     *            The date and time the parent element was created. Is also used
     *            for the modified time stamp.
     */

    public Asset(final long created)
    {
        this(created, created);
    }


    /**
     * Creates new asset-management information with the created and modified
     * time stamp set to the specified times.
     *
     * @param created
     *            The time stamp when the parent element was created.
     * @param modified
     *            The time stamp when the parent element was last modified.
     */

    public Asset(final long created, final long modified)
    {
        this.created = created;
        this.modified = modified;
    }


    /**
     * Full constructor.
     *
     * @param created
     *            The time stamp when the parent element was created.
     * @param modified
     *            The time stamp when the parent element was last modified.
     * @param unit
     *            The unit of distance. Must not be null.
     * @param upAxis
     *            The up Axis. Must not be null.
     * @param geographicLocation
     *            The geographic location. May be null.
     * @param revision
     *            The revision. May be null.
     * @param subject
     *            The description of the topical subject. May be null.
     * @param title
     *            The title. May be null.
     */

    public Asset(final long created, final long modified, final Unit unit,
        final UpAxis upAxis, final GeographicLocation geographicLocation,
        final String revision, final String subject, final String title)
    {
        this(created, modified);
        setUnit(unit);
        setUpAxis(upAxis);
        this.geographicLocation = geographicLocation;
        this.revision = revision;
        this.subject = subject;
        this.title = title;
    }


    /**
     * Returns the creation time stamp.
     *
     * @return The creation time stamp.
     */

    public long getCreated()
    {
        return this.created;
    }


    /**
     * Sets the creation time stamp.
     *
     * @param created
     *            The creation time stamp to set.
     */

    public void setCreated(final long created)
    {
        this.created = created;
    }


    /**
     * Returns last modification time stamp.
     *
     * @return The last modification time stamp.
     */

    public long getModified()
    {
        return this.modified;
    }


    /**
     * Sets the last modification time stamp.
     *
     * @param modified
     *            The last modification time stamp to set.
     */

    public void setModified(final long modified)
    {
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
     * Returns the description of the topical subject.
     *
     * @return The subject. May be null if not set.
     */

    public String getSubject()
    {
        return this.subject;
    }


    /**
     * Sets the description of the topical subject.
     *
     * @param subject
     *            The subject to set. Null to unset.
     */

    public void setSubject(final String subject)
    {
        this.subject = subject;
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


    /**
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.contributors.hashCode();
        result = prime * result + (int) (this.created ^ (this.created >>> 32));
        result = prime
            * result
            + ((this.geographicLocation == null) ? 0 : this.geographicLocation
                    .hashCode());
        result = prime * result + this.keywords.hashCode();
        result = prime * result
            + (int) (this.modified ^ (this.modified >>> 32));
        result = prime * result
            + ((this.revision == null) ? 0 : this.revision.hashCode());
        result = prime * result
            + ((this.subject == null) ? 0 : this.subject.hashCode());
        result = prime * result
            + ((this.title == null) ? 0 : this.title.hashCode());
        result = prime * result + this.unit.hashCode();
        result = prime * result + this.upAxis.hashCode();
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
        final Asset other = (Asset) obj;
        if (!this.contributors.equals(other.contributors)) return false;
        if (this.created != other.created) return false;
        if (this.geographicLocation == null)
        {
            if (other.geographicLocation != null) return false;
        }
        else if (!this.geographicLocation.equals(other.geographicLocation))
            return false;
        if (!this.keywords.equals(other.keywords)) return false;
        if (this.modified != other.modified) return false;
        if (this.revision == null)
        {
            if (other.revision != null) return false;
        }
        else if (!this.revision.equals(other.revision)) return false;
        if (this.subject == null)
        {
            if (other.subject != null) return false;
        }
        else if (!this.subject.equals(other.subject)) return false;
        if (this.title == null)
        {
            if (other.title != null) return false;
        }
        else if (!this.title.equals(other.title))
            return false;
        else if (!this.unit.equals(other.unit)) return false;
        if (this.upAxis != other.upAxis) return false;
        return true;
    }


    /**
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString()
    {
        return "Asset [contributors=" + this.contributors + ", created="
            + this.created + ", modified=" + this.modified
            + ", geographicLocation=" + this.geographicLocation + ", keywords="
            + this.keywords + ", revision=" + this.revision + ", subject="
            + this.subject + ", title=" + this.title + ", unit=" + this.unit
            + ", upAxis=" + this.upAxis + "]";
    }
}
