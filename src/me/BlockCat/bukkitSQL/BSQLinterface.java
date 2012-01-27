package me.BlockCat.bukkitSQL;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public interface BSQLinterface {
	
	/**
	 * Returns the connection made.
	 * @return <code> Connection </code>
	 */	
	public Connection getConnection();
	
	/**
	 * Add a table.
	 * values are: nameColumn:typeColumn
	 * types can be for example:
	 * int
	 * char
	 * float
	 * @param name
	 * @param values
	 */	
	public void addTable(String name , String ... values);
	
	/**
	 * Executes the string given, in SQL.
	 * string must be a legal SQL command.
	 * @param execute
	 * @throws SQLException
	 */
	public void Execute(String execute) throws SQLException;
	
	/**
	 * 	returns the statement.
	 * @return <code>Statement</code>
	 */
	public Statement statement();
	
	/**
	 * checks if database contains table.
	 * @param tableName
	 * @return <code> boolean </code>
	 */
	public boolean tableExists(String tableName);
}
