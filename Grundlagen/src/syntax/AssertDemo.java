package syntax;

public class AssertDemo {

	public static void main(String[] args) {
		
		// F�r die Anwendung aktivieren mit
		// Debug | Debug Configuration | Java Application | Assertions | Arguments | 
		// VM Arguments -ea eintragen | Apply 
		//
		// Die Application muss einmal gelaufen sein, damit unter
		// Java Application �berhaupt Assertions erscheinen.
		assert false: "Hallo";
	
		assert false;
	}

}
