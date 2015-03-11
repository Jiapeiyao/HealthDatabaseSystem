package entityRelationModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Insurances {
	public String PayerID;
	public String PayerName; 
   	public String Purpose;
   	public String PolicyType;
   	public String PolicyHolder;
   	public String insertSQL;
   	private final String insurancesFormat = "INSURANCES(PayerID, PayerName, Purpose, PolicyType, PolicyHolder)";
   	private final String insurancesPK = " ON DUPLICATE KEY UPDATE PayerID=PayerID;\n";
   	
   	public Insurances(){
		insertSQL="";
   	}
   	
	public void addInsurances(String PayerID, String PayerName, String Purpose, String PolicyType, String PolicyHolder) {
		this.PayerID = "'"+PayerID+"'";
		this.PayerName = "'"+PayerName+"'";
		this.Purpose = "'"+Purpose+"'";
		this.PolicyType = "'"+PolicyType+"'";
		this.PolicyHolder = "'"+PolicyHolder+"'";
		insertSQL += ERModel.generateNewSql(insurancesFormat, this.attributes(), insurancesPK);
	}

//	public String attributes(){
//		return PayerID+", "+PayerName+", "+Purpose+", "+PolicyType+", "+PolicyHolder;
//	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PayerID);
		L.add(PayerName); 
		L.add(Purpose);
		L.add(PolicyType);
		L.add(PolicyHolder);
		return L;
	}
	
	public void insert(Connection conn)  throws SQLException {
		try{
			if (isValid(conn)){
				//prepare the sql command
				String sqlComm = "INSERT INTO INSURANCES(PayerID, PayerName, Purpose, PolicyType, PolicyHolder) VALUES (?,?,?,?,?)";
	            PreparedStatement pst = conn.prepareStatement(sqlComm);
	            pst.setString(1, PayerID);
	            pst.setString(2, PayerName);
	            pst.setString(3, Purpose);
	            pst.setString(4, PolicyType);
	            pst.setString(5,  PolicyHolder);
	            pst.executeUpdate();
			}
	        }catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	}
	
	private boolean isValid(Connection conn){
		ResultSet rs = null;
		int count = 0;
		try{
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) AS Count "
									+ " FROM I fh "
									+ " WHERE fh.PayerID="+PayerID);
			if (rs.next())
				count = rs.getInt("Count");
			return count == 0;
	        }catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
		return true;
	}
}
