package day0351;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlStudy {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost?allowLoadLocalInfile=true&serverTimezone=UTC", "root", "1234");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone=UTC", "root", "1234");
		Statement stmt = con.createStatement();
		
		stmt.execute("drop database if exists test");
		stmt.execute("create database test");
		stmt.execute("use test");
		
		stmt.execute("create table member(no int primary key not null auto_increment,"
				+ " name varchar(5) not null)");
	}
	
}
