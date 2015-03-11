package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Insurances {
	public String PayerID;
	public String PayerName; 
   	public String Purpose;
   	public String PolicyType;
   	public String PolicyHolder;
   	public ArrayList<String> insertSQL;
   	private final String insurancesFormat = "INSURANCES(PayerID, PayerName, Purpose, PolicyType, PolicyHolder)";
   	private final String insurancesPK = " ON DUPLICATE KEY UPDATE PayerID=PayerID;\n";
   	
   	public Insurances(){
   		insertSQL=new ArrayList<String>();
   	}
   	
	public void addInsurances(String PayerID, String PayerName, String Purpose, String PolicyType, String PolicyHolder) {
		this.PayerID = "'"+ERModel.cQ(PayerID)+"'";
		this.PayerName = "'"+ERModel.cQ(PayerName)+"'";
		this.Purpose = "'"+ERModel.cQ(Purpose)+"'";
		this.PolicyType = "'"+ERModel.cQ(PolicyType)+"'";
		this.PolicyHolder = "'"+ERModel.cQ(PolicyHolder)+"'";
		 insertSQL.add(ERModel.generateNewSql(insurancesFormat, this.attributes(), insurancesPK));
	}

//	public String attributes(){
//		return PayerID+", "+PayerName+", "+Purpose+", "+PolicyType+", "+PolicyHolder;
//	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(PayerID);
		L.add(PayerName); 
		L.add(Purpose);
		L.add(PolicyType);
		L.add(PolicyHolder);
		return L;
	}
	
}
