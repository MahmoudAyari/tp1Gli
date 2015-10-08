package fr.istic.gli;

import java.awt.Color;

import javax.swing.JFrame;


	public class Controller {
		
		
		static Model model;
		static View view;
		
		
		
		  public Controller() {
			super();
			model = new Model();
			model.setName("Budget");
			model.setColor(new Color[] {Color.black,Color.green,Color.yellow,Color.red});
		    model.setValue(new double[]{5,33,100,15});
		  }





		public static void main(String[] argv) {
			Controller controller = new Controller();
		    JFrame frame = new JFrame();
		     
		     view= new View(model);
		    
		    frame.getContentPane().add(view);
		    frame.setSize(600, 500);
		    frame.setVisible(true);

		  }
		}