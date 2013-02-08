package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.Fizzbuzz;
import heignamerican.InverseFizzbuzz.Result;

public class TetsuzukiInverseFizzbuzz extends AbstractInverseFizzbuzzLogic {
	private final int LOWER;
	private final int UPPER;

	public TetsuzukiInverseFizzbuzz(int aMin, int aMax) {
		super(aMin, aMax);

		LOWER = MIN - 1;
		UPPER = MAX + 1;
	}

	@Override
	public Result getReal(final Fizzbuzz... aInput) {
		int tMin = LOWER;
		int tMax = UPPER;

		START_LOOP: for (int tStart = MIN; tStart < MAX; tStart++) {
			int tIndex = 0;

			for (int tNumber = tStart; tNumber < MAX; tNumber++) {
				if (Fizzbuzz.isFizzbuzz(tNumber)) {
					if (aInput[tIndex].equals(Fizzbuzz.toFizzbuzz(tNumber))) {
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
}
