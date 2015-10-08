package fr.istic.gli;

import java.awt.Color;

public class Model  {

	
	  public String name;
	  public double[] value;
	  public Color[]  color;
	  public String[] description;
	  public Double[] donnees;
	 
	  
	  
	  
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model(String name, double[] value, Color[] color, String[] description, Double[] donnees) {
		super();
		this.name = name;
		this.value = value;
		this.color = color;
		this.description = description;
		this.donnees = donnees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double[] getValue() {
		return value;
	}
	public void setValue(double[] value) {
		this.value = value;
	}
	public Color[] getColor() {
		return color;
	}
	public void setColor(Color[] color) {
		this.color = color;
	}
	public String[] getDescription() {
		return description;
	}
	public void setDescription(String[] description) {
		this.description = description;
	}
	public Double[] getDonnees() {
		return donnees;
	}
	public void setDonnees(Double[] donnees) {
		this.donnees = donnees;
	}

	  

	

	
}
