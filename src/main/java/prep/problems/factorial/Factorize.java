package prep.problems.factorial;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashSet;

// Compute the prime factorization of a number
public class Factorize {
  
	public int factorialTrailingZeroes(int n) {
		Map<Integer, Integer> factors = factorialPrimeFactors(n);
		
		if (factors.containsKey(5)) return factors.get(5);
		else return 0;
	}
	
	
	
	public Map<Integer, Integer> factorialPrimeFactors(int n) {
		
		List<Map<Integer, Integer>> factorizations = new LinkedList<Map<Integer, Integer>>();
		
		// get the prime factorizations for 2 through n
		for (int i = 2; i <= n; i++) {
			factorizations.add(primeFactors(i));
		}
		
		// combine them
		Map<Integer, Integer> allFactors = new HashMap<Integer, Integer>();
		for (Map<Integer, Integer> factors : factorizations) {
			for (Entry<Integer, Integer> entry : factors.entrySet()) {
				int base = entry.getKey();
				int exp = entry.getValue();
				if (allFactors.containsKey(base)) {
					int currentExp = allFactors.get(base);
					allFactors.put(base, currentExp + exp);
				} else {
					allFactors.put(base, exp);
				}
			}
		}
		
		return allFactors;
	}
	
	public Map<Integer, Integer> primeFactors(int n) {
		
		if (n < 2) return Collections.emptyMap();
		
		// base -> exponent
		Map<Integer, Integer> factors = new HashMap<Integer, Integer>();
		
		int d = 2;
		
		while (n != 1 && d <= n) {
			
			if (isPrime(d) && n % d == 0) {
				n /= d;
				if (factors.containsKey(d)) {
					int e = factors.get(d);
					factors.put(d, e + 1);
				} else {
					factors.put(d,  1);
				}
				d = 2;
			} else if (d <= Math.ceil(Math.sqrt(n))) {
				d++;
			} else {
				d = n;
			}
		}
		
		return factors;
	}
	
	private Set<Integer> knownPrimes = new HashSet<Integer>();
	
	private boolean isPrime(int n) {
		
		if (n < 2) return false;
		if (n == 2) return true;
		
		if (knownPrimes.contains(n)) return true;
		
		int sqrt = (int)Math.ceil(Math.sqrt(n));
		
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) return false;
		}
		
		knownPrimes.add(n);
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Factorize f = new Factorize();
		
		int n = 100;
		
		Map<Integer, Integer> factors = f.factorialPrimeFactors(n);
		
		for (Entry<Integer, Integer> entry : factors.entrySet()) {
			int d = entry.getKey();
			int e = entry.getValue();
			System.out.println(d + "^" + e);
		}
		
	}
	
}
