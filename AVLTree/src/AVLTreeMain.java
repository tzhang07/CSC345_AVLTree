
public class AVLTreeMain {
	public static void main(String[] args) {
		buildSmallTree1();
	}
	
	private static void testDelete() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
//		System.out.println("\nInside test Delete");
		newAvlTree.insert(14);
		newAvlTree.insert(5);
		newAvlTree.insert(36);
		newAvlTree.insert(2);
		newAvlTree.insert(10);
		newAvlTree.insert(21);
		newAvlTree.insert(55);
		newAvlTree.insert(15);
		newAvlTree.insert(28);
		newAvlTree.deleteValue(14);
		newAvlTree.deleteValue(15);
		newAvlTree.deleteValue(21);
	}
	
	private static void buildSmallTree1() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		newAvlTree.insert(5);
		newAvlTree.insert(2);
		newAvlTree.insert(6);
		newAvlTree.printTree(); // 5 with 2 children: L: 2 R: 6
		System.out.println(); // should print 5 2 6
		newAvlTree.insert(7);
		newAvlTree.insert(8);
		newAvlTree.printTree(); // should print 5 2 7 6 8
	}
}

