package neumont.mat210;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class InfoTab extends JPanel
{
	public InfoTab() {
		setLayout(null);
		
		JLabel lblMatrixCalculator = new JLabel("Matrix Calculator");
		lblMatrixCalculator.setFont(new Font("Tahoma", Font.PLAIN, 47));
		lblMatrixCalculator.setBounds(31, 26, 377, 65);
		add(lblMatrixCalculator);
		
		JLabel lblLuisAndradeTraven = new JLabel("Group: Luis Andrade, Traven Iliff, Jonathan Pearl, and Gerald Probst");
		lblLuisAndradeTraven.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLuisAndradeTraven.setBounds(31, 97, 633, 65);
		add(lblLuisAndradeTraven);
		
		JLabel lblNewLabel = new JLabel("<html>In this matrix calculator you are free to edit matrices by hand as well as perform calculations, both unary and binary, upon them in different tabs of this program. If you wish, you may save your results to another matrix to perform even more calculations on the answer in the same tab or other tabs.</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 175, 586, 220);
		add(lblNewLabel);
	}
}
