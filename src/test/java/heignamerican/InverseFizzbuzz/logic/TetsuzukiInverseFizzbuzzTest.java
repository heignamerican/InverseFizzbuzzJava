package heignamerican.InverseFizzbuzz.logic;

import org.junit.Before;

public class TetsuzukiInverseFizzbuzzTest extends InverseFizzbuzzTest {
	@Before
	public void setUp() {
		mInverseFizzbuzz = new TetsuzukiInverseFizzbuzz(MIN, MAX);
	}
}
