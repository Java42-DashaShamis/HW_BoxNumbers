package telran.util;

import java.util.TreeSet;


public class BoxNumbersTreeSet extends BoxNumbersSet{
	public BoxNumbersTreeSet() {
		col = new TreeSet<Integer>();
	}
	@Override
	public Integer removeInRange(int minInclusive, int maxExclusive){
		// V.R. oldSize is redundant variable
		int oldSize = col.size();
		TreeSet<Integer> subset = (TreeSet<Integer>) ((TreeSet<Integer>)col).subSet(minInclusive, true, maxExclusive, false);
		/* V.R. TreeSet.subset() doesn't return null. So the next check is redundant
		 * The end of this method may look as following
		 * 
		int countRemovedNumbers = subset.size();
		subset.clear();
		return countRemovedNumbers;
		 */
		if(subset!=null) {
			subset.clear();
		}
		return oldSize - col.size();
	}
}
