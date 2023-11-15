import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLTreeTestTony {
	
	@Test
	void testInsert() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		newAvlTree.insert(10);
		for(int i = 0; i < 50; i++) {
			int randomNum = (int)Math.random() * 50;
			newAvlTree.insert(randomNum);
			assertEquals(newAvlTree.search(randomNum), randomNum);
		}
//		assertEquals(newAvlTree.getSize(), 50);
		assertEquals(newAvlTree.search(10), 10);
	}
	
	@Test
	void testSize() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		for(int i = 0; i < 50; i++) {
			newAvlTree.insert(i);
		}
		assertEquals(newAvlTree.getSize(), 50);
		for(int i = 50; i < 10000; i++) {
			newAvlTree.insert(i);
		}
		assertEquals(newAvlTree.getSize(), 10000);
		
		newAvlTree = new AVLTree<Integer>();
		for(int i = 0; i < 50; i++) {
			newAvlTree.insert(i);
		}
		
	
		for(int i = 0; i < 10; i++) {
			System.out.print("Attempting to delete: " + i);
			newAvlTree.deleteValue(i);
		}
		assertEquals(newAvlTree.getSize(), 40);
		
		
		for(int i = 10; i < 20; i++) {
			newAvlTree.deleteValue(i);
		}
		assertEquals(newAvlTree.getSize(), 30);
	}
	
	@Test
	void testMin() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		for(int i = 0; i < 50; i++) {
			newAvlTree.insert(i);
		}
		assertEquals(newAvlTree.getMin(), 0);
		newAvlTree = new AVLTree<Integer>();
		assertEquals(newAvlTree.getSize(), 0);
		
		for(int i = 50; i < 10000; i++) {
			newAvlTree.insert(i);
		}
		assertEquals(newAvlTree.getMin(), 50);
	}
	
	@Test
	void testMax() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		for(int i = 0; i < 50; i++) {
			newAvlTree.insert(i);
		}
		assertEquals(newAvlTree.getMax(), 49);
		newAvlTree = new AVLTree<Integer>();
		assertEquals(newAvlTree.getSize(), 0);
		
		for(int i = 50; i < 10000; i++) {
			newAvlTree.insert(i);
		}
		assertEquals(newAvlTree.getMax(), 9999);
	}
	
	@Test
	void testDelete() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("\nInside test Delete");
		newAvlTree.insert(14);
		newAvlTree.insert(5);
		newAvlTree.insert(36);
		newAvlTree.insert(2);
		newAvlTree.insert(10);
		newAvlTree.insert(21);
		newAvlTree.insert(55);
		newAvlTree.insert(15);
		newAvlTree.insert(28);
		newAvlTree.deleteValue(2);
		assertEquals(newAvlTree.search(2), null);
		newAvlTree.deleteValue(14);
		assertEquals(newAvlTree.search(14), null);
		newAvlTree.deleteValue(15);
		assertEquals(newAvlTree.search(15), null);
		newAvlTree.deleteValue(21);
		assertEquals(newAvlTree.search(21), null);
		
	}

}
