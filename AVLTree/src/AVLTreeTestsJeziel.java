/*
 * Author: Jeziel Banos Gonzalez
 * Description: File contains a few general tests for the AVL tree methods.
 * This file was created at the start of the development process so it only tests 
 * a few select cases
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class AVLTreeTestsJeziel {

	@Test
	void checkInserts() {
		// checks that insert is actually adding to the tree, but does not check for 
		// correct rotations, rotations was not implemented at time of writing
		AVLTree<Integer> curTree = new AVLTree<>();
		assertTrue(curTree.getSize() == 0);

		curTree.insert(5);
		assertTrue(curTree.search(5) == 5);
		assertTrue(curTree.getSize() == 1);

		curTree.insert(10);
		assertTrue(curTree.search(10) == 10);
		assertTrue(curTree.getSize() == 2);

		curTree.insert(1);
		assertTrue(curTree.search(1) == 1);
		assertTrue(curTree.getSize() == 3);

		curTree.deleteValue(1);
		assertTrue(curTree.search(1) == null);
		assertTrue(curTree.getSize() == 2);

	}

	@Test
	void searchInnerNode() {
		// {4, 58, 40, 43, 82, 81, 32, 25, 38, 62}
		// testing the search method of the tree to ensure it can find nodes that exists
		AVLTree<Integer> curTree = new AVLTree<>();

		curTree.insert(4);
		curTree.insert(58);
		curTree.insert(40);
		curTree.insert(43);
		curTree.insert(82);
		curTree.insert(81);
		curTree.insert(32);
		curTree.insert(25);
		curTree.insert(38);
		curTree.insert(62);

		assertTrue(curTree.search(43) == 43);
		assertTrue(curTree.search(82) == 82);
		assertTrue(curTree.search(81) == 81);
		
		curTree.printTree();

	}

	@Test
	void searchLeaf() {
		// {5,2,6,8,10, 3, 4}
		// checking we can search for leafs
		AVLTree<Integer> curTree = new AVLTree<>();

		curTree.insert(5);
		curTree.insert(2);
		curTree.insert(6);
		curTree.insert(8);
		curTree.insert(10);
		curTree.insert(3);
		curTree.insert(4);

		assertTrue(curTree.search(10) == 10);
		assertTrue(curTree.search(4) == 4);

	}

	@Test
	void checkDeletes() {
		// {5,2,6,8,10, 3, 4}
		// checks if delete is functioning correctly and only deleting one node, and not its children as well
		AVLTree<Integer> curTree = new AVLTree<>();

		curTree.insert(5);
		curTree.insert(2);
		curTree.insert(6);
		curTree.insert(8);
		curTree.insert(10);
		curTree.insert(3);
		curTree.insert(4);
		
		curTree.deleteValue(2);
		assertTrue(curTree.search(2) == null);
		curTree.deleteValue(8);
		assertTrue(curTree.search(8) == null);
		
		// making sure children of the deleted node still exist
		assertTrue(curTree.search(10) == 10);
		assertTrue(curTree.search(4) == 4);
		
	}
}
