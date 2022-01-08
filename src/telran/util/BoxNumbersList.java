package telran.util;
import java.util.HashSet;
import java.util.Iterator;

public abstract class BoxNumbersList extends BoxNumbersCollection{
	
	@Override
	public Integer removeRepeated() {
		// V.R. It is right to get HashSet directly from Collection
		// There is the way to get Collection directly from HashSet.
		// Think about this way. It is possible to see how it looks at my repository.
		HashSet<Integer> hashset = new HashSet<>(col);
		Iterator<Integer> it = iterator();
		int sizeOld = col.size();
		while(it.hasNext()) {
			int num = it.next();
			if(hashset.contains(num)) {
				hashset.remove(num);
			}else {
				it.remove();
			}
		}
		return sizeOld - col.size();
	}
}
