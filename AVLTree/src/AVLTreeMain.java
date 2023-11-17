import java.util.*;


public class AVLTreeMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please press T for tests. Press M to manually make the tree.");
		String s = scan.nextLine();
		String tests = "t";
		String makeTree = "m";
		String treeType = null;
		if(tests.compareTo(s.toLowerCase()) == 0) {
			/**
			 * 
			 * 
			 * 
			 * PLEASE PUT ALL THE PRE-MADE TEST CASES HERE!!!!
			 * 
			 * 
			 */
			buildSmallTree1();
			buildBigTree2();
			testDelete();
		}
		else if(makeTree.compareTo(s.toLowerCase()) == 0) {
			String quit = "quit";
			AVLTree<Integer> avlITree = null;
			AVLTree<String> avlSTree = null;
			boolean hasQuit = false;
			boolean correctInput = false;
			while(!correctInput) {
				System.out.println("What tree would you like to build?\nTree of Strings: S\nTree of Ints: I");
				treeType = scan.nextLine();
				if(treeType.toLowerCase().compareTo("i") == 0) {
					avlITree = new AVLTree<Integer>();
					correctInput = true;
					System.out.println("Chosen to build a tree of ints.\n");
				}
				else if(treeType.toLowerCase().compareTo("s") == 0) {
					avlSTree = new AVLTree<String>();
					correctInput = true;
					System.out.println("Chosen to build a tree of strings.\n");
				}
				else if(treeType.toLowerCase().compareTo("quit") == 0 || treeType.toLowerCase().compareTo(quit) == 0) {
					return;
				}
				else {
					System.out.println("Please input S or I, or quit by typing \"quit\".");
				}
			}
			
			while(!hasQuit) {
				if(avlITree != null && treeType.toLowerCase().compareTo("i") == 0) {
					System.out.println("Please input an int. Type \"Quit\" or \"quit\" to see end result.");
				}
				else {
					System.out.println("Please input a string: Type \"Quit\" or \"quit\" to see end result.");
				}
				String input = scan.nextLine();
				if(input.toLowerCase().compareTo(quit) == 0) {
					hasQuit = true;
					System.out.println("Exiting.");
					break;
				}
				
				if(avlITree != null) {
					try {
						avlITree.insert(Integer.parseInt(input));
						System.out.println("Inserting int: " + input + "\n");
					}
					catch(NumberFormatException e) { 
						System.out.println("Input not an int. Did not insert the input.\n");
						continue;
					}
				}
				else if(avlSTree != null){
					System.out.println("Inserting String: " + input + "\n");
					avlSTree.insert(input);
				}
			}
			if(avlITree != null && avlITree.getSize() > 0) {
				System.out.println("Tree: ");
				avlITree.printTree();
			}
			else if(avlSTree != null && avlITree.getSize() > 0) {
				System.out.println("Tree: ");
				avlSTree.printTree();
			}
			else {
				System.out.println("Did not make tree or did not insert any inputs.");
			}
			scan.close();
		}
		else {
			System.out.println("None of the options selected. Automatically exiting.");
		}
}
	
	
	private static void testDelete() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("===============================================");
		System.out.println("Testing Delete");
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
		System.out.println("\nAfter deleting:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(15);
		System.out.println("\nAfter deleting 15:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(21);
		System.out.println("\nAfter deleting: 21");
		newAvlTree.printTree();
		System.out.println("\n===============================================");

	}
	
	private static void test2() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("===============================================");
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
	
	private static void buildSmallTree1() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("===============================================");
		System.out.println("TESTING SMALL TREE WITH 8 NODES");
		newAvlTree.insert(5);
		newAvlTree.insert(2);
		newAvlTree.insert(6);
		System.out.println("Expected:\n5 2 6\nActual:"); // should print 5 2 6
		newAvlTree.printTree(); // 5 with 2 children: L: 2 R: 6
		newAvlTree.insert(7);
		newAvlTree.insert(8);
		System.out.println("\n\nExpected:\n5 2 7 6 8 \nActual:");
		newAvlTree.printTree(); // should print 5 2 7 6 8
		newAvlTree.insert(9);
		System.out.println("\n\nExpected:\n7 5 8 2 6 9 \nActual:");
		newAvlTree.printTree(); // should print 7 5 8 2 6 9
		newAvlTree.insert(1);
		System.out.println("\n\nExpected:\n7 5 8 2 6 9 1 \nActual:");
		newAvlTree.printTree(); // should print 7 5 8 2 6 9 1
		newAvlTree.insert(11);
		System.out.println("\n\nExpected:\n7 5 9 2 6 8 11 1\nActual:");
		newAvlTree.printTree(); // should print 7 5 9 2 6 8 11 1
		System.out.println("\n===============================================");

	}
	
	private static void buildBigTree2() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("===============================================");
		System.out.println("TESTING BIG TREE WITH 50 NODES");
		for(int i = 1; i <= 26; i++) {
			newAvlTree.insert(i);
			if(i > 0 && i % 2 == 0) {
				System.out.println("\nPrinting Tree after inserting: " + i + " nodes:");
				newAvlTree.printTree();
				System.out.println();
			}
		}
		System.out.println("\nPrinting out final tree:");
		newAvlTree.printTree();
		System.out.println("\n===============================================");
	}
}

