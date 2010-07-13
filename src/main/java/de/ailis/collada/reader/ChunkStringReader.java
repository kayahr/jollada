/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.reader;


/**
 * This class parses string values from a number of character array chunks
 * as returned by the SAX parser for example.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public abstract class ChunkStringReader
{
    /** The string builder used for building the strings */
    private final StringBuilder builder = new StringBuilder();


    /**
     * Adds a chunk. For each detected (and complete) string in the chunk it
     * calls the valueFound method. You have to call the finish method after
     * adding all chunks to make sure that the last string is correctly found.
     *
     * @param ch
     *            The character array
     * @param start
     *            The starting index of the chunk in the array
     * @param length
     *            The length of the chunk in the array
     */

    public void addChunk(final char[] ch, final int start, final int length)
    {
        for (int i = start, max = start + length; i < max; i++)
        {
            final char c = ch[i];
            if (c == ' ' || c == '\n' || c == '\t' || c == '\r')
            {
                finish();
            }
            else
            {
                this.builder.append(c);
            }
        }
    }


    /**
     * Adds a chunk. For each detected (and complete) float in the chunk it
     * calls the valueFound method. You have to call the finish method after
     * adding all chunks to make sure that the last float is correctly found.
     *
     * @param chunk
     *            The chunk to add
     */

    public void addChunk(final String chunk)
    {
        addChunk(chunk.toCharArray(), 0, chunk.length());
    }


    /**
     * Finishes processing chunks. Call this after you have added all chunks
     * to make sure that the last string is correctly processed.
     */

    public void finish()
    {
        if (this.builder.length() > 0)
        {
            valueFound(this.builder.toString());
            this.builder.setLength(0);
        }
    }


    /**
     * Called when a string value has been found.
     *
     * @param value
     *            The found string value
     */

    protected abstract void valueFound(String value);
}
