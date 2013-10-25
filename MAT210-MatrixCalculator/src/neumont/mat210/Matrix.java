package neumont.mat210;

public class Matrix 
{
	public double[][] cells;
	private boolean needsToCalcDeterminate;
	private double determinant;
	
	public Matrix(){ this(3); }
	
	public Matrix( int dimension ){
		this.cells = new double[dimension][dimension];
		for( int i = 0; i < dimension; i++ )
		{
			cells[i][i] = 1;
		}
		needsToCalcDeterminate = true;
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
		needsToCalcDeterminate = true;
	}
	
	public void setCell( int column, int row, double value ){
		needsToCalcDeterminate = true;
		this.cells[column][row] = value;
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
