import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class deleteTests {

	@Test
	void miniTest() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		newAvlTree.insert(15);
		newAvlTree.insert(55);
		newAvlTree.insert(21);
		newAvlTree.insert(28);
		newAvlTree.insert(100);
		newAvlTree.insert(200);
		newAvlTree.insert(300);
		newAvlTree.insert(53);
		newAvlTree.insert(10);

		int[] arr = new int[] { 15, 55, 21, 28, 100, 200, 300, 53, 10 };
		assertTrue(newAvlTree.getSize() == 9);

		for (int i = 0; i < 9; i++) {
			System.out.print("Trying to delete:");
			System.out.print(arr[i]);
			System.out.print("\n");

			newAvlTree.deleteValue(arr[i]);
			newAvlTree.printTree();
			System.out.print("\n");
			assertTrue(newAvlTree.getSize() == 9 - i - 1);
			System.out.print("The current size is:");
			System.out.print(newAvlTree.getSize());
			System.out.print("\n");

		}

	}
	
	@Test
	void randomValsTest() {
		Random rand = new Random();
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();

		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			int toAdd = rand.nextInt(20);
			arr.add(toAdd);
			newAvlTree.insert(toAdd);
		}
		newAvlTree.printTree();
		System.out.print("\n");
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print("Trying to delete:");
			System.out.print(arr.get(i));
			System.out.print("\n");

			newAvlTree.deleteValue(arr.get(i));
			newAvlTree.printTree();
			System.out.print("\n");
			System.out.print("The current size is:");
			System.out.print(newAvlTree.getSize());
			System.out.print("\n");

		}

		
		
	}

}
