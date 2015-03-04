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
	private final Database Database;
	
	private final JButton loadButton = new JButton("Load");
	private final JButton runButton = new JButton("Run");
	private final JButton stepButton = new JButton("Step");
	
	private final JTextArea InputText = new JTextArea(6,0);
	private final JTextArea DataMemoryCell = new JTextArea(6,0);
	private final JTextArea DataStack = new JTextArea(6,0);
	private final JTextArea BuildInfo= new JTextArea(6,0);
	private final JScrollPane ScrollInputText = new JScrollPane(InputText);
	private final JScrollPane ScrollDataMemoryCell = new JScrollPane(DataMemoryCell);
	private final JScrollPane ScrollDataStack = new JScrollPane(DataStack);
	private final JScrollPane ScrollBuildInfo = new JScrollPane(BuildInfo);
	private final JPanel TextPanel = new JPanel();
	
	ControlPanel( View view, Database Database ){
		this.view = view;
		this.Database = Database;
		
		setLayout( new GridLayout( 1, 3 ) );
		add( loadButton );
		add( runButton );
		add( stepButton );
		
		runButton.setEnabled(false);
		stepButton.setEnabled(false);
		 
		initialize();
		//view.setImage( Database.getImage() );
		}
	
	private void initialize(){
		loadButton.addActionListener( new ActionListener() {
		    //@Override
			public void actionPerformed( ActionEvent actionEvent )
			{ loadButtonActionPerformed( actionEvent ); }
		});
		runButton.addActionListener( new ActionListener() {
		    //@Override
			public void actionPerformed( ActionEvent actionEvent )
			{ runButtonActionPerformed( actionEvent ); }
		});
		
		stepButton.addActionListener( new ActionListener() {
			 //@Override
			public void actionPerformed( ActionEvent actionEvent )
			{ stepButtonActionPerformed( actionEvent ); }
		});
	}
	
	/**
     * Implementation of load Button
     * @param actionEvent unused
     */
	private void loadButtonActionPerformed( ActionEvent actionEvent ) {

	}
	
	/**
     * Implementation of run Button
     * @param actionEvent unused
     */
	private void runButtonActionPerformed( ActionEvent actionEvent ) {

	}
	
	/**
     * Implementation of step Button
     * @param actionEvent unused
     */
	private void stepButtonActionPerformed( ActionEvent actionEvent ) {

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
