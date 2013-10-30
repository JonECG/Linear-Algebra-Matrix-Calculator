package neumont.mat210;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryTab extends JPanel {

	private Matrix[] matrices;

	private MatrixPanel leftMatrix;
	private MatrixPanel rightMatrix;
	private MatrixPanel resultMatrix;
	
	private MatrixSelector selectLeftMatrix;
	private MatrixSelector selectRightMatrix;
	private MatrixSelector saveResult;

	private JLabel leftMatrixLabel;
	private JLabel rightMatrixLabel;
	private JLabel lblResult;
	private JLabel label;

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
		this.setBounds(0, 0, 760, 465);
		setLayout(null);

		leftMatrix = new MatrixPanel(false);
		leftMatrix.setBackground(SystemColor.inactiveCaption);
		leftMatrix.setBounds(49, 88, 160, 160);
		leftMatrix.setMatrix(matrices[0]);
		add(leftMatrix);

		rightMatrix = new MatrixPanel(false);
		rightMatrix.setBackground(SystemColor.inactiveCaption);
		rightMatrix.setBounds(558, 88, 160, 160);
		rightMatrix.setMatrix(matrices[1]);
		add(rightMatrix);

		resultMatrix = new MatrixPanel(false);
		resultMatrix.setBackground(new Color(0, 204, 204));
		resultMatrix.setBounds(285, 218, 205, 209);
		resultMatrix.setMatrix(null);
		add(resultMatrix);





		leftMatrixLabel = new JLabel("A=");
		leftMatrixLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		leftMatrixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftMatrixLabel.setBounds(63, 11, 124, 66);
		add(leftMatrixLabel);

		rightMatrixLabel = new JLabel("B=");
		rightMatrixLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		rightMatrixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightMatrixLabel.setBounds(579, 11, 124, 66);
		add(rightMatrixLabel);

		lblResult = new JLabel("RESULT");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResult.setBounds(350, 182, 68, 44);
		add(lblResult);

		JLabel saveResultLabel = new JLabel("Save result to:");
		saveResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveResultLabel.setBounds(520, 360, 94, 14);
		add(saveResultLabel);

		selectLeftMatrix = new MatrixSelector(matrices)
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				leftMatrixLabel.setText( this.getCurrentMatrixLetter() + "=" );
				leftMatrix.setMatrix( getCurrentMatrix() );
			}
		};
		selectLeftMatrix.setBounds(10,316,110,111);
		add(selectLeftMatrix);

		selectRightMatrix = new MatrixSelector(matrices)
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				rightMatrixLabel.setText( this.getCurrentMatrixLetter() + "=" );
				rightMatrix.setMatrix( getCurrentMatrix() );
			}
		};
		selectRightMatrix.currentlySelected = 1;
		selectRightMatrix.setBounds(640,316,110,111);
		add(selectRightMatrix);

		saveResult = new MatrixSelector(matrices)
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(resultMatrix.getMatrix() != null)
				{
					int matrixIndex = 0;
					if(getCurrentMatrixIndex() == 0)
					{
						matrixIndex = 0;
					}
					if(getCurrentMatrixIndex() == 1)
					{
						matrixIndex = 1;
					}
					if(getCurrentMatrixIndex() == 2)
					{
						matrixIndex = 2;
					}
					if(getCurrentMatrixIndex() == 3)
					{
						matrixIndex = 3;
					}

					for(int col = 0; col < matrices[matrixIndex].getDimension(); col++)
						for(int row = 0; row < matrices[matrixIndex].getDimension(); row++)
							matrices[matrixIndex].setCell(col, row, resultMatrix.getMatrix().getCell(col, row));
					
					rightMatrix.validate();
					leftMatrix.validate();
				}
				else
					WindowDriver.showErrorMessage("No result", "Perform one of the binary operations in order to get a result to save.");
			}
		};
		saveResult.setBounds(520,385,110,111);
		add(saveResult);





		JRadioButton rbtnAdd = new JRadioButton("Addition");
		rbtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rbtnAdd.setHorizontalAlignment(SwingConstants.CENTER);
		rbtnAdd.setBounds(271, 32, 225, 36);
		rbtnAdd.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("Add");
				if(leftMatrix.getMatrix().getDimension() != rightMatrix.getMatrix().getDimension())
					WindowDriver.showErrorMessage("Matrix Dimension error", "Matrices must be the same dimension in order to perform binary operations.");
				else
					resultMatrix.setMatrix(MatrixMath.add(leftMatrix.getMatrix(), rightMatrix.getMatrix()));
			}
		});
		add(rbtnAdd);

		JRadioButton rbtnSubtract = new JRadioButton("Subtraction");
		rbtnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rbtnSubtract.setHorizontalAlignment(SwingConstants.CENTER);
		rbtnSubtract.setBounds(271, 88, 225, 36);
		rbtnSubtract.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("subtract");
				if(leftMatrix.getMatrix().getDimension() != rightMatrix.getMatrix().getDimension())
					WindowDriver.showErrorMessage("Matrix Dimension error", "Matrices must be the same dimension in order to perform binary operations.");
				else
					resultMatrix.setMatrix(MatrixMath.subtract(leftMatrix.getMatrix(), rightMatrix.getMatrix()));
			}
		});
		add(rbtnSubtract);

		JRadioButton rbtnMultiply = new JRadioButton("Multiply");
		rbtnMultiply.setHorizontalAlignment(SwingConstants.CENTER);
		rbtnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rbtnMultiply.setBounds(271, 139, 225, 36);
		rbtnMultiply.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("multiply");
				if(leftMatrix.getMatrix().getDimension() != rightMatrix.getMatrix().getDimension())
					WindowDriver.showErrorMessage("Matrix Dimension error", "Matrices must be the same dimension in order to perform binary operations.");
				else
					resultMatrix.setMatrix(MatrixMath.multiply(leftMatrix.getMatrix(), rightMatrix.getMatrix()));
			}
		});
		add(rbtnMultiply);

		ButtonGroup binaryGroup = new ButtonGroup();
		binaryGroup.add(rbtnAdd);
		binaryGroup.add(rbtnSubtract);
		binaryGroup.add(rbtnMultiply);





		JLabel resultArea = new JLabel("[ ]");
		resultArea.setHorizontalAlignment(SwingConstants.CENTER);
		resultArea.setFont(new Font("Tahoma", Font.PLAIN, 280));
		resultArea.setBounds(236, 117, 302, 348);
		add(resultArea);

		JLabel leftMatrix_Area = new JLabel("[ ]");
		leftMatrix_Area.setHorizontalAlignment(SwingConstants.CENTER);
		leftMatrix_Area.setFont(new Font("Tahoma", Font.PLAIN, 250));
		leftMatrix_Area.setBounds(-22, -38, 302, 348);
		add(leftMatrix_Area);

		JLabel rightMatrix_Area = new JLabel("[ ]");
		rightMatrix_Area.setHorizontalAlignment(SwingConstants.CENTER);
		rightMatrix_Area.setFont(new Font("Tahoma", Font.PLAIN, 250));
		rightMatrix_Area.setBounds(487, -38, 302, 348);
		add(rightMatrix_Area);
		
		JLabel lblSelectMatrix = new JLabel("Select matrix:");
		lblSelectMatrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectMatrix.setBounds(10, 291, 110, 14);
		add(lblSelectMatrix);
		
		label = new JLabel("Select matrix:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(640, 291, 110, 14);
		add(label);

	}
	
	public void resetMatrixPanel()
	{
		leftMatrix.setMatrix( selectLeftMatrix.getCurrentMatrix() );
		rightMatrix.setMatrix( selectRightMatrix.getCurrentMatrix() );
		repaint();
	}
}
