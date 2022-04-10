package test;

import javax.swing.JButton;

import org.lwjgl.opengl.GL11;

import me.rythem.ui.Window;
import me.rythem.ui.events.ScreenHandler;
import me.rythem.ui.font.FontHandler;
import me.rythem.ui.font.FontRenderer;
import me.rythem.ui.font.FontType;
import me.rythem.ui.helpers.Fonts;
import me.rythem.ui.settings.Flags;

import static me.rythem.ui.helpers.Graphics.*;

public class Main {

	static Window window;
	
	public static void main(String[] args) {
		window = new Window("Hi bedless lol", 800, 500).setBackgroundColor(6, 7, 24).setScreenHandler(new Screen()).getFlags().modify(Flags.HAS_BORDER, Flags.TRUE).start();
	}
	
	public static class Screen extends ScreenHandler {

		private FontHandler	fontHandler = new FontHandler();
		
		@Override
		public void initGui() {
			fontHandler.initAll();
			
		}
		
		@Override
		public void drawScreen(int mouseX, int mouseY) {

		}

		@Override
		public void mouseClicked(int mouseX, int mouseY, int button) {
			
		}

		@Override
		public void mouseReleased(int mouseX, int mouseY, int button) {
			
		}

		@Override
		public void keyPressed(int key) {
			
		}
		
		@Override
		public void keyReleased(int key) {

		}

		@Override
		public void onResize(int width, int height) {

		}
		
	}
	
}
