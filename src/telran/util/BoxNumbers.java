package telran.util;

import java.util.function.Predicate;

public interface BoxNumbers extends Iterable<Integer> {
	boolean addNumber(int num);
	boolean removeNumber(int num);
	/* V.R. Why each following 3 methods returns Integer?
	 *  Due to class diagram each of them returns int.
	 */
	Integer removeRepeated();
	Integer removeByPredicate(Predicate<Integer> predicate);
	Integer removeInRange(int minInclusive, int maxExclusive);
	boolean containsNumber(int num);
}
