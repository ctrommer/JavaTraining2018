package schiff;

import java.time.LocalDateTime;

public class Ship {
	
	private String name;
	private String colour;
	private double weightInLBS;
	private LocalDateTime startConversion;
	private LocalDateTime endConversion;
	
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

	public LocalDateTime getStartConversion() {
		return startConversion;
	}

	public void setStartConversion(LocalDateTime startConversion) {
		this.startConversion = startConversion;
	}

	public LocalDateTime getEndConversion() {
		return endConversion;
	}

	public void setEndConversion(LocalDateTime endConversion) {
		this.endConversion = endConversion;
	}

}
