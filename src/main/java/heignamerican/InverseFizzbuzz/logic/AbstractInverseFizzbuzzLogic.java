package heignamerican.InverseFizzbuzz.logic;

import heignamerican.InverseFizzbuzz.Fizzbuzz;
import heignamerican.InverseFizzbuzz.InverseFizzbuzz;
import heignamerican.InverseFizzbuzz.Result;

public abstract class AbstractInverseFizzbuzzLogic implements InverseFizzbuzz {
	protected final int MIN;
	protected final int MAX;

	public AbstractInverseFizzbuzzLogic(int aMin, int aMax) {
		MIN = aMin;
		MAX = aMax;
	}

	public final Result get(Fizzbuzz... aInput) {
		if (aInput.length == 0)
			throw new IllegalArgumentException();
		return getReal(aInput);
	}

	public abstract Result getReal(Fizzbuzz... aInput);
}