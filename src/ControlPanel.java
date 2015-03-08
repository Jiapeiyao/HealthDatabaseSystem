import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * 
 */

/**
 * @author Jiapei Yao, Xinglun
 *
 */

public class ControlPanel extends JPanel {
	private final View view;
	//private final Database Database;
	
	private final JButton patientButton = new JButton("Patient");
	private final JButton DoctorButton = new JButton("Doctor");
	private final JButton AdminButton = new JButton("Administer");
	
	private final JTextArea InputText = new JTextArea(6,0);
	private final JTextArea DataMemoryCell = new JTextArea(6,0);
	private final JTextArea DataStack = new JTextArea(6,0);
	private final JTextArea BuildInfo= new JTextArea(6,0);
	private final JScrollPane ScrollInputText = new JScrollPane(InputText);
	private final JScrollPane ScrollDataMemoryCell = new JScrollPane(DataMemoryCell);
	private final JScrollPane ScrollDataStack = new JScrollPane(DataStack);
	private final JScrollPane ScrollBuildInfo = new JScrollPane(BuildInfo);
	private final JPanel TextPanel = new JPanel();
	
	ControlPanel( View view ){
		this.view = view;
		//this.Database = Database;
		
		setLayout( new GridLayout( 1, 3 ) );
		add( patientButton );
		add( DoctorButton );
		add( AdminButton );
		
		//DoctorButton.setEnabled(false);
		//AdminButton.setEnabled(false);
		
		initialize();
		//view.setImage( Database.getImage() );
		}
	
	private void initialize(){
		patientButton.addActionListener( new ActionListener() {
		    //@Override
			public void actionPerformed( ActionEvent actionEvent )
			{ patientButtonActionPerformed( actionEvent ); }
		});
		DoctorButton.addActionListener( new ActionListener() {
		    //@Override
			public void actionPerformed( ActionEvent actionEvent )
			{ DoctorButtonActionPerformed( actionEvent ); }
		});
		
		AdminButton.addActionListener( new ActionListener() {
			 //@Override
			public void actionPerformed( ActionEvent actionEvent )
			{ AdminButtonActionPerformed( actionEvent ); }
		});
	}
	
	/**
     * Implementation of load Button
     * @param actionEvent unused
     */
	private void patientButtonActionPerformed( ActionEvent actionEvent ) {

	}
	
	/**
     * Implementation of run Button
     * @param actionEvent unused
     */
	private void DoctorButtonActionPerformed( ActionEvent actionEvent ) {

	}
	
	/**
     * Implementation of step Button
     * @param actionEvent unused
     */
	private void AdminButtonActionPerformed( ActionEvent actionEvent ) {

	}
	
	/**
	 * pass the JPanel consist of two JTextArea to outer program
	 * @return TextPanel
	 */
	public JPanel getTextPanel(){
		InputText.setBounds(0, 0, 10000, 30);
		JSplitPane dataSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ScrollDataMemoryCell, ScrollDataStack);
		dataSplitPane.setMinimumSize(new Dimension(60,60));
		JSplitPane upperSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
	               ScrollInputText, dataSplitPane);
		upperSplitPane.setMinimumSize(new Dimension(60,60));
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
               upperSplitPane, ScrollBuildInfo);
		splitPane.setMinimumSize(new Dimension(120,180));

		InputText.setEditable(false);
		BuildInfo.setEditable(false);
		DataMemoryCell.setEditable(false);
		DataStack.setEditable(false);
		TextPanel.setLayout(new GridLayout());
		TextPanel.add(splitPane);
		
		return TextPanel;
	}
}
