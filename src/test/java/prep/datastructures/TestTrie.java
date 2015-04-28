package prep.datastructures;

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
	
}
