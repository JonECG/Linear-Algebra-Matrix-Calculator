package neumont.mat210;

public class Matrix 
{
	public double[][] cells;
	private double determinant;
	
	public Matrix(){ this(3); }
	
	public Matrix( int dimension ){
		this.cells = new double[dimension][dimension];
		//calculateDeterminant();
	}
	
	private double calculateDeterminant(){
		double determinate = 0;
		int sign = 1;
		for( int i = 0; i < cells.length; i++ )
		{
			determinate += sign * MatrixMath.minor( this, i, 0 ).calculateDeterminant();
			sign *= -1;
		}
		return determinate;
	}
	
	public int getDimension()
	{
		return cells.length;
	}
	
	public double getDeterminant()
	{
		return determinant;
	}
	
	public void changeDimension( int newDimension ){
		
	}
	
	public void setCell( int column, int row, double value ){
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
