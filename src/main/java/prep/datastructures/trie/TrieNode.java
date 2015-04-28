package prep.datastructures.trie;

public class TrieNode {

	public TrieNode[] children;
	public int numChildren;
	public boolean isWord;
	
	public TrieNode() {
		children = new TrieNode[Trie.ALPHABET_SIZE];
		numChildren = 0;
		isWord = false;
	}
	
	public boolean isLeaf() {
		return numChildren == 0;
	}
	
	public void addChild(char c, TrieNode child) {
		int index = Trie.charToIndex(c);
		if (children[index] != null) {
			throw new RuntimeException("TrieNode already has child for char '"+c+"'");
		}
		children[index] = child;
	}
	
	public TrieNode getChild(char c) {
		return children[Trie.charToIndex(c)];
	}
	
	public int firstChildIndex() {
		for (int i = 0; i < Trie.ALPHABET_SIZE; i++) {
			if (children[i] != null) return i;
		}
		throw new RuntimeException("Node has no children.");
	}
}
