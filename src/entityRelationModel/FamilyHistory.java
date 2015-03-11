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

public class FamilyHistory {
	public String PatientID;
	public String RelativeID;
	public String Relation;
	public String insertSQL;
	private final String familyHistoryFormat = "FAMILYHISTORY(PatientID, RelativeID, Relation)";
	private final String familyHistoryPK = " ON DUPLICATE KEY UPDATE PatientID=PatientID, RelativeID=RelativeID;\n";
	
	public FamilyHistory(){
		insertSQL="";
	}
	
	public void addFamilyHistory(String PatientID, String RelativeID, String Relation){
		this.PatientID = "'"+PatientID+"'";
		this.RelativeID = "'"+RelativeID+"'";
		this.Relation = "'"+Relation+"'";
		insertSQL += ERModel.generateNewSql(familyHistoryFormat, this.attributes(), familyHistoryPK);
	}
//
//	public String attributes(){
//		return PatientID+", "+RelativeID+", "+Relation;
//	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PatientID);
		L.add(RelativeID);
		L.add(Relation);
		return L;
	}
}
