package entityRelationModel;

import java.util.ArrayList;


/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Allergies {
	public String PatientID;
	public String SubstanceID;
	public String AllergyStatus;
	public String Reaction;
	public ArrayList<String> insertSQL;
	private final String allergiesFormat = "ALLERGIES(PatientID, SubstanceID, AllergyStatus, Reaction)";
	private final String allergiesPK = " ON DUPLICATE KEY UPDATE PatientID=PatientID, SubstanceID=SubstanceID;\n";
	
	public Allergies(){
		insertSQL=new ArrayList<String>();
	}
	
	public void addAllergies(String PatientID, String SubstanceID, String AllergyStatus, String Reaction){
		this.PatientID = "'"+ERModel.cQ(PatientID)+"'";
		this.SubstanceID = "'"+ERModel.cQ(SubstanceID)+"'";
		this.AllergyStatus = "'"+ERModel.cQ(AllergyStatus)+"'";
		this.Reaction = "'"+ERModel.cQ(Reaction)+"'";
		insertSQL.add(ERModel.generateNewSql(allergiesFormat, this.attributes(), allergiesPK));
	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PatientID);
		L.add(SubstanceID);
		L.add(AllergyStatus);
		L.add(Reaction);
		return L;
	}
	
}
