package fabrikMethodeAbstrakteFabrik;



/**
 * Erzeuge eine griechische Armee mit Schiffen und Soldaten und eine römische Armee mit Schiffen und Soldaten. 
 * Verwende hierzu die Entwurfsmuster Fabrikmethode und Abstrakte Fabrik. 
 * 
 * Abgrenzung:
 * 
 * - Wenn eine Klasse eine statische Methode hat, um Instanzen von ihr selbst zu erzeugen, ist das noch keine Fabrikmethode.
 * 
 * - Fabrikmethode ist eine Klassenhierachie zum Erzeugen von Instanzen einer Klassenhierachie. In diesem Beispiel ist die Klassenhierachie
 * 		zum Erzeugen der griechischen Armee eine Fabrikmethode.
 * 
 * - Eine abstrakte Fabrik ist eine Mehrfachanwendung der Fabrikmethode.
 *
 */
public abstract class ArmeeAbstrakteFabrik {

	public abstract Soldat erzeugeSoldat();
	public abstract Schiff erzeugeSchiff();
	
	public static void main(String[] args) {
		
		GriechischeArmeeFabrikMethode griechischeArmeeFabrikMethode = new GriechischeArmeeFabrikMethode();
		Schiff griechischesSchiff = griechischeArmeeFabrikMethode.erzeugeSchiff();
		Soldat griechischerSoldat = griechischeArmeeFabrikMethode.erzeugeSoldat();
		
		System.out.println(griechischesSchiff);
		System.out.println(griechischerSoldat);
		
	}

}
