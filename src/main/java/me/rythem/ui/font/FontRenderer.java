package me.rythem.ui.font;

import static me.rythem.ui.helpers.Graphics.*;

import java.awt.Color;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import org.newdawn.slick.TrueTypeFont;

public class FontRenderer {

	private TrueTypeFont ttfFont;
	
	private Font font;
	private int type, size;
	private boolean isInitialized;
	
	public FontRenderer(Font font, FontType type, int size) {
		this.font = font;
		this.type = type.get();
		this.size = size;
	}

	public FontRenderer init() {
		if(isInitialized())return this;

		java.awt.Font font;
		try {
			font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new File(this.font.getPath()));
			font.deriveFont(type, size);
			this.ttfFont = new TrueTypeFont(font, false);
		}catch (Exception e) {
			e.printStackTrace();
		}
		isInitialized = true;

		return this;
	}
	
	public boolean isInitialized() {
		return this.isInitialized;
	}
	
	public int getStringWidth(String text) {
		return this.ttfFont.getWidth(text);
	}
	
	public int getStringHeight(String text) {
		return this.ttfFont.getHeight(text);
	}
	
	public int getHeight() {
		return this.ttfFont.getHeight();
	}
	
	public void drawString(String text, int x, int y, int color) {
		color(color);
		this.ttfFont.drawString(x, y, text);
	}
	
	public void drawCenteredString(String text, int x, int y, int color) {
		color(color);
		this.ttfFont.drawString(x - (getStringWidth(text) / 2), y, text);
	}
	
	public void drawStringWithShadow(String text, int x, int y, int color) {
		color(new Color(color).darker().getRGB());
		this.ttfFont.drawString(x + 0.5f, y + 0.5f, text);
		color(color);
		this.ttfFont.drawString(x, y, text);
	}
	
	public void drawCenteredStringWithShadow(String text, int x, int y, int color) {
		color(new Color(color).darker().getRGB());
		this.ttfFont.drawString(x - (getStringWidth(text) / 2) + 0.5f, y + 0.5f, text);
		color(color);
		this.ttfFont.drawString(x - (getStringWidth(text) / 2), y, text);
	}
	
}
