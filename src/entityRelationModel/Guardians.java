package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Guardians {
	public String GuardianNo;
	public String GivenName;
	public String FamilyName;
    public String Phone;
	public String Address;
   	public String City;
	public String State;
	public String Zip;
	public ArrayList<String> insertSQL;
	private final String guardiansFormat = "GUARDIANS(GuardianNo, GivenName, FamilyName, Phone, Address, City, State, Zip)";
	private final String guardiansPK = " ON DUPLICATE KEY UPDATE GuardianNo=GuardianNo;\n";
	
	public Guardians(){
		insertSQL=new ArrayList<String>();
	}


	
	public void addGuardians(String GuardianNo, String GivenName, String FamilyName, String Phone, String Address, String City, String State, String Zip) {
		 this.GuardianNo = "'"+ERModel.cQ(GuardianNo)+"'";
		 this.GivenName = "'"+ERModel.cQ(GivenName)+"'";
		 this.FamilyName = "'"+ERModel.cQ(FamilyName)+"'";
		 this.Phone = "'"+ERModel.cQ(Phone)+"'";
		 this.Address = "'"+ERModel.cQ(Address)+"'";
		 this.City = "'"+ERModel.cQ(City)+"'";
		 this.State = "'"+ERModel.cQ(State)+"'";
		 this.Zip = "'"+ERModel.cQ(Zip)+"'";
		 insertSQL.add(ERModel.generateNewSql(guardiansFormat, this.attributes(), guardiansPK));
	}

	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(GuardianNo);
		L.add(GivenName);
		L.add(FamilyName);
		L.add(Phone);
		L.add(Address);
		L.add(City);
		L.add(State);
		L.add(Zip);
		return L;
	}
	
}
