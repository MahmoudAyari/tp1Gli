package fr.istic.gli;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

public class Controller {

	static Model model;
	static View view;

	double x;
	double y;

	public Controller() {
		super();
		model = new Model();
		model.setName("Budget");
		model.setColor(new Color[] { Color.black, Color.green, Color.yellow, Color.red, Color.cyan });
		model.setValue(new double[] { 5, 33, 100, 15, 20 });
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void update() {
		for (int i = 0; i < model.getValue().length; i++) {
			if (view.getArcs()[i].contains(x, y)) {

				System.out.println("i =  " +i);
			}
		}

	}

	public static void main(String[] argv) {
		Controller controller = new Controller();
		JFrame frame = new JFrame();
		view = new View(model);
		frame.getContentPane().add(view);
		frame.setSize(700, 600);
		frame.setVisible(true);

	}
}