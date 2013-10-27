package neumont.mat210;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class MatrixSelector extends JPanel implements ActionListener
{
	private Matrix[] matrices;
	private int currentlySelected;
	private int alphabetStart = 'A';
	
	public MatrixSelector( Matrix[] matrices )
	{
		this.matrices = matrices;
		this.setLayout( new GridLayout( 2, matrices.length/2 + 1, 0, 0 ) );
		for( int i = 0; i < matrices.length; i++ )
		{
			JButton button = new JButton( "" + (char)(alphabetStart + i));
			button.addActionListener( new ActionListener()
			{
				int matrixValue;
				
				public ActionListener init( int matrixValue )
				{
					this.matrixValue = matrixValue;
					return this;
				}
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					currentlySelected = matrixValue;
					performMyAction();
				}
			}.init(i));
			add(button);
		}
	}
	
	public Matrix getCurrentMatrix()
	{
		return matrices[ currentlySelected ];
	}
	
	public char getCurrentMatrixLetter()
	{
		return (char) (alphabetStart + currentlySelected);
	}
	
	protected void performMyAction()
	{
		actionPerformed( new ActionEvent( this, 0, "" ) );
	}

	@Override
	public abstract void actionPerformed(ActionEvent e);
}
