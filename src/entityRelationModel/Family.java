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

public class Family {
	public String RelativeID;
	public String Age;
	public String Diagnosis;
	public String insertSQL;
	private final String familyFormat = "FAMILY(RelativeID, Age, Diagnosis)";
	private final String familyPK = " ON DUPLICATE KEY UPDATE RelativeID=RelativeID;\n";
	
	public Family(){
		insertSQL="";
	}
	
	public void addFamily(String RelativeID, String Age, String Diagnosis) {
		this.RelativeID = "'"+RelativeID+"'";
		this.Age = Age;
		this.Diagnosis = "'"+Diagnosis+"'";
		insertSQL += ERModel.generateNewSql(familyFormat, this.attributes(), familyPK);
	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(RelativeID);
		L.add(Age);
		L.add(Diagnosis);
		return L;
	}
}
