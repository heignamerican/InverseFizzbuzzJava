package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.InverseFizzbuzz;

public class MinLoopMappingLogicTest extends InverseFizzbuzzTest {
	@Override
	protected InverseFizzbuzz create(int aMin, int aMax) {
		return new MinLoopMappingLogic(aMin, aMax);
	}
}
