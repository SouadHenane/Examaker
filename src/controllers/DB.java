package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {

	public DB (String path){
	Connection connection ;
	Statement statement ;
		
		try 
		{
			Class.forName("org.sqlite.JDBC");
			connection =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Souad\\workspace\\Teste\\Examaker_web\\WebContent\\EtudiantData.sqlite");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate( "DROP TABLE IF EXISTS path");
			statement.executeUpdate( "CREATE TABLE path (PATH VARCHAR)");
			System.out.println("créé");

			statement.executeUpdate("INSERT INTO path(PATH) VALUES('"+path+"')");
			System.out.println("inséré");
			                              
		}
	catch(SQLException | ClassNotFoundException er)
		{
		System.err.println(er.getMessage());
		}
	}
}
