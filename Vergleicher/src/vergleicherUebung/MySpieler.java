package vergleicherUebung;

public class MySpieler {
	
    private final String name;
    private final Integer alter;
    private final MyZeichenkette spitzname;


    public MySpieler(String name, Integer alter) {
		this.name = name;
		this.alter = alter;
		this.spitzname = new MyZeichenkette("");
	}    

    
    
	public MySpieler(String name, Integer alter, MyZeichenkette spitzname) {
		this.name = name;
		this.alter = alter;
		this.spitzname = spitzname;
	}

	@Override
	public String toString() {
		return "MySpieler [name=" + name + ", alter=" + alter + ", zeichenkette=" + spitzname + "]";
	}

	public String getName() { return name; }
	
    public Integer getAlter() { return alter; }
    
	public MyZeichenkette getSpitzname() {		return spitzname;	}



    
    
    
}
