package entityRelationModel;

import java.util.ArrayList;

public class PatientRole {
	public String PatientID;
    public String GuardianNo;
    public String Relationship;
    public ArrayList<String> insertSQL;
    private final String patientRoleFormat = "PATIENTROLE(PatientID, GuardianNo, Relationship)";
    private final String patientRolePK = " ON DUPLICATE KEY UPDATE PatientID=PatientID, GuardianNo=GuardianNo;\n";
    
    public PatientRole(){
    	insertSQL=new ArrayList<String>();
    }
    
	public void addPatientRole(String PatientID, String GuardianNo, String Relationship) {
		this.PatientID = "'"+ERModel.cQ(PatientID)+"'";
		this.GuardianNo = "'"+ERModel.cQ(GuardianNo)+"'";
		this.Relationship = "'"+ERModel.cQ(Relationship)+"'";
		insertSQL.add(ERModel.generateNewSql(patientRoleFormat, this.attributes(), patientRolePK));
	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PatientID);
		L.add(GuardianNo);
		L.add(Relationship);
		return L;
	}

}
