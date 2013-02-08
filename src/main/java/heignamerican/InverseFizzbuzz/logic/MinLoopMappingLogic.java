package heignamerican.InverseFizzbuzz.logic;

import static heignamerican.InverseFizzbuzz.Fizzbuzz.isFizzbuzz;
import static heignamerican.InverseFizzbuzz.Fizzbuzz.toFizzbuzz;
import heignamerican.InverseFizzbuzz.Fizzbuzz;
import heignamerican.InverseFizzbuzz.Result;
import heignamerican.myutils.Tuple2;
import heignamerican.myutils.collection.CollectionUtil;
import heignamerican.myutils.collection.ConvertException;
import heignamerican.myutils.collection.Converter;
import heignamerican.myutils.collection.Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinLoopMappingLogic extends AbstractInverseFizzbuzzLogic {
	private final List<Tuple2<Integer, Fizzbuzz>> mLoop;

	public MinLoopMappingLogic(int aMin, int aMax) {
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
	public Result getReal(final Fizzbuzz... aInput) {
		final int tLength = aInput.length;

		try {
			List<Integer> tList = Range.list(0, mLoop.size());
			List<List<Tuple2<Integer, Fizzbuzz>>> tMapped = CollectionUtil.mapping(tList, new Converter<Integer, List<Tuple2<Integer, Fizzbuzz>>>() {
				@Override
				public List<Tuple2<Integer, Fizzbuzz>> convert(Integer aFrom) throws ConvertException {
					return getExtendList(mLoop, aFrom, tLength);
				}
			});
			List<List<Tuple2<Integer, Fizzbuzz>>> tSelected = CollectionUtil.select(tMapped, new Filter<List<Tuple2<Integer, Fizzbuzz>>>() {
				@Override
				public boolean accept(List<Tuple2<Integer, Fizzbuzz>> aEntry) {
					for (int i = 0; i < tLength; i++) {
						if (aEntry.get(i).get2() != aInput[i])
							return false;
					}
					return true;
				}
			});
			List<Result> tMapped2 = CollectionUtil.mapping(tSelected, new Converter<List<Tuple2<Integer, Fizzbuzz>>, Result>() {
				@Override
				public Result convert(List<Tuple2<Integer, Fizzbuzz>> aFrom) throws ConvertException {
					return Result.result(aFrom.get(0).get1(), aFrom.get(tLength - 1).get1());
				}
			});
			List<Result> tSelected2 = CollectionUtil.select(tMapped2, new Filter<Result>() {
				@Override
				public boolean accept(Result aResult) {
					return MIN <= aResult.start && aResult.end <= MAX;
				}
			});

			if (tSelected2.size() == 0)
				return Result.none();

			return Collections.min(tSelected2, new Comparator<Result>() {
				@Override
				public int compare(Result aLeft, Result aRight) {
					return aLeft.getLength() - aRight.getLength();
				}
			});
		} catch (ConvertException aCause) {
			throw new RuntimeException();
		}
	}

	public static class Range {
		/**
		 * @param aStart
		 *            inclusive
		 * @param aEnd
		 *            exclusive
		 * @return
		 */
		public static List<Integer> list(int aStart, int aEnd) {
			List<Integer> tResult = new ArrayList<>();
			for (int i = aStart; i < aEnd; i++)
				tResult.add(i);
			return tResult;
		}
	}

	private List<Tuple2<Integer, Fizzbuzz>> getExtendList(List<Tuple2<Integer, Fizzbuzz>> aLoop, int aStartIndex, int aLength) {
		List<Tuple2<Integer, Fizzbuzz>> tResult = new ArrayList<>();
		for (int i = 0; i < aLength; i++) {
			tResult.add(aLoop.get((aStartIndex + i) % aLoop.size()));
		}
		return tResult;
	}
}
