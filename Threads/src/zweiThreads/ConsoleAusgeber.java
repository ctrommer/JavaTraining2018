package zweiThreads;

public class ConsoleAusgeber implements Runnable{
	
	private String auszugeben;
	private int	warteZeit;

	public ConsoleAusgeber( String auszugeben, int warteZeit ) {
		super();
		this.auszugeben = auszugeben;
		this.warteZeit = warteZeit;
	}

	// In Schleife Text ausgeben und danach auf andere Threads warten.
	// 10 mal wiederholen.
	@Override
	public void run() {
		for ( Integer index = 0; index < 10; index++ ) {  
			System.out.println( auszugeben );
			synchronized ( this ) {
				try {
					wait( warteZeit );
				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}				
			}
		}
	}
}