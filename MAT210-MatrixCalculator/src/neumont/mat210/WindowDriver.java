package neumont.mat210;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class WindowDriver
{
	static final int NUMBER_OF_MATRICES = 4;
	
	private JFrame frame;

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
					window.frame.setVisible( true );
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 760, 494);
		frame.getContentPane().add(tabbedPane);
		
		Matrix[] matrices = { Matrix.getIdentity(3), Matrix.getIdentity(3), Matrix.getIdentity(3), Matrix.getIdentity(3) };
		
		JPanel setPanel = new MatrixSetTab( matrices );
		tabbedPane.addTab("Edit Matrices", null, setPanel, null);
		
//		JPanel unaryPanel = new UnaryTab( matrices );
//		tabbedPane.addTab("Unary Operations", null, unaryPanel, null);
		
		JPanel binaryPanel = new BinaryTab( matrices );
		tabbedPane.addTab("Binary Operations", null, binaryPanel, null);
	}
}
