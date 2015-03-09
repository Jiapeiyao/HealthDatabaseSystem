import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */
public class App extends JFrame {
	private final View view = new View();
	private final ControlPanel controlPanel;
	private final Database database;
	
	App(){
		database = new Database("healthmessagesexchange2");
		controlPanel = new ControlPanel( view );        
		setTitle( "Health Message Exchange Database System" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Dimension dimension = new Dimension( view.IMAGE_SIZE, view.IMAGE_SIZE + controlPanel.getHeight() );
		setSize( dimension  );
		setPreferredSize( dimension );
	
		JScrollPane ScrollView= new JScrollPane(view);
		ScrollView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 

		add( ScrollView, BorderLayout.CENTER );
		add( controlPanel, BorderLayout.PAGE_START );
		add( controlPanel.getTextPanel(), BorderLayout.PAGE_END );
	
		setVisible( true );
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
	}

}
