package neumont.mat210;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class MatrixSetTab extends JPanel
{

	private MatrixPanel matPanel;
	private JLabel whichMatrix;
	private Matrix[] matrices;
	
	public MatrixSetTab( Matrix[] matrices )
	{
		this.matrices = matrices;
		initialize();
	}

	private void initialize()
	{
		this.setBounds( 0, 0, 760, 500 );
		setLayout(null);

		
		whichMatrix = new JLabel("A=");
		whichMatrix.setBounds(42, 109, 165, 82);
		add(whichMatrix);
		whichMatrix.setFont(new Font("Tahoma", Font.PLAIN, 68));
		whichMatrix.setHorizontalAlignment(SwingConstants.CENTER);

		MatrixSelector select = new MatrixSelector(matrices)
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				whichMatrix.setText( this.getCurrentMatrixLetter() + "=" );
				matPanel.setMatrix( getCurrentMatrix() );
			}
		};
		select.setBounds(71,223,110,111);
		add(select);
		
		matPanel = new MatrixPanel( true );
		matPanel.setMatrix( matrices[0] );
		matPanel.setBounds(260, 87, 418, 315);
		add(matPanel);
		matPanel.setBackground(SystemColor.inactiveCaption);
		
		JButton increaseDimensions = new JButton("Increase Dimension");
		increaseDimensions.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Matrix mat = matPanel.getMatrix();
				mat.changeDimension( mat.getDimension() + 1 );
				matPanel.updateView();
			}
		});
		increaseDimensions.setBounds(398, 11, 151, 25);
		add(increaseDimensions);
		
		JButton decreaseDimension = new JButton("Truncate Dimension");
		decreaseDimension.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Matrix mat = matPanel.getMatrix();
				mat.changeDimension( Math.max( 1, mat.getDimension() - 1 ) );
				matPanel.updateView();
			}
		});
		decreaseDimension.setBounds(398, 49, 151, 25);
		add(decreaseDimension);
		
		JLabel label_1 = new JLabel("[  ]");
		label_1.setBounds(185, -57, 570, 495);
		add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 409));
	}
}
