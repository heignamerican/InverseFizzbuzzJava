package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.InverseFizzbuzz;

public class MinLoopLogicTest extends InverseFizzbuzzTest {
	@Override
	protected InverseFizzbuzz create(int aMin, int aMax) {
		return new MinLoopLogic(aMin, aMax);
	}
}
