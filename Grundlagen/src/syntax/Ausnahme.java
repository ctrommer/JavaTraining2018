package syntax;

import javax.management.BadStringOperationException;

public class Ausnahme {

	public static void main(String[] args) {
		
		try {
			handeledExceptionDemo();
		} catch (BadStringOperationException | NullPointerException exception) {
			exception.printStackTrace();
		} finally {
			System.out.println("\nwird immer aufgerufen");
		}
		
		unhandeledException();
	}

	private static void handeledExceptionDemo() throws BadStringOperationException {
		throw new BadStringOperationException("Falsche String Operation!");
	}

	private static void unhandeledException() {
		throw new RuntimeException();
	}

}
