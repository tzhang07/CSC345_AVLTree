import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class AVLTreeTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void heightTest() {
		fail("Not yet implemented");
		
		AVLTree<Integer> currTree = new AVLTree<>();
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			int randomNum = rand.nextInt(-1000, 1000);
			currTree.insert(randomNum);
		}
		
		/*int heightDiff = currTree.rightHeight() - currTree.leftHeight()
		assertTrue(-1 <= heightDiff && heightDiff <= 1);
		*/
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
		
		for (int n : numbers) {
			currTree.deleteValue(n);
			assertTrue(currTree.search(n) == null);
		}
	}
	
	@Test
	void checkMinAndMax() {
		AVLTree<Integer> currTree = new AVLTree<>();
		for (int i = 0; i < 100; i++) {
			currTree.insert(i);
		}
		
		assertTrue(currTree.getMin() == 0);
		assertTrue(currTree.getMax() == 99);
	}

}