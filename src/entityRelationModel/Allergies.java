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

public class Allergies {
	public String PatientID;
	public String SubstanceID;
	public String AllergyStatus;
	public String Reaction;
	public String insertSQL;
	private final String allergiesFormat = "ALLERGIES(PatientID, SubstanceID, AllergyStatus, Reaction)";
	private final String allergiesPK = " ON DUPLICATE KEY UPDATE PatientID=PatientID, SubstanceID=SubstanceID;\n";
	
	public Allergies(){
		insertSQL = "";
	}
	
	public void addAllergies(String PatientID, String SubstanceID, String AllergyStatus, String Reaction){
		this.PatientID = "'"+PatientID+"'";
		this.SubstanceID = "'"+SubstanceID+"'";
		this.AllergyStatus = "'"+AllergyStatus+"'";
		this.Reaction = "'"+Reaction+"'";
		insertSQL += ERModel.generateNewSql(allergiesFormat, this.attributes(), allergiesPK);
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
