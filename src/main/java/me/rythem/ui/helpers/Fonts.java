package me.rythem.ui.helpers;

import me.rythem.ui.font.Font;

public class Fonts {

	public static Font ARIAL = new Font("Arial", getFont("Arial.ttf"));
	public static Font VERDANA = new Font("Verdana", getFont("Verdana.ttf"));
	public static Font Comfortaa = new Font("Comfortaa", getFont("Comfortaa.ttf"));
	public static Font Dreamscape = new Font("Dreamscape", getFont("Dreamscape.ttf"));
	
	public static String getFont(String name) {
		return "fonts\\" + name;
	}

}
