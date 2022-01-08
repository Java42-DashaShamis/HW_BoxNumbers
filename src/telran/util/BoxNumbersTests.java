package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoxNumbersTests {
	BoxNumbers bnArrayList = new BoxNumbersArrayList();
	BoxNumbers bnLinkedList = new BoxNumbersLinkedList();
	BoxNumbers bnHashSet = new BoxNumbersHashSet();
	BoxNumbers bnTreeSet = new BoxNumbersTreeSet();
	
	int [] list = {10,-20,30,8,-50,12,76,0,30,40,12,-10,-50};//-50,-20,-10,0,8,10,12,30,40,76

	@BeforeEach
	void setUp() throws Exception {
		fillCollection(bnArrayList, list);
		fillCollection(bnLinkedList, list);
		fillCollection(bnHashSet, list);
		fillCollection(bnTreeSet, list);
	}

	private void fillCollection(BoxNumbers col, int[] list) {
		for(int i = 0; i < list.length; i++) {
			col.addNumber(list[i]);
		}
		
	}

	@Test
	void addTest() {
		assertTrue(bnArrayList.addNumber(100));
		assertTrue(bnLinkedList.addNumber(100));
		assertTrue(bnHashSet.addNumber(100));
		assertFalse(bnHashSet.addNumber(100));
		assertTrue(bnTreeSet.addNumber(100));
		assertFalse(bnTreeSet.addNumber(100));
	}
	
	@Test
	void removeTest() {
		assertTrue(bnArrayList.removeNumber(8));
		assertFalse(bnArrayList.removeNumber(8));
		
		assertTrue(bnLinkedList.removeNumber(8));
		assertFalse(bnLinkedList.removeNumber(8));
		
		assertTrue(bnHashSet.removeNumber(8));
		assertFalse(bnHashSet.removeNumber(8));
		assertTrue(bnHashSet.removeNumber(12));
		assertFalse(bnHashSet.removeNumber(12));
		
		assertTrue(bnTreeSet.removeNumber(8));
		assertFalse(bnTreeSet.removeNumber(8));
		assertTrue(bnTreeSet.removeNumber(12));
		assertFalse(bnTreeSet.removeNumber(12));
	}
	
	@Test
	void removeRepeatedTest() {
		assertEquals(3, bnArrayList.removeRepeated());
		assertEquals(3, bnLinkedList.removeRepeated());
		assertEquals(0, bnHashSet.removeRepeated());
		assertEquals(0, bnTreeSet.removeRepeated());
	}
	
	@Test
	void removeByPredicateTest() {
		assertEquals(4, bnArrayList.removeByPredicate(new GreaterPredicate(20)));
		assertEquals(0, bnArrayList.removeByPredicate(new GreaterPredicate(20)));
		
		assertEquals(4, bnLinkedList.removeByPredicate(new GreaterPredicate(20)));
		assertEquals(0, bnLinkedList.removeByPredicate(new GreaterPredicate(20)));
		
		assertEquals(3, bnHashSet.removeByPredicate(new GreaterPredicate(20)));
		assertEquals(0, bnHashSet.removeByPredicate(new GreaterPredicate(20)));
		
		assertEquals(3, bnTreeSet.removeByPredicate(new GreaterPredicate(20)));
		assertEquals(0, bnTreeSet.removeByPredicate(new GreaterPredicate(20)));
	}
	
	@Test
	void removeInRangeTest() {
		assertEquals(6, bnArrayList.removeInRange(8,40));
		assertEquals(0, bnArrayList.removeInRange(8,40));
		assertEquals(0, bnArrayList.removeInRange(50,40));
		
		assertEquals(6, bnLinkedList.removeInRange(8,40));
		assertEquals(0, bnLinkedList.removeInRange(8,40));
		assertEquals(0, bnLinkedList.removeInRange(50,40));
		
		assertEquals(4, bnHashSet.removeInRange(8,40));
		assertEquals(0, bnHashSet.removeInRange(8,40));
		assertEquals(0, bnHashSet.removeInRange(50,40));
		
		
		assertEquals(4, bnTreeSet.removeInRange(8,40));
		assertEquals(0, bnTreeSet.removeInRange(8,40));
		boolean fl = false;
		try {
			bnTreeSet.removeInRange(50,40);
		} catch (IllegalArgumentException e) {
			fl = true;
		}
		assertTrue(fl);
	}
	
	@Test
	void containsTest() {
		assertTrue(bnArrayList.containsNumber(8));
		assertFalse(bnArrayList.containsNumber(33));
		bnArrayList.removeNumber(8);
		assertFalse(bnArrayList.containsNumber(8));
		bnArrayList.removeNumber(30);
		assertTrue(bnArrayList.containsNumber(30));
		
		assertTrue(bnLinkedList.containsNumber(8));
		assertFalse(bnLinkedList.containsNumber(33));
		bnLinkedList.removeNumber(8);
		assertFalse(bnLinkedList.containsNumber(8));
		bnLinkedList.removeNumber(30);
		assertTrue(bnLinkedList.containsNumber(30));
		
		assertTrue(bnHashSet.containsNumber(8));
		assertFalse(bnHashSet.containsNumber(33));
		bnHashSet.removeNumber(8);
		assertFalse(bnHashSet.containsNumber(8));
		bnHashSet.removeNumber(30);
		assertFalse(bnHashSet.containsNumber(30));
		
		assertTrue(bnTreeSet.containsNumber(8));
		assertFalse(bnTreeSet.containsNumber(33));
		bnTreeSet.removeNumber(8);
		assertFalse(bnTreeSet.containsNumber(8));
		bnTreeSet.removeNumber(30);
		assertFalse(bnTreeSet.containsNumber(30));
		
	}

}
