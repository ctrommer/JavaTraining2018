package providenAnnotation;

class FoersterImpl implements Foerster {
	
	private String name;
	private Integer alter;
	
	public FoersterImpl(String name, Integer alter) {
		this.name = name;
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "FoersterImpl [name=" + name + ", alter=" + alter + "]";
	}
}
