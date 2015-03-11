import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	public Connection conn = null;
	public final String dbName;
	
	public Database(String dbName) {
		this.dbName = dbName;
		try {
			conn = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Get a new database connection
	 * 
	 * @return conn
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + dbName,
				connectionProps);

		return conn;
	}
	
	/**
	 * Get the result set from this database
	 * 
	 * @param sqlComm
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet selectTable(String sqlComm)  throws SQLException {
		ResultSet rs = null;
		try{
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlComm);
	        }catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
		return rs;
	}
	
	/**
	 * Execute insert query
	 * 
	 * @param sqlComm
	 * @throws SQLException
	 */
	public void executeInsert(String sqlComm)  throws SQLException {
		try{
			//prepare the sql command
            PreparedStatement pst = conn.prepareStatement(sqlComm);
            pst.executeUpdate();
	        }catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	}
	
	/**
	 * close connection to the database
	 * 
	 * @throws SQLException
	 */
	public void closeConnection()  throws SQLException {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test for reading Database
	 * @param args
	 * @throws SQLException
	 */
//	public static void main(String[] args) throws SQLException {
//		Database db = new Database("healthmessagesexchange2");
//		ResultSet rs = null;
//		try {
//			rs = db.selectTable("SELECT * FROM messages");
//			while (rs.next()){
//				for (int i = 1; i<=44; i++)
//					System.out.print(rs.getString(i)+"\t");
//				System.out.print("\n");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    try {
//			db.closeConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
