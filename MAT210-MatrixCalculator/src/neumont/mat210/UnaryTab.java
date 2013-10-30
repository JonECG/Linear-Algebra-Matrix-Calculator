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
			inputSelect.setBounds(158, 272, 104, 65);
		add(inputSelect);
		
		MatrixSelector panel_2 = new MatrixSelector(matrices){

			@Override
			public void actionPerformed(ActionEvent e) {
				matrices[getCurrentMatrixIndex()] = result.getMatrix();
				input.updateUI();
			}};
		panel_2.setBounds(507, 272, 104, 65);
		add(panel_2);
		
		result = new MatrixPanel(false);
		result.setBounds(462, 39, 191, 204);
		result.setMatrix(new Matrix(3));
		add(result);
		
		JButton btnInverse = new JButton("Inverse");
		btnInverse.setBounds(329, 227, 89, 23);
		add(btnInverse);
		btnInverse.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int i = Integer.parseInt(textField.getText());
					result.setMatrix( MatrixMath.invert( input.getMatrix() ));
				}catch(Exception ex){
					WindowDriver.showErrorMessage("Determinant of Zero", "This Matrix has no Inverse.");
					textField.setText("");
				}
				
			}
			
		});
		
		JButton btnTranspose = new JButton("Transpose");
		btnTranspose.setBounds(329, 272, 89, 23);
		add(btnTranspose);
		btnTranspose.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setMatrix(MatrixMath.transpose(input.getMatrix()));
				
			}});
		
		JButton btnAdjoint = new JButton("Adjoint");
		btnAdjoint.setBounds(329, 317, 89, 23);
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
