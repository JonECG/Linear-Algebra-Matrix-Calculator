package neumont.mat210;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.AWTEvent;
import java.awt.GridLayout;

public class MatrixPanel extends JPanel
{
	private boolean isEditable;
	private Matrix mat;
	
	public MatrixPanel( boolean isEditable ) 
	{
		this.isEditable = isEditable;
		setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	public MatrixPanel( boolean isEditable, Matrix mat ) 
	{
		this.mat = mat;
		this.isEditable = isEditable;
		updateView();
	}
	
	public void updateView()
	{
		if (mat != null)
		{
			removeAll();
			setLayout(new GridLayout(mat.getDimension(), mat.getDimension(), 0, 0));
			for( int i = 0; i < mat.getDimension(); i++ )
			{
				for( int j = 0; j < mat.getDimension(); j++ )
				{
					JTextField cell = new JTextField( ""+mat.getCell(i, j));
					cell.setEditable( isEditable );
					
					if( isEditable )
					{
						MatrixActionFocusListener list = new MatrixActionFocusListener( i, j )
						{
							@Override
							public void update(AWTEvent e) 
							{
								JTextField field = ((JTextField) e.getSource());
								String currentText = field.getText();
								try
								{
									mat.setCell(column, row, Double.parseDouble( currentText ) );
								}
								catch( Exception ex ){};
								field.setText( ""+mat.getCell(column, row) );
							}
						};
						cell.addActionListener( list );
						cell.addFocusListener( list );
					}
					cell.setHorizontalAlignment(JTextField.CENTER);
					add( cell );
				}
			}
		}
		revalidate();
		repaint();
	}
	
	public void setMatrix( Matrix mat )
	{
		this.mat = mat;
		updateView();
	}
	
	public Matrix getMatrix()
	{
		return mat;
	}
}
