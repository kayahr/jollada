/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;




/**
 * A color attribute.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class ColorAttribute extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The opacity definition. */
    private Opaque opaque = Opaque.A_ONE;

    /** The color. */
    private RGBAColor color;

    /** The texture. */
    private Texture texture;


    /**
     * Constructs a color attribute with a color.
     *
     * @param color
     *            The color. Must not be null.
     */

    public ColorAttribute(final RGBAColor color)
    {
        setColor(color);
    }


    /**
     * Constructs a color attribute with a texture.
     *
     * @param texture
     *            The texture. Must not be null.
     */

    public ColorAttribute(final Texture texture)
    {
        setTexture(texture);
    }


    /**
     * Returns the opaque definition.
     *
     * @return The opaque definition
     */

    public Opaque getOpaque()
    {
        return this.opaque;
    }


    /**
     * Sets the opaque definition.
     *
     * @param opaque
     *            The opaque definition to set. Must not be null.
     */

    public void setOpaque(final Opaque opaque)
    {
        if (opaque == null)
            throw new IllegalArgumentException("opaque must not be null");
        this.opaque = opaque;
    }


    /**
     * Returns the color.
     *
     * @return The color. May be null if an other attribute is set.
     */

    public RGBAColor getColor()
    {
        return this.color;
    }


    /**
     * Sets the color. This removes the other color attributes if present.
     *
     * @param color
     *            The color to set. Must not be null.
     */

    public void setColor(final RGBAColor color)
    {
        if (color == null)
            throw new IllegalArgumentException("color must not be null");
        if (this.texture != null)
        {
            removeChild(this.texture);
            this.texture = null;
        }
        if (color != this.color)
        {
            if (this.color != null) removeChild(this.color);
            this.color = color;
            addChild(color);
        }
    }


    /**
     * Returns the texture.
     *
     * @return The texture. May be null if an other color attribute is set.
     */

    public Texture getTexture()
    {
        return this.texture;
    }


    /**
     * Sets the texture. This removes the other color attributes if present.
     *
     * @param texture
     *            The texture to set. Must not be null.
     */

    public void setTexture(final Texture texture)
    {
        if (texture == null)
            throw new IllegalArgumentException("texture must not be null");
        if (this.color != null)
        {
            removeChild(this.color);
            this.color = null;
        }
        if (texture != this.texture)
        {
            if (this.texture != null) removeChild(this.texture);
            this.texture = texture;
            addChild(texture);
        }
    }
}
