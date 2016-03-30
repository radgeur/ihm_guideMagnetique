package fr.lri.swingstates.canvas.animations.transitions;

import fr.lri.swingstates.animations.ATag;
import fr.lri.swingstates.animations.Animation;
import fr.lri.swingstates.canvas.CStateMachine;

/**
 * <p>
 * A transition triggered by an animation that has just been resumed. For
 * example, one can want to suspend an animation <code>animAwake</code>
 * when an animation <code>animSlept</code> is resumed.
 * 
 * <pre>
 * 	Transition tshape = new AnimationResumed(animSlept) {
 * 		public void action() {
 * 			// suspends
 * <code>
 * animAwake
 * </code>
 *  animation.
 * 			animAwake.suspend();
 * 		}
 * 	}
 * 	
 * </pre>
 * 
 * </p>
 * 
 * @author Caroline Appert
 */
public class AnimationResumed extends AnimationEvent {

	/**
	 * Builds a transition that loops on the current state triggered when
	 * any animation that has just been resumed.
	 */
	public AnimationResumed() {
		super(CStateMachine.ANIMATION_RESUMED);
	}

	/**
	 * Builds a transition that loops on the current state triggered when an
	 * animation that has just been resumed.
	 * 
	 * @param anim
	 *            The animation that fires this transition.
	 */
	public AnimationResumed(Animation anim) {
		super(CStateMachine.ANIMATION_RESUMED, anim);
	}

	/**
	 * Builds a transition that loops on the current state triggered when a
	 * tagged animation that has just been resumed.
	 * 
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 */
	public AnimationResumed(ATag tagAnim) {
		super(CStateMachine.ANIMATION_RESUMED, tagAnim);
	}

	/**
	 * Builds a transition triggered when any animation that has just been
	 * resumed.
	 * 
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationResumed(String outState) {
		super(CStateMachine.ANIMATION_RESUMED, outState);
	}

	/**
	 * Builds a transition triggered when an animation that has just been
	 * resumed.
	 * 
	 * @param anim
	 *            The animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationResumed(Animation anim, String outState) {
		super(CStateMachine.ANIMATION_RESUMED, anim, outState);
	}

	/**
	 * Builds a transition triggered when a tagged animation that has just
	 * been resumed.
	 * 
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationResumed(ATag tagAnim, String outState) {
		super(CStateMachine.ANIMATION_RESUMED, tagAnim, outState);
	}
}
