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

public class LabTests {
	public String LabTestResultID;
	public String LabTestType;
    public String ReferenceRangeHigh;
    public String ReferenceRangeLow;
    public String insertSQL;
    private final String labTestsFormat = "LABTESTS( LabTestResultID, LabTestType, ReferenceRangeHigh, ReferenceRangeLow)";
    private final String labTestsPK = " ON DUPLICATE KEY UPDATE LabTestResultID=LabTestResultID;\n";
	
    public LabTests(){
		insertSQL="";
    }
    
    public void addLabtests(String LabTestResultID, String LabTestType, String ReferenceRangeHigh, String ReferenceRangeLow) {
		this.LabTestResultID = "'"+LabTestResultID+"'";
		this.LabTestType = "'"+LabTestType+"'";
		this.ReferenceRangeHigh = "'"+ReferenceRangeHigh+"'";
		this.ReferenceRangeLow = "'"+ReferenceRangeLow+"'";
		insertSQL += ERModel.generateNewSql(labTestsFormat, this.attributes(), labTestsPK);
	}
    
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(LabTestResultID);
		L.add(LabTestType);
		L.add(ReferenceRangeHigh);
		L.add(ReferenceRangeLow);
		return L;
	}
}
