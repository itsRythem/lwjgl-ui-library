package me.rythem.ui.animation;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimationHandler {

	private List<Animation> animations = new ArrayList<Animation>();
	private int fps;
	
	public AnimationHandler(int fps) {
		this.fps = fps;
	}
	
	public AnimationHandler init() {
		new Thread(() -> {
			Runnable animationExecutor = new Runnable() {
			    public void run() {
			    	for(Animation animation : animations)
			    		animation.update();
			    }
			};
			
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
			executor.scheduleAtFixedRate(animationExecutor, 0, (1000 / this.fps), TimeUnit.MILLISECONDS);
		}).start();
		return this;
	}

	protected void put(Animation animation) {
		animations.add(animation);
	}
	
}
