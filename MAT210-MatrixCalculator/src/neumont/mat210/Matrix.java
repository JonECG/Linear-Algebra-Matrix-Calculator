package neumont.mat210;

public class Matrix 
{
	private double[][] cells;
	private double determinant;
	
	public Matrix(){ this(3); }
	
	public Matrix( int dimension ){
		this.cells = new double[dimension][dimension];
		calculateDeterminant();
	}
	
	private void calculateDeterminant(){
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
}
