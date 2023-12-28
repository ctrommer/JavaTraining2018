package vergleicherBeispiel;

public class Spieler {
	
    private final String name;
    private final Integer alter;
    private final Zeichenkette spitzname;
    
    public Spieler( String name, Integer alter, String spitzname ) {
		this.name = name;
		this.alter = alter;
		this.spitzname = new Zeichenkette( spitzname );
	}

	public String getName() { return name; }	
    public Integer getAlter() { return alter; }    
    public Zeichenkette getSpitzname() { return spitzname; }
}
