package syntax;

import static java.lang.Integer.MAX_VALUE;

public class StaticImportBeispiel {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		
		// Integer.MAX_VALUE mit static import
		System.out.println(MAX_VALUE);
	}

}
