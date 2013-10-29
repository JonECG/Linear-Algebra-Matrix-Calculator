package neumont.mat210;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class UnaryTab extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -350247910530867283L;
	private Matrix[] matrices;
	private MatrixPanel input, result;
	public UnaryTab(Matrix[] mats) {
		setLayout(null);
		matrices=mats;
		input = new MatrixPanel(false);
		input.setMatrix(matrices[0]);
		input.setBounds(101, 56, 208, 160);
		add(input);
		
		final JLabel lblA = new JLabel("A=");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblA.setBounds(26, 105, 65, 65);
		add(lblA);
		
		MatrixSelector panel_1 = new MatrixSelector(matrices){

			@Override
			public void actionPerformed(ActionEvent e) {
				input.setMatrix( getCurrentMatrix() );
				lblA.setText(getCurrentMatrixLetter()+ "=");
			}};
		panel_1.setBounds(158, 272, 104, 65);
		add(panel_1);
		
		MatrixSelector panel_2 = new MatrixSelector(matrices){

			@Override
			public void actionPerformed(ActionEvent e) {
				matrices[getCurrentMatrixIndex()] = result.getMatrix();
				input.updateUI();
			}};
		panel_2.setBounds(507, 272, 104, 65);
		add(panel_2);
		
		result = new MatrixPanel(false);
		result.setBounds(445, 56, 208, 160);
		result.setMatrix(new Matrix(3));
		add(result);
		
		JButton btnInverse = new JButton("Inverse");
		btnInverse.setBounds(329, 227, 89, 23);
		add(btnInverse);
		btnInverse.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setMatrix( MatrixMath.invert( input.getMatrix() ));
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
		btnAdjoint.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setMatrix(MatrixMath.adjoint(input.getMatrix()));
				
			}});
		
	}
}
