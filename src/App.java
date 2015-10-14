/**
 * 
 */

/**
 * @author CharlesYJP
 *
 */
public class App {

	/**
	 * 
	 */
	public App() {
		HealthMessageExchanger hme = new HealthMessageExchanger();
		MainPanel mp = new MainPanel(hme.Target_DB);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
	}

}
