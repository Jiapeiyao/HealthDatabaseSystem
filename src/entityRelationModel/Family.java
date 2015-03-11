package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Family {
	public String RelativeID;
	public String Age;
	public String Diagnosis;
	public ArrayList<String> insertSQL;
	private final String familyFormat = "FAMILY(RelativeID, Age, Diagnosis)";
	private final String familyPK = " ON DUPLICATE KEY UPDATE RelativeID=RelativeID;\n";
	
	public Family(){
		insertSQL=new ArrayList<String>();
	}
	
	public void addFamily(String RelativeID, String Age, String Diagnosis) {
		this.RelativeID = "'"+ERModel.cQ(RelativeID)+"'";
		this.Age = Age;
		this.Diagnosis = "'"+ERModel.cQ(Diagnosis)+"'";
		 insertSQL.add(ERModel.generateNewSql(familyFormat, this.attributes(), familyPK));
	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(RelativeID);
		L.add(Age);
		L.add(Diagnosis);
		return L;
	}
}
