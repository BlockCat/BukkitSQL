package me.BlockCat.bukkitSQL;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class BSQLdatabase {

	public static Connection conn;

	public BSQLdatabase(BukkitSQL instance){
	}

	//connecting
	public static Connection connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection(Config.getURL(), Config.getUsername(), Config.getPass());
			return conn;
		}
		catch(Exception e){
			//e.printStackTrace();
			BukkitSQL.log.info("[BukkitSQL] Not connected, maybe a wrong username?");
			return null;
		}
	}
}
