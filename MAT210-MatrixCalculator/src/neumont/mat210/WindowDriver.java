package neumont.mat210;


import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;

public class WindowDriver
{
	static final int NUMBER_OF_MATRICES = 4;
	
	private static JFrame frame;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args )
	{
		EventQueue.invokeLater( new Runnable()
		{
			public void run()
			{
				try
				{
					WindowDriver window = new WindowDriver();
					frame.setVisible( true );
				}
				catch ( Exception e )
				{
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the application.
	 */
	public WindowDriver()
	{
		initialize();
	}
	
	public static void showErrorMessage( String title, String message )
	{
		JOptionPane.showMessageDialog(frame, message, title,  JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds( 100, 100, 778, 544 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBounds(0, 0, 760, 494);
		frame.getContentPane().add(tabbedPane);
		
		Matrix[] matrices = { Matrix.getIdentity(3), Matrix.getIdentity(3), Matrix.getIdentity(3), Matrix.getIdentity(3) };
		
		final MatrixSetTab setPanel = new MatrixSetTab( matrices );
		tabbedPane.addTab("Edit Matrices", null, setPanel, null);

		final UnaryTab unaryPanel = new UnaryTab( matrices );
		tabbedPane.addTab("Unary Operations", null, unaryPanel, null);
		
		final BinaryTab binaryPanel = new BinaryTab( matrices );
		tabbedPane.addTab("Binary Operations", null, binaryPanel, null);
		
		final ScalarTab scalarTab = new ScalarTab( matrices );
		tabbedPane.addTab("Scaling", null, scalarTab, null);
		
		tabbedPane.addChangeListener( new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				setPanel.resetMatrixPanel();
				unaryPanel.resetMatrixPanel();
				binaryPanel.resetMatrixPanel();
				scalarTab.resetMatrixPanel();
			}
		});
	}
}
