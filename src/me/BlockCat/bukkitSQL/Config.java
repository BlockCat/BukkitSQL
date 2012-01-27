package me.BlockCat.bukkitSQL;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {


	public static void load(BukkitSQL plugin) {
		final FileConfiguration config = plugin.getConfig();

		config.options().header("BukkitSQL properties");

		config.addDefault("SQL.host", "localhost");
		config.addDefault("SQL.port", 3306);
		config.addDefault("SQL.database", "minecraft");
		config.addDefault("SQL.username", "root");
		config.addDefault("SQL.password", "");

		String host = config.getString("SQL.host");
		int port = config.getInt("SQL.port");
		String database = config.getString("SQL.database");

		config.options().copyDefaults(true);
		plugin.saveConfig();

		url = "jdbc:mysql://" + host + ":" + port + "/" + database ;
		pass = config.getString("SQL.password");
		username = config.getString("SQL.username");


	}

	public static String getURL(){
		return url;		
	}

	public static String getPass(){
		return pass;		
	}

	public static String getUsername(){
		return username;
	}



	private static String url;
	private static String pass;
	private static String username;

}
