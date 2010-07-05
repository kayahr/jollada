/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import java.util.List;


/**
 * Interface for lists with document-aware elements.
 *
 * @author Klaus Reimer <k@ailis.de>
 * @param <T>
 *            The list element type
 */

public interface DocumentList<T extends DocumentAware> extends List<T>,
    DocumentAware
{
    // Empty
}
