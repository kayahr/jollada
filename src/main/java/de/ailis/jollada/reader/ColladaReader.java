/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import de.ailis.jollada.exceptions.ParserException;
import de.ailis.jollada.model.Document;


/**
 * Reads a COLLADA file.
 *
 * @author Klaus Reimer <k@ailis.de>
 */

public class ColladaReader
{
    /**
     * Reads a COLLADA document from the specified file and returns it.
     *
     * @param filename
     *            The name of the file to read.
     * @return The COLLADA document.
     * @throws ParserException
     *             When COLLADA document could not be read.
     */

    public Document read(final String filename)
    {
        return read(new File(filename));
    }


    /**
     * Reads a COLLADA document from the specified file and returns it.
     *
     * @param file
     *            The file to read.
     * @return The COLLADA document.
     * @throws ParserException
     *             When COLLADA document could not be read.
     */

    public Document read(final File file)
    {
        try
        {
            final InputStream stream = new FileInputStream(file);
            try
            {
                return read(stream);
            }
            finally
            {
                stream.close();
            }
        }
        catch (final IOException e)
        {
            throw new ParserException("Unable to read collada document: " + e,
                e);
        }
    }


    /**
     * Reads a COLLADA document from the specified input stream and returns
     * it.
     *
     * @param stream
     *            The stream from which to read the COLLADA document
     * @return The COLLADA document
     * @throws ParserException
     *             When COLLADA document could not be read
     */

    public Document read(final InputStream stream)
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
