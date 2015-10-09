package fr.istic.gli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class View extends JComponent implements MouseListener {

	Model model;
	Controller controller;
	private JTable table;
    private JButton addRow;
    
	View(Model model) {
		this.model = model;
		this.addMouseListener(this);
		controller = new Controller();

	}

	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
			
			
			Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		      arc.setFrame(70, 200, 150, 150);
		      arc.setAngleStart((int) (curValue * 360 / total));
		      arc.setAngleExtent((int) (model.value[i] * 360 / total));
		      curValue += model.value[i];
		      Graphics2D g2 = (Graphics2D) g; 
		      g2.setColor(Color.gray);
		      g2.draw(arc);
		      g2.setColor(model.color[i]);
		      g2.fill(arc);
		      g2.setColor(Color.black);
		      Font font = new Font("Arial", Font.PLAIN, 24);
		      g2.setFont(font);
		      g.drawString("Welcome", 50, 70);
		      g2.setColor(Color.white);
              g2.fillOval(90, 220, 110, 110);
		      g2.setColor(Color.lightGray);
			  g2.fillOval(95, 225, 100, 100);
			
			

		}
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		controller.setX(e.getX());
		controller.setY(e.getY());
		controller.update();
		 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}