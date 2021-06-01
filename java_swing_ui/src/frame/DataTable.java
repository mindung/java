package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTable {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost?allowLoadLocalInfile=true&serverTimeZone=UTC", "root", "1234");
		Statement stmt = con.createStatement();
		
		stmt.execute("drop database if exists testLogin");
		stmt.execute("create database testLogin default character set utf8");
		stmt.execute("use testLogin");
		
		stmt.execute("create table member(no int primary key not null auto_increment,"
				+ "id varchar(20),"
				+ "pw varchar(20),"
				+ "name varchar(20))");
		
		stmt.execute("insert into member values(0, 'admin', '1234', '가나다')");
	}
}
