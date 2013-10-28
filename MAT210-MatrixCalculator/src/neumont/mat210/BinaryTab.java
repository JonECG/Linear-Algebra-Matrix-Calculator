package neumont.mat210;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class BinaryTab extends JPanel {

	private Matrix[] matrices;
	
	public BinaryTab( Matrix[] matrices )
	{
		this.matrices = matrices;
		initialize();
	}
	
	/**
	 * Create the panel.
	 */
	private void initialize() 
	{
		this.setBounds(0, 0, 760, 500);
		setLayout(null);
		
		JPanel matrixA = new JPanel();
		matrixA.setBackground(SystemColor.inactiveCaption);
		matrixA.setBounds(49, 88, 160, 160);
		add(matrixA);
		matrixA.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel matrixB = new JPanel();
		matrixB.setBackground(SystemColor.inactiveCaption);
		matrixB.setBounds(558, 88, 160, 160);
		add(matrixB);
		matrixB.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 204, 204));
		panel_2.setBounds(285, 256, 205, 209);
		add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel matrixALabel = new JLabel("A=");
		matrixALabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		matrixALabel.setHorizontalAlignment(SwingConstants.CENTER);
		matrixALabel.setBounds(63, 11, 124, 66);
		add(matrixALabel);
		
		JLabel matrixBLabel = new JLabel("B=");
		matrixBLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		matrixBLabel.setHorizontalAlignment(SwingConstants.CENTER);
		matrixBLabel.setBounds(579, 11, 124, 66);
		add(matrixBLabel);
		
		JRadioButton btnAdd = new JRadioButton("Addition");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAdd.setHorizontalAlignment(SwingConstants.CENTER);
		btnAdd.setBounds(271, 67, 225, 36);
		add(btnAdd);
		
		JRadioButton btnSubtract = new JRadioButton("Subtraction");
		btnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSubtract.setHorizontalAlignment(SwingConstants.CENTER);
		btnSubtract.setBounds(271, 129, 225, 36);
		add(btnSubtract);
		
		JLabel lblResult = new JLabel("Result = ");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblResult.setBounds(24, 307, 185, 124);
		add(lblResult);
		
		JLabel resultArea = new JLabel("[ ]");
		resultArea.setHorizontalAlignment(SwingConstants.CENTER);
		resultArea.setFont(new Font("Tahoma", Font.PLAIN, 280));
		resultArea.setBounds(236, 152, 302, 348);
		add(resultArea);
		
		JLabel matrixA_Area = new JLabel("[ ]");
		matrixA_Area.setHorizontalAlignment(SwingConstants.CENTER);
		matrixA_Area.setFont(new Font("Tahoma", Font.PLAIN, 250));
		matrixA_Area.setBounds(-22, -38, 302, 348);
		add(matrixA_Area);
		
		JLabel matrixB_Area = new JLabel("[ ]");
		matrixB_Area.setHorizontalAlignment(SwingConstants.CENTER);
		matrixB_Area.setFont(new Font("Tahoma", Font.PLAIN, 250));
		matrixB_Area.setBounds(487, -38, 302, 348);
		add(matrixB_Area);

	}
}
