package ew1.ex2;

/**
 *  The class contains the static method rectangular which checks for
 *  a non-empty array of type int[][] whether it is rectangular, that
 *  is, whether all its rows have the same length.
 *  
 *  @author Jiayu Zhang
 *  @version 2020-05-18
 */
public class IsRectangular {

	/**
     *  The method checks for a non-empty array of type int[][]  //int[i row][j column], two-dimensional arrays
     *  whether it is rectangular, that is, whether all its rows have
     *  the same length.
     *  @param a A non-empty array of type int[][].
     *  @return true if all rows have the same length, false if the
     *  lengths of the rows differ.
	 */
	public static boolean isRectangular(int[][] a) {  //a.length = 6
		// Compare all lengths to the length of row number 0.
		int lengthRow = a[0].length; //3
		/*
		 * if each its length is the same as the length of row 0, return true,
		 * otherwise return false immediately.
		 */
		for(int i = 1; i < a.length; i++) {
			if(a[i].length == lengthRow)
				return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] a = {{1,2,3},
					{1,3,2},
					{2,1,3},
					{2,3,1},
					{3,1,2},
					{3,2,1}};
		System.out.println(isRectangular(a)); //should be true
		int[][] b = {{1},
					{1,2},
					{1,2,3},
					{2,1},
					{1,2},
					{3,2,1}};
		System.out.println(isRectangular(b)); //should be false
	}

}
