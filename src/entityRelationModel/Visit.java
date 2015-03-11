package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Visit {

	public String LabTestPerformanceDate;
	public String TestResultValue;
	public String PatientVisitID;
	public String PatientID;
	public String LabTestResultID;
	public ArrayList<String> insertSQL;
	private final String visitFormat = "VISIT(LabTestPerformanceDate, TestResultValue, PatientVisitID, PatientID, LabTestResultID)";
	private final String visitPK = " ON DUPLICATE KEY UPDATE PatientVisitID=PatientVisitID, PatientID=PatientID, LabTestResultID=LabTestResultID;\n";
	
	public Visit(){
		insertSQL=new ArrayList<String>();
	}


	
	public void addVisit(String LabTestPerformanceDate, String TestResultValue, String PatientVisitID, String PatientID, String LabTestResultID) {
		this.LabTestPerformanceDate = "'"+ERModel.cQ(LabTestPerformanceDate)+"'";
		this.TestResultValue = "'"+ERModel.cQ(TestResultValue)+"'";
		this.PatientVisitID = "'"+ERModel.cQ(PatientVisitID)+"'";
		this.PatientID = "'"+ERModel.cQ(PatientID)+"'";
		this.LabTestResultID = "'"+ERModel.cQ(LabTestResultID)+"'";
		insertSQL.add(ERModel.generateNewSql(visitFormat, this.attributes(), visitPK));
	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(LabTestPerformanceDate);
		L.add(TestResultValue);
		L.add(PatientVisitID);
		L.add(PatientID);
		L.add(LabTestResultID);
		return L;
	}
}
