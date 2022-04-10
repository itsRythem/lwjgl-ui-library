package me.rythem.ui.helpers;

import static org.lwjgl.glfw.GLFW.*;

public class Keyboard {

	public static String getKeyName(int key) {
		return glfwGetKeyName(key, glfwGetKeyScancode(key));
	}
	
}
