package prep.datastructures;

import prep.datastructures.binarytree.BSTNode;

public class BinaryTree {

	private BSTNode root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public void put(int key, String value) {
		
		if (root == null) {
			root = new BSTNode(key, value);
		} else {
			root.put(key, value);
		}
	}

	public String get(int key) {
		if (root == null) return null;
		else return root.get(key);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean remove(int key) {
		if (root == null) return false;
		else if (root.key == key) {
			root = null;
			return true;
		}
		else return root.remove(key, null);
	}
	
}
