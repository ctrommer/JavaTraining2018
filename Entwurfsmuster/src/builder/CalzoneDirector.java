package builder;

/**
 * Ein in der Praxis sinnvolles Beispiel f�r den Director habe ich nicht gefunden.
 * Mich duenkt, hier wird nur die Fabrikmethode angewendet und dann in diesem
 * Kontext Director genannt.
 * 
 * Quellen:
 * ( 1 ) Mit Quellcode und Bildchen 
 * https://refactoring.guru/design-patterns/builder
 * hier das Java Codebeispiel f�r den Director anschauen:
 * https://refactoring.guru/design-patterns/builder/java/example#example-0--Demo-java
 * 
 * ( 2 )
 * Erich Gamma ...
 * Der Director wird zwar bei Erich Gamma erw�hnt, aber nicht im Codebeispiel.
 * file:///C:/Users/ctrom/OneDrive/Documents/KnowHow/B%C3%BCcher/Erich%20Gamma/hires/pat3bfso.htm
 * 
 * ( 3 )
 * Curt ...
 * file:///C:/Users/ctrom/OneDrive/Documents/KnowHow/B%C3%BCcher/Curt%20Trommer/Entwurfsmuster/Doku/DesginPatterns.pdf
 *
 */
public class CalzoneDirector {

	public Calzone erzeugeCalzoneMitSosse() {
		return new Calzone.Builder().sosseDrin().build();
	}

}
