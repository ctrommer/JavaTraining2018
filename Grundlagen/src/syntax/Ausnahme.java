package syntax;

import javax.management.BadStringOperationException;

public class Ausnahme {

	public static void main(String[] args) {
		
		// Zeigt handeled Exception, mit Teil, der immer aufgerufen wird. 
		try {
			handeledExceptionDemo();
		} catch (BadStringOperationException | NullPointerException exception) {
			exception.printStackTrace();
		} finally {
			System.out.println("\nwird immer aufgerufen");
		}

		// zeigt unhandeled Exception
		unhandeledException();
	}

	/**
	 * @throws BadStringOperationException
	 */
	private static void handeledExceptionDemo() throws BadStringOperationException {
		throw new BadStringOperationException("Falsche String Operation!");
	}

	/**
	 * Wirft eine unbehandelte Ausnahme.
	 */
	private static void unhandeledException() {
		throw new RuntimeException();
	}

}
