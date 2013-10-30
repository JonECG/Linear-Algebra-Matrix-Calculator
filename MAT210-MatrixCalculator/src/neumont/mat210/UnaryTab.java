package neumont.mat210;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.SwingConstants;

public class UnaryTab extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -350247910530867283L;
	private Matrix[] matrices;
	private MatrixPanel input, result;
	private MatrixSelector inputSelect;
	private JTextField textField;
	public UnaryTab(Matrix[] mats) {
		setLayout(null);
		matrices=mats;
		input = new MatrixPanel(false);
		input.setMatrix(matrices[0]);
		input.setBounds(111, 39, 185, 204);
		add(input);
		
		final JLabel lblA = new JLabel("A=");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblA.setBounds(26, 105, 65, 65);
		add(lblA);
		
		inputSelect = new MatrixSelector(matrices){

			@Override
			public void actionPerformed(ActionEvent e) {
				input.setMatrix( getCurrentMatrix() );
				lblA.setText(getCurrentMatrixLetter()+ "=");
			}};
			inputSelect.setBounds(158, 296, 104, 89);
		add(inputSelect);
		
		MatrixSelector panel_2 = new MatrixSelector(matrices){

			@Override
			public void actionPerformed(ActionEvent e) {
				if( result.getMatrix() != null )
				{
					matrices[getCurrentMatrixIndex()] = result.getMatrix();
					input.updateUI();
				}
				else
				{
					WindowDriver.showErrorMessage("No result", "Perform one of the unary operations in order to get a result to save.");
				}
				
			}};
		panel_2.setBounds(507, 296, 104, 89);
		add(panel_2);
		
		result = new MatrixPanel(false);
		result.setBounds(462, 39, 191, 204);
		result.setMatrix(null);
		add(result);
		
		JButton btnInverse = new JButton("Inverse");
		btnInverse.setBounds(324, 227, 102, 23);
		add(btnInverse);
		btnInverse.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (input.getMatrix().getDeterminant() != 0)
				{
					result.setMatrix( MatrixMath.invert( input.getMatrix() ));
				}
				else
				{
					WindowDriver.showErrorMessage("Determinant of Zero", "This Matrix has no Inverse.");
				}
				
			}
			
		});
		
		JButton btnTranspose = new JButton("Transpose");
		btnTranspose.setBounds(324, 272, 102, 23);
		add(btnTranspose);
		btnTranspose.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setMatrix(MatrixMath.transpose(input.getMatrix()));
				
			}});
		
		JButton btnAdjoint = new JButton("Adjoint");
		btnAdjoint.setBounds(324, 317, 102, 23);
		add(btnAdjoint);
		
		JLabel label = new JLabel("[ ]");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 250));
		label.setBounds(10, -39, 387, 300);
		add(label);
		
		JLabel label_1 = new JLabel("[ ]");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 250));
		label_1.setBounds(362, -39, 387, 300);
		add(label_1);
		
		JLabel lblResult = new JLabel("Result=");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResult.setBounds(362, 105, 90, 65);
		add(lblResult);
		
		JLabel label_2 = new JLabel("Select matrix:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(158, 272, 110, 14);
		add(label_2);
		
		JLabel lblSaveResultTo = new JLabel("Save result to:");
		lblSaveResultTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveResultTo.setBounds(507, 272, 110, 14);
		add(lblSaveResultTo);
		btnAdjoint.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setMatrix(MatrixMath.adjoint(input.getMatrix()));
				
			}});
		
	}
	
	public void resetMatrixPanel()
	{
		input.setMatrix( inputSelect.getCurrentMatrix() );
		repaint();
	}
}
