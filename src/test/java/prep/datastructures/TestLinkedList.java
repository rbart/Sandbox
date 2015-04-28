package prep.datastructures;
import org.junit.Test;
import org.junit.Assert;

import prep.datastructures.LinkedList;

public class TestLinkedList {

	@Test
	public void emptyTest() {
		
		LinkedList list = new LinkedList();
		
		Assert.assertTrue("List should be empty", list.isEmpty());
		Assert.assertTrue("List should be empty", list.length() == 0);
		
	}
	
	@Test
	public void singletonTest() {
		
		LinkedList list = new LinkedList();
		
		list.append(5);
		
		Assert.assertTrue("Size should be 1", list.length() == 1);
		Assert.assertTrue("Not empty", !list.isEmpty());
		Assert.assertTrue("Should contain 5", list.get(0) == 5);
		
	}
	
	@Test
	public void multiTest() {
		
		LinkedList list = new LinkedList();
		
		list.append(42);
		list.append(27);
		Assert.assertTrue("27 is at index 1", list.get(1) == 27);
		Assert.assertTrue("Size is 2", list.length() == 2);
		list.append(1);
		list.append(2);
		list.append(3);
		Assert.assertTrue("27 is at index 1", list.get(1) == 27);
		Assert.assertTrue("42 is at index 0", list.get(0) == 42);
		Assert.assertTrue("1 is at index 2", list.get(2) == 1);
		
		Assert.assertTrue("27 gets removed", list.remove(27));
		
		Assert.assertTrue("27 is not in the list", !list.remove(27));
		Assert.assertTrue("42 is at index 0", list.get(0) == 42);
		Assert.assertTrue("1 is at index 1", list.get(1) == 1);
		Assert.assertTrue("2 is at index 2", list.get(2) == 2);
	}
}
