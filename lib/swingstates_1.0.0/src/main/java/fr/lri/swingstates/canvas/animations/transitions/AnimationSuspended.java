package fr.lri.swingstates.canvas.animations.transitions;

import java.util.EventObject;

import fr.lri.swingstates.animations.ATag;
import fr.lri.swingstates.animations.Animation;
import fr.lri.swingstates.canvas.CElement;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.events.VirtualCElementEvent;
import fr.lri.swingstates.sm.transitions.Event;

/**
 * <p>
 * A transition triggered by an animation that has just been suspended. For
 * example, one can want to resume an animation <code>animSlept</code>
 * when an animation <code>animAwake</code> is suspended.
 * 
 * <pre>
 * 	Transition tshape = new AnimationSuspended(animAwake) {
 * 		public void action() {
 * 			// resumes
 * <code>
 * animSlept
 * </code>
 *  animation.
 * 			animSlept.resume();
 * 		}
 * 	}
 * 	
 * </pre>
 * 
 * </p>
 * 
 * @author Caroline Appert
 */
public class AnimationSuspended extends AnimationEvent {

	/**
	 * Builds a transition that loops on the current state triggered when
	 * any animation has just been suspended.
	 */
	public AnimationSuspended() {
		super(CStateMachine.ANIMATION_SUSPENDED);
	}

	/**
	 * Builds a transition that loops on the current state triggered when an
	 * animation has just been suspended.
	 * 
	 * @param anim
	 *            The animation that fires this transition.
	 */
	public AnimationSuspended(Animation anim) {
		super(CStateMachine.ANIMATION_SUSPENDED, anim);
	}

	/**
	 * Builds a transition that loops on the current state triggered when a
	 * tagged animation has just been suspended.
	 * 
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 */
	public AnimationSuspended(ATag tagAnim) {
		super(CStateMachine.ANIMATION_SUSPENDED, tagAnim);
	}

	/**
	 * Builds a transition triggered when any animation has just been
	 * supended.
	 * 
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationSuspended(String outState) {
		super(CStateMachine.ANIMATION_SUSPENDED, outState);
	}

	/**
	 * Builds a transition triggered when an animation has just been
	 * supended.
	 * 
	 * @param anim
	 *            The animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationSuspended(Animation anim, String outState) {
		super(CStateMachine.ANIMATION_SUSPENDED, anim, outState);
	}

	/**
	 * Builds a transition triggered when a tagged animation has just been
	 * supended.
	 * 
	 * @param tagAnim
	 *            The tag of the animation that fires this transition.
	 * @param outState
	 *            The name of the output state.
	 */
	public AnimationSuspended(ATag tagAnim, String outState) {
		super(CStateMachine.ANIMATION_SUSPENDED, tagAnim, outState);
	}

}


