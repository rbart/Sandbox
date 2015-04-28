package prep.problems.parens;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Parens {

	public static Set<String> parens(int n) {
		if (n == 1) return Collections.singleton("()");
		Set<String> allParens = new HashSet<String>();
		Set<String> subParens = parens(n - 1);
		for (String p : subParens) {
			allParens.add("()"+p);
			allParens.add("("+p+")");
			allParens.add(p+"()");
		}
		return allParens;
	}
	
	public static void main(String[] args) {
		
		for (String p : parens(10)) System.out.println(p);
		
	}
}
