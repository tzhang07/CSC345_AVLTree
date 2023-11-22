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
			testDelete2();
			testDelete3();
			testDelete4();
			delete25Nodes();
			randomTest();
		}
		else if(makeTree.compareTo(s.toLowerCase()) == 0) {
			String quit = "quit";
			AVLTree<Integer> avlITree = null;
			AVLTree<String> avlSTree = null;
			boolean hasQuit = false;
			boolean correctInput = false;
			/**
			 * This while loop will grab the user's input and make the tree based on the user's input.
			 */
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
			
			/**
			 * This will run until the user inputs quit.
			 */
			while(!hasQuit) {
				if(avlITree != null && treeType.toLowerCase().compareTo("i") == 0) {
					System.out.println("\nType \"Quit\" or \"quit\" to see end result.");
					System.out.println("Please press i for insert, d for delete:");

				}
				else {
					System.out.println("\nType \"Quit\" or \"quit\" to see end result.");
					System.out.println("Please press i for insert, d for delete:");
				}
				String input = scan.nextLine();
				if(input.toLowerCase().compareTo(quit) == 0) {
					hasQuit = true;
					System.out.println("Exiting.");
					break;
				}
				/**
				 * Checks to see what tree type it is.
				 */
				if(avlITree != null && treeType.toLowerCase().compareTo("i") == 0) {
					/**
					 * Delete
					 */
					if(input.toLowerCase().compareTo("d") == 0) {
						System.out.println("Please input a number to delete from AVLTree");
						String secondInput = scan.nextLine();
						try {
							if(avlITree.search(Integer.parseInt(secondInput)) == null) {
								System.out.println(secondInput + " is not found within the AVLTree.");
							}
							avlITree.deleteValue(Integer.parseInt(secondInput));
						} catch(NumberFormatException e) {
							System.out.println("Input is not an int or does not exist. Please try again");
							continue;
						}
					}
					/**
					 * Insert
					 */
					else if(input.toLowerCase().compareTo("i") == 0) {
						System.out.println("Please input a number to insert to AVLTree");
						String secondInput = scan.nextLine();
						try {
							avlITree.insert(Integer.parseInt(secondInput));
						} catch(NumberFormatException e) {
							System.out.println("Input is not an int. Please try again.");
							continue;
						}
					}
					/**
					 * If user enters wrong input, not "i" or "d"
					 */
					else {
						System.out.println("Wong Input.\nPlease choose either to insert or to delete. \"i\" to insert, and \"d\" to delete.");
					}
				}
				/**
				 * For the string avl tree
				 */
				else if(avlSTree != null && treeType.toLowerCase().compareTo("s") == 0) {
					/**
					 * Deleting
					 */
					if(input.toLowerCase().compareTo("d") == 0) {
						System.out.println("Please input a string to delete from AVLTree");
						String secondInput = scan.nextLine();
						if(avlSTree.search(secondInput) == null) {
							System.out.println(secondInput + " is not found within the AVLTree.");
						}
						avlSTree.deleteValue(secondInput);
					}
					/**
					 * Inserting
					 */
					else if(input.toLowerCase().compareTo("i") == 0) {
						System.out.println("Please input a string to insert to AVLTree");
						String secondInput = scan.nextLine();
						avlSTree.insert(secondInput);	
					}
					/**
					 * If user does not use "i" or "d"
					 */
					else {
						System.out.println("Wrong input.\nPlease choose either to insert or to delete. \"i\" to insert, and \"d\" to delete.");
					}
				}
				
				
			}
			if(avlITree != null && avlITree.getSize() > 0) {
				System.out.println("Tree: ");
				avlITree.printTree();
			}
			else if(avlSTree != null && avlSTree.getSize() > 0) {
				System.out.println("Tree: ");
				avlSTree.printTree();
			}
			else {
				System.out.println("Did not make tree or did not insert any inputs, or tree is empty.");
			}
			scan.close();
		}
		else {
			System.out.println("None of the options selected. Automatically exiting.");
		}
}
	
	/**
	 * Test delete!!
	 */
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
		System.out.println("\n\nAfter deleting 14:");
		System.out.println("Expected:\n15 5 36 2 10 21 55 28\nActual:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(15);
		System.out.println("\n\nAfter deleting 15:");
		System.out.println("Expected:\n21 5 36 2 10 28 55\nActual:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(21);
		System.out.println("\n\nAfter deleting: 21");
		System.out.println("Expected:\n28 5 36 2 10 55\nActual:");
		newAvlTree.printTree();
		newAvlTree.deleteValue(36);
		System.out.println("\n\nAfter deleting 36:");
		System.out.println("Expected:\n28 5 55 2 10\nActual:");
		newAvlTree.printTree();
		System.out.println("\n===============================================");

	}
	
	/**
	 * Second test of delete
	 */
	private static void testDelete2() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("===============================================");
		newAvlTree.insert(9);
		newAvlTree.insert(8);
		newAvlTree.insert(15);
		newAvlTree.insert(7);
		newAvlTree.insert(13);
		newAvlTree.insert(20);
		newAvlTree.insert(10);
		System.out.println("TESTING DELETE2 WITH TREE:");
		newAvlTree.printTree();
		System.out.println("\nDelete 8:\nExpected:\n13 9 15 7 10 20\nActual:");
		newAvlTree.deleteValue(8);
		newAvlTree.printTree();
		
		
		
		System.out.println("\n===============================================");
	}
	
	/**
	 * Third test of delete
	 */
	private static void testDelete3() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("\n===============================================");
		newAvlTree.insert(50);
		newAvlTree.insert(25);
		newAvlTree.insert(75);
		newAvlTree.insert(15);
		newAvlTree.insert(60);
		newAvlTree.insert(35);
		newAvlTree.insert(120);
		newAvlTree.insert(10);
		newAvlTree.insert(68);
		newAvlTree.insert(90);
		newAvlTree.insert(125);
		newAvlTree.insert(83);
		newAvlTree.insert(100);
		System.out.println("\nTESTING DELETE3 WITH TREE:");
		newAvlTree.printTree();
		System.out.println("\n\nDeleting 120");
		newAvlTree.deleteValue(120);
		System.out.println("Expected:\n50 25 75 15 35 60 90 10 68 83 125 100\nActual:");
		newAvlTree.printTree();
		System.out.println("\n\nDeleting 10");
		System.out.println("Expected:\n75 50 90 25 60 83 125 15 35 68 100\nActual:");
		newAvlTree.deleteValue(10);
		newAvlTree.printTree();
		System.out.println("\n===============================================");
	}
	
	/**
	 * Fourth test of delete
	 */
	private static void testDelete4() {
		AVLTree<Integer> avlTree = new AVLTree<>();

        // Test Case 1: Insertion
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(15);
        avlTree.insert(3);
        avlTree.insert(7);
        avlTree.insert(12);
        avlTree.insert(17);
        System.out.println("AVL Tree after insertion:");
        avlTree.printTree();
        System.out.println();

        /*
         * Expected AVL Tree:
         *      10
         *     /  \
         *    5    15
         *   / \   / \
         *  3   7 12  17
         */

        // Test Case 2: Deletion
        avlTree.deleteValue(5);
        System.out.println("AVL Tree after deleting 5:");
        avlTree.printTree();
        System.out.println();

        /*
         * Expected AVL Tree:
         *      10
         *     /  \
         *    7    15
         *   /     / \
         *  3     12  17
         */

        // Test Case 3: Deletion causing rotations
        avlTree.deleteValue(15);
        System.out.println("AVL Tree after deleting 15:");
        avlTree.printTree();
        System.out.println();

        /*
         * Expected AVL Tree:
         *     10
         *     / \
         *    7   17
         *   /    /
         *  3    12  
         */
        
        // Test Case 4: Deletion causing double rotations
        avlTree.deleteValue(10);
        System.out.println("AVL Tree after deleting 10:");
        avlTree.printTree();
        System.out.println();
        /*
         * Expected AVL Tree:
         *     12         
         *     / \      
         *    7  17 
         *   /     
         *  3      
         */
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
	
	/**
	 * Builds a "small tree"
	 */
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
	
	/**
	 * Builds a big tree with 25 nodes
	 */
	private static void buildBigTree2() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("===============================================");
		System.out.println("TESTING BIG TREE WITH 26 NODES");
		for(int i = 0; i < 26; i++) {
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
	
	/**
	 * Builds and delete the nodes
	 */
	private static void delete25Nodes() {
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		System.out.println("===============================================");
		System.out.println("TESTING BIG TREE WITH 26 NODES");
		for(int i = 0; i < 26; i++) {
			newAvlTree.insert(i);
			if(i > 0 && i % 2 == 0) {
				System.out.println("\nPrinting Tree after inserting: " + i + " nodes:");
				newAvlTree.printTree();
				System.out.println();
			}
		}
		System.out.println("\nPrinting out final tree before deleting:");
		newAvlTree.printTree();
		
		for(int i = 0; i < 26; i++) {
			newAvlTree.deleteValue(i);
			if(newAvlTree.getSize() % 2 == 0 && newAvlTree.getSize() > 0) {
				System.out.println("\nPrinting tree if size is even:");
				newAvlTree.printTree();
				System.out.println();
			}
		}
		System.out.println("\nPrinting tree after deleting:");
		newAvlTree.printTree();
		System.out.println("\n===============================================");
	}
	
	/**
	 * Randomly inserting tree
	 */
	private static void randomTest() {
		System.out.println("\n===============================================");
		AVLTree<Integer> newAvlTree = new AVLTree<Integer>();
		for(int i = 0; i < 25; i++) {
			int randVal = (int) (Math.random() * 25 + 1);
			newAvlTree.insert(randVal);
		}
		newAvlTree.printTree();
		System.out.println("===============================================");
	}
}

