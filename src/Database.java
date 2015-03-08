import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */
public class Database {
	private final String userName = "root";
	private final String password = "";
	private final String serverName = "localhost";
	private final int portNumber = 3306;
	private final String dbName1 = "test";
	public Connection conn = null;
	
	public Database(String dbName) {
		try {
			conn = getConnection(dbName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String dbName) throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + dbName,
				connectionProps);

		return conn;
	}
	
	public ResultSet selectTable(Connection conn, String sqlComm) throws SQLException {
		ResultSet rs = null;
		try{
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlComm);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
		return rs;
	}

	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		Database db = new Database("healthmessagesexchange2");
//		ResultSet rs = null;
//		try {
//			rs = db.selectTable(db.conn, "SELECT * FROM messages");
//			while (rs.next()){
//				System.out.print(rs.getString(5)+" ");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    db.conn.closeConnection();
//	}

}
