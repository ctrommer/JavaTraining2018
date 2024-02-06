package singleton;

public enum SingletonWithEnum {
	INSTANCE;

	private String inhalt = "";

	public String getInhalt() {
		return inhalt;
	}

	protected void setInhalt( String inhalt ) {
		this.inhalt = inhalt;
	}

	public static void main(String[] args) {
		SingletonWithEnum.INSTANCE.setInhalt("Test");
		System.out.println( SingletonWithEnum.INSTANCE.getInhalt() );
	}

}
