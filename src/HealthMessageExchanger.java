import java.sql.ResultSet;
import java.sql.SQLException;

import entityRelationModel.Author;
import entityRelationModel.Family;
import entityRelationModel.Guardian;
import entityRelationModel.Insurance;
import entityRelationModel.Patient;
import entityRelationModel.Plan;
import entityRelationModel.Substance;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */
public class HealthMessageExchanger {
	private final String HealthMessageExchangeDBName = "healthmessagesexchange2";
	private final String HealthMessageTargetDBFileName = "HealthMessageTarget";
	private final Database Source_DB;
	private final Database Target_DB;
	private Author author;
	private Family family;
	private Guardian guardian;
	private Insurance insurance;
	private Patient patient;
	private Plan plan;
	private Substance substance;
	
	public HealthMessageExchanger() {
		 Source_DB = new Database(HealthMessageExchangeDBName);
		 Target_DB = new Database(HealthMessageTargetDBFileName);
	}
	
	public void parseMessage() throws SQLException {
		ResultSet rs = null;
		try {
			rs = Source_DB.selectTable("SELECT * FROM messages");
			while (rs.next()){
				parseOneTuple(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void parseOneTupleToTargetDatabase(ResultSet tuple) throws SQLException{
			Author author = new Author(tuple.getString(17), tuple.getString(18), tuple.getString(19), tuple.getString(20));
			Family family = new Family(tuple.getString(), tuple.getString());
			Guardian guardian = new Guardian(tuple.getString(),tuple.getString(),tuple.getString(),tuple.getString(), 
					tuple.getString(),tuple.getString(),tuple.getString(),tuple.getString());
			Insurance insurance = new Insurance(tuple.getString(), tuple.getString(), tuple.getString(), tuple.getString(), tuple.getString());
			labtest labtest = new Labtest(tuple.getString(), tuple.getString(), tuple.getString(), tuple.getString());
			Patient patient = new Patient(tuple.getString(), tuple.getString(), tuple.getString(), tuple.getString(), 
					tuple.getString(), tuple.getString(), tuple.getString(), tuple.getString(), tuple.getString());
			Plan plan = new Plan(tuple.getString(), tuple.getString(), tuple.getString(), tuple.getString());
			Substance substance = new Substance(tuple.getString());
	}
	
	//private void parseOneEntity() {}
	

}
