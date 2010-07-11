/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.io.Serializable;


/**
 * Geographic location information.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class GeographicLocation implements Serializable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The longitude. */
    private float longitude;

    /** The latitude. */
    private float latitude;

    /** The altitude. */
    private float altitude;

    /** The altitude mode. */
    private AltitudeMode altitudeMode;


    /**
     * Constructs a geographic location with the given information.
     *
     * @param longitude
     *            The longitude.
     * @param latitude
     *            The latitude.
     * @param altitude
     *            The altitude relative to ground.
     */

    public GeographicLocation(final float longitude, final float latitude,
        final float altitude)
    {
        setLongitude(longitude);
        setLatitude(latitude);
        setAltitude(altitude);
    }


    /**
     * Constructs a geographic location with the given information.
     *
     * @param longitude
     *            The longitude.
     * @param latitude
     *            The latitude.
     * @param altitude
     *            The altitude.
     * @param altitudeMode
     *            The altitude mode. Must not be null.
     */

    public GeographicLocation(final float longitude, final float latitude,
        final float altitude, final AltitudeMode altitudeMode)
    {
        setLongitude(longitude);
        setLatitude(latitude);
        setAltitude(altitude, altitudeMode);
    }


    /**
     * Returns the longitude.
     *
     * @return The longitude.
     */

    public float getLongitude()
    {
        return this.longitude;
    }


    /**
     * Sets the longitude.
     *
     * @param longitude
     *            The longitude to set.
     * @return This geographic location for chaining.
     */

    public GeographicLocation setLongitude(final float longitude)
    {
        this.longitude = longitude;
        return this;
    }


    /**
     * Returns the latitude.
     *
     * @return The latitude.
     */

    public float getLatitude()
    {
        return this.latitude;
    }


    /**
     * Sets the latitude.
     *
     * @param latitude
     *            The latitude to set.
     * @return This geographic location for chaining.
     */

    public GeographicLocation setLatitude(final float latitude)
    {
        this.latitude = latitude;
        return this;
    }


    /**
     * Returns the altitude.
     *
     * @return The altitude.
     */

    public float getAltitude()
    {
        return this.altitude;
    }


    /**
     * Sets the altitude relative to the ground
     *
     * @param altitude
     *            The altitude to set.
     * @return This geographic location for chaining.
     */

    public GeographicLocation setAltitude(final float altitude)
    {
        setAltitude(altitude, AltitudeMode.RELATIVE_TO_GROUND);
        return this;
    }


    /**
     * Sets the altitude.
     *
     * @param altitude
     *            The altitude to set.
     * @param mode
     *            The altitude mode. Must not be null.
     * @return This geographic location for chaining.
     */

    public GeographicLocation setAltitude(final float altitude,
        final AltitudeMode mode)
    {
        this.altitude = altitude;
        setAltitudeMode(mode);
        return this;
    }


    /**
     * Returns the altitude mode.
     *
     * @return The altitude mode. Never null.
     */

    public AltitudeMode getAltitudeMode()
    {
        return this.altitudeMode;
    }


    /**
     * Sets the altitude mode.
     *
     * @param altitudeMode
     *            The altitude mode to set. Must not be null.
     * @return This geographic location for chaining.
     */

    public GeographicLocation setAltitudeMode(final AltitudeMode altitudeMode)
    {
        if (altitudeMode == null)
            throw new IllegalArgumentException("altitudeMode must not be null");
        this.altitudeMode = altitudeMode;
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
        result = prime * result + Float.floatToIntBits(this.altitude);
        result = prime * result
            + ((this.altitudeMode == null) ? 0 : this.altitudeMode.hashCode());
        result = prime * result + Float.floatToIntBits(this.latitude);
        result = prime * result + Float.floatToIntBits(this.longitude);
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
        final GeographicLocation other = (GeographicLocation) obj;
        if (Float.floatToIntBits(this.altitude) != Float
                .floatToIntBits(other.altitude)) return false;
        if (this.altitudeMode != other.altitudeMode) return false;
        if (Float.floatToIntBits(this.latitude) != Float
                .floatToIntBits(other.latitude)) return false;
        if (Float.floatToIntBits(this.longitude) != Float
                .floatToIntBits(other.longitude)) return false;
        return true;
    }


    /**
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString()
    {
        return "GeographicLocation [longitude=" + this.longitude
            + ", latitude=" + this.latitude + ", altitude=" + this.altitude
            + ", altitudeMode=" + this.altitudeMode + "]";
    }
}
