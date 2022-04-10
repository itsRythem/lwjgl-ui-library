package me.rythem.ui.helpers;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.DoubleBuffer;

import org.lwjgl.BufferUtils;

import me.rythem.ui.helpers.cursor.CursorType;

public class Mouse {

	public static int[] getMouseCoordinates(long windowId) {
	    DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
	    DoubleBuffer y = BufferUtils.createDoubleBuffer(1);

	    glfwGetCursorPos(windowId, x, y);
	    return new int[] {(int) x.get(), (int) y.get()};
	}
	
	public static int getX(long windowId) {
		return getMouseCoordinates(windowId)[0];
	}
	
	public static int getY(long windowId) {
		return getMouseCoordinates(windowId)[1];
	}
	
	public static void setCursorType(long windowId, CursorType cursorType) {
		glfwSetCursor(windowId, 0);
	}
	
}
