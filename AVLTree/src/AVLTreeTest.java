import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class AVLTreeTest {
	
	//private HashSet<Integer> numbers = new HashSet<>();
	
	@Test
	void heightTest() {
		Random rand = new Random();
		HashSet<Integer> numbers = new HashSet<>();
		AVLTree<Integer> currTree = new AVLTree<>();
		for (int i = 0; i < 100; i++) {
			int randomNum = rand.nextInt(-1000, 1000);
			if (numbers.add(randomNum)) {
				currTree.insert(randomNum);
			}
		}
		
		int heightDiff = currTree.getRightHeight() - currTree.getLeftHeight();
		currTree.printTree();
		assertTrue(heightDiff > -2);
		assertTrue(heightDiff < 2);
		assertTrue(currTree.getSize() == numbers.size());
	}
	
	@Test
	void searchTest() {
		Random rand = new Random();
		HashSet<Integer> numbers = new HashSet<>();
		AVLTree<Integer> currTree = new AVLTree<>();
		for (int i = 0; i < 50; i++) {
			int toAdd = rand.nextInt(0, 100);
			if (numbers.add(toAdd)) {
				currTree.insert(toAdd);
			}
		}
		
		assertTrue(currTree.getSize() == numbers.size());
		for (int n : numbers) {
			assertTrue(currTree.search(n) == n);
		}
	}
	
	@Test
	void deleteTest() {
		Random rand = new Random();
		HashSet<Integer> numbers = new HashSet<>();
		AVLTree<Integer> currTree = new AVLTree<>();
		for (int i = 0; i < 50; i++) {
			int toAdd = rand.nextInt(-100, 100);
			if (numbers.add(toAdd)) {
				currTree.insert(toAdd);
			}
		}
		
		int size = currTree.getSize();
		for (int n : numbers) {
			currTree.printTree();
			System.out.println("\nCurrent size is " + currTree.getSize() + "\nActual should be " + size);
			currTree.deleteValue(n);
			size--;
			//numbers.remove(n);
			assertTrue(currTree.search(n) == null);
			if (!currTree.isEmpty()) {
				int heightDiff = currTree.getLeftHeight() - currTree.getRightHeight();
				assertTrue(heightDiff > -2);
				assertTrue(heightDiff < 2);
			}
			assertTrue(currTree.getSize() == size);
		}
	}
	
	@Test
	void checkMinAndMax() {
		HashSet<Integer> numbers = new HashSet<>();
		AVLTree<Integer> currTree = new AVLTree<>();
		for (int i = 0; i < 100; i++) {
			if (numbers.add(i)) {
				currTree.insert(i);
			}
		}
		
		assertTrue(currTree.getMin() == 0);
		assertTrue(currTree.getMax() == 99);
		assertTrue(currTree.getSize() == numbers.size());
	}
	
	@Test
	void checkOrderedList() {
		AVLTree<Integer> currTree = new AVLTree<>();
		for (int i = 0; i < 100; i++) {
			currTree.insert(i);
		}
		
		int heightDiff = currTree.getLeftHeight() - currTree.getRightHeight();
		assertTrue(heightDiff > -2);
		assertTrue(heightDiff < 2);
		assertTrue(currTree.getSize() == 100);
	}
	
	@Test
	void checkEmptyTree() {
		AVLTree<Integer> currTree = new AVLTree<>();
		
		assertTrue(currTree.getMax() == null);
		assertTrue(currTree.getMin() == null);
		assertTrue(currTree.getSize() == 0);
	}

}
