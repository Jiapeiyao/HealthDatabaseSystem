package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Record {
	public String PatientID;
	public String AuthorID;
	public String ParticipatingRole;
	public ArrayList<String> insertSQL;
	private final String recordFormat = "RECORD(PatientID, AuthorID, ParticipatingRole)";
	private final String recordPK = " ON DUPLICATE KEY UPDATE  PatientID=PatientID, AuthorID=AuthorID;\n";
	
	public Record(){
		insertSQL=new ArrayList<String>();
	}

	public void addRecord(String PatientID, String AuthorID, String ParticipatingRole) {
		this.PatientID = "'"+ERModel.cQ(PatientID)+"'";
		this.AuthorID = "'"+ERModel.cQ(AuthorID)+"'";
		this.ParticipatingRole = "'"+ERModel.cQ(ParticipatingRole)+"'";
		insertSQL.add(ERModel.generateNewSql(recordFormat, this.attributes(), recordPK));
	}

	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PatientID);
		L.add(AuthorID);
		L.add(ParticipatingRole);
		return L;
	}
}
