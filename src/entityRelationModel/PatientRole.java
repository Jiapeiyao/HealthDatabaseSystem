package entityRelationModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

public class PatientRole {
	public String PatientID;
    public String GuardianNo;
    public String Relationship;
    public String insertSQL;
    private final String patientRoleFormat = "PATIENTROLE(PatientID, GuardianNo, Relationship)";
    private final String patientRolePK = " ON DUPLICATE KEY UPDATE PatientID=PatientID, GuardianNo=GuardianNo;\n";
    
    public PatientRole(){
		insertSQL="";
    }
    
	public void addPatientRole(String PatientID, String GuardianNo, String Relationship) {
		this.PatientID = "'"+PatientID+"'";
		this.GuardianNo = "'"+GuardianNo+"'";
		this.Relationship = "'"+Relationship+"'";
		insertSQL += ERModel.generateNewSql(patientRoleFormat, this.attributes(), patientRolePK);
	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PatientID);
		L.add(GuardianNo);
		L.add(Relationship);
		return L;
	}
	
	public void insert(Connection conn)  throws SQLException {
		try{
			//prepare the sql command
			if (isValid(conn)){
				String sqlComm = "INSERT INTO PATIENTROLE(PatientID, GuardianNo, Relationship) VALUES (?,?,?)";
	            PreparedStatement pst = conn.prepareStatement(sqlComm);
	            pst.setString(1, PatientID);
	            pst.setString(2, GuardianNo);
	            pst.setString(3, Relationship);
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
									+ " FROM PATIENTROLE pr "
									+ " WHERE pr.PatientID="+PatientID
									+ " AND pr.GuardianNo="+GuardianNo);
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
