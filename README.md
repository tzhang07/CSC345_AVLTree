# CSC345_AVLTree
CSC345 Project:

AVLTree Class
Constructor:
Contains two different constructors, one with no arguments, and one with a node as an argument. The first one makes a tree with no root yet, while the second one sets the passed node as a root.

Public Methods:
insert(T val): call by: AVLTree.insert(T value) 
This method inserts the passed value into the tree by creating a node containing the value, or increasing an already exisiting node's quantity field. (See below in Node Class). 
insert does not return anything.
insert has a time complexity of O(log(N))

T search(T val): call by: AVLTree.search(T value)
This method searches for an instance of passed value within the AVLTree.
If the value is found within the tree, the method returns the value found. Otherwise, null is returned.
search has a time complexity of O(log(N))

T getMin(): call by: AVLTree.getMin()
This method finds and returns the minimum value of the AVLTree.
Returns the smallest value, but if the tree is empty, it returns null.
getMin has a time complexity of O(log(N))

T getMax(): call by: AVLTree.getMax()
This method finds and returns the maximum value of the AVLTree.
Returns the largest value, but if the tree is empty, it returns null.
getMax has a time complexity of O(log(N))

deleteValue(T val): call by: AVLTree.deleteValue(T value)
This method attempts to remove the passed value from the AVLTree. If multiple of this value exists, it only subtracts one from the quantity of the Node.
deleteValue does not return anything.
deleteValue has a time complexity of O(log(N))

int getSize(): call by: AVLTree.getSize()
This method returns the current number of Nodes within the tree.
Returns number of Nodes in tree.
getSize has a time complexity of O(1)

boolean isEmpty(): call by: AVLTree.isEmpty()
This method lets the caller know if the AVLTree is empty or not.
Returns true if tree is empty, false otherwise.
isEmpty() has a time complexity of O(1)

printTree(): call by: AVLTree.printTree()
This method prints out the AVLTree in BFS order onto the console.
Returns nothing.
printTree has a time complexity of O(N)

T getLeft(): call by: AVLTree.getLeft() [FOR TESTING PURPOSES ONLY]
This method gets the value of the left subtree's root.
Returns a T value.
getLeft has a time complexity of O(1)

T getRight(): call by: AVLTree.getRight() [FOR TESTING PURPOSES ONLY]
This method gets the value of the right subtree's root.
Returns a T value.
getRight has a time complexity of O(1)

int getLeftHeight(): call by: AVLTree.getLeftHeight()  [FOR TESTING PURPOSES ONLY]
This method gets the height of the first left subtree according to the root.
Returns an integer value of the height.
getLeftHeight has a time complexity of O(1)

int getRightHeight(): call by: AVLTree.getRightHeight()  [FOR TESTING PURPOSES ONLY]
This method gets the height of the first right subtree according to the root.
Returns an integer value of the height.
getRightHeight has a time complexity of O(1)

Private Methods:

Node<T> insertHelper(Node<T> root, T val):
This method recurses down the tree to add a value to the end of the tree, unless that value is a duplicate. In the case of a duplicate, it adds 1 to the quantity of the Node with the same value. As it backtracks, it determines if any rotations must be done.
Returns the Node altered by the recursive call.
insertHelper has a time complexity of O(log(N))

Node<T> deleteHelper(Node<T> root, T val):
This method recurses down the tree to remove a value from the tree, unless that value is a duplicate. In the case of a duplicate, it subtracts 1 from the quantity of the Node with the same value. As it backtracks, it determines if any rotations must be done. In the case the method removes a value from the middle of the tree, it finds the next in order value to replace it with and then removes that value.
Returns the Node altered by the recursive call.
deleteHelper has a time complexity of O(log(N))

Node<T> findNodeToReplace(Node<T> root):
This method recurses down the tree to find the next in order value of the tree begining at the root's parent.
Returns the next in order Node found.
findNodeToReplace has a time complexity of O(log(N))

T searchHelper(Node<T> root, T val):
This method recurses down the tree to find a value within the tree.
Returns the value if within the tree, null otherwise.
searchHelper has a time complexity of O(log(N))

int compare(T val1, T val2):
Compares the two values passed.
Returns 0 if values are equal, <0 if val1 < val2, and >0 if val1 > val2.
compare has a time complexity equal to the time complexity of the compareTo method associated with the object T.

int recalcHeightOfNode(Node<T> root)
Recalculates the height of the root based off the heights of it's children.
Returns the height of the root passed.
recalcHeightOfNode has a time complexity of O(1)

int recalcWeightOfNode(Node<T> root)
Recalculates the weight of the root based off the heights of it's children.
Returns the weight of the root passed.
recalcWeightOfNode has a time complexity of O(1)

Node<T> rotateLeft(Node<T>)
Rotates the subtree beginning at the passed root to the left, esentially shifting the value of the right child of the root to become the new root of the subtree.
Returns the new root of the subtree.
rotateLeft has a time complexity of O(1)

Node<T> rotateRight(Node<T>)
Rotates the subtree beginning at the passed root to the right, esentially shifting the value of the left child of the root to become the new root of the subtree.
Returns the new root of the subtree.
rotateRight has a time complexity of O(1)


Node Class:
Node class is to be used by the AVLTree class. Node class has the following fields;
right, left, parent, weight, height, quantity. 
right is a Node object which is the right child of the current node, left is the left child of the current node. 
weight is a integer value which is used for rotations in the AVLTree class, which discribes what side a tree is "leaning" torwards
height is a integer value which describes the height of the current node. So the height of a node represents the entire height of the subtree that the current node is the root of. So a leaf is of height 0/
quantity is a integer value which describes how many times a value has been inserted into the tree. The more times a matching value has been inserting, the higher quantity gets (+1). removing will -1 this field.



AVLTreeMain:
This is the main file in which you should run. You can choose to run either:
  - Pre-made test cases
  - Make your own AVLTree with inserts.
You can use and check the pre-made test cases by running and pressing T or t, they are not case-sensitive.
If you choose to manually make the tree, input "M" or m in order to start.
After that, users need to choose to either insert or delete nodes from the tree. "I" for insert and "D" for delete.
Once a command is inputted, users can now insert or delete the nodes that they want.
Once "quit" is inputted, it will print out the AVL tree and user's can draw the tree themselves.

If you choose the make your own AVLTree, you can choose either an AVLTree of Ints or Strings. Once a choice has been made, you can freely insert by pressing I or i, not case-sensitive and once finished, you can type "quit" in order to see the tree that you have made. 

AVLTreeTest:
This is a secondary file that runs multiple tests on the tree to ensure things such as proper balance kept, deletion of items within the tree, and searching are all in tact with random, non-repeating values.
Since these tests are JUnit, you can also choose to run these and have a code coverage be done to the program. Roughly 93.5 of all lines within the AVLTree.java file will be covered. Only some unused methods and redundancy basecases will be missed.
All tests are pre-made. You may run these tests as many time as you wish to ensure they work properly.
