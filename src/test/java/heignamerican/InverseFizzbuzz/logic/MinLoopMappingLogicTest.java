package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.InverseFizzbuzz;

public class MinLoopMappingLogicTest extends InverseFizzbuzzTest {
	@Override
	protected InverseFizzbuzz create() {
		return new MinLoopMappingLogic(MIN, MAX);
	}
}
