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

public class Visit {

	public String LabTestPerformanceDate;
	public String TestResultValue;
	public String PatientVisitID;
	public String PatientID;
	public String LabTestResultID;
	public String insertSQL;
	private final String visitFormat = "VISIT(LabTestPerformanceDate, TestResultValue, PatientVisitID, PatientID, LabTestResultID)";
	private final String visitPK = " ON DUPLICATE KEY UPDATE PatientVisitID=PatientVisitID, PatientID=PatientID, LabTestResultID=LabTestResultID;\n";
	
	public Visit(){
		insertSQL="";
	}


	
	public void addVisit(String LabTestPerformanceDate, String TestResultValue, String PatientVisitID, String PatientID, String LabTestResultID) {
		this.LabTestPerformanceDate = "'"+LabTestPerformanceDate+"'";
		this.TestResultValue = "'"+TestResultValue+"'";
		this.PatientVisitID = "'"+PatientVisitID+"'";
		this.PatientID = "'"+PatientID+"'";
		this.LabTestResultID = "'"+LabTestResultID+"'";
		insertSQL += ERModel.generateNewSql(visitFormat, this.attributes(), visitPK);
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
