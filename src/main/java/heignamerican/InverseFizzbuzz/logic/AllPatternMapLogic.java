package heignamerican.InverseFizzbuzz.logic;

import static heignamerican.InverseFizzbuzz.Fizzbuzz.*;

import heignamerican.InverseFizzbuzz.Fizzbuzz;
import heignamerican.InverseFizzbuzz.InverseFizzbuzz;
import heignamerican.InverseFizzbuzz.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPatternMapLogic implements InverseFizzbuzz {
	private final int MIN;
	private final int MAX;
	private final Map<String, Result> mMap;

	public AllPatternMapLogic(int aMin, int aMax) {
		MIN = aMin;
		MAX = aMax;

		mMap = createMap();
	}

	@Override
	public Result get(Fizzbuzz... aInput) {
		if (aInput.length == 0)
			throw new IllegalArgumentException();

		String tInputFizzbuzzString = toString(aInput);

		if (!mMap.containsKey(tInputFizzbuzzString)) {
			return Result.none();
		}
		return mMap.get(tInputFizzbuzzString);
	}

	private Map<String, Result> createMap() {
		Map<String, Result> tMap = new HashMap<>();

		for (int tStart = MIN; tStart < MAX; tStart++) {
			for (int tEnd = tStart; tEnd < MAX; tEnd++) {
				List<Fizzbuzz> tList = new ArrayList<>();
				for (int i = tStart; i <= tEnd; i++) {
					if (isFizzbuzz(i)) {
						tList.add(toFizzbuzz(i));
					}
				}

				if (tList.size() > 0) {
					final String tFizzbuzzString = toString(tList);
					Result tNewResult = Result.result(tStart, tEnd);
					if (!tMap.containsKey(tFizzbuzzString)) {
						tMap.put(tFizzbuzzString, tNewResult);
					} else {
						Result tCurrentResult = tMap.get(tFizzbuzzString);
						if (tNewResult.getLength() < tCurrentResult.getLength()) {
							tMap.put(tFizzbuzzString, tNewResult);
						}
					}
				}
			}
		}
		return tMap;
	}

	private String toString(Fizzbuzz[] aInput) {
		return toString(Arrays.asList(aInput));
	}

	private static String toString(List<Fizzbuzz> aList) {
		StringBuilder tStringBuilder = new StringBuilder();
		for (Fizzbuzz tFizzbuzz : aList) {
			tStringBuilder.append(tFizzbuzz.name());
			tStringBuilder.append(",");
		}
		return tStringBuilder.toString();
	}
}
