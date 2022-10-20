package providenKlasse;

class HausmeisterImpl implements Hausmeister {
	private String name;
	private Integer geburtsjahr;
	
	public HausmeisterImpl(String name, Integer geburtsjahr) {
		this.name = name;
		this.geburtsjahr = geburtsjahr;
	}

	@Override
	public String toString() {
		return "HausmeisterImpl [name=" + name + ", geburtsjahr=" + geburtsjahr + "]";
	}

}
