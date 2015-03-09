package Data;

public class Labtest {
	public String LabTestResultID;
	public String LabTestType;
    public String ReferenceRangeHight;
    public String ReferenceRangeLow;
	public Labtest(String LabTestResultID, String LabTestType, String ReferenceRangeHight, String ReferenceRangeLow) {
		this.LabTestResultID = LabTestResultID;
		this.LabTestType = LabTestType;
		this.ReferenceRangeHight = ReferenceRangeHight;
		this.ReferenceRangeLow = ReferenceRangeLow;
	}

}
