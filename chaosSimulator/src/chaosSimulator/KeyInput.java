package chaosSimulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import chaosSimulator.DisplayPanel.STATES;

//handles key input
public class KeyInput implements KeyListener{
	private int[] keys;
	
	private boolean isPaused = false;
	private boolean unPressed = true;

	private DisplayPanel displayPanel;
	
	public KeyInput(DisplayPanel dp) {
		keys = new int[256];
		this.displayPanel = dp;
	}
	
	public void tick() {
		if (unPressed && keys[32] == 1) {
			isPaused = !isPaused;
		}
		
		unPressed = keys[32] == 0;
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = 1;
		if(e.getKeyCode() == KeyEvent.VK_E) {
			displayPanel.state = DisplayPanel.STATES.menu;
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			displayPanel.getWorld().setArmX(displayPanel.getWorld().getStartArmX());
			displayPanel.getWorld().setArmY(displayPanel.getWorld().getStartArmY());
			displayPanel.getWorld().getMagnets();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = 0;
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public int[] getKeys() {return keys;}
	public boolean getIsPaused() {return isPaused;}
	
}
