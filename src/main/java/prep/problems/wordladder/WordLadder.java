package prep.problems.wordladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import prep.datastructures.Graph;
import prep.datastructures.graph.BFS;

public class WordLadder {

	private List<String> words;
	private Graph wordGraph;
	
	public WordLadder() throws IOException {
		words = readWords();
		wordGraph = loadWordGraph();
	}
	
	public List<String> findLadder(String word1, String word2) {
		return BFS.findPath(wordGraph, word1, word2);
	}
	
	private Graph loadWordGraph() {

		if (words == null) throw new IllegalStateException("word list not initialized!");
		
		Graph g = new Graph();
		
		// load nodes
		for (String word : words) g.addNode(word);
		
		// load edges
		for (String word : words) {
			for (String adjacent : getAdjacentWords(word)) {
				g.addEdge(word, adjacent);
			}
		}
		
		return g;
	} 
	
	private List<String> getAdjacentWords(String word) {
		
		List<String> adjacentWords = new ArrayList<String>();
		
		for (String wild : getWildcardStrings(word)) {
			for (String w : words) {
				if (wildcardMatch(wild, w) && !w.equals(word))
					adjacentWords.add(w);
			}
		}
		
		return adjacentWords;
	}
	
	/**
	 * Given a word like "food", return "_ood", "f_od", etc.
	 * @return
	 */
	private List<String> getWildcardStrings(String word) {
		
		List<String> wildcards = new ArrayList<String>();
		StringBuilder s;
		for (int wildCardIndex = 0; wildCardIndex < word.length(); wildCardIndex++) {
			s = new StringBuilder();
			for (int charIndex = 0; charIndex < word.length(); charIndex++) {
				if (charIndex == wildCardIndex) 
					s.append("_");
				else 
					s.append(word.charAt(charIndex));
			}
			wildcards.add(s.toString());
		}
		return wildcards;
	}
	
	/**
	 * Returns true if wild matches word except for the wildcard ("_") character
	 * @param wild
	 * @param word
	 * @return
	 */
	private boolean wildcardMatch(String wild, String word) {

		if (wild.length() != word.length()) return false;
		
		for (int i = 0; i < wild.length(); i++) {
			char wildChar = wild.charAt(i);
			char wordChar = word.charAt(i);
			if (wildChar != '_')
				if (wildChar != wordChar) return false;
		}
		return true;
	}

	public static List<String> readWords() throws IOException {
		
		InputStreamReader isr = null; 
		BufferedReader reader = null;
		
		try {
			
			isr = new InputStreamReader(WordLadder.class.getResourceAsStream("/words4.txt"));
			reader = new BufferedReader(isr);
			
			List<String> words = new ArrayList<String>();
			String line;
			
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\s+");
				for (String word : split) {
					String trim = word.trim();
					if (!trim.isEmpty()) words.add(trim);
				}
			}
			
			return words;
		
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			if (isr != null) isr.close();
			if (reader != null) reader.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		WordLadder wl = new WordLadder();
		
		List<String> path = wl.findLadder("FOOD", "MAIN");
		
		for (String w : path) System.out.println(w);
		
	}
	
}
