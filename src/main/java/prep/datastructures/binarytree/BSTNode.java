package prep.datastructures.binarytree;

public class BSTNode {

	public int key;
	public String value;
	public BSTNode left;
	public BSTNode right;
	
	public BSTNode(int k, String v) {
		this.key = k;
		this.value = v;
		this.left = null;
		this.right = null;
	}
	
	private int minKey() {
		if (this.left == null) return key;
		else return left.minKey();
	}
	
	public void put(int key, String value) {
		
		if (this.key > key) {
			if (this.left == null) this.left = new BSTNode(key, value);
			else left.put(key, value);
		} else if (this.key < key) {
			if (this.right == null) this.right = new BSTNode(key, value);
			else right.put(key, value);
		} else if (this.key == key) this.value = value;
		else throw new RuntimeException("Unhandled Case");
	}
	
	public String get(int key) {
		if (this.key == key) return value;
		else if (this.key > key) return left.get(key);
		else return right.get(key);
	}
	
	public boolean remove(int key, BSTNode parent) {
		if (this.key > key) {
			if (this.left == null) return false;
			else return this.left.remove(key, this);
		} else if (this.key < key) {
			if (this.right == null) return false;
			else return this.right.remove(key, this);
		} 
		// this.key == key
		if (this.left == null && this.right == null) {
			if (this == parent.left) parent.left = null;
			else parent.right = null;
			return true;
		}
		else if (this.left == null) {
			if (this == parent.left) parent.left = this.right;
			else parent.right = this.right;
			return true;
		} else if (this.right == null) {
			if (this == parent.left) parent.left = this.right;
			else parent.right = this.right;
			return true;
		} else { // both children are present
			// find the inorder successor
			int minkey = left.minKey();
			String value = this.get(minkey);
			left.remove(minkey, this);
			this.key = minkey;
			this.value = value;
			return true;
		}
	}
}
