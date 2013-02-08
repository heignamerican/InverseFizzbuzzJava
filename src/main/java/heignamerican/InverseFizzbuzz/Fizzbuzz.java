package heignamerican.InverseFizzbuzz;

public enum Fizzbuzz {
	FIZZ, //
	BUZZ, //
	FIZZBUZZ, //
	;

	public static boolean isFizzbuzz(int aNumber) {
		return aNumber % 3 == 0 || aNumber % 5 == 0;
	}

	public static Fizzbuzz toFizzbuzz(int aNumber) {
		if (aNumber % 15 == 0)
			return FIZZBUZZ;
		if (aNumber % 3 == 0)
			return FIZZ;
		if (aNumber % 5 == 0)
			return BUZZ;
		throw new IllegalArgumentException();
	}
}
