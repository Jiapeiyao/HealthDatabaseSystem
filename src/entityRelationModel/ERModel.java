package entityRelationModel;
import java.util.ArrayList;

/**
 * Common Functions that are used by all the entity and relation classes are put here
 * 
 * @author Jiapei Yao, Xinglun XU
 *
 */

public class ERModel {
	
	public static String generateNewSql(String TABLE_NAME_WITH_ATTRIBUTES, ArrayList<String> valueList, String PK){
			//prepare the sql command
			String sqlComm = "INSERT INTO " + TABLE_NAME_WITH_ATTRIBUTES + " VALUES ( ";
			for (int i=0; i<valueList.size()-1; i++){
				sqlComm += (valueList.get(i) + ",");
			}
			sqlComm+= valueList.get(valueList.size()-1) + ")";
			sqlComm+= PK;
			return sqlComm;
	}
	
	public static String cQ(String str){
		String retStr = "";
		if (str == null || str.length()==0)
			return str;
		for (int i=0; i<str.length(); i++){
			if (str.charAt(i)=='\'')
				retStr += '\\';
			retStr += str.charAt(i);
		}
		return retStr;
	}

//	void main(){
//		System.out.println(ERModel.cQ("abc's cd"));
//		
//	}
}
