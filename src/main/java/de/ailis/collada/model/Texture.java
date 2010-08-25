/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A texture.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Texture extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The texture reference. */
    private String texture;

    /** The texcoord reference. */
    private String texcoord;


    /**
     * Constructs a new texture.
     *
     * @param texture
     *            The texture reference. Must not be null.
     * @param texcoord
     *            The texture coordinates reference. Must not be null.
     */


    public Texture(final String texture, final String texcoord)
    {
        setTexture(texture);
        setTexcoord(texcoord);
    }


    /**
     * Returns the texture reference.
     *
     * @return The texture reference. Never null.
     */

    public String getTexture()
    {
        return this.texture;
    }

    /**
     * Sets the texture reference.
     *
     * @param texture
     *            The texture reference to set. Must not be null.
     */

    public void setTexture(final String texture)
    {
        if (texture == null)
            throw new IllegalArgumentException("texture must not be null");
        this.texture = texture;
    }


    /**
     * Returns the texcoord reference.
     *
     * @return The texcoord reference. Never null.
     */

    public String getTexcoord()
    {
        return this.texcoord;
    }


    /**
     * Sets the texcoord reference.
     *
     * @param texcoord
     *            The texcoord to set. Must not be null.
     */

    public void setTexcoord(final String texcoord)
    {
        if (texcoord == null)
            throw new IllegalArgumentException("texcoord must not be null");
        this.texcoord = texcoord;
    }
}
