package heignamerican.InverseFizzbuzz;

public class Result {
	public final int start;
	public final int end;
	public final boolean isNone;

	public static Result none() {
		return new Result(-1, -1, true);
	}

	public static Result result(int aNumber) {
		return new Result(aNumber, aNumber, false);
	}

	public static Result result(int aStart, int aEnd) {
		return new Result(aStart, aEnd, false);
	}

	private Result(int aStart, int aEnd, boolean aIsNone) {
		start = aStart;
		end = aEnd;
		isNone = aIsNone;
	}

	@Override
	public String toString() {
		if (isNone)
			return "none.";
		if (start == end)
			return String.format("[%d]", start);
		return String.format("[%d,%d]", start, end);
	}

	public int getLength() {
		return end - start + 1;
	}
}
