package prep.datastructures.trie;

public class Trie {

	public static final int ALPHABET_SIZE = Character.getNumericValue('z') - Character.getNumericValue('a');
	
	public static int charToIndex(char c) {
		int index = ALPHABET_SIZE - Character.getNumericValue(c);
		if (index < 0 || index >= ALPHABET_SIZE) {
			throw new IllegalArgumentException("Character '"+c+"' outside of alphabet.");
		}
		return index;
	}
	public static char indexToChar(int index) {
		return (char)(Character.getNumericValue('a')+index);
	}
}
