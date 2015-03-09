import java.sql.ResultSet;
import java.sql.SQLException;

import Data.Author;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */
public class HealthMessageExchanger {
	private final String HealthMessageExchangeSqlFileName = "healthmessagesexchange2";
	private final Database database;
	
	public HealthMessageExchanger() {
		 database = new Database(HealthMessageExchangeSqlFileName);
	}
	
	public void parseMessage(){
		ResultSet rs = null;
		try {
			rs = database.selectTable("SELECT * FROM messages");
			while (rs.next()){
				parseOneTuple(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parseOneTuple(ResultSet tuple){
		Author author = new Author();
	}
	
	

}
