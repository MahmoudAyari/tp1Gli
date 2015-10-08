package fr.istic.gli;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;

class View extends JComponent {
 

	Model model;
 
  View(Model model ) {
	    this.model= model;
	   
  }
  
  
  public void paint(Graphics g) {
	  Graphics2D g2 = (Graphics2D)g;
	    RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);
	    
    drawPie((Graphics2D) g, getBounds(), model);
  }

  void drawPie(Graphics2D g, Rectangle area, Model model) {
    double total = 0.0D;
    for (int i = 0; i < model.getValue().length; i++) {
      total += model.value[i];
    }

    double curValue = 0.0D;
    int startAngle = 0;
    for (int i = 0; i < model.getValue().length; i++) {
      startAngle = (int) (curValue * 360 / total);
      int arcAngle = (int) (model.value[i] * 360 / total);

      g.setColor(model.color[i]);
      g.fillArc(200, 200,200, 200, startAngle, arcAngle);
      curValue += model.value[i];
     
		
      
	g.setColor(Color.white);
	g.fillOval(213, 214, 175, 175);
	g.setColor(Color.lightGray);
	g.fillOval(228, 230, 145, 145); 
		
	g.setFont(new Font("Arial", Font.BOLD, 14));
	g.setColor(Color.WHITE);
	

	g.drawString( model.getName() , 270, 280);
		
    }
  }
}