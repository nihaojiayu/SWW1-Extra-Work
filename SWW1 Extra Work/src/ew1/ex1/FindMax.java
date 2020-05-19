package ew1.ex1;

import java.util.Arrays;

/**
 * Extra work 1 - Exercise1
 * 
 * The class contains the static method max which computes the
 * maximum of a non-empty one-dimensional array of type int[].
 * @author Jiayu Zhang
 * @version 2020-05-18
 * 
 */
public class FindMax {
	
	/**
	 * The method computes the maximum of a non-empty one-dimensional array of type int[].
	 * @param an An arbitrary non-empty array of type int[].
	 * @return The maximal value of all the values in a.
	 */
	public static int max(int[] a) {
		int max = a[0];
		for(int e : a) {
			if(e > max)
				max = e;
		}
		return max;
	}
	
	/**
	 * Faster method.
	 * @param an An arbitrary non-empty array of type int[].
	 * @return The maximal value of all the values in a.
	 */
	public static int fasterMaxMethod(int[] a) {
		int max = Arrays.stream(a).max().getAsInt();
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		System.out.println("The maximum value in the array is: " + max(a));
		int[] b = {1,5,3};
		System.out.println("The maximum value in the array is: " + max(b));
		int[] c = {7,4,3};
		System.out.println("The maximum value in the array is: " + max(c));
		int[] d = {-1,-2,-3};
		System.out.println("The maximum value in the array is: " + max(d));
		int[] e = {-5};
		System.out.println("The maximum value in the array is: " + max(e));
	}
}
