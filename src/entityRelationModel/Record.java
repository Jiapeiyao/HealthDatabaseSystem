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

public class Record {
	public String PatientID;
	public String AuthorID;
	public String ParticipatingRole;
	public String insertSQL;
	private final String recordFormat = "RECORD(PatientID, AuthorID, ParticipatingRole)";
	private final String recordPK = " ON DUPLICATE KEY UPDATE  PatientID=PatientID, AuthorID=AuthorID;\n";
	
	public Record(){
		insertSQL="";
	}

	public void addRecord(String PatientID, String AuthorID, String ParticipatingRole) {
		this.PatientID = "'"+PatientID+"'";
		this.AuthorID = "'"+AuthorID+"'";
		this.ParticipatingRole = "'"+ParticipatingRole+"'";
		insertSQL += ERModel.generateNewSql(recordFormat, this.attributes(), recordPK);
	}

	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PatientID);
		L.add(AuthorID);
		L.add(ParticipatingRole);
		return L;
	}
}
