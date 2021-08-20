package vergleicherBeispiel;

public class Spieler {
	
    private final String name;
    private final Integer alter;
    
    public Spieler(String name, Integer alter) {
		this.name = name;
		this.alter = alter;	
	}    

	public String getName() { return name; }	
    public Integer getAlter() { return alter; }    
}
