package singleton;


public class SingletonWithFactory {
	
	private static final SingletonWithFactory INSTANCE = new SingletonWithFactory();
	
	private String inhalt = "";

	private SingletonWithFactory() {
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt( String inhalt ) {
		this.inhalt = inhalt;
	}

	protected static SingletonWithFactory getInstance() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		
		SingletonWithFactory.getInstance().setInhalt("Test");
		System.out.println( SingletonWithFactory.getInstance().getInhalt() );

	}

}
