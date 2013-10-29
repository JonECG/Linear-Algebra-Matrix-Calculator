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
	private JLabel whichMatrix;
	MatrixSelector selector, selector2;
	private JLabel lblNewLabel;
	private JLabel label_1;
	
	public ScalarTab(Matrix[] matrix) {
		this.tabMatrix = matrix;
		
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
				
				tabMatrix[selector.getCurrentMatrixIndex()] = matrixPanel.getMatrix();
				mp.setMatrix( getCurrentMatrix());
			}
		};
		selector2.setBounds(429,278,110,111);
				
						this.add(selector2);
						
		mp = new MatrixPanel(false);
		mp.setMatrix(matrix[0]);
		mp.setBounds(151, 31, 158, 138);
		mp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		this.add(mp);
		
		textField = new JTextField();
		textField.setBounds(29, 97, 77, 44);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("[  ]");
		label.setBounds(99, -110, 374, 377);
		add(label);
		label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 200f));
		this.add(mp);
		whichMatrix = new JLabel();
		whichMatrix.setBounds(40, 555, 228, -122);
		whichMatrix.setText("A");
		this.add(whichMatrix);
		
		lblNewLabel = new JLabel("=");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 99));
		lblNewLabel.setBounds(198, 180, 70, 44);
		add(lblNewLabel);
		
		label_1 = new JLabel("[  ]");
		label_1.setFont(label_1.getFont().deriveFont(label_1.getFont().getSize() + 200f));
		label_1.setBounds(99, 114, 374, 351);
		add(label_1);
		
		matrixPanel = new MatrixPanel(false);
		matrixPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		matrixPanel.setBounds(151, 251, 158, 138);
		matrixPanel.setMatrix(matrix[0]);
		add(matrixPanel);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(textField.getText());
				matrixPanel.setMatrix(MatrixMath.scale(i, selector.getCurrentMatrix()));
			}
		});
		btnNewButton.setBounds(439, 190, 89, 23);
		add(btnNewButton);
	}
}
