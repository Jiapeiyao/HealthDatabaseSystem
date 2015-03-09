package Data;

public class Insurance {
	public String PayerID;
	public String PayerName; 
   	public String Purpose;
   	public String PolicyType;
   	public String PolicyHoler;
    	
	public Insurance(String PayerID, String PayerName, String Purpose, String PolicyType, String PolicyHolder) {
		this.PayerID = PayerID;
		this.PayerName = PayerName;
		this.Purpose = Purpose;
		this.PolicyType = PolicyType;
		this.PolicyHolder = PolicyHolder;
	}

}
