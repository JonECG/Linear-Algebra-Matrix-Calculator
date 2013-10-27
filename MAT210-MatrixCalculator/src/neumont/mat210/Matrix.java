package neumont.mat210;

public class Matrix 
{
	private double[][] cells;
	private boolean needsToCalcDeterminate;
	private double determinant;
	
	public Matrix(){ this(3); }
	
	public Matrix( int dimension ){
		this.cells = new double[dimension][dimension];
		needsToCalcDeterminate = true;
	}
	
	public static Matrix getIdentity( int dimension )
	{
		Matrix result = new Matrix( dimension );
		
		for( int i = 0; i < dimension; i++ )
		{
			result.setCell( i, i, 1 );
		}
		
		return result;
	}
	
	private double calculateDeterminant(){
		double determinate = 0;
		if( cells.length != 1 )
		{
			int sign = 1;
			for( int i = 0; i < cells.length; i++ )
			{
				determinate += sign * cells[i][0]*MatrixMath.minor( this, i, 0 ).calculateDeterminant();
				sign *= -1;
			}
		}
		else
		{
			determinate = cells[0][0];
		}
		return determinate;
	}
	
	public int getDimension()
	{
		return cells.length;
	}
	
	public double getDeterminant()
	{
		if( needsToCalcDeterminate )
		{
			determinant = calculateDeterminant();
			needsToCalcDeterminate = false;
		}
		return determinant;
	}
	
	public void changeDimension( int newDimension ){
		double[][] newCells = new double[newDimension][newDimension];
		
		for( int i = 0; i < newDimension; i++ )
		{
			newCells[i][i] = 1;
			for( int j = 0; j < newDimension; j++ )
			{
				if( i < cells.length && j < cells.length )
				{
					newCells[i][j] = cells[i][j];
				}
			}
		}
		
		cells = newCells;
		needsToCalcDeterminate = true;
	}
	
	public void setCell( int column, int row, double value ){
		needsToCalcDeterminate = true;
		this.cells[column][row] = value;
	}
	
	public void incrementCell( int column, int row, double value ){
		needsToCalcDeterminate = true;
		this.cells[column][row] += value;
	}
	
	public double getCell( int column, int row ){
		return this.cells[column][row];
	}
	
	public String toString(){
		String s = "";
		for(int row = 0 ; row < cells.length; row++){
			for(int col = 0 ; col < cells.length; col++)
			{
				s += "["+ cells[col][row] +"]";
			}
			s+= "\n";
		}
		return s;
	}
}
