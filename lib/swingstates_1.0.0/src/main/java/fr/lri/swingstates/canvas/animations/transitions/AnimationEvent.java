package fr.lri.swingstates.canvas.animations.transitions;

import java.util.EventObject;

import fr.lri.swingstates.animations.ATag;
import fr.lri.swingstates.animations.Animation;
import fr.lri.swingstates.events.VirtualAnimationEvent;
import fr.lri.swingstates.sm.transitions.Event;

/**
 * <p>
 * A transition triggered by an animation. Animation transitions allow
 * developers to retrieve the animation that fired this transition:
 * 
 * <pre>
 * 	Transition tshape = new AnimationEvent(&quot;anEvent&quot;) {
 * 		public void action() {
 * 			// starts the transition that fired this transition
 * 			getAnimation().start();
 * 		}
 * 	}
 * 	
 * </pre>
 * 
 * </p>
 * 
 * @author Caroline Appert
 */
abstract class AnimationEvent extends Event {

	protected Animation animation = null;
	protected ATag tagAnimation = null;
	protected boolean genericAnimation = true;

	/**
	 * Builds a transition triggered by any animation that loops on the
	 * current state.
	 * 
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered: "AnimationStarted", "AnimationStopped",
	 *            "AnimationSuspended" or "AnimationResumed".
	 */
	protected AnimationEvent(String keyEvent) {
		super(keyEvent);
	}

	/**
	 * Builds a transition triggered by an animation that loops on the
	 * current state.
	 * 
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered: "AnimationStarted", "AnimationStopped",
	 *            "AnimationSuspended" or "AnimationResumed".
	 * @param anim
	 *            The animation that fires this transition.
	 */
	protected AnimationEvent(String keyEvent, Animation anim) {
		super(keyEvent);
		animation = anim;
		genericAnimation = false;
	}

	/**
	 * Builds a transition triggered by a tagged animation that loops on the
	 * current state.
	 * 
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered: "AnimationStarted", "AnimationStopped",
	 *            "AnimationSuspended" or "AnimationResumed".
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 */
	protected AnimationEvent(String keyEvent, ATag tagAnim) {
		super(keyEvent);
		tagAnimation = tagAnim;
		genericAnimation = false;
	}

	/**
	 * Builds a transition triggered by any animation.
	 * 
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered: "AnimationStarted", "AnimationStopped",
	 *            "AnimationSuspended" or "AnimationResumed".
	 * @param outState
	 *            The name of the output state.
	 */
	protected AnimationEvent(String keyEvent, String outState) {
		super(keyEvent, outState);
	}

	/**
	 * Builds a transition triggered by an animation.
	 * 
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered: "AnimationStarted", "AnimationStopped",
	 *            "AnimationSuspended" or "AnimationResumed".
	 * @param anim
	 *            The animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	protected AnimationEvent(String keyEvent, Animation anim, String outState) {
		super(keyEvent, outState);
		animation = anim;
		genericAnimation = false;
	}

	/**
	 * Builds a transition triggered by a tagged animation.
	 * 
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered: "AnimationStarted", "AnimationStopped",
	 *            "AnimationSuspended" or "AnimationResumed".
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	protected AnimationEvent(String keyEvent, ATag tagAnim, String outState) {
		super(keyEvent, outState);
		tagAnimation = tagAnim;
		genericAnimation = false;
	}

	/**
	 * @return the animation that has just fired this transition.
	 */
	public Animation getAnimation() {
		return animation;
	}

	public VirtualAnimationEvent getAnimationEvent() {
		return (VirtualAnimationEvent) triggeringEvent;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return getClass().getSuperclass().getSimpleName() + "(" + animation + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		if (!(eventObject instanceof VirtualAnimationEvent))
			return false;
		if (super.matches(eventObject)) {
			Animation triggeringAnimation = ((VirtualAnimationEvent) eventObject).getAnimation();
			// transition for a given tagged animation
			if (tagAnimation != null) {
				if (tagAnimation.tagsAnimation(triggeringAnimation)) {
					animation = triggeringAnimation;
					return true;
				} else {
					return false;
				}
			} else {
				// generic transition
				if (genericAnimation) {
					animation = triggeringAnimation;
					return true;
					// transition for a given animation
				} else {
					return triggeringAnimation == animation;
				}
			}
		} else
			return false;
	}
}
