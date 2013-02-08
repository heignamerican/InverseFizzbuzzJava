package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.InverseFizzbuzz;

public class TetsuzukiInverseFizzbuzzTest extends InverseFizzbuzzTest {
	@Override
	protected InverseFizzbuzz create() {
		return new TetsuzukiInverseFizzbuzz(MIN, MAX);
	}
}
