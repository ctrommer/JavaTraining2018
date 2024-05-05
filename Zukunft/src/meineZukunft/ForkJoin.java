package meineZukunft;

import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	private final int zahl;

	public ForkJoin(int zahl) {
		this.zahl = zahl;
	}

	/**
	 * Gibt die Zahlen von 1 bis 3 Rekursiv aus.
	 */
	@Override
	protected Integer compute() {
		
		System.out.println( "aus Thread mit Zahl: " + zahl );
		
		if ( zahl >= 3 ) {
			return zahl;
		}
		

		// erzeuge neuen Task
		ForkJoin forkJoinRekursiv = new ForkJoin( zahl + 1 );
		// starte neuen Task
		forkJoinRekursiv.fork();
		
		// gebe Ergebnis von Task zurück, sobald "Berechnung" beendet.
		return forkJoinRekursiv.join();
   }

	public static void main(String[] args) {
		ForkJoin forkJoin = new ForkJoin( 1 );
		Integer ergebnis = forkJoin.compute();
		System.out.println("aus main: " + ergebnis);
	}
	
	@Test
	public void testOhneThreadQuadrieren() {
		try {
			assertEquals( 
					81, 
					ohneThreadQuadrieren( 9 ).get() );
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testInEigenemThreadQuadrieren() {
		try {
			assertEquals( 
					81, 
					inEigenemThreadQuadrieren( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInEigenemThreadQuadrierenDannMit2Multiplizieren() {
		try {
			assertEquals( 
					162, 
					inEigenemThreadQuadrierenDannMit2Multiplizieren( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInEigenemThreadQuadrierenDannMit2InThreadMultiplizieren() {
		try {
			assertEquals( 
					162, 
					inEigenemThreadQuadrierenDannMit2InThreadMultiplizieren( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInEigenemThreadQuadrierenDannMitMit2InThreadMultiplizieren() {
		try {
			assertEquals( 
					162, 
					inEigenemThreadQuadrierenDannMitMit2InThreadMultiplizieren( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}	

	@Test
	public void testErsterThreadQuadriertZweiterThreadMultipliziertMit2Kombiniert() {
		try {
			assertEquals( 
					99, 
					ersterThreadQuadriertZweiterThreadMultipliziertMit2Kombiniert( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDreiTheadsParallelDannGejoint( ) {
		List<Integer> dreiTheadsParallelDannGejoint = dreiTheadsParallelDannGejoint( 9 ).collect( Collectors.toList() );		
		List<Integer> expected = List.of( 81, 18, 90 );
		assertEquals( 
				expected, 
				dreiTheadsParallelDannGejoint );
	}

	@Test
	public void testInEigenemThreadQuadrierenAusnameBehandelnOhneException() {
		try {
			assertEquals( 
					"81", 
					inEigenemThreadQuadrierenAusnameBehandeln( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInEigenemThreadQuadrierenAusnameBehandelnMitException() {
		try {
			assertDoesNotThrow(
							() 
							-> inEigenemThreadQuadrierenAusnameBehandeln( 46341 ).get() );
			
			assertEquals(
					"Zahl zu gross.", 
					inEigenemThreadQuadrierenAusnameBehandeln( 46341 ).get());		
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testErledigeAufgabeUndParallelDazuUnteraufgabeInThread() {
		assertEquals(
				81, 
				erledigeAufgabeUndParallelDazuUnteraufgabeInThread( 9 ) );		
	}
	


	
	
	
	
	
	
}
