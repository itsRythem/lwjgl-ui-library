package me.rythem.ui.font;

import java.util.HashMap;

import me.rythem.ui.helpers.Fonts;

public class FontHandler {

	/**
	 * hashmap containing all fonts
	 */
	private HashMap<String, FontRenderer> fontRenderers = new HashMap<String, FontRenderer>();
	
	/**
	 * puts a new font into the handler
	 */
	public void put(String name, FontRenderer fontRenderer) {
		fontRenderers.put(name, fontRenderer);
	}
	
	/**
	 * @param name
	 * @return a ttf font renderer if found in hashmap, defaults to arial;plain;20
	 */
	public FontRenderer getFont(String name) {
		if(fontRenderers.containsKey(name)) {
			return fontRenderers.get(name);
		}else {
			fontRenderers.put(name, new FontRenderer(Fonts.ARIAL, FontType.DEFAULT, 20).init());
			return fontRenderers.get(name);
		}
	}
	
	/**
	 * initializes all fonts in the handler
	 */
	public void initAll() {
		for(FontRenderer fontRenderer : fontRenderers.values()) {
			fontRenderer.init();
		}
	}
	
}
