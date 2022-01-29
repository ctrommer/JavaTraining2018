package providenKlasse;

import com.google.inject.Inject;

class HausmeisterImpl implements Hausmeister {
	private String name;
	private Integer geburtsjahr;
	
	@Inject
	public HausmeisterImpl(String name, Integer geburtsjahr) {
		this.name = name;
		this.geburtsjahr = geburtsjahr;
	}

	@Override
	public String toString() {
		return "HausmeisterImpl [name=" + name + ", geburtsjahr=" + geburtsjahr + "]";
	}

}
