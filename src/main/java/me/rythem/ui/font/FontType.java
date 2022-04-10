package me.rythem.ui.font;

import java.awt.Font;

public enum FontType {

	DEFAULT(Font.PLAIN),
	ITALIC(Font.ITALIC),
	BOLD(Font.BOLD);
	
	private int id;
	FontType(int id){
		this.id = id;
	}
	
	public int get() {
		return this.id;
	}
	
}
