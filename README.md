# CSC345_AVLTree
CSC345 Project:

AVLTree Class
Constructor:
Contains two different constructors, one with no arguments, and one with a node as an argument. The first one makes a tree with no root yet, while the second one sets the passed node as a root.

Public Methods:
insert(T val): call by: AVLTree.insert(T value) 
This method inserts the passed value into the tree by creating a node containing the value, or increasing an already exisiting node's quantity field. (See below in Node Class). 
insert does no return anything and has a time complexity of O(log(n))




Private Methods:




Node Class:
Node class is to be used by the AVLTree class. Node class has the following fields;
right, left, parent, weight, height, quantity. 
right is a Node object which is the right child of the current node, left is the left child of the current node. 
parent is also a Node object, which is the parent of the current node.
weight is a integer value which is used for rotations in the AVLTree class, which discribes what side a tree is "leaning" torwards
height is a integer value which describes the height of the current node. So the height of a node represents the entire height of the subtree that the current node is the root of. So a leaf is of height 0/
quantity is a integer value which describes how many times a value has been inserted into the tree. The more times a matching value has been inserting, the higher quantity gets (+1). removing will -1 this field.



AVLTreeMain
