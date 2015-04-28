package prep.datastructures;

public class Heap {

	private int[] keys;
	private String[] values;
	private int size;
	
	public Heap(int maxSize) {
		keys = new int[maxSize];
		values = new String[maxSize];
		size = 0;
	}
	
	private void swap(int i, int j) {
		int keyi = keys[i];
		String vali = values[i];
		keys[i] = keys[j];
		values[i] = values[j];
		keys[j] = keyi;
		values[j] = vali;
	}
	
	private int parent(int child) {
		return (int)Math.floor((child-1)/2);
	}
	private int lc(int parent) {
		return 2*parent + 1;
	}
	private int rc(int parent) {
		return 2*parent + 2;
	}
	
	public void insert(int priority, String value) {
		if (size >= keys.length - 1) throw new RuntimeException("Heap is full!");
		int m = size;
		keys[m] = priority;
		values[m] = value;
		while (m > 0 && keys[parent(m)] > priority) {
			swap(m, parent(m));
			m = parent(m);
		}
		size++;
	}
	
	public int findMinPriority() {
		if (size == 0) throw new IllegalStateException("Heap is Empty");
		return keys[0];
	}
	public String findMinValue() {
		if (size == 0) throw new IllegalStateException("Heap is Empty");
		return values[0];
	}
	
	public String deleteMin() {
		if (size == 0) throw new IllegalStateException("Cannot delete from empty heap");
		String deletedVal = values[0];
		int m = 0;
		keys[0] = keys[size - 1];
		while (m <= parent(size - 2)) {
			int minChildIndex;
			if (rc(m) > size - 2) {
				minChildIndex = lc(m); // right child does not exist
			}
			else if (keys[lc(m)] < keys[rc(m)]) {
				minChildIndex = lc(m);
			} else {
				minChildIndex = rc(m);
			}
			if (keys[minChildIndex] < keys[m]) {
				swap(minChildIndex, m);
				m = minChildIndex;
			}
		}
		size--;
		
		return deletedVal;
	}
	
}
