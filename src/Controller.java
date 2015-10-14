import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jiapei Yao, Xinglun
 *
 */
public class Controller {
	
	private Database db;
	
	
	public Controller(Database db) {
		this.db = db;
	}
	
	public String getPatientInfo(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		try{
			rs = db.selectTable("SELECT * FROM PATIENTS" + " WHERE PatientID = '" + PatientID + "' ;");
			rs.next();
			returnString += "PatientID: " + rs.getString(1);
			returnString += "  GivenName: " + rs.getString(2);
			returnString += "  FamilyName: " + rs.getString(3);
			returnString += "  Suffix: " + rs.getString(4);
			returnString += "  Gender: " + rs.getString(5);
			returnString += "  Birthtime: " + rs.getString(6);
			returnString += "  ProviderID: " + rs.getString(7);
			returnString += "  InsuranceID: " + rs.getString(8);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return returnString;
	}
	
	public String getGuardianNo(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		try{
			rs = db.selectTable("SELECT * FROM PATIENTROLE" + " WHERE PatientID = '" + PatientID + "' ;");
			rs.next();
			returnString = rs.getString(2);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return returnString;
	}
	
	
	public String getGuardianRelation(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		try{
			rs = db.selectTable("SELECT * FROM PATIENTROLE" + " WHERE PatientID = '" + PatientID + "' ;");
			rs.next();
			returnString = rs.getString(3);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return returnString;
	}
	
	
	public String getGuardianInfo(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		try
		{
			rs = db.selectTable("SELECT * FROM GUARDIANS" + " WHERE GuardianNo = '" + getGuardianNo(PatientID)+ "' ;");
			rs.next();
			returnString += "GuardianNo: " + rs.getString(1);
			returnString += "  GivenName: " + rs.getString(2);
			returnString += "  FamilyName: " + rs.getString(3);
			returnString += "  Phone: " + rs.getString(4);
			returnString += "  Address: " + rs.getString(5);
			returnString += "  City: " + rs.getString(6);
			returnString += "  State: " + rs.getString(7);
			returnString += "  Zip: " + rs.getString(8);
			returnString += "  Relation: " + getGuardianRelation(PatientID);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return returnString;
	}
	
	
	public void updateAttribute(String table, String attribute, String newValue, String objectID, String IDName) throws SQLException
	{
		String t = table;
		if(attribute == "Relationship"){
			t = "PATIENTROLE";
		}
		
		
		String set = attribute + " = " + "'"+newValue+"'";
		String condition = IDName + " = " + objectID;
		
		try{
		db.executeEdit(t, set, condition);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public String getPlanInfo(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM PLANS" + " WHERE PatientID = '" + PatientID+ "' ;");
		rs.next();
		returnString += "PlanID: " + rs.getString(1);
		returnString += "  PlanDate: " + rs.getString(2);
		returnString += "  Activity: " + rs.getString(3);
		
		return returnString;
	}
	
	public String getAllergyInfo(String PatientID) throws SQLException
	{
		ArrayList<String> alid = getAllergyID(PatientID);
		ArrayList<String> alStatus = getAllergyStatus(PatientID);
		ArrayList<String> alReaction = getAllergyReaction(PatientID);
		String returnString = "";
		ResultSet rs = null;
		for(int i=1;i<=alid.size();i++)
		{
			rs = db.selectTable("SELECT * FROM SUBSTANCES" + " WHERE ID = '" + alid.get(i-1) + "' ;");
			rs.next();
			returnString += "  SubstanceID: " + rs.getString(1);
			returnString += "  Substance name: " + rs.getString(2);
			returnString += "  Allergy Status: " + alStatus.get(i-1);
			returnString += "  Allergy Reaction: " + alReaction.get(i-1);
		}
		return returnString;
	}
	
	public ArrayList<String> getAllergyID(String PatientID) throws SQLException
	{
		ArrayList<String> al = new ArrayList<String>();
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM ALLERGIES" + " WHERE PatientID = '" + PatientID + "' ;");
		while(rs.next()){
			al.add(rs.getString(2));
		}
		return al;
	}
	
	public ArrayList<String> getAllergyStatus(String PatientID) throws SQLException
	{
		ArrayList<String> al = new ArrayList<String>();
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM ALLERGIES" + " WHERE PatientID = '" + PatientID + "' ;");
		while(rs.next()){
			al.add(rs.getString(3));
		}
		return al;
	}
	
	public ArrayList<String> getAllergyReaction(String PatientID) throws SQLException
	{
		ArrayList<String> al = new ArrayList<String>();
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM ALLERGIES" + " WHERE PatientID = '" + PatientID + "' ;");
		while(rs.next()){
			al.add(rs.getString(4));
		}
		return al;
	}

	public ArrayList<String> getAllergyRelationIndex(String PatientID) throws SQLException{
		ArrayList<String> al = new ArrayList<String>();
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM ALLERGIES" + " WHERE PatientID = '" + PatientID + "' ;");
		int i = 1;
		while(rs.next()){
			al.add("Relaiton "+ i);
			i++;
		}
		return al;
	}
	
	public void updateAllergy(String attribute, String newValue, String objectID, int n) throws SQLException
	{
		System.out.print(n);
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM ALLERGIES" + " WHERE PatientID = '" + objectID + "' ;");
		for(int i = 0; i<n+1;i++)
		{
			rs.next();
		}
		String substanceID = rs.getString(2);
		db.executeEdit("ALLERGIES", attribute+" = '"+newValue+"'", "PatientID = '"+objectID+"' AND "+ "SubstanceID = '"+substanceID+"'");
	}
	
	public int countPatientFromAllergy(String substanceID) throws SQLException
	{
		ResultSet rs = null;
		rs = db.selectTable("SELECT COUNT(*) FROM ALLERGIES"+ " WHERE SubstanceID = '" + substanceID + "' ;");
		rs.next();
		return rs.getInt(1);
	}

	public String getPatientsWithManyA() throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM ALLERGIES"+ " GROUP BY PatientID "+" HAVING COUNT(*) > 1 ");
		String temp="";
		while(rs.next())
		{
			if(rs.getString(1) != temp)
			{
				returnString += rs.getString(1)+"  ";
				temp = rs.getString(1);
			}

		}
		
		return returnString;
	}
	
	public String getPatientsWithS() throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM PLANS"+ " WHERE Activity = '" + "Surgery" + "' ;");
		while(rs.next())
		{
			if(compareWithToday(rs.getString(2)))
			{
				returnString += rs.getString(4)+"  "; 
			}
		}
		
		
		return returnString;
	}
	
	private boolean compareWithToday(String s)
	{
		int last;
		int i=0; 
		while(s.charAt(i)!='/')
		{
			i++;
		}
		String stringMonth = String.copyValueOf(s.toCharArray(),0,i);
		last = i+1;
		i++;
		while(s.charAt(i)!='/')
		{
			i++;
		}
		String stringDate = String.copyValueOf(s.toCharArray(), last, i-last);
		last = i+1;
		i++;
		while(s.charAt(i)!=' ')
		{
			i++;
		}
		String stringYear = String.copyValueOf(s.toCharArray(), last, i-last);

		int intMonth = Integer.parseInt(stringMonth);
		int intDay = Integer.parseInt(stringDate);
		int intYear = Integer.parseInt(stringYear);
		
		Date date = new Date();
		SimpleDateFormat yearF = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthF = new SimpleDateFormat("MM");
		SimpleDateFormat dayF = new SimpleDateFormat("dd");
		
		int todayMonth = Integer.parseInt(monthF.format(date));
		int todayDay = Integer.parseInt(dayF.format(date));
		int todayYear = Integer.parseInt(yearF.format(date));
		
//		System.out.print(todayMonth+" "+todayDay+" "+todayYear+ "  ");
		return intMonth == todayMonth && intDay == todayDay && intYear == todayYear;
	}
	
	
	public String getAuthorsWithManyP() throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM RECORD"+ " GROUP BY AuthorID "+" HAVING COUNT(*) > 1 ");
		String temp="";
		while(rs.next())
		{
			if(rs.getString(2) != temp)
			{
				returnString += rs.getString(2)+"  ";
				temp = rs.getString(2);
			}

		}
		
		return returnString;
	}
	
	public String getFamilyHistory(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM FAMILYHISTORY"+ " WHERE PatientID = '" + PatientID + "' ;");
		while(rs.next())
		{
			returnString += getFamilyHistoryWithRID(rs.getString(2));
		}
		
		
		return returnString;
	}
	
	private String getFamilyHistoryWithRID(String RelativeID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM FAMILY"+ " WHERE RelativeID = '" + RelativeID + "' ;");
		rs.next();
		returnString += "RelativeID: "+rs.getString(1);
		returnString += "  Age: "+rs.getString(2);
		returnString += "  Diagnosis: " + rs.getString(3)+"  ";
		return returnString;
	}

	
	public String getAuthorsWithPID(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM RECORD"+ " WHERE PatientID = '" + PatientID + "' ;");
		while(rs.next())
		{
			returnString += getAuthorsWithAID(rs.getString(2));
		}
		
		
		return returnString;
	}
	
	private String getAuthorsWithAID(String AuthorID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM AUTHOR"+ " WHERE AuthorID = '" + AuthorID + "' ;");
		rs.next();
		returnString += "AuthorID: "+rs.getString(1);
		returnString += "  AuthorTitle: "+rs.getString(2);
		returnString += "  AuthorFirstName: " + rs.getString(3);
		returnString+=  "  AuthorLastName: " + rs.getString(4)+"  ";
		return returnString;
	}
	
	public String getInsuranceWithPatientID(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM PATIENTS"+ " WHERE PatientID = '" + PatientID + "' ;");
		rs.next();
		return getInsuranceInfo(rs.getString(8));
	}
	
	private String getInsuranceInfo(String PayerID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM INSURANCES"+ " WHERE PayerID = '" + PayerID + "' ;");
		rs.next();
		returnString += "PayerID: "+rs.getString(1);
		returnString += "  PayerName: "+rs.getString(2);
		returnString += "  Purpose: " + rs.getString(3);
		returnString += "  PolicyType: " + rs.getString(4);
		returnString += "  PolicyHolder: " + rs.getString(5);
		return returnString;
	}
	
	
	public String getVisitResult(String PatientID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM VISIT"+ " WHERE PatientID = '" + PatientID + "' ;");
		while(rs.next())
		{
			returnString += "LabTestPerformanceDate: "+rs.getString(1);
			returnString += "  TestResultValue: "+rs.getString(2);
			returnString += "  PativeVisitID: " + rs.getString(3)+"  ";
			returnString += getLabTestForm(rs.getString(5));
		}
		return returnString;
	}
	
	private String getLabTestForm(String LabTestResultID) throws SQLException
	{
		String returnString = "";
		ResultSet rs = null;
		rs = db.selectTable("SELECT * FROM LABTESTS"+ " WHERE LabTestResultID = '" + LabTestResultID + "' ;");
		rs.next();
		returnString += "LabTestResultID: "+rs.getString(1);
		returnString += "  LabTestType: "+rs.getString(2);
		returnString += "  ReferenceRangeHigh: " + rs.getString(3);
		returnString += "  ReferenceRangeLow:  " + rs.getString(4)+"  " ;
		return returnString;
	}
	

	

	
	
}
