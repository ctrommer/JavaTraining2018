package providenAnnotation;

import com.google.inject.Inject;

class FoersterImpl implements Foerster {
	
	private String name;
	private Integer alter;
	
	@Inject
	public FoersterImpl(String name, Integer alter) {
		this.name = name;
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "FoersterImpl [name=" + name + ", alter=" + alter + "]";
	}
}
