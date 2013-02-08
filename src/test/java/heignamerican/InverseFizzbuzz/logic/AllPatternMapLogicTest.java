package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.InverseFizzbuzz;

public class AllPatternMapLogicTest extends InverseFizzbuzzTest {
	protected InverseFizzbuzz create() {
		return new AllPatternMapLogic(MIN, MAX);
	}
}
