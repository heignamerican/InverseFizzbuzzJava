package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.InverseFizzbuzz;

public class MinLoopLogicTest extends InverseFizzbuzzTest {
	@Override
	protected InverseFizzbuzz create() {
		return new MinLoopLogic(MIN, MAX);
	}
}
