package me.BlockCat.bukkitSQL;

import java.util.logging.Logger;

import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.mysql.jdbc.Statement;

public class BukkitSQL extends JavaPlugin {

	public static Logger log = Logger.getLogger("Minecraft");
	public static Statement statement = null;
	private ServicesManager sm;

	@Override
	public void onDisable() {

		sm.unregisterAll(this);
		log.info("[BukkitSQL] Dissabled.");
	}

	@Override
	public void onEnable() {
		//load config
		Config.load(this);
		BSQLdatabase.connect();		
		this.register();
		
		try{
			statement = (Statement) BSQLdatabase.conn.createStatement();
		} catch(Exception e){
			e.printStackTrace();
		}
		log.info("[BukkitSQL] Enabled.");
	}
	
	private void register(){
		sm = getServer().getServicesManager();
		BSQLinterface interFace = new SQLexecutors();
		sm.register(BSQLinterface.class, interFace, this, ServicePriority.Normal);
	}

}
