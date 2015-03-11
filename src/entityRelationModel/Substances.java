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

public class Substances {
	public String Id;
	public String Substance;
	public String insertSQL;
	private final String substancesFormat = "SUBSTANCES(Id, Substance)";
	private final String substancesPK = " ON DUPLICATE KEY UPDATE Id=Id;\n";
	
	public Substances(){
		insertSQL="";
	}
	
	public void addSubstances(String Id, String Substance) {
		this.Id = "'"+Id+"'";
		this.Substance = "'"+Substance+"'";
		insertSQL += ERModel.generateNewSql(substancesFormat, this.attributes(), substancesPK);


	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(Id);
		L.add(Substance);
		return L;
	}
}

