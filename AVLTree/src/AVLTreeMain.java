
public class AVLTreeMain {
	public static void main(String[] args) {
		test2();
	}
	
	private void test1() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		newAvlTree.insert(14);
		newAvlTree.insert(5);
		newAvlTree.insert(36);
		newAvlTree.insert(2);
		newAvlTree.insert(10);
		newAvlTree.insert(21);
		newAvlTree.insert(55);
		newAvlTree.insert(15);
		newAvlTree.insert(28);
		System.out.println("Before deleting:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(14);
		System.out.println("After deleting:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(15);
		System.out.println("After deleting 15:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(21);
		System.out.println("After deleting: 21");
		newAvlTree.printTree();
	}
	
	private static void test2() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		newAvlTree.insert(4);
		newAvlTree.insert(14);
		newAvlTree.insert(8);
		newAvlTree.insert(0);
		newAvlTree.insert(12);
		newAvlTree.insert(20);
		newAvlTree.insert(13);
		System.out.println("After Inserting:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(4);
		System.out.println();
		newAvlTree.printTree();
		newAvlTree.deleteValue(8);
		System.out.println();
		newAvlTree.printTree();
		
		newAvlTree.insert(10);
		System.out.println();
		newAvlTree.printTree();
		newAvlTree.deleteValue(20);
		System.out.println();
		newAvlTree.printTree();
		newAvlTree.insert(11);
		System.out.println();
		newAvlTree.printTree();
	}
}
