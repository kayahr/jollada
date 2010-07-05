/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;



/**
 * Interface for COLLADA asset elements.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public interface AssetElement
{
    /**
     * Returns the asset-management information. For the COLLADA document
     * element this is never null. For all other elements it can be null because
     * asset-management information is optional there.
     *
     * @return The asset-management information. Never null for COLLADA document
     *         element. May be null for others.
     */

    public Asset getAsset();
}
