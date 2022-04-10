package me.rythem.ui.helpers;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.opengl.GL11;

public class Graphics {

	public static void color(int hex) {
        float red = (float)(hex >> 24 & 255) / 255.0F;
        float green = (float)(hex >> 16 & 255) / 255.0F;
        float blue = (float)(hex >> 8 & 255) / 255.0F;
        float alpha = (float)(hex & 255) / 255.0F;
        glColor4f(red, green, blue, alpha);
	}
	
	public static void circle(int x, int y, int radius, int width, int points, int color) {
		GL11.glLineWidth(width); 
		GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glBegin(GL11.GL_LINE_LOOP); 
		for(int i = 0; i < points; i++) { 
			GL11.glVertex2f(x + (int) (radius * Math.cos((2.0f * 3.1415926f * i / points))), y + (int) (radius * Math.sin((2.0f * 3.1415926f * i / points))));
		}
		GL11.glEnd();
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glLineWidth(1); 
	}
	
	public static void rectangle(int x, int y, int x2, int y2, int color) {
		color(color);

		glBegin(GL_QUADS);
		{
	        glVertex2d(x, y2);
	        glVertex2d(x2, y2);
	        glVertex2d(x2, y);
	        glVertex2d(x, y);
		}
		glEnd();
	}
	
	public static void rectangle_gradient(int x, int y, int x2, int y2, boolean direction, int color1, int color2) {
		glBegin(GL_QUADS);
		{
			color(color1);
			if(direction) {
				glVertex2f(x, y);
				glVertex2f(x, y2);
				color(color2);
				glVertex2f(x2, y2);
				glVertex2f(x2, y);
			}else {
				glVertex2f(x, y);
				color(color2);
				glVertex2f(x, y2);
				glVertex2f(x2, y2);
				color(color1);
				glVertex2f(x2, y);
			}
		}
		glEnd();
	}
	
	public static void rectangle_gradient_4(int x, int y, int x2, int y2, int color1, int color2, int color3, int color4) {
		glBegin(GL_QUADS);
		{
			color(color1);
			glVertex2f(x, y2);
			color(color2);
			glVertex2f(x2, y2);
			color(color3);
			glVertex2f(x2, y);
			color(color4);
			glVertex2f(x, y);
		}
		glEnd();
	}
	
	
	public static void rounded_rectangle(int x, int y, int x2, int y2, int radius, int color) {
		glPushAttrib(0);
		glScaled(0.5D, 0.5D, 0.5D);
		x *= 2.0D;
		y *= 2.0D;
		x2 *= 2.0D;
		y2 *= 2.0D;
		int i;

		color(color);
		
		glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);

		glEnable(GL_LINE_SMOOTH);		
		glBegin(GL_POLYGON);
		{
			for (i = 0; i <= 90; i += 3)
				glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
			for (i = 90; i <= 180; i += 3)
				glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y2 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
			for (i = 0; i <= 90; i += 3)
				glVertex2d(x2 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y2 - radius + Math.cos(i * Math.PI / 180.0D) * radius); 
			for (i = 90; i <= 180; i += 3)
				glVertex2d(x2 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius); 
		}
		glEnd();
		glDisable(GL_LINE_SMOOTH);
		
		glEnable(GL_LINE_SMOOTH);
		glBegin(GL_LINE_LOOP);
		{
			for (i = 0; i <= 90; i += 3)
				glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
			for (i = 90; i <= 180; i += 3)
				glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y2 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
			for (i = 0; i <= 90; i += 3)
				glVertex2d(x2 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y2 - radius + Math.cos(i * Math.PI / 180.0D) * radius); 
			for (i = 90; i <= 180; i += 3)
				glVertex2d(x2 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius); 
		}
		glEnd();
		glDisable(GL_LINE_SMOOTH);
		
		glScaled(2.0D, 2.0D, 2.0D);
		glPopAttrib();
	}
	
	public static void dropbox(String current, String[] options, int x, int y, int width, int height, int color1, int color2, int color3) {
		
	}
	
}
