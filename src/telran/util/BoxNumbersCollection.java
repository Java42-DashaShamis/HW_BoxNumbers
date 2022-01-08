package telran.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;


public abstract class BoxNumbersCollection implements BoxNumbers {
	protected Collection <Integer> col;

	public boolean addNumber(int num) {
		return col.add(num);
	}
	public boolean removeNumber(int num) {
		return col.remove(num);
	}
	public Integer removeByPredicate(Predicate<Integer> predicate) {
		int sizeOld = col.size();
		Iterator<Integer> it = iterator();
		while(it.hasNext()) {
			if(predicate.test(it.next())) {
				it.remove();
			}
		}
		return sizeOld - col.size();
	}
	public Integer removeInRange(int minInclusive, int maxExclusive) {
		return removeByPredicate(num -> num >= minInclusive && num < maxExclusive);
	}
	public boolean containsNumber(int num) {
		return col.contains(num);
	}
	public Iterator<Integer> iterator() {
		return col.iterator();
	}
}
