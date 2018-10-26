package syntax;

public class ClassObject {

	public static void main(String[] args) {
		nameDerKlasse();
		klasseErzeugen();
		
		istMotorrad1();
		istMotorrad2();
		istMotorrad3();
	}

	private static void nameDerKlasse() {
		Class<String> clazz1 = String.class;
		System.out.println(clazz1.getSimpleName());
	}
	
	/**
	 * Klasse erzeugen aus Klassename als String
	 */
	private static void klasseErzeugen() {
		try {
			Class<?> clazz2 = Class.forName("syntax.Motorrad");
			
			Motorrad motorrad = (Motorrad) clazz2.newInstance();
			
			System.out.println(motorrad);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static void istMotorrad1() {
		Fahrzeug fahrzeug = new Motorrad(300);
		if ( fahrzeug instanceof Motorrad ) {
			System.out.println("ist ein Motorrad");
		}
		
	}

	private static void istMotorrad2() {
		Fahrzeug fahrzeug = new Motorrad(300);
		
		if( Motorrad.class.isInstance(fahrzeug)) {
			System.out.println("ist ein Motorrad");			
		}
		
	}
	
	private static void istMotorrad3() {
		Fahrzeug fahrzeug = new Motorrad(300);
		
		if ( fahrzeug.getClass() == Motorrad.class ) {
			System.out.println("ist ein Motorrad");			
		}
	}	
	
	
}
