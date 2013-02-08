package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.Fizzbuzz;
import heignamerican.InverseFizzbuzz.InverseFizzbuzz;
import heignamerican.InverseFizzbuzz.Result;

public class TetsuzukiInverseFizzbuzz implements InverseFizzbuzz {
	private final int MIN;
	private final int MAX;
	private final int LOWER;
	private final int UPPER;

	public TetsuzukiInverseFizzbuzz(int aMin, int aMax) {
		MIN = aMin;
		MAX = aMax;

		LOWER = MIN - 1;
		UPPER = MAX + 1;
	}

	@Override
	public Result get(final Fizzbuzz... aInput) {
		if (aInput.length == 0)
			throw new IllegalArgumentException();

		int tMin = LOWER;
		int tMax = UPPER;

		START_LOOP: for (int tStart = MIN; tStart < MAX; tStart++) {
			int tIndex = 0;

			for (int tNumber = tStart; tNumber < MAX; tNumber++) {
				if (isFizzbuzz(tNumber)) {
					if (aInput[tIndex].equals(toFizzbuzz(tNumber))) {
						tIndex++;
						if (tIndex == aInput.length) {
							final int tCurrentHaba = tMax - tMin + 1;
							final int tNewHaba = tNumber - tStart + 1;

							if (tNewHaba < tCurrentHaba) {
								tMin = tStart;
								tMax = tNumber;

								if (tNewHaba == aInput.length) {
									return Result.result(tMin, tMax);
								}
							}
							continue START_LOOP;
						}
					} else {
						continue START_LOOP;
					}
				}
			}
		}
		if (tMin == LOWER || tMax == UPPER)
			return Result.none();
		return Result.result(tMin, tMax);
	}

	public static boolean isFizzbuzz(int aNumber) {
		return aNumber % 3 == 0 || aNumber % 5 == 0;
	}

	public static Fizzbuzz toFizzbuzz(int aNumber) {
		if (aNumber % 15 == 0)
			return Fizzbuzz.FIZZBUZZ;
		if (aNumber % 3 == 0)
			return Fizzbuzz.FIZZ;
		if (aNumber % 5 == 0)
			return Fizzbuzz.BUZZ;
		throw new IllegalArgumentException();
	}
}
