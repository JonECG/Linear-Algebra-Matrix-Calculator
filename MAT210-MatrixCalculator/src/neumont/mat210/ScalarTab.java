package neumont.mat210;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScalarTab extends JPanel{
	private JTextField textField;
	private Matrix[] tabMatrix;
	private MatrixPanel mp, matrixPanel;
	MatrixSelector selector, selector2;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel lblScalar;
	private JLabel lblSetMatrix;
	private JLabel whichMatrix;
	
	public ScalarTab(Matrix[] matrix) {
		tabMatrix = matrix;
		
		setLayout(null);
		
		selector = new MatrixSelector(matrix){
			@Override
			public void actionPerformed(ActionEvent e) {
				whichMatrix.setText( this.getCurrentMatrixLetter() + "=" );
				mp.setMatrix( getCurrentMatrix() );
			}
		};
		selector.setBounds(429,31,110,111);
		
				this.add(selector);
		
		selector2 = new MatrixSelector(matrix){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tabMatrix[getCurrentMatrixIndex()] = matrixPanel.getMatrix();
				mp.setMatrix( selector.getCurrentMatrix() );
				mp.updateView();
			}
		};
		selector2.setBounds(429,278,110,111);
				
						this.add(selector2);
						
		mp = new MatrixPanel(false);
		mp.setMatrix(matrix[0]);
		mp.setBounds(151, 51, 158, 138);
		mp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		this.add(mp);
		
		textField = new JTextField();
		textField.setBounds(29, 97, 77, 44);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("[  ]");
		label.setBounds(99, -89, 374, 377);
		add(label);
		label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 200f));
		this.add(mp);
		
		lblNewLabel = new JLabel("=");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 99));
		lblNewLabel.setBounds(198, 200, 70, 44);
		add(lblNewLabel);
		
		label_1 = new JLabel("[  ]");
		label_1.setFont(label_1.getFont().deriveFont(label_1.getFont().getSize() + 200f));
		label_1.setBounds(99, 132, 374, 351);
		add(label_1);
		
		matrixPanel = new MatrixPanel(false);
		matrixPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		matrixPanel.setBounds(151, 266, 158, 138);
		matrixPanel.setMatrix(matrix[0]);
		add(matrixPanel);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int i = Integer.parseInt(textField.getText());
					matrixPanel.setMatrix(MatrixMath.scale(i, selector.getCurrentMatrix()));
				}catch(Exception ex){
					WindowDriver.showErrorMessage("Input Error", "Please enter a valid number.");
					textField.setText("");
				}
				
			}
		});
		
		btnNewButton.setBounds(439, 190, 89, 23);
		add(btnNewButton);
		
		lblScalar = new JLabel("Scalar");
		lblScalar.setBounds(43, 76, 46, 14);
		add(lblScalar);
		
		lblSetMatrix = new JLabel("Save to matrix:");
		lblSetMatrix.setBounds(439, 251, 89, 14);
		add(lblSetMatrix);
		
		whichMatrix = new JLabel("A =");
		whichMatrix.setFont(new Font("Tahoma", Font.PLAIN, 26));
		whichMatrix.setBounds(208, 11, 66, 23);
		add(whichMatrix);
	}
	
	public void resetMatrixPanel()
	{
		mp.setMatrix( selector.getCurrentMatrix() );
		repaint();
	}
}
