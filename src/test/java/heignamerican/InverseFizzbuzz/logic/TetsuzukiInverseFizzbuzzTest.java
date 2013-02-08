package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.InverseFizzbuzz;

public class TetsuzukiInverseFizzbuzzTest extends InverseFizzbuzzTest {
	@Override
	protected InverseFizzbuzz create(int aMin, int aMax) {
		return new TetsuzukiInverseFizzbuzz(aMin, aMax);
	}
}
