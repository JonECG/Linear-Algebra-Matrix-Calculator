package neumont.mat210;

public class MatrixMath {
	
	public static Matrix add( Matrix a, Matrix b ){
		Matrix result = new Matrix(a.getDimension());
		for(int col = 0; col < result.getDimension(); col++)
		{
			for(int row = 0; row < result.getDimension(); row++)
			{
				double addedValue = a.getCell(col, row) + b.getCell(col, row);
				result.setCell(col, row, addedValue);
			}
		}
		return result;
	}
	
	
	public static Matrix subtract( Matrix a, Matrix b ){
		Matrix result = new Matrix(a.getDimension());
		for(int col = 0; col < result.getDimension(); col++)
		{
			for(int row = 0; row < result.getDimension(); row++)
			{
				double subtractedValue = a.getCell(col, row) - b.getCell(col, row);
				result.setCell(col, row, subtractedValue);
			}
		}
		return result;
	}
	
	//this works! tested on 2 3x3s
	public static Matrix multiply( Matrix a, Matrix b ){
		
		Matrix m = new Matrix(a.getDimension());
		
		for(int row = 0 ; row < a.getDimension() ; row++){
			for(int col = 0 ; col < a.getDimension(); col++){
				for(int i =0 ; i < a.getDimension() ; i ++){
					m.getCell(col,row += a.getCell(i, row) * b.getCell(col, i));
				}
			}
		}
		return m;
	}
	
	
	public static Matrix scale( double scalar,Matrix a){
		
		Matrix n= new Matrix(a.getDimension());
		
		for(int row=0; row < a.getDimension(); row++)
		{
		   for(int col=0; col<a.getDimension(); col++)
		   {
			  n.setCell(col, row, a.getCell(row, col) * scalar);
		   }
			   
		}
		return n;
	}
	

	public static Matrix transpose( Matrix mat ){
		Matrix result = new Matrix(mat.getDimension());
		for(int col = 0; col < mat.getDimension(); col++)
		{
			for(int row = 0; row < mat.getDimension(); row++)
			{
				result.setCell(col, row, mat.getCell(row, col));
			}
		}
		return result;
	}
	
	
	public static Matrix invert( Matrix mat ){
		return scale( 1/mat.getDeterminant(), adjoint(mat) );
	}
	
	
	private static Matrix adjoint( Matrix mat ){
		Matrix result = new Matrix( mat.getDimension() );
		for( int col = 0; col < mat.getDimension(); col++ )
		{
			for( int row = 0; row < mat.getDimension(); row++ )
			{
				result.setCell( col, row, ((col+row%2==0)?1:-1)*minor(mat, row, col).getDeterminant() );
			}
		}
		return result;
	}
	
	public static Matrix minor( Matrix mat, int column, int row ){
		Matrix result = new Matrix( mat.getDimension()-1 );
		for( int i = 0; i < mat.getDimension(); i++ )
		{
			for( int j = 0; j < mat.getDimension(); j++ )
			{
				if( i != column && j != row )
					result.setCell( (i>column)?i-1:i, (j>column)?j-j:j, mat.getCell( i, j ) );
			}
		}
		return result;
	}
}
