package fr.lri.swingstates.canvas.animations.transitions;

import fr.lri.swingstates.animations.ATag;
import fr.lri.swingstates.animations.Animation;
import fr.lri.swingstates.canvas.CStateMachine;

/**
 * <p>
 * A transition triggered by an animation that has just "naturally" stopped
 * or has just been explicitely stopped. For example, one can want to start
 * an animation <code>animAfter</code> just after an animation
 * <code>animBefore</code> has stopped.
 * 
 * <pre>
 * 	Transition tshape = new AnimationStopped(animBefore) {
 * 		public void action() {
 * 			// starts
 * <code>
 * animAfter
 * </code>
 *  animation.
 * 			animAfter.start();
 * 		}
 * 	}
 * 	
 * </pre>
 * 
 * </p>
 * 
 * @author Caroline Appert
 */
public class AnimationStopped extends AnimationEvent {

	/**
	 * Builds a transition that loops on the current state triggered when
	 * any animation has just stopped.
	 */
	public AnimationStopped() {
		super(CStateMachine.ANIMATION_STOPPED);
	}

	/**
	 * Builds a transition that loops on the current state triggered when an
	 * animation has just stopped.
	 * 
	 * @param anim
	 *            The animation that fires this transition.
	 */
	public AnimationStopped(Animation anim) {
		super(CStateMachine.ANIMATION_STOPPED, anim);
	}

	/**
	 * Builds a transition that loops on the current state triggered when a
	 * tagged animation has just stopped.
	 * 
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 */
	public AnimationStopped(ATag tagAnim) {
		super(CStateMachine.ANIMATION_STOPPED, tagAnim);
	}

	/**
	 * Builds a transition triggered when any animation has just stopped.
	 * 
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationStopped(String outState) {
		super(CStateMachine.ANIMATION_STOPPED, outState);
	}

	/**
	 * Builds a transition triggered when an animation has just stopped.
	 * 
	 * @param anim
	 *            The animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationStopped(Animation anim, String outState) {
		super(CStateMachine.ANIMATION_STOPPED, anim, outState);
	}

	/**
	 * Builds a transition triggered when a tagged animation has just
	 * stopped.
	 * 
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationStopped(ATag tagAnim, String outState) {
		super(CStateMachine.ANIMATION_STOPPED, tagAnim, outState);
	}

}
