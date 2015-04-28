package prep.serialize;

import prep.serialize.bst.BSTNode;

public class BST {

	private BSTNode root;
	
	public BST() { 
		root = null;
	}
	
	public void add(int data) {
		if (root == null) root = new BSTNode(data);
		else root.add(data);
	}
	
	public String serialize() {
		
		if (root == null) return "";
		else return root.serialize();
		
	}
	
	public static BST deserialize(String s) {
		if (s.isEmpty()) return new BST();
		else {
			String[] split = s.split(" ");
			BSTNode newRoot = deserialize(split, 0).node;
			BST bst = new BST();
			bst.root = newRoot;
			return bst;
		}
	}
	
	private static Pair deserialize(String[] values, int index) {
		
		if (index >= values.length || values[index].equals("0")) {
			return new Pair(null, index);
		}
		else {
			int data = Integer.parseInt(values[index]);

			BSTNode node = new BSTNode(data);
			Pair p1 = deserialize(values, index + 1);
			Pair p2 = deserialize(values, p1.index + 1);
			
			node.left = p1.node;
			node.right = p2.node;
			
			return new Pair(node, p2.index);
		}
	}
	
	private static class Pair {
		public BSTNode node;
		public int index;
		public Pair(BSTNode node, int index) {
			this.node = node;
			this.index = index;
		}
	}
	
	public static void main(String[] args) {
		
		BST tree = new BST();
		tree.add(5);
		tree.add(3);
		tree.add(1);
		tree.add(4);
		tree.add(7);
		tree.add(8);
		
		String ser = tree.serialize();
		BST des = BST.deserialize(ser);
		String ser2 = des.serialize();
		
		System.out.println(ser);
		System.out.println(ser2);
	}
}

