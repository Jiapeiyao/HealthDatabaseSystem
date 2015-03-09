package Data;

public class Patient {

	public String PatientID;
	public String GivenName;
	public String FamilyName;
	public String Suffix;
	public String Gender;
	public String Birthtime;
	public String ProviderID;
	public String PatientRole;
	public String InsuranceID;

	public Patient(String PatientID, String GivenName, String FamilyName, String Suffix, String Gender, String Birthtime, String ProviderID, String PatientRole, String InsuranceID) {
		this.PatientID = PatientID;
		this.GivenName = GivenName;
		this.FamilyName = FamilyName;
		this.Suffix = Suffix;
		this.Gender = Gender;
		this.Birthtime = Birthtime;
		this.ProviderID = ProviderID;
		this.PatientRole = PatientRole;
		this.InsuranceID = InsuranceID;
	}

}
