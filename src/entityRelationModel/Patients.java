package entityRelationModel;

import java.util.ArrayList;

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
	public ArrayList<String> insertSQL;
	private final String patientsFormat = "PATIENTS(PatientID, GivenName, FamilyName, Suffix, Gender, Birthtime, ProviderID, InsuranceID)";
	private final String patientsPK = " ON DUPLICATE KEY UPDATE PatientID=PatientID;\n";
	
	public Patients(){
		insertSQL=new ArrayList<String>();
	}
	
	public void addPatients(String PatientID, String GivenName, String FamilyName, String Suffix, 
			String Gender, String Birthtime, String ProviderID, String InsuranceID) {
		this.PatientID = "'"+ERModel.cQ(PatientID)+"'";
		this.GivenName = "'"+ERModel.cQ(GivenName)+"'";
		this.FamilyName = "'"+ERModel.cQ(FamilyName)+"'";
		this.Suffix = "'"+ERModel.cQ(Suffix)+"'";
		this.Gender = "'"+ERModel.cQ(Gender)+"'";
		this.Birthtime = "'"+ERModel.cQ(Birthtime)+"'";
		this.ProviderID = "'"+ERModel.cQ(ProviderID)+"'";
		this.InsuranceID = "'"+ERModel.cQ(InsuranceID)+"'";
		 insertSQL.add(ERModel.generateNewSql(patientsFormat, this.attributes(), patientsPK));
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
