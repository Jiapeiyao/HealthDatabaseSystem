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

public class Patients {

	public String PatientID;
	public String GivenName;
	public String FamilyName;
	public String Suffix;
	public String Gender;
	public String Birthtime;
	public String ProviderID;
	public String InsuranceID;
	public String insertSQL;
	private final String patientsFormat = "PATIENTS(PatientID, GivenName, FamilyName, Suffix, Gender, Birthtime, ProviderID, InsuranceID)";
	private final String patientsPK = " ON DUPLICATE KEY UPDATE PatientID=PatientID;\n";
	
	public Patients(){
		insertSQL="";
	}
	
	public void addPatients(String PatientID, String GivenName, String FamilyName, String Suffix, 
			String Gender, String Birthtime, String ProviderID, String InsuranceID) {
		this.PatientID = "'"+PatientID+"'";
		this.GivenName = "'"+GivenName+"'";
		this.FamilyName = "'"+FamilyName+"'";
		this.Suffix = "'"+Suffix+"'";
		this.Gender = "'"+Gender+"'";
		this.Birthtime = "'"+Birthtime+"'";
		this.ProviderID = "'"+ProviderID+"'";
		this.InsuranceID = "'"+InsuranceID+"'";
		insertSQL += ERModel.generateNewSql(patientsFormat, this.attributes(), patientsPK);
	}

	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PatientID);
		L.add(GivenName);
		L.add(FamilyName);
		L.add(Suffix);
		L.add(Gender);
		L.add(Birthtime);
		L.add(ProviderID);
		L.add(InsuranceID);
		return L;
	}
}
