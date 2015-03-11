package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class LabTests {
	public String LabTestResultID;
	public String LabTestType;
    public String ReferenceRangeHigh;
    public String ReferenceRangeLow;
    public ArrayList<String> insertSQL;
    private final String labTestsFormat = "LABTESTS( LabTestResultID, LabTestType, ReferenceRangeHigh, ReferenceRangeLow)";
    private final String labTestsPK = " ON DUPLICATE KEY UPDATE LabTestResultID=LabTestResultID;\n";
	
    public LabTests(){
    	insertSQL=new ArrayList<String>();
    }
    
    public void addLabtests(String LabTestResultID, String LabTestType, String ReferenceRangeHigh, String ReferenceRangeLow) {
		this.LabTestResultID = "'"+ERModel.cQ(LabTestResultID)+"'";
		this.LabTestType = "'"+ERModel.cQ(LabTestType)+"'";
		this.ReferenceRangeHigh = "'"+ERModel.cQ(ReferenceRangeHigh)+"'";
		this.ReferenceRangeLow = "'"+ERModel.cQ(ReferenceRangeLow)+"'";
		insertSQL.add(ERModel.generateNewSql(labTestsFormat, this.attributes(), labTestsPK));
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
