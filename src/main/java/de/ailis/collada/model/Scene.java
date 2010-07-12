/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * A scene.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class Scene extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The visual scene instance. */
    private VisualSceneInstance visualSceneInstance;


    /**
     * Returns the visual scene instance.
     *
     * @return The visual scene instance. May be null if not set.
     */

    public VisualSceneInstance getVisualSceneInstance()
    {
        return this.visualSceneInstance;
    }


    /**
     * Sets the visual scene instance.
     *
     * @param visualSceneInstance
     *            The visual scene instance to set.
     * @return This scene for chaining.
     */

    public Scene setVisualSceneInstance(
        final VisualSceneInstance visualSceneInstance)
    {
        if (visualSceneInstance != this.visualSceneInstance)
        {
            // Remove old visual scene instance if present
            if (this.visualSceneInstance != null)
                removeChild(this.visualSceneInstance);

            if (visualSceneInstance != null)
            {
                // Detach new visual scene instance from previous scene
                final Scene scene = visualSceneInstance.getScene();
                if (scene != null) scene.setVisualSceneInstance(null);

                // Add visual scene instance
                addChild(visualSceneInstance);
            }

            this.visualSceneInstance = visualSceneInstance;
        }
        return this;
    }
}
