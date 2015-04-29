package prep.datastructures.trie;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class Trie {

	public static final int ALPHABET_SIZE = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;
	
	public static int charToIndex(char c) {
		int index = Character.getNumericValue(c) - Character.getNumericValue('a');
		if (index < 0 || index >= ALPHABET_SIZE) {
			throw new IllegalArgumentException("Character '"+c+"' outside of alphabet.");
		}
		return index;
	}
	public static char indexToChar(int index) {
		return (char)(Character.getNumericValue('a')+index);
	}
	
	/*
	 * End Static Members
	 */
	
	private TrieNode root;
	private int numWords;
	
	public Trie() {
		root = new TrieNode();
		numWords = 0;
	}
	
	public void add(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode child = current.getChild(c);
			if (child == null) {
				child = new TrieNode();
				current.addChild(c, child);
			}
			current = child;
		}
		if (!current.isWord) numWords++;
		current.isWord = true;
	}
	
	public boolean contains(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode child = current.getChild(c);
			if (child == null) return false;
			current = child;
		}
		return current.isWord;
	}
	
	public boolean remove(String word) {
		TrieNode current = root;
		Stack<TrieNode> path = new Stack<TrieNode>();
		for (int i = 0; i < word.length(); i++) {
			path.push(current);
			current = current.getChild(word.charAt(i));
			if (current == null) return false;
		}
		if (!current.isWord) return false;
		numWords--;
		if (!current.isLeaf()) return true;
		else {
			for (int i = word.length() - 1; i >= 0; i--) {
				current = path.pop();
				current.removeChild(word.charAt(i));
				if (!current.isLeaf() || current.isWord) break;
			}
			return true;
		}
	}
	
	public List<String> getPrefixes() {
		List<String> prefixes = new LinkedList<String>();
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if (root.children[i] == null) continue;
			StringBuilder prefix = new StringBuilder();
			prefix.append(indexToChar(i));
			TrieNode current = root.children[i];
			while (current.numChildren == 1) {
				int childIndex = current.firstChildIndex();
				prefix.append(indexToChar(childIndex));
				current = current.children[childIndex];
			}
			prefixes.add(prefix.toString());
		}
		return prefixes;
	}
}
