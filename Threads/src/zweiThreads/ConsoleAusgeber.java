package zweiThreads;

public class ConsoleAusgeber {
	
	String auszugeben;
	int	warteZeit;

	public ConsoleAusgeber( String auszugeben, int warteZeit ) {
		super();
		this.auszugeben = auszugeben;
		this.warteZeit = warteZeit;
	}

	// In Schleife Text ausgeben und danach auf andere Threads warten.
	// 10 mal wiederholen.
}