import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entityRelationModel.Allergies;
import entityRelationModel.Author;
import entityRelationModel.ERModel;
import entityRelationModel.Family;
import entityRelationModel.FamilyHistory;
import entityRelationModel.Guardians;
import entityRelationModel.Insurances;
import entityRelationModel.LabTests;
import entityRelationModel.Patients;
import entityRelationModel.PatientRole;
import entityRelationModel.Plans;
import entityRelationModel.Record;
import entityRelationModel.Substances;
import entityRelationModel.Visit;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */
public class HealthMessageExchanger {
	private final String HealthMessageExchangeDBName = "healthmessagesexchange2";
	private final String HealthMessageTargetDBFileName = "HealthMessagesDatabase";
	private final Database Source_DB;
	private final Database Target_DB;
	private Allergies allergies;
	private Author author;
	private Family family;
	private FamilyHistory familyHistory;
	private Guardians guardians;
	private Insurances insurances;
	private LabTests labTests;
	private Patients patients;
	private PatientRole patientRole;
	private Plans plans;
	private Record record;
	private Substances substances;
	private Visit visit;
	
	/**
	 * Constructor
	 */
	public HealthMessageExchanger() {
		 Source_DB = new Database(HealthMessageExchangeDBName);
		 Target_DB = new Database(HealthMessageTargetDBFileName);
		 allergies = new Allergies();
		 author = new Author();
		 family = new Family();
		 familyHistory = new FamilyHistory();;
		 guardians = new Guardians();
		 insurances = new Insurances();
		 labTests = new LabTests();
		 patients = new Patients();
		 patientRole = new PatientRole();
		 plans = new Plans();
		 record = new Record();
		 substances = new Substances();
		 visit = new Visit();
		 try {
			parseMessagesToTargetDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * parse Messages in `message` table to 
	 * 
	 * @throws SQLException
	 */
	public void parseMessagesToTargetDatabase() throws SQLException {
		ResultSet rs = null;
		try {
			rs = Source_DB.selectTable("SELECT * FROM messages");
			while (rs.next()){
				parseOneTupleToTargetDatabase(rs);
			}
			//entities
			executeCommInAnArrayList(guardians.insertSQL);
			executeCommInAnArrayList(author.insertSQL);
			executeCommInAnArrayList(insurances.insertSQL);
			executeCommInAnArrayList(family.insertSQL);
			executeCommInAnArrayList(substances.insertSQL);
			executeCommInAnArrayList(labTests.insertSQL);
			executeCommInAnArrayList(patients.insertSQL);
			//relations
			executeCommInAnArrayList(record.insertSQL);
			executeCommInAnArrayList(familyHistory.insertSQL);
			executeCommInAnArrayList(allergies.insertSQL);
			executeCommInAnArrayList(plans.insertSQL);
			executeCommInAnArrayList(visit.insertSQL);
			executeCommInAnArrayList(patientRole.insertSQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void executeCommInAnArrayList(ArrayList<String> commList)  throws SQLException {
		for (int i=0; i<commList.size(); i++)
			try {
				Target_DB.executeInsert(commList.get(i));
				//System.out.print(commList.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * categorize the columns of one tuple into several class,
	 * and then store into the target database
	 * 
	 * @param tuple
	 * @throws SQLException
	 */
	private void parseOneTupleToTargetDatabase(ResultSet tuple) throws SQLException{
		allergies.addAllergies(tuple.getString(3), tuple.getString(31), tuple.getString(34), tuple.getString(33));
		author.addAuthor(tuple.getString(17), tuple.getString(18), tuple.getString(19), tuple.getString(20));
		family.addFamily(tuple.getString(27), tuple.getString(29), tuple.getString(30));
		familyHistory.addFamilyHistory(tuple.getString(3), tuple.getString(27), tuple.getString(28));
		guardians.addGuardians(tuple.getString(8), tuple.getString(10), tuple.getString(11),tuple.getString(12),
				tuple.getString(13), tuple.getString(14), tuple.getString(15), tuple.getString(16));
		insurances.addInsurances(tuple.getString(22), tuple.getString(23), tuple.getString(26), tuple.getString(25), tuple.getString(24));
		labTests.addLabtests(tuple.getString(35), tuple.getString(38), tuple.getString(40), tuple.getString(41));
		patients.addPatients(tuple.getString(3), tuple.getString(4), tuple.getString(5), "null", "null", tuple.getString(6), tuple.getString(7), tuple.getString(22));
		patientRole.addPatientRole(tuple.getString(3), tuple.getString(8), tuple.getString(9));
		plans.addPlans(tuple.getString(42), tuple.getString(44), tuple.getString(43), tuple.getString(3));
		record.addRecord(tuple.getString(3), tuple.getString(17), tuple.getString(21));
		substances.addSubstances(tuple.getString(31), tuple.getString(32));
		visit.addVisit(tuple.getString(37), tuple.getString(39), tuple.getString(36), tuple.getString(3), tuple.getString(35));
		 
		
	}
	
	private void printTable(String Table_Name, int Columns){
		ResultSet rs = null;
		String sqlComm = "SELECT * FROM "+Table_Name;
		try {
			rs = Target_DB.selectTable(sqlComm);
			while (rs.next()){
				for (int i=1; i<=Columns; i++)
					System.out.print(rs.getString(i)+"\t");
				System.out.print("\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test for storage of target database
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		HealthMessageExchanger hme = new HealthMessageExchanger();
		
//		hme.printTable("GUARDIANS", 8);
//		hme.printTable("AUTHOR", 4);
//		hme.printTable("INSURANCES", 5);
//		hme.printTable("FAMILY", 3);
//		hme.printTable("SUBSTANCES", 2);
//		hme.printTable("LABTESTS", 4);
//		hme.printTable("PATIENTS", 8);

//		hme.printTable("RECORD", 3);
//		hme.printTable("FAMILYHISTORY", 3);
//		hme.printTable("ALLERGIES", 4);
//		hme.printTable("PLANS", 4);
//		hme.printTable("VISIT", 5);
//		hme.printTable("PATIENTROLE", 3);		
		
	    try {
	    	hme.Target_DB.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
