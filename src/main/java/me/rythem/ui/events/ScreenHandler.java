package me.rythem.ui.events;

import me.rythem.ui.helpers.Mouse;

public abstract class ScreenHandler {

	public abstract void initGui();
	public abstract void drawScreen(int mouseX, int mouseY);
	public abstract void mouseClicked(int mouseX, int mouseY, int button);
	public abstract void mouseReleased(int mouseX, int mouseY, int button);
	public abstract void keyPressed(int key);
	public abstract void keyReleased(int key);
	public abstract void onResize(int width, int height);

}
