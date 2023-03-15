package schiff;

public class Ship {
	
	private String name;
	private String colour;
	private double weightInLBS;
	
	public Ship(String name, String colour, double weightInLBS) {
		super();
		this.name = name;
		this.colour = colour;
		this.weightInLBS = weightInLBS;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getWeightInLBS() {
		return weightInLBS;
	}
	public void setWeightInLBS(double weightInLBS) {
		this.weightInLBS = weightInLBS;
	}

}
