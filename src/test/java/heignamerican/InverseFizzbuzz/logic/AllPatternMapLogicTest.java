package heignamerican.InverseFizzbuzz.logic;

import org.junit.Before;

public class AllPatternMapLogicTest extends InverseFizzbuzzTest {
	@Before
	public void setUp() {
		mInverseFizzbuzz = new AllPatternMapLogic(MIN, MAX);
	}
}
