package fr.lri.swingstates.canvas.animations.transitions;

import fr.lri.swingstates.animations.ATag;
import fr.lri.swingstates.animations.Animation;
import fr.lri.swingstates.canvas.CStateMachine;

/**
 * <p>
 * A transition triggered by an animation that has just started. For
 * example, one can want to stop an animation <code>animBefore</code> when
 * an animation <code>animAfter</code> starts.
 * 
 * <pre>
 * 	Transition tshape = new AnimationStarted(animAfter) {
 * 		public void action() {
 * 			// stops
 * <code>
 * animBefore
 * </code>
 *  animation.
 * 			animBefore.stop();
 * 		}
 * 	}
 * 	
 * </pre>
 * 
 * </p>
 * 
 * @author Caroline Appert
 */
public class AnimationStarted extends AnimationEvent {

	/**
	 * Builds a transition that loops on the current state triggered when
	 * any animation has just started.
	 */
	public AnimationStarted() {
		super(CStateMachine.ANIMATION_STARTED);
	}

	/**
	 * Builds a transition that loops on the current state triggered when an
	 * animation has just started.
	 * 
	 * @param anim
	 *            The animation that fires this transition.
	 */
	public AnimationStarted(Animation anim) {
		super(CStateMachine.ANIMATION_STARTED, anim);
	}

	/**
	 * Builds a transition that loops on the current state triggered when a
	 * tagged animation has just started.
	 * 
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 */
	public AnimationStarted(ATag tagAnim) {
		super(CStateMachine.ANIMATION_STARTED, tagAnim);
	}

	/**
	 * Builds a transition triggered when any animation has just started.
	 * 
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationStarted(String outState) {
		super(CStateMachine.ANIMATION_STARTED, outState);
	}

	/**
	 * Builds a transition triggered when an animation has just started.
	 * 
	 * @param anim
	 *            The animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationStarted(Animation anim, String outState) {
		super(CStateMachine.ANIMATION_STARTED, anim, outState);
	}

	/**
	 * Builds a transition triggered when a tagged animation has just
	 * started.
	 * 
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationStarted(ATag tagAnim, String outState) {
		super(CStateMachine.ANIMATION_STARTED, tagAnim);
	}

}
