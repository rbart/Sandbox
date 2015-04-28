package prep.datastructures;
import org.junit.Test;
import org.junit.Assert;

import prep.datastructures.BinaryTree;

public class TestBinaryTree {

	@Test
	public void simpleTest() {
		
		BinaryTree tree = new BinaryTree();
		tree.put(5,  "Hello");
		Assert.assertTrue(tree.get(5) == "Hello");
	}
	
	@Test
	public void multiTest() {
		
		BinaryTree tree = new BinaryTree();
		tree.put(5,  "5");
		tree.put(3,  "3");
		tree.put(1,  "1");
		tree.put(4,  "4");
		tree.put(7,  "7");
		tree.put(6,  "6");
		Assert.assertTrue(tree.get(5) == "5");
		Assert.assertTrue(tree.get(3) == "3");
		Assert.assertTrue(tree.get(1) == "1");
		Assert.assertTrue(tree.get(4) == "4");
		Assert.assertTrue(tree.get(7) == "7");
		Assert.assertTrue(tree.get(6) == "6");
	}
	
}
