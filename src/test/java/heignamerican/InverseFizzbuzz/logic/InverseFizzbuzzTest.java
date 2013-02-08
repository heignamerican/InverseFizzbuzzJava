package heignamerican.InverseFizzbuzz.logic;

import static heignamerican.InverseFizzbuzz.Fizzbuzz.*;
import static heignamerican.InverseFizzbuzz.ResultMatcher.*;
import static org.hamcrest.MatcherAssert.*;
import heignamerican.InverseFizzbuzz.InverseFizzbuzz;
import heignamerican.InverseFizzbuzz.Result;

import org.junit.Test;

public abstract class InverseFizzbuzzTest {
	protected static final int MIN = 1;
	protected static final int MAX = 100;

	protected InverseFizzbuzz mInverseFizzbuzz;

	@Test(expected = IllegalArgumentException.class)
	public void testDame() {
		assertThat(mInverseFizzbuzz.get(), is(Result.result(3, 3)));
	}

	@Test
	public void test() {
		assertThat(mInverseFizzbuzz.get(FIZZ), is(Result.result(3)));
		assertThat(mInverseFizzbuzz.get(BUZZ), is(Result.result(5)));
		assertThat(mInverseFizzbuzz.get(FIZZ, BUZZ), is(Result.result(9, 10)));
		assertThat(mInverseFizzbuzz.get(BUZZ, FIZZ), is(Result.result(5, 6)));

		assertThat(mInverseFizzbuzz.get(FIZZBUZZ), is(Result.result(15)));

		assertThat(mInverseFizzbuzz.get(FIZZ, BUZZ, FIZZ), is(Result.result(3, 6)));
		assertThat(mInverseFizzbuzz.get(FIZZ, FIZZ), is(Result.result(6, 9)));
		assertThat(mInverseFizzbuzz.get(FIZZ, FIZZ, BUZZ), is(Result.result(6, 10)));
	}

}