/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.jollada.model;


/**
 * A animation sampler.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class AnimationSampler extends Element implements Identifiable
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The behavior for values before the first key. */
    private AnimationBehavior preBehavior = AnimationBehavior.UNDEFINED;

    /** The behavior for values after the last key. */
    private AnimationBehavior postBehavior = AnimationBehavior.UNDEFINED;

    /** The inputs. */
    private final UnsharedInputs inputs = new UnsharedInputs(this);


    /**
     * Returns the id.
     *
     * @return The id. May be null if not set.
     */

    @Override
    public String getId()
    {
        return this.id;
    }


    /**
     * Sets the id.
     *
     * @param id
     *            The id to set. Null to unset.
     */

    @Override
    public void setId(final String id)
    {
        super.updateId(id);
    }


    /**
     * Returns the behavior for values after the last key.
     *
     * @return The behavior. Never null.
     */

    public AnimationBehavior getPreBehavior()
    {
        return this.preBehavior;
    }


    /**
     * Returns the behavior for values before the first key.
     *
     * @return The behavior. Never null.
     */

    public AnimationBehavior getPostBehavior()
    {
        return this.postBehavior;
    }


    /**
     * Sets the behavior for values before the first key.
     *
     * @param preBehavior
     *            The behavior to set. Must not be null.
     */

    public void setPreBehavior(final AnimationBehavior preBehavior)
    {
        if (preBehavior == null)
            throw new IllegalArgumentException("preBehavior must not be null");
        this.preBehavior = preBehavior;
    }


    /**
     * Sets the behavior for values after the last key..
     *
     * @param postBehavior
     *            The behavior to set. Must not be null.
     */

    public void setPostBehavior(final AnimationBehavior postBehavior)
    {
        if (postBehavior == null)
            throw new IllegalArgumentException("postBehavior must not be null");
        this.postBehavior = postBehavior;
    }


    /**
     * Returns the inputs.
     *
     * @return The inputs. Never null. May be empty.
     */

    public UnsharedInputs getInputs()
    {
        return this.inputs;
    }
}
