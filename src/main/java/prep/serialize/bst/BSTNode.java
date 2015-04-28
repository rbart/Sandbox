package prep.serialize.bst;

public class BSTNode {

	public int data;
	public BSTNode left;
	public BSTNode right;
	
	public BSTNode(int data) {
		this.data = data;
	}
	
	public void add(int d) {
		if (this.data > d) {
			if (this.left == null) this.left = new BSTNode(d);
			else this.left.add(d);
		} else {
			if (this.right == null) this.right = new BSTNode(d);
			else this.right.add(d);
		}
	}
	
	public String serialize() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.data);
		if (this.left != null) sb.append(" " + left.serialize());
		else sb.append(" 0");
		if (this.right != null) sb.append(" " + right.serialize());
		else sb.append(" 0");
		return sb.toString();
	}
}
