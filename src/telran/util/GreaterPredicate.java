package telran.util;

import java.util.function.Predicate;

public class GreaterPredicate implements Predicate<Integer> {
	
	private Integer number;
	public GreaterPredicate(Integer number) {
		this.number = number;
	}

	@Override
	public boolean test(Integer num) {
		return number < num;
	}

}
