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

public class Author {
	public String AuthorID;
	public String AuthorTitle;
    public String AuthorFirstName;
    public String AuthorLastName;
    public String insertSQL;
    private final String authorFormat = "AUTHOR(AuthorID, AuthorTitle, AuthorFirstName, AuthorLastName)";
    
	private final String authorPK = " ON DUPLICATE KEY UPDATE AuthorID=AuthorID;\n";
    
    public Author(){
    	insertSQL = "";
    }
		
	public void addAuthor(String AuthorID, String AuthorTitle, String AuthorFirstName, String AuthorLastName) {
		this.AuthorID = "'"+AuthorID+"'";
		this.AuthorTitle = "'"+AuthorTitle+"'";
		this.AuthorFirstName = "'"+AuthorFirstName+"'";
		this.AuthorLastName = "'"+AuthorLastName+"'";
		insertSQL += ERModel.generateNewSql(authorFormat, this.attributes(), authorPK);
	}
	
	public ArrayList<String> attributes(){
		ArrayList<String> L = new ArrayList<String>();
		L.add(AuthorID);
		L.add(AuthorTitle);
		L.add(AuthorFirstName);
		L.add(AuthorLastName);
		return L;
	}
	
}
