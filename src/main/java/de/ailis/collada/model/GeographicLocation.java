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

public class GeographicLocation implements Serializable
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
     */

    public void setLongitude(final float longitude)
    {
        this.longitude = longitude;
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
     */

    public void setLatitude(final float latitude)
    {
        this.latitude = latitude;
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
     */

    public void setAltitude(final float altitude)
    {
        setAltitude(altitude, AltitudeMode.RELATIVE_TO_GROUND);
    }


    /**
     * Sets the altitude.
     *
     * @param altitude
     *            The altitude to set.
     * @param mode
     *            The altitude mode. Must not be null.
     */

    public void setAltitude(final float altitude, final AltitudeMode mode)
    {
        this.altitude = altitude;
        setAltitudeMode(mode);
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
     */

    public void setAltitudeMode(final AltitudeMode altitudeMode)
    {
        if (altitudeMode == null)
            throw new IllegalArgumentException("altitudeMode must not be null");
        this.altitudeMode = altitudeMode;
    }
}
