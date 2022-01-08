package telran.util;

import java.util.TreeSet;


public class BoxNumbersTreeSet extends BoxNumbersSet{
	public BoxNumbersTreeSet() {
		col = new TreeSet<Integer>();
	}
	@Override
	public Integer removeInRange(int minInclusive, int maxExclusive){
		int oldSize = col.size();
		TreeSet<Integer> subset = (TreeSet<Integer>) ((TreeSet<Integer>)col).subSet(minInclusive, true, maxExclusive, false);
		if(subset!=null) {
			subset.clear();
		}
		return oldSize - col.size();
	}
}
