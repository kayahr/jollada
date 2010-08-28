/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * List of effect profiles.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class EffectProfiles extends Elements<EffectProfile>
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;


    /**
     * Constructor.
     *
     * @param parent
     *            The parent element
     */

    EffectProfiles(final Element parent)
    {
        super(parent);
    }


    /**
     * Returns the first common profile.
     *
     * @return The first common profile. May return null if no common profile is
     *         found.
     */

    public CommonEffectProfile getCommonProfile()
    {
        for (final EffectProfile profile : this)
            if (profile instanceof CommonEffectProfile)
                return (CommonEffectProfile) profile;
        return null;
    }
}
