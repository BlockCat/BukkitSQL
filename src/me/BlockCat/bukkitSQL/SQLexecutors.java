package me.BlockCat.bukkitSQL;

import java.sql.SQLException;

import me.BlockCat.bukkitSQL.pool.BConnectionPool;
import me.BlockCat.bukkitSQL.pool.ObjectPool;
import me.BlockCat.bukkitSQL.pool.Pool;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SQLexecutors implements BSQLinterface {
	


	@Override
	public void addTable(String name , String ... values){
		if (BukkitSQL.statement != null){
			try {			
				Execute("SELECT * FROM " + name);
			} catch (SQLException e) {
				try {
					String value = "";
					for(String v : values){
						String[] x = v.split(":");
						value = value + ", " + x[0] + " " + x[1];
					}
					value = value.replaceFirst(",", "");

					BukkitSQL.log.info("Made new table:  " + value);
					String execute = "CREATE TABLE " + name + " (" +value + ")";
					Execute(execute);
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void Execute(String execute) throws SQLException{
		BukkitSQL.statement.execute(execute);			
	}


	@Override
	public Connection getConnection() {
		//return BSQLdatabase.conn;
		Pool<Connection> connectionPool = new ObjectPool<Connection>();
	      connectionPool.setFactory(new BConnectionPool());
	      // get a new Vector. This operation replaces the new operator
	      Connection con = connectionPool.get();
	      // perform an operation on vec here
	      
	      
	      // once we are done, recycle this vector
	      connectionPool.recycle(con);
	      // for safety reasons, point vec to null
		return con;
	}

	@Override
	public Statement getStatement() {
		return BukkitSQL.statement;
	}

	
	@Override
	public boolean tableExists(String tableName) {
		try{
			Execute("SELECT * FROM " + tableName);
			return true;
		}catch(SQLException e){
			return false;
		}
	}

}
