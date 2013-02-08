package heignamerican.InverseFizzbuzz.logic;

import static heignamerican.InverseFizzbuzz.Fizzbuzz.isFizzbuzz;
import static heignamerican.InverseFizzbuzz.Fizzbuzz.toFizzbuzz;
import heignamerican.InverseFizzbuzz.Fizzbuzz;
import heignamerican.InverseFizzbuzz.Result;
import heignamerican.myutils.Tuple2;
import heignamerican.myutils.collection.CollectionUtil;
import heignamerican.myutils.collection.Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinLoopLogic extends AbstractInverseFizzbuzzLogic {
	private final List<Tuple2<Integer, Fizzbuzz>> mLoop;

	public MinLoopLogic(int aMin, int aMax) {
		super(aMin, aMax);

		mLoop = new ArrayList<>();
		init(mLoop);
	}

	private void init(List<Tuple2<Integer, Fizzbuzz>> aLinkedHashMap) {
		for (int i = 1; i <= 15; i++) {
			if (isFizzbuzz(i)) {
				aLinkedHashMap.add(new Tuple2<Integer, Fizzbuzz>(i, toFizzbuzz(i)));
			}
		}
	}

	@Override
	public Result getReal(Fizzbuzz... aInput) {
		final int tLength = aInput.length;
		List<Result> tResultCandidate = new ArrayList<>();

		LOOP: for (int tFizzbuzzIndex = 0; tFizzbuzzIndex < mLoop.size(); tFizzbuzzIndex++) {
			Tuple2<Integer, Fizzbuzz>[] tExpected = getExtendList(mLoop, tFizzbuzzIndex, tLength);
			for (int i = 0; i < tLength; i++) {
				if (tExpected[i].get2() != aInput[i])
					continue LOOP;
			}
			tResultCandidate.add(Result.result(tExpected[0].get1(), tExpected[tLength - 1].get1()));
		}

		tResultCandidate = CollectionUtil.select(tResultCandidate, new Filter<Result>() {
			@Override
			public boolean accept(Result aResult) {
				return MIN <= aResult.start && aResult.end <= MAX;
			}
		});
		if (tResultCandidate.size() == 0)
			return Result.none();

		Collections.sort(tResultCandidate, new Comparator<Result>() {
			@Override
			public int compare(Result aLeft, Result aRight) {
				return aLeft.getLength() - aRight.getLength();
			}
		});
		return tResultCandidate.get(0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Tuple2<Integer, Fizzbuzz>[] getExtendList(List<Tuple2<Integer, Fizzbuzz>> aLoop, int aStartIndex, int aLength) {
		Tuple2[] tResult = new Tuple2[aLength];
		for (int i = 0; i < aLength; i++) {
			tResult[i] = aLoop.get((aStartIndex + i) % aLoop.size());
		}
		return tResult;
	}
}
