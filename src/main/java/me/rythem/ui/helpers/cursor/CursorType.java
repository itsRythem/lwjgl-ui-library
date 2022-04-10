package me.rythem.ui.helpers.cursor;

import static org.lwjgl.glfw.GLFW.*;

public enum CursorType {

	NORMAL(GLFW_ARROW_CURSOR),
	TEXT(GLFW_IBEAM_CURSOR),
	CROSSHAIR(GLFW_CROSSHAIR_CURSOR),
	POINTING(GLFW_POINTING_HAND_CURSOR),
	GRABBED(GLFW_RESIZE_ALL_CURSOR),
	NOT_ALLOWED(GLFW_NOT_ALLOWED_CURSOR),
	RESIZE_H(GLFW_RESIZE_EW_CURSOR),
	RESIZE_V(GLFW_RESIZE_NS_CURSOR),
	RESIZE_HV(GLFW_RESIZE_NESW_CURSOR);

	private int glfwId;
	CursorType(int glfwId) {
		this.glfwId = glfwId;
	}
	
}
