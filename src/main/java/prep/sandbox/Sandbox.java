package prep.sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sandbox {

	private static class Foo {
		
		public int a, b;
		
		public Foo(int a, int b) { 
			this.a = a; 
			this.b = b;
		}
	
	}

	public static void blarg(Foo f) {
		f = new Foo(7,8);
	}
	
	public static int factorial(int n) {
		if (n < 0) throw new IllegalArgumentException("Factorial not defined for negative numbers");
		if (n <= 2) return n;
		else return n*factorial(n-1);
	}
	
	public static void main(String[] args) {
		
		System.out.println(allPermutations("pea"));
	}

	public static Set<Set<Integer>> allSubsets(Set<Integer> s) {
		
		Set<Set<Integer>> allSubs = new HashSet<Set<Integer>>();
		allSubs.add(s);
		
		if (s.size() > 1) {
			for (Integer i : s) {
				Set<Integer> subset = new HashSet<Integer>(s);
				subset.remove(i);
				allSubs.addAll(allSubsets(subset));
			}
		}
		return allSubs;
	}
	
	public static List<String> allPermutations(String s) {
		
		if (s.isEmpty()) return Collections.singletonList(s);
		
		List<String> allPerms = new ArrayList<String>(factorial(s.length()));
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i) + s.substring(i+1, s.length());
			List<String> perms = allPermutations(sub);
			for (String perm : perms) {
				allPerms.add(s.charAt(i) + perm);
			}
		}
		return allPerms;
		
	}
	
}
