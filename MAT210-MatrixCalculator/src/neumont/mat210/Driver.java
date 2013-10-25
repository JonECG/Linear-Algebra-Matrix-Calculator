package neumont.mat210;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * this commented out code was used to test matrix multiplication but 
		 * I thought you might want to use the pre loaded matricies to test your own
		 * code
		 */
//		Matrix matrix = new Matrix(3);
//		matrix.setCell(0, 0, 1);
//		matrix.setCell(1, 0, 2);
//		matrix.setCell(2, 0, 3);
//		matrix.setCell(0, 1, 2);
//		matrix.setCell(1, 1, 3);
//		matrix.setCell(2, 1, 1);
//		matrix.setCell(0, 2, 3);
//		matrix.setCell(1, 2, 1);
//		matrix.setCell(2, 2, 2);
//		
//		System.out.println(matrix.toString());
//		
//		Matrix matrix2 = new Matrix(3);
//		matrix2.setCell(0, 0, 3);
//		matrix2.setCell(1, 0, 2);
//		matrix2.setCell(2, 0, 1);
//		matrix2.setCell(0, 1, 2);
//		matrix2.setCell(1, 1, 1);
//		matrix2.setCell(2, 1, 3);
//		matrix2.setCell(0, 2, 1);
//		matrix2.setCell(1, 2, 2);
//		matrix2.setCell(2, 2, 3);
//		
//		System.out.println("");
//		
//		System.out.println(matrix2.toString());
//		System.out.println("");
		
		Matrix matrix3 = new Matrix(4);
		matrix3.setCell(0, 0, 3);
		matrix3.setCell(1, 0, 2);
		matrix3.setCell(2, 0, 1);
		matrix3.setCell(3, 0, 4);
		
		matrix3.setCell(0, 1, 2);
		matrix3.setCell(1, 1, 1);
		matrix3.setCell(2, 1, 3);
		matrix3.setCell(3, 1, 5);
		
		matrix3.setCell(0, 2, 1);
		matrix3.setCell(1, 2, 2);
		matrix3.setCell(2, 2, 3);
		matrix3.setCell(3, 2, 2);
		
		matrix3.setCell(0, 3, 4);
		matrix3.setCell(1, 3, 2);
		matrix3.setCell(2, 3, 3);
		matrix3.setCell(3, 3, 1);
		
		System.out.println("");
		
		System.out.println(matrix3.toString());
		System.out.println("");
		
		Matrix matrix4 = new Matrix(4);
		matrix4.setCell(0, 0, 1);
		matrix4.setCell(1, 0, 2);
		matrix4.setCell(2, 0, 3);
		matrix4.setCell(3, 0, 4);
		matrix4.setCell(0, 1, 5);
		matrix4.setCell(1, 1, 6);
		matrix4.setCell(2, 1, 7);
		matrix4.setCell(3, 1, 8);
		matrix4.setCell(0, 2, 9);
		matrix4.setCell(1, 2, 3);
		matrix4.setCell(2, 2, 7);
		matrix4.setCell(3, 2, 4);
		matrix4.setCell(0, 3, 9);
		matrix4.setCell(1, 3, 2);
		matrix4.setCell(2, 3, 6);
		matrix4.setCell(3, 3, 1);
		
		System.out.println("");
		
		System.out.println(matrix4.toString());
		System.out.println("");
		
		Matrix m3 = MatrixMath.add(matrix3, matrix4);
		System.out.println(m3.toString());

	}

}
