package telran.util;

import java.util.function.Predicate;

public interface BoxNumbers extends Iterable<Integer> {
	boolean addNumber(int num);
	boolean removeNumber(int num);
	Integer removeRepeated();
	Integer removeByPredicate(Predicate<Integer> predicate);
	Integer removeInRange(int minInclusive, int maxExclusive);
	boolean containsNumber(int num);
}
