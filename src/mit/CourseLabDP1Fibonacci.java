package mit;

import java.util.Arrays;

/*
 * Subproblems: Prefixes. To solve 3, solve the subproblem 2. # of subproblems = n.
 * 
 * Guesses: Nothing to guess
 * 
 * Recurrence: Relate the original problem to subproblem.
 */

public class CourseLabDP1Fibonacci {
	
	public static int fibonacciNaiveTopDown(int n) {
		if(n <=2) {
			return 1;
		}
		return fibonacciNaiveTopDown(n-1) + fibonacciNaiveTopDown(n-2);
	}
	
	public static int fibonacciMemoized(int n) {
		int[] memoized = new int[n];
		Arrays.fill(memoized, -1);
		return fibonacciMemoized(n, memoized);
	}
	
	public static int fibonacciMemoized(int n, int[] memoized) {
		if(memoized[n] != -1) {
			return memoized[n];
		}
		if(n <= 2) {
			memoized[n] = 1;
			return memoized[n];
		}
		memoized[n] = fibonacciMemoized(n-1, memoized) + fibonacciMemoized(n-2, memoized);
		return memoized[n];
	}
	
	public static int fibonacciBottomUp(int n) {
		if(n <= 2) {
			return 1;
		}
		int previous = 1;
		int current = 1;
		for(int i = 2; i < n; i++) {
			int temp = current;
			current = previous + temp;
			previous = temp;
		}
		return current;
	}
	
	public static void printTimeTaken(long start, long end) {
		System.out.println("Time taken - " + (end - start));
	}
	
	public static void main(String[] args) {
		int n = 40;
		long start = System.currentTimeMillis();
		System.out.println("NaiveTopDown = " + fibonacciNaiveTopDown(n));
		long end = System.currentTimeMillis();
		printTimeTaken(start, end);
		
		start = System.currentTimeMillis();
		System.out.println("Memoized = " + fibonacciMemoized(n));
		end = System.currentTimeMillis();
		printTimeTaken(start, end);
		
		start = System.currentTimeMillis();
		System.out.println("BottomUp = " + fibonacciBottomUp(n));
		end = System.currentTimeMillis();
		printTimeTaken(start, end);
	}

}
