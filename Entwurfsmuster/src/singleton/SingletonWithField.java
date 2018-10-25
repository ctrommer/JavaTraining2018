package singleton;

public class SingletonWithField {
	
	public static final SingletonWithField INSTANCE = new SingletonWithField();
	
	private String inhalt = new String();

	private SingletonWithField() {
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public static void main(String[] args) {		
		SingletonWithField.INSTANCE.setInhalt("Test");
		System.out.println( SingletonWithField.INSTANCE.getInhalt() );
	}

}