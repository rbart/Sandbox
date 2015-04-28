package prep.problems.binarysearch;

public class RotatedBinarySearch {

	public static int[] rotatedArray(int size, int rotation) {
		
		int[] array = new int[size];
		
		for (int i = 0; i < size; i++) {
			array[(i + rotation) % size] = i;
		}
		
		return array;
	}
	
	public static int startIndex(int[] data, int i, int j) {
		if (i == j-1) return j;
		if (data[i] < data[j]) return i;
		int mid = (int) Math.floor((i+j)/2);
		if (data[mid] > data[j])
			return startIndex(data, mid, j);
		else 
			return startIndex(data, i, mid);
	}
	
	
	public static int binarySearch(int[] data, int value, int i, int j) {
		if (i > j) return -1;
		int mid = (int)Math.floor((i + j)/2);
		if (data[mid] == value) return mid;
		else if (data[mid] > value)
			return binarySearch(data, value, i, mid-1);
		else 
			return binarySearch(data, value, mid+1, j);
	}
	
	public static int rotatedBinarySearch(int[] data, int value, int i, int j, int rotation) {
		if (i > j) return -1;
		int mid = (int)Math.floor((i + j)/2);
		if (data[(mid + rotation) % data.length] == value) return mid;
		else if (data[(mid + rotation) % data.length] > value)
			return rotatedBinarySearch(data, value, i, mid-1, rotation);
		else 
			return rotatedBinarySearch(data, value, mid+1, j, rotation);
	}
}
