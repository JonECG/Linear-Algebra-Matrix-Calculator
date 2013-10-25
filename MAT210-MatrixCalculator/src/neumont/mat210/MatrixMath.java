package neumont.mat210;

public class MatrixMath {
	
	public static Matrix add( Matrix a, Matrix b ){
		return null;
	}
	
	public static Matrix subtract( Matrix a, Matrix b ){
		return null;
	}
	
	public static Matrix multiply( Matrix a, Matrix b ){
		return null;
	}
	
	public static Matrix scale( double scalar ){
		return null;
	}
	
	public static Matrix transpose( Matrix mat ){
		return null;
	}
	
	public static Matrix invert( Matrix mat ){
		return null;
	}
	
	public static Matrix adjoint( Matrix mat ){
		return null;
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
