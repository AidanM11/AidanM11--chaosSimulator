package chaosSimulator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class MouseListener extends MouseAdapter{
	private DisplayPanel displayPanel;
	
	public MouseListener(DisplayPanel displayPanel) {
		this.displayPanel = displayPanel;
	}
	
	public void mousePressed(MouseEvent e) {
		LinkedList<Magnet> magnets = this.displayPanel.getWorld().getMagnets();
		boolean canCreate = true;
		for(int i = 0; i < Magnet.totalMagnets; i++) {
			int magX = magnets.get(i).getXPos();
			int magY = magnets.get(i).getYPos();
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			if((mouseX <= magX + 10 && mouseX >= magX -10 && mouseY <= magY +10 && mouseY >= magY -10)) {
				canCreate = false;
				break;
			}
		}
		if(canCreate) {
			int xCoord = e.getX();
			int yCoord = e.getY();
			Magnet a = new Magnet(xCoord, yCoord, displayPanel.getWorld().getDefaultCoef());
			this.displayPanel.getWorld().addMagnet(a);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		System.out.println("dragging");
		LinkedList<Magnet> magnets = this.displayPanel.getWorld().getMagnets();
		for(int i = 0; i< Magnet.totalMagnets; i++) {
			int magX = magnets.get(i).getXPos();
			int magY = magnets.get(i).getYPos();
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			
			if(mouseX <= magX + 10 && mouseX >= magX -10 && mouseY <= magY +10 && mouseY >= magY -10) {
				magnets.get(i).setxPos(mouseX);
				magnets.get(i).setyPos(mouseY);
				
				break;
			}
			
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		
	}
}
