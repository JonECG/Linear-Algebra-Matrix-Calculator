package neumont.mat210;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class WindowDriver
{

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setForeground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnA = new JButton("A");
		btnA.setBounds(71, 223, 49, 49);
		panel_1.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setBounds(132, 223, 49, 49);
		panel_1.add(btnB);
		
		JButton btnD = new JButton("D");
		btnD.setBounds(132, 285, 49, 49);
		panel_1.add(btnD);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(71, 285, 49, 49);
		panel_1.add(btnC);
		
		JLabel lblA = new JLabel("A=");
		lblA.setBounds(79, 109, 94, 82);
		panel_1.add(lblA);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 68));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(260, 87, 418, 315);
		panel_1.add(panel);
		panel.setBackground(SystemColor.inactiveCaption);
		
		JLabel label_1 = new JLabel("[  ]");
		label_1.setBounds(185, -57, 570, 495);
		panel_1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 409));
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
