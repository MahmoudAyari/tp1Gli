package fr.istic.gli;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

class View extends JComponent implements MouseListener {

	Model model;
	Controller controller;

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
			startAngle = (int) (curValue * 360 / total);
			int arcAngle = (int) (model.value[i] * 360 / total);

			g.setColor(model.color[i]);
			g.fillArc(200, 200, 200, 200, startAngle, arcAngle);
			curValue += model.value[i];

			g.setColor(Color.white);
			g.fillOval(213, 214, 175, 175);
			g.setColor(Color.lightGray);
			g.fillOval(228, 230, 145, 145);

			g.setFont(new Font("Arial", Font.BOLD, 14));
			g.setColor(Color.WHITE);

			g.drawString(model.getName(), 270, 280);

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		controller.setX(e.getX());
		controller.setY(e.getY());
		
		 System.out.println("x  "+controller.getX());
	     System.out.println("y  "+controller.getY()); 
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