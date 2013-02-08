package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.InverseFizzbuzz;

public class AllPatternMapLogicTest extends InverseFizzbuzzTest {
	@Override
	protected InverseFizzbuzz create(int aMin, int aMax) {
		return new AllPatternMapLogic(aMin, aMax);
	}
}
