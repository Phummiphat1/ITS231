public class BST<T extends Comparable<T>> extends BT<T> {
	/** Create an empty binary tree */
	public BST() {

	}

	/** Create a binary tree from an object */
	public BST(T object) {
		root.element = object;
	}

	/** Create a binary tree from an array of objects */
	public BST(T[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	// ----------------------------------------------
	/**
	 * Insert newdata into the binary search tree
	 */
	public void insert(T newdata) {
		// Ex1: Complete this program
		if (root == null) {
			// Create a new root
			root = new BTNode<T>(newdata);
		} else {
			// Locate the parent node
			BTNode<T> parent = null;
			BTNode<T> current = root;
			// insert your code
			while (true) {
				if (current.element.compareTo(newdata)==0){// root = newdata
					break;
				}
				else if (current.element.compareTo(newdata)>0){// root > newdata
					parent = current;
					current = current.left;
					if (current==null){
						parent.left = new BTNode<T>(newdata);
						break;
					}
				}
				else if (current.element.compareTo(newdata)<0){// root < newdata
					parent = current;
					current = current.right;
					if (current==null){
						parent.right = new BTNode<T>(newdata);
						break;
					}
				}
			}
			
		}

		size++;
	}

	// ----------------------------------------------
	/**
	 * Delete data from the binary search tree
	 */
	// Ex2. Complete This Program
	public T delete(T item) {
		// Locate the node to be deleted and also locate its parent node
		BTNode<T> parent = null;
		BTNode<T> current = root;

		boolean currentIsLeftChild = true;

		while (current != null) {
			// insert your code
			if (current.element.compareTo(item)==0){// root = newdata
				break;
			}
			else if (current.element.compareTo(item)>0){// root > newdata
				parent = current;
				current = current.left;
				currentIsLeftChild = true;
			}
			else if (current.element.compareTo(item)<0){// root < newdata
				parent = current;
				current = current.right;
				currentIsLeftChild = false;
			}
		}

		// Case 0: item is not in the tree
		if (current == null) {
			return null;
		}

		T temp = current.element;
		// Case 1: current is the leaf

		if (current.left == null && current.right == null) {
			// insert your code
			if (currentIsLeftChild){
				parent.left = null;
			}
			else{parent.right = null;}
			current = null;
			return temp;
		}

		// Case 2: If the deleted node has one child
		// Case 2.1: if its child node is on the right
		if ((current.left == null)) { // If only has one right child or no children.
			if (currentIsLeftChild) {// In case of only have right child
				// insert your code
				if (parent!=null){
					parent.left = current.right;
				}
				else{
					root = current.right;
				}
			} else {
				// insert your code
				if (parent!=null){
					parent.right = current.right;
					current.element = null;
				}
				else{
					root = current.right;
				}
			}
		}
		// Case 2.2: If its child node is on the left
		else if ((current.right == null)) { // Only one left child
			if (currentIsLeftChild) {
				// insert your code
				if (parent!=null){
					parent.left = current.left;
				}
				else{
					root = current.right;
				}
			} else {
				// insert your code
				if (parent!=null){
					parent.right = current.left;
				}
				else{
					root = current.right;
				}
			}
		} else { // Case 3: Have both children
			BTNode<T> maxleft = current.left;
			BTNode<T> maxleftParent = current;
			while (maxleft.right != null) {
				maxleftParent = maxleft;
				maxleft = maxleft.right;
			}// you got maxleft!
			current.element = maxleft.element;
			// rearrange the tree
			if (maxleft.left == null && maxleft.right == null) { // Case 3.1 if maxleft is a leave, then ..
				//insert your code
				if (maxleftParent==maxleft){
					maxleftParent.left = null;
				}
				else{
					maxleftParent.right = null;
				}
			} 
			else if (maxleft.left != null) { // Case 3.2 if maxleft has a left child, then .
				//insert your code
				maxleftParent = maxleft.left;
			} 
			else if (maxleftParent == current) { // Case 3.3 if maxleft is leftchild of current, then ..
				//insert your code
				current.left = maxleft.left;
			}
		}
		size--;
		return temp;
	}
	// ---------------------------------------------------------

	// Search for the data returns true if it finds the data or otherwise false
	public boolean search(T data) { 
		// Ex 3: Complete this section.
		
		//replace the following line with your code
		if (root == null) {// nothing in tree
			return false;
		}
		// Locate the parent node
		BTNode<T> parent = null;
		BTNode<T> current = root;
		// insert your code
		while (true) {
			if (current == null){
				return false;
			}
			if (current.element.compareTo(data)==0){// root = newdata
				return true;
			}
			else if (current.element.compareTo(data)>0){// root > newdata
				parent = current;
				current = current.left;
			}
			else if (current.element.compareTo(data)<0){// root < newdata
				parent = current;
				current = current.right;
			}
		}
	}

	// ---------------------------------------------------------

	BTNode<T> findSmallest() {
		return findSmallest(root);
	}

	// ----------------------------------------------
	BTNode<T> findSmallest(BTNode<T> start) {
		// Ex 4: Complete this section.
		
		//replace the following line with your code
		if (size==0){// nothing in tree
			return null;
		}
		BTNode<T> parent = null;
		BTNode<T> current = start;
		while (true) {
			if (current==null){
				return parent;
			}
			parent = current;
			current = current.left;
		}
	}

	// ----------------------------------------------
	BTNode<T> findLargest() {
		return findLargest(root);
	}

	// ----------------------------------------------
	BTNode<T> findLargest(BTNode<T> start) { 
		// Ex 5: Complete this section.

		//replace the following line with your code
		if (size==0){// nothing in tree
			return null;
		}
		BTNode<T> parent = null;
		BTNode<T> current = start;
		while (true) {
			if (current==null){
				return parent;
			}
			parent = current;
			current = current.right;
		}
		
	}

	/** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public BTNode getRoot() {
		return root;
	}

	/** Returns a path from the root leading to the specified element */
	public java.util.ArrayList<BTNode<T>> path(T e) {
		java.util.ArrayList<BTNode<T>> list = new java.util.ArrayList<BTNode<T>>();
		BTNode<T> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array of nodes
	}

}