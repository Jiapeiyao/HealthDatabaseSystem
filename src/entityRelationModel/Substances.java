package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Substances {
	public String Id;
	public String Substance;
	public ArrayList<String> insertSQL;
	private final String substancesFormat = "SUBSTANCES(Id, Substance)";
	private final String substancesPK = " ON DUPLICATE KEY UPDATE Id=Id;\n";
	
	public Substances(){
		insertSQL=new ArrayList<String>();
	}
	
	public void addSubstances(String Id, String Substance) {
		this.Id = "'"+ERModel.cQ(Id)+"'";
		this.Substance = "'"+ERModel.cQ(Substance)+"'";
		 insertSQL.add(ERModel.generateNewSql(substancesFormat, this.attributes(), substancesPK));


	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(Id);
		L.add(Substance);
		return L;
	}
}

