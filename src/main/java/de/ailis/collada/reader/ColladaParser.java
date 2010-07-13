/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.reader;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import de.ailis.collada.model.Document;


/**
 * Parses a COLLADA file.
 *
 * @author Klaus Reimer <k@ailis.de>
 */

public class ColladaParser
{
    /**
     * Parses a COLLADA document from the specified input stream and returns
     * it.
     *
     * @param stream
     *            The stream from which to read the COLLADA document
     * @return The COLLADA document
     * @throws ParserException
     *             When COLLADA document could not be read
     */

    public Document parse(final InputStream stream)
    {
        try
        {
            final ColladaHandler handler = new ColladaHandler();
            final XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(stream));
            return handler.getDocument();
        }
        catch (final IOException e)
        {
            throw new ParserException("Unable to read collada document: " + e,
                    e);
        }
        catch (final SAXException e)
        {
            throw new ParserException("Unable to parse collada document: " + e,
                    e);
        }
    }
}
