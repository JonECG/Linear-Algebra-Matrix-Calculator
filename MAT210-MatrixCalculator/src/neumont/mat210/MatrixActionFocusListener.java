package neumont.mat210;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public abstract class MatrixActionFocusListener implements ActionListener, FocusListener
{
	protected int column, row;
	
	public MatrixActionFocusListener( int column, int row )
	{
		this.column = column;
		this.row = row;
	}

	@Override
	public void focusGained(FocusEvent e){};

	@Override
	public void focusLost(FocusEvent e)
	{
		update(e);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		update(e);
	}
	
	public abstract void update( AWTEvent e );
}
