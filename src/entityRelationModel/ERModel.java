package entityRelationModel;
import java.util.ArrayList;

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
}
