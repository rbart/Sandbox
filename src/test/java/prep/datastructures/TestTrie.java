package prep.datastructures;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.Assert;

import prep.datastructures.trie.Trie;

public class TestTrie {

	@Test
	public void testContainsSimple() {
		Trie trie = new Trie();
		trie.add("aardvark");
		Assert.assertTrue(trie.contains("aardvark"));
	}
	
	@Test
	public void testContains() {
		String[] words = new String[] {
				"aardvark",
				"aaron",
				"bee",
				"beet",
				"beetle",
				"sale",
				"salmon"
		};
		Trie trie = new Trie();
		for (String word : words) trie.add(word);
		for (String word : words) Assert.assertTrue(trie.contains(word));
	}
	
	@Test
	public void testRemoveSimple() {
		Trie trie = new Trie();
		trie.add("aardvark");
		Assert.assertTrue(trie.contains("aardvark"));
		Assert.assertTrue(!trie.remove("foo"));
		Assert.assertTrue(trie.remove("aardvark"));
		Assert.assertTrue(!trie.contains("aardvark"));
	}
	
	@Test
	public void testRemove() {
		String[] words = new String[] {
				"aardvark",
				"aaron",
				"bee",
				"beet",
				"beetle",
				"sale",
				"salmon"
		};
		Trie trie = new Trie();
		for (String word : words) trie.add(word);
		for (String word : words) {
			Assert.assertTrue(trie.remove(word));
			Assert.assertTrue(!trie.contains(word));
		}
	}
	
	@Test
	public void testPrefixes() {
		String[] words = new String[] {
				"aardvark",
				"aaron",
				"bee",
				"beet",
				"beetle",
				"sale",
				"salmon"
		};
		Trie trie = new Trie();
		for (String word : words) trie.add(word);
		Set<String> prefixes = new HashSet<String>();
		prefixes.addAll(trie.getPrefixes());
		Assert.assertTrue(prefixes.contains("aar"));
		Assert.assertTrue(prefixes.contains("bee"));
		Assert.assertTrue(prefixes.contains("sal"));
		Assert.assertTrue(prefixes.size() == 3);
	}
}
