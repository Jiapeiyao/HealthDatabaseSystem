package entityRelationModel;

import java.util.ArrayList;

/**
 * @author Jiapei Yao, Xinglun Xu
 *
 */

public class Author {
	public String AuthorID;
	public String AuthorTitle;
    public String AuthorFirstName;
    public String AuthorLastName;
    public ArrayList<String> insertSQL;
    private final String authorFormat = "AUTHOR(AuthorID, AuthorTitle, AuthorFirstName, AuthorLastName)";
    
	private final String authorPK = " ON DUPLICATE KEY UPDATE AuthorID=AuthorID;\n";
    
    public Author(){
    	insertSQL=new ArrayList<String>();
    }
		
	public void addAuthor(String AuthorID, String AuthorTitle, String AuthorFirstName, String AuthorLastName) {
		this.AuthorID = "'"+ERModel.cQ(AuthorID)+"'";
		this.AuthorTitle = "'"+ERModel.cQ(AuthorTitle)+"'";
		this.AuthorFirstName = "'"+ERModel.cQ(AuthorFirstName)+"'";
		this.AuthorLastName = "'"+ERModel.cQ(AuthorLastName)+"'";
		insertSQL.add(ERModel.generateNewSql(authorFormat, this.attributes(), authorPK));
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
