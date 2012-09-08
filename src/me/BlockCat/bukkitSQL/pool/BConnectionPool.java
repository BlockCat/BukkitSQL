package me.BlockCat.bukkitSQL.pool;

import me.BlockCat.bukkitSQL.BSQLdatabase;

import com.mysql.jdbc.Connection;

public class BConnectionPool implements PoolObjectFactory<Connection> {

	@Override
	public Connection newObject() {
		return BSQLdatabase.connect();
	}

}
