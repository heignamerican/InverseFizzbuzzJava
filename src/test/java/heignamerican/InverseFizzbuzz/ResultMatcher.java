package heignamerican.InverseFizzbuzz;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class ResultMatcher extends BaseMatcher<Result> {
	public static Matcher<Result> is(Result aExpected) {
		return new ResultMatcher(aExpected);
	}

	private final Result mExpected;

	public ResultMatcher(Result aExpected) {
		mExpected = aExpected;
	}

	@Override
	public boolean matches(Object aActual) {
		if (mExpected == null || aActual == null)
			return false;
		if (mExpected == aActual)
			return true;
		if (!(aActual instanceof Result))
			return false;

		final Result tActual = (Result) aActual;
		if (mExpected.isNone != tActual.isNone)
			return false;
		if (mExpected.isNone && tActual.isNone)
			return true;
		return mExpected.start == tActual.start && mExpected.end == tActual.end;

	}

	@Override
	public void describeTo(Description aDescription) {
		aDescription.appendValue(mExpected);
	}
}