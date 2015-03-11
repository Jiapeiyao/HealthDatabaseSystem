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
	private final String guardians2Format = "GUARDIANS()";
	private final String guardiansPK = " ON DUPLICATE KEY UPDATE GuardianNo=GuardianNo;\n";
	
	public Guardians(){
		insertSQL=new ArrayList<String>();
	}


	
	public void addGuardians(String GuardianNo, String GivenName, String FamilyName, String Phone, String Address, String City, String State, String Zip) {
		 this.GuardianNo = "'"+GuardianNo+"'";
		 this.GivenName = "'"+GivenName+"'";
		 this.FamilyName = "'"+FamilyName+"'";
		 this.Phone = "'"+Phone+"'";
		 this.Address = "'"+Address+"'";
		 this.City = "'"+City+"'";
		 this.State = "'"+State+"'";
		 this.Zip = "'"+Zip+"'";
		 insertSQL.add(ERModel.generateNewSql(guardians2Format, this.attributes(), guardiansPK));
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
