package net.noprefix.bedwars.MySQL;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.bukkit.Bukkit;

import de.dytanic.cloudnet.api.CloudAPI;


public class MySQL {


	private static String HOST = "localhost";
	private static String DATABASE = "xxx";
	private static String USER = "xxx";
	private static String PASSWORD = "xxx";
	private static String PORT = "xxx";

	private static Connection con;
	private boolean ic;
	
	
	
	public boolean isConnected(){
		return ic;
	}
	

	public void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);
			Bukkit.getConsoleSender().sendMessage("§aSuccessfully connected to MySQL-Database.");
			ic = true;
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§cCould not connect to MySQL-Database, please check your MySQL-Settings.");
			ic = false;
		}
	}
	
	public void close() {
		try {
			if(con != null) {
				con.close();
				Bukkit.getConsoleSender().sendMessage("§aSuccessfully closed MySQL-Connection.");
				ic = false;
			}else{
				Bukkit.getConsoleSender().sendMessage("§cThere is no running connection to MySQL-Database.");
			}
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("§cCould not close MySQL-Connection, ERROR-CODE: "+e.getMessage());
		}
	}
	
	public void update(String qry) {
		try {
			Statement st = con.createStatement();
			st.executeUpdate(qry);
			st.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public ResultSet getResult(String qry) {
		ResultSet rs = null;
		
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(qry);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return rs;
	}
	public void createTable() {
		update("CREATE TABLE IF NOT EXISTS Bedwars(Name VARCHAR(16), UUID VARCHAR(64), POINTS int, KILLS int, DEATHS int, WINS int, GAMES int);");
	}
	
	public boolean existPlayerName(String uuid) {
		try {
			ResultSet rs = getResult("SELECT * FROM Bedwars WHERE UUID= '" + uuid + "'");

			if (rs.next()) {
				return rs.getString("UUID") != null;
			}
			rs.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void createPlayer(String name, String uuid) {
		if(!existPlayerName(uuid)){
			update("INSERT INTO Bedwars(Name, UUID, POINTS, KILLS, DEATHS, WINS, GAMES) VALUES ('" + name + "', '" + uuid + "', '0', '0', '0', '0', '0');");
		}
		
	}
	
	public Integer getKills(String uuid) {
		Integer i = 0;
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			try {
				ResultSet rs = getResult("SELECT * FROM Bedwars WHERE UUID= '" + uuid + "'");
				if((!rs.next()) || (Integer.valueOf(rs.getInt("KILLS")) == null));
				
				i = rs.getInt("KILLS");
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}else {
			createPlayer(name, uuid);
			getKills(uuid);
		}
		
		return i;
	}
	public String getNameByUUID(String uuid) {
		String i = " ";
			try {
				ResultSet rs = getResult("SELECT * FROM Bedwars WHERE UUID= '" + uuid + "'");
				if((!rs.next()) || (String.valueOf(rs.getString("NAME")) == null));
				
				i = rs.getString("NAME");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return i;
	}
	
	public Integer getPoints(String uuid) {
		Integer i = 0;
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			try {
				ResultSet rs = getResult("SELECT * FROM Bedwars WHERE UUID= '" + uuid + "'");
				if((!rs.next()) || (Integer.valueOf(rs.getInt("POINTS")) == null));
				
				i = rs.getInt("POINTS");
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}else {
			createPlayer(name, uuid);
			getPoints(uuid);
		}
		
		return i;
	}
	
	public Integer getDeaths(String uuid) {
		Integer i = 0;
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			try {
				ResultSet rs = getResult("SELECT * FROM Bedwars WHERE UUID= '" + uuid + "'");
				if((!rs.next()) || (Integer.valueOf(rs.getInt("DEATHS")) == null));
				
				i = rs.getInt("DEATHS");
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}else {
			createPlayer(name, uuid);
			getDeaths(uuid);
		}
		
		return i;
	}
	
	public Integer getWins(String uuid) {
		Integer i = 0;
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			try {
				ResultSet rs = getResult("SELECT * FROM Bedwars WHERE UUID= '" + uuid + "'");
				if((!rs.next()) || (Integer.valueOf(rs.getInt("WINS")) == null));
				
				i = rs.getInt("WINS");
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}else {
			createPlayer(name, uuid);
			getWins(uuid);
		}
		
		return i;
	}
	
	public Integer getGames(String uuid) {
		Integer i = 0;
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			try {
				ResultSet rs = getResult("SELECT * FROM Bedwars WHERE UUID= '" + uuid + "'");
				if((!rs.next()) || (Integer.valueOf(rs.getInt("GAMES")) == null));
				
				i = rs.getInt("GAMES");
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}else {
			createPlayer(name, uuid);
			getGames(uuid);
		}
		
		return i;
	}
	
	public void setKills(String uuid, Integer kills) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			update("UPDATE Bedwars SET KILLS= '" + kills + "' WHERE UUID= '" + uuid+ "';");
		}else {
			createPlayer(name, uuid);
			setKills(uuid, kills);
		}
		
	}
	
	public void setPoints(String uuid, Integer points) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			update("UPDATE Bedwars SET POINTS= '" + points + "' WHERE UUID= '" + uuid+ "';");
		}else {
			createPlayer(name, uuid);
			setPoints(uuid, points);
		}
		
	}
	
	public void setDeaths(String uuid, Integer deaths) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			update("UPDATE Bedwars SET DEATHS= '" + deaths + "' WHERE UUID= '" + uuid+ "';");
		}else {
			createPlayer(name, uuid);
			setDeaths(uuid, deaths);
		}
		
	}
	
	
	public void setGames(String uuid, Integer games) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			update("UPDATE Bedwars SET GAMES= '" + games + "' WHERE UUID= '" + uuid+ "';");
		}else {
			createPlayer(name, uuid);
			setGames(uuid, games);
		}
		
	}
	
	
	public void setWins(String uuid, Integer wins) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			update("UPDATE Bedwars SET WINS= '" + wins + "' WHERE UUID= '" + uuid+ "';");
		}else {
			createPlayer(name, uuid);
			setWins(uuid, wins);
		}
		
	}
	
	public void addKill(String uuid, Integer kills) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			setKills(uuid, Integer.valueOf(getKills(uuid)+kills.intValue()));
		}else {
			createPlayer(name, uuid);
			addKill(uuid, kills);
		}	
	}
	
	public void addDeaths(String uuid, Integer deaths) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			setDeaths(uuid, Integer.valueOf(getDeaths(uuid)+deaths.intValue()));
		}else {
			createPlayer(name, uuid);
			addDeaths(uuid, deaths);
		}	
	}
	
	public void addPoints(String uuid, Integer points) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			setPoints(uuid, Integer.valueOf(getPoints(uuid)+points.intValue()));
		}else {
			createPlayer(name, uuid);
			addPoints(uuid, points);
		}	
	}
	
	
	public void addGames(String uuid, Integer games) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			setGames(uuid, Integer.valueOf(getGames(uuid)+games.intValue()));
		}else {
			createPlayer(name, uuid);
			addGames(uuid, games);
		}	
	}
	
	
	public void addWins(String uuid, Integer wins) {
		UUID id = UUID.fromString(uuid);
		String name = CloudAPI.getInstance().getPlayerName(id);
		if(existPlayerName(uuid)) {
			setWins(uuid, Integer.valueOf(getWins(uuid)+wins.intValue()));
		}else {
			createPlayer(name, uuid);
			addWins(uuid, wins);
		}	
	}
	
	public Integer getRank(String uuid) {
		Integer rank = -1;
		
		try {
			ResultSet rs = getResult("SELECT * FROM Bedwars ORDER BY POINTS DESC");
			while (rs.next()) {
				String uuid2 = rs.getString("UUID");
				if(uuid2.equalsIgnoreCase(uuid)) {
					rank = rs.getRow();
					break;
				}
				
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rank;
		
	}
	
}
