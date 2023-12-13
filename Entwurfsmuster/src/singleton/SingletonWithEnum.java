package singleton;

public enum SingletonWithEnum {
	INSTANCE;

	private String inhalt = new String();

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt( String inhalt ) {
		this.inhalt = inhalt;
	}

	public static void main(String[] args) {
		SingletonWithEnum.INSTANCE.setInhalt("Test");
		System.out.println( SingletonWithEnum.INSTANCE.getInhalt() );
	}

}
