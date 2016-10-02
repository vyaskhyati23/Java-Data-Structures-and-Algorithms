package LCS_PROJECT;

import java.util.Random;

/**
 * @author Khyati K.Vyas
 *
 */

public class LCS_DP {

	private static final String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		/**
		 * TODO Calling the randomStringGenerator function to generate two
		 * random alphabet strings.
		 */

		String s1 = randomStringGenerator(40000);
		String s2 = randomStringGenerator(1000);
		
	
		/**
		 * Prints strings and their lengths
		 */

		System.out.println("String is: " + s1);
		System.out.println("Length of first string is " + s1.length());

		System.out.println("String is: " + s2);
		System.out.println("Length of second string is " + s2.length());

		/**
		 * Start and end time before and after LCS_DP is recorded to calculate
		 * the time taken to compute LCS.
		 */

		long start = System.currentTimeMillis();
		/**
		 * Call to the LCS_DP which returns the final LCS of the strings s1 and
		 * s2.
		 */
		String result = LCS_DP(s1, s2);
		long end = System.currentTimeMillis();
		System.out.println("Time elapsed in Milliseconds : " + (end - start));
		System.out.println("LCS IS " + result);
		System.out.println("Length of LCS is : " + result.length());

	}

	/**
	 * 
	 * @param number
	 *            -Creates randomly generated strings of the specified number.
	 * @return randomGeneratedString. The randomly generated string of varying
	 *         lengths.
	 */

	public static String randomStringGenerator(int number) {
		StringBuffer randomGeneratedString = new StringBuffer();

		int s_length = s.length();
		for (int i = 0; i < number; i++) {
			double position = Math.random() * s_length;
			randomGeneratedString.append(s.charAt((int) position));
		}
		return randomGeneratedString.toString();
	}

	/**
	 * 
	 * @param s1
	 *            - first sequence of type String
	 * @param s2
	 *            - second sequence of type String
	 * @return finalString - computed LCS of s1 , s2.
	 */
	public static String LCS_DP(String s1, String s2) {
		String finalString = "";
		/**
		 * Grid to store the solutions of the sub-problems.
		 */
		int[][] LCS_grid = new int[s1.length() + 1][s2.length() + 1];
		/**
		 * Storing solutions of the sub problems.
		 */
		for (int k = s1.length() - 1; k >= 0; k--) {
			for (int m = s2.length() - 1; m >= 0; m--) {

				if (s1.charAt(k) == s2.charAt(m)) {
					LCS_grid[k][m] = (char) (LCS_grid[k + 1][m + 1] + 1);
				} else {
					int max = Math.max(LCS_grid[k + 1][m], LCS_grid[k][m + 1]);
					LCS_grid[k][m] = max;
				}
			}
		}

		/**
		 * Starting from bottom right corner to backtrack to print the LCS.
		 */
		int x = 0, y = 0;
		while (x < s1.length() && y < s2.length()) {

			if (s1.charAt(x) == s2.charAt(y)) {
				finalString = finalString + s1.charAt(x);
				x++;
				y++;
			} else if (LCS_grid[x + 1][y] >= LCS_grid[x][y + 1]) {
				x++;
			} else
				y++;
		}

		return finalString;
	}

}
