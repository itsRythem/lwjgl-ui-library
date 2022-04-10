package me.rythem.ui.animation;

public class Animation {

	private AnimationType animationType;
	private float current, goal, speed;
	
	public Animation(AnimationType animationType, float speed, AnimationHandler handler) {
		this.animationType = animationType;
		this.speed = speed;
		handler.put(this);
	}

	protected void update() {
		if(Math.abs(current - goal) <= 0f) return;
		
		switch(animationType) {
		case LINEAR:{
			current += (goal - current) / speed;
			break;
		}case DEV:{
			current += (goal - current) / (speed * (goal - current));
			break;
		}
		}
	}
	
	
	
}
