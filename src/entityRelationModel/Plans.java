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

public class Plans {
	public String PlanID;
	public String PlanDate;
	public String Activity;
	public String PatientID;
	public String insertSQL;
	private final String plansFormat = "PLANS(PlanID, PlanDate, Activity, PatientID)";
	private final String plansPK = " ON DUPLICATE KEY UPDATE PlanID=PlanID;\n";
	
	public Plans(){
		insertSQL="";
	}
	
	public void addPlans(String PlanID, String PlanDate, String Activity, String PatientID) {
		this.PlanID = "'"+PlanID+"'";
		this.PlanDate = "'"+PlanDate+"'";
		this.Activity = "'"+Activity+"'";
		this.PatientID = "'"+PatientID+"'";
		insertSQL += ERModel.generateNewSql(plansFormat, this.attributes(), plansPK);
	}

//	public String attributes(){
//		return PlanID+", "+PlanDate+", "+Activity+", "+PatientID;
//	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PlanID);
		L.add(PlanDate);
		L.add(Activity);
		L.add(PatientID);
		return L;
	}
	
	public void insert(Connection conn)  throws SQLException {
		try{
			if (isValid(conn)){
				//prepare the sql command
				String sqlComm = "INSERT INTO PLANS(PlanID, PlanDate, Activity, PatientID) VALUES (?,?,?,?)";
	            PreparedStatement pst = conn.prepareStatement(sqlComm);
	            pst.setString(1, PlanID);
	            pst.setString(2, PlanDate);
	            pst.setString(3, Activity);
	            pst.setString(4, PatientID);
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
				rs = stmt.executeQuery("SELECT COUNT(*) as Count "
										+ " FROM PLANS pl "
										+ " WHERE pl.PlanID="+PlanID);
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
