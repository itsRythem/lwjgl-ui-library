package me.rythem.ui;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import me.rythem.ui.events.ScreenHandler;
import me.rythem.ui.helpers.Mouse;
import me.rythem.ui.settings.Flags;

import java.awt.Color;
import java.nio.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Window {

	private String title;
	private GLFWWindowSizeCallback sizeCallback;
	private int width, height;
	private ScreenHandler screenHandler;
	private Color backgroundColor;
	private long id;

	public Window(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		flagsHandler = new FlagHandler(this);
	}
	
	/**
	 * initialize the window
	 */
	public Window start() {
		init();
		loop();

		glfwFreeCallbacks(id);
		glfwDestroyWindow(id);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
		
		return (this != null ? this : new Window("Undefined", 100, 100));
	}
	
	/**
	 * returns the windows id
	 */
	public long getId() {
		return id;
	}

	/**
	 * sets the screen for the window to handle
	 * @param screenHandler
	 */
	public Window setScreenHandler(ScreenHandler screenHandler) {
		this.screenHandler = screenHandler;
		return this;
	}
	
	/**
	 * sets the background color of the window
	 * @param red
	 * @param green
	 * @param blue
	 */
	public Window setBackgroundColor(int red, int green, int blue) {
		this.backgroundColor = new Color(red, green, blue);
		return this;
	}
	
	private HashMap<Integer, Integer> flags = new HashMap<Integer, Integer>();
	
	private FlagHandler flagsHandler;
	public class FlagHandler {
		
		Window window;
		
		public FlagHandler(Window window) {
			window.flags.put(Flags.HAS_BORDER, Flags.TRUE);
			window.flags.put(Flags.CAN_RESIZE, Flags.TRUE);
			
			this.window = window;
		}
		
		/**
		 * modify a flag
		 * @param flagIn
		 * @param value
		 * @return
		 */
		public Window modify(int flagIn, int value) {
			if(window.flags.containsKey(flagIn)) {
				window.flags.replace(flagIn, value);
			}
			return window;
		}
		
	}
	
	/**
	 * @return all modifiable flags
	 */
	public FlagHandler getFlags() {
		return flagsHandler;
	}

	/**
	 * does most of the glfw stuff
	 */
	private void init() {
		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(Flags.CAN_RESIZE, flags.get(Flags.CAN_RESIZE));
		glfwWindowHint(Flags.HAS_BORDER, flags.get(Flags.HAS_BORDER));
		
		id = glfwCreateWindow(width, height, title, NULL, NULL);
		if (id == NULL)
			throw new RuntimeException("Failed to create the GLFW window");

		glfwSetKeyCallback(id, (window, key, scancode, action, mods) -> {
			if(window != id || screenHandler == null)return;

			screenHandler.keyPressed(key);
		});
		
		glfwSetWindowSizeCallback(id, (window, widthIn, heightIn) -> {
			if(window != id || screenHandler == null)return;
			
			width = widthIn;
			height = heightIn;
			glViewport(0, 0, width, height);
			screenHandler.onResize(widthIn, heightIn);
        });
        
        glfwSetMouseButtonCallback(id, (window, button, action, mods) -> {
			if(window != id || screenHandler == null || button < 0 || button > 3)return;
			
			if(action == GLFW_PRESS) {
				screenHandler.mouseClicked(Mouse.getX(id), Mouse.getY(id), button);
			}else {
				screenHandler.mouseReleased(Mouse.getX(id), Mouse.getY(id), button);
			}
        });

		try (MemoryStack stack = stackPush()) {
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);
			glfwGetWindowSize(id, pWidth, pHeight);
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
			glfwSetWindowPos(id, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
		}

		glfwMakeContextCurrent(id);
		glfwSwapInterval(1);
		glfwShowWindow(id);
		
		if(screenHandler != null)
			screenHandler.initGui();
	}

	/**
	 * creates the window loop
	 */
	private void loop() {
		GL.createCapabilities();
		glClearColor(backgroundColor.getRed() / 255f, backgroundColor.getGreen() / 255f, backgroundColor.getBlue() / 255f, 1.0f);
		
		while(!glfwWindowShouldClose(id)) {
			if(screenHandler == null)continue;
			
			int[] mouseCoords = Mouse.getMouseCoordinates(id);
			int mouseX = mouseCoords[0];
			int mouseY = mouseCoords[1];
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	        glMatrixMode(5889);
	        glLoadIdentity();
	        glOrtho(0.0, this.width / 2.0, this.height / 2.0, 0.0, 1000.0, 3000.0);
	        glTranslated(0.0, 0.0, -2000.0);
	        glClear(16384);
	        glEnable(3553);
	        glEnable(3042);
	        glBlendFunc(770, 771);
			screenHandler.drawScreen(mouseX, mouseY);

			glDisable(3553);
			if(glGetError() != 0) {
				System.err.println("OpenGL Error: #" + GL11.glGetError());
			}
			
			glfwSwapBuffers(id);
			glfwPollEvents();
		}
	}
	
	/**
	 * @param eventListener
	 * @return true if window has a screen
	 */
	public boolean hasScreenListener(ScreenHandler screenHandler) {
		return this.screenHandler != null;
	}

	/**
	 * sets the windows opacity
	 * @param opacity
	 */
	public void setOpacity(float opacity) {
		glfwSetWindowOpacity(id, opacity);
	}
	
	/**
	 * hides the window
	 */
	public void hide() {
		glfwHideWindow(id);
	}
	
	/**
	 * shows the window
	 */
	public void show() {
		glfwShowWindow(id);
	}
	
	/**
	 * sets the window in focus
	 */
	public void setFocused() {
		glfwFocusWindow(id);
	}
	
	/**
	 * sets the position of the window
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y) {
		glfwSetWindowPos(id, 10 + (int)(Math.random() * 1250), 30 + (int)(Math.random() * 1250));
	}
	
}