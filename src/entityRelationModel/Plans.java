package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Plans {
	public String PlanID;
	public String PlanDate;
	public String Activity;
	public String PatientID;
	public ArrayList<String> insertSQL;
	private final String plansFormat = "PLANS(PlanID, PlanDate, Activity, PatientID)";
	private final String plansPK = " ON DUPLICATE KEY UPDATE PlanID=PlanID;\n";
	
	public Plans(){
		insertSQL=new ArrayList<String>();
	}
	
	public void addPlans(String PlanID, String PlanDate, String Activity, String PatientID) {
		this.PlanID = "'"+ERModel.cQ(PlanID)+"'";
		this.PlanDate = "'"+ERModel.cQ(PlanDate)+"'";
		this.Activity = "'"+ERModel.cQ(Activity)+"'";
		this.PatientID = "'"+ERModel.cQ(PatientID)+"'";
		insertSQL.add(ERModel.generateNewSql(plansFormat, this.attributes(), plansPK));
	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PlanID);
		L.add(PlanDate);
		L.add(Activity);
		L.add(PatientID);
		return L;
	}
}
