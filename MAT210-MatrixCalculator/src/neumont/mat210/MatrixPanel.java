package neumont.mat210;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MatrixPanel extends JPanel
{
	private boolean isEditable;
	private Matrix mat;
	private DecimalFormat df;
	private ArrayList<JTextField> jFields;
	
	public MatrixPanel( boolean isEditable ) 
	{
		this.isEditable = isEditable;
		setLayout(new GridLayout(1, 0, 0, 0));
		df = new DecimalFormat("#.######");
		jFields = new ArrayList<JTextField>();
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
			jFields.clear();
			setLayout(new GridLayout(mat.getDimension(), mat.getDimension(), 0, 0));
			for( int i = 0; i < mat.getDimension(); i++ )
			{
				for( int j = 0; j < mat.getDimension(); j++ )
				{
					JTextField cell = new JTextField( df.format( mat.getCell(i, j ) + 0.0 ) );
					cell.setEditable( isEditable );
					jFields.add(cell);
					
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
								field.setText( df.format( mat.getCell(column, row ) + 0.0 ) );
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
		else
		{
			removeAll();
			jFields.clear();
			setLayout(new GridLayout(1,1, 0, 0));
			add(new JLabel("No Matrix"));
		}
		revalidate();
		repaint();
	}
	
	@Override
	public void validate()
	{
		if (mat != null)
		{
			GridLayout lay = (GridLayout)getLayout();
			if( lay.getRows() != mat.getDimension() )
			{
				updateView();
			}
			else
			{
				updateTextAreas();
			}
		}
		super.validate();
	}
	
	private void updateTextAreas() 
	{
		for( int i = 0; i < jFields.size(); i++ )
		{
			jFields.get(i).setText( df.format( mat.getCell( i/mat.getDimension(), i%mat.getDimension() ) ) );
		}
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
