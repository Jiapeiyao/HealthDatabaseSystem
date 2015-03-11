package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class FamilyHistory {
	public String PatientID;
	public String RelativeID;
	public String Relation;
	public ArrayList<String> insertSQL;
	private final String familyHistoryFormat = "FAMILYHISTORY(PatientID, RelativeID, Relation)";
	private final String familyHistoryPK = " ON DUPLICATE KEY UPDATE PatientID=PatientID, RelativeID=RelativeID;\n";
	
	public FamilyHistory(){
		insertSQL=new ArrayList<String>();
	}
	
	public void addFamilyHistory(String PatientID, String RelativeID, String Relation){
		this.PatientID = "'"+ERModel.cQ(PatientID)+"'";
		this.RelativeID = "'"+ERModel.cQ(RelativeID)+"'";
		this.Relation = "'"+ERModel.cQ(Relation)+"'";
		 insertSQL.add(ERModel.generateNewSql(familyHistoryFormat, this.attributes(), familyHistoryPK));
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
