package prep.problems.binarysearch;

import org.junit.Test;
import org.junit.Assert;

public class RotatedBinarySearchTest {

	@Test
	public void testRotation() {
		
		int[] unrotated = RotatedBinarySearch.rotatedArray(5, 0);
		
		for (int i = 0; i < 5; i++) {
			Assert.assertTrue(unrotated[i] == i);
		}
		
		int[] rotated = RotatedBinarySearch.rotatedArray(5, 3);
		
		for (int i = 0; i < 5; i++) {
			Assert.assertTrue(rotated[(i + 3) % 5] == i);
		}
		
		Assert.assertTrue(rotated[3] == 0);
	}
	
	@Test
	public void testStartIndex() {
		
		int[] data = RotatedBinarySearch.rotatedArray(10, 3);
		
		int startIndex = RotatedBinarySearch.startIndex(data, 0, data.length-1);
		
		for (int i = 0; i < data.length; i++) System.out.print(data[i] + " ");
		System.out.println();
		
		System.out.println(startIndex);
		
		Assert.assertTrue(startIndex == 3);
	}
	
	@Test
	public void testManyStartIndex() {
		
		for (int size = 5; size < 50; size++) {
			for (int rotation = 0; rotation < size; rotation++) {
				int[] data = RotatedBinarySearch.rotatedArray(size, rotation);
				int startIndex = RotatedBinarySearch.startIndex(data, 0, data.length-1);
				Assert.assertTrue(startIndex == rotation);
			}
		}
	}
	
	@Test
	public void testBinarySearch() {
		int[] data = RotatedBinarySearch.rotatedArray(10, 0);
		
		for (int i = 0; i < data.length; i++) {
			Assert.assertTrue(RotatedBinarySearch.binarySearch(data, i, 0, data.length-1) == i);
		}
	}
}
