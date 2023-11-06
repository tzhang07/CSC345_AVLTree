
public class AVLTreeMain {
	public static void main(String[] args) {
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
		newAvlTree.deleteValue(14);
		newAvlTree.deleteValue(15);
		newAvlTree.deleteValue(21);
	}
}
