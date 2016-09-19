package ssa;
import java.sql.*;

public class SqlConnDB {
	String dburl = null;
	String user = null;
	String pass = null;
	public Connection myConn = null;
	
	public int runUpdate(String sql) throws SQLException {
		Statement stmt = myConn.createStatement();
		try{
			int recsAffected = stmt.executeUpdate(sql);
			return recsAffected;
		} catch(SQLException ex) {
			throw ex;
		}
	}
	
	public ResultSet executeSqlQuery(String sql) throws SQLException {
		Statement stmt = myConn.createStatement();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			return rs;
		} catch(SQLException ex) {
			throw ex;
		}
	}
	public SqlConnDB(String url, String user, String pwd) throws SQLException {
		myConn=DriverManager.getConnection(url,user,pwd);
	}
	public void close() throws SQLException {
		if(myConn!=null) { myConn.close(); myConn=null;}
	}
}
