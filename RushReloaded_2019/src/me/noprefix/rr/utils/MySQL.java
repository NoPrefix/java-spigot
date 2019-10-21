package me.noprefix.rr.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import org.bukkit.Bukkit;



public class MySQL
{
  private static Connection con;
  private boolean ic;
  
  public boolean isConnected() { return this.ic; }

  
  public void connect(String HOST, String PORT, String DATABASE, String USER, String PASSWORD) {
    if (!isConnected()) {
      try {
        con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);
        Bukkit.getConsoleSender().sendMessage("§a[MinePixelsAPI] Erfolgreich zur Datenbank verbunden.");
        this.ic = true;
      } catch (SQLException e) {
        Bukkit.getConsoleSender().sendMessage("§a[MinePixelsAPI] Die MySQL verbindung konnte nicht hergestellt werden.");
        this.ic = false;
      } 
    }
  }
  
  public void close() {
    try {
      if (con != null) {
        con.close();
        Bukkit.getConsoleSender().sendMessage("§a[MinePixelsAPI] Die MySQL verbindung wurde erfolgreich beendet.");
        this.ic = false;
      } else {
        Bukkit.getConsoleSender().sendMessage("§a[MinePixelsAPI] Derzeit ist keine Datebank verbunden..");
      } 
    } catch (SQLException e) {
      Bukkit.getConsoleSender().sendMessage("§a[MinePixelsAPI] Fehler: " + e.getMessage());
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

  
  public void createTable(String table) { update("CREATE TABLE IF NOT EXISTS " + table + "(Name VARCHAR(16), UUID VARCHAR(64), COINS int, BOOSTER int, NCHEST int, ECHEST int, ONEST int, WGESCH int);"); }

  
  public boolean existPlayerName(String uuid, String table) {
    try {
      ResultSet rs = getResult("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
      
      if (rs.next()) {
        return (rs.getString("UUID") != null);
      }
      rs.close();
      return false;
    } catch (SQLException e) {
      e.printStackTrace();

      
      return false;
    } 
  }
  public void createPlayer(String name, String uuid, String table) {
    if (!existPlayerName(uuid, table)) {
      update("INSERT INTO " + table + "(Name, UUID, COINS, BOOSTER, NCHEST, ECHEST, ONEST, WGESCH) VALUES ('" + name + "', '" + uuid + "', '1000', '0', '0', '0', '0', '0');");
    }
  }

  
  public String getNameByUUID(String uuid, String table) {
    String i = " ";
    try {
      ResultSet rs = getResult("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
      if (!rs.next() || String.valueOf(rs.getString("NAME")) == null);
      
      i = rs.getString("NAME");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    
    return i;
  }
  
  public Integer getCoins(String uuid, String table) {
    Integer i = Integer.valueOf(0);
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      try {
        ResultSet rs = getResult("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
        if (!rs.next() || Integer.valueOf(rs.getInt("COINS")) == null);
        
        i = Integer.valueOf(rs.getInt("COINS"));
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      
      createPlayer(name, uuid, table);
      getCoins(uuid, table);
    } 
    
    return i;
  }
  
  public Integer getBooster(String uuid, String table) {
    Integer i = Integer.valueOf(0);
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      try {
        ResultSet rs = getResult("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
        if (!rs.next() || Integer.valueOf(rs.getInt("BOOSTER")) == null);
        
        i = Integer.valueOf(rs.getInt("BOOSTER"));
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      
      createPlayer(name, uuid, table);
      getBooster(uuid, table);
    } 
    
    return i;
  }
  
  public Integer getNChest(String uuid, String table) {
    Integer i = Integer.valueOf(0);
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      try {
        ResultSet rs = getResult("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
        if (!rs.next() || Integer.valueOf(rs.getInt("NCHEST")) == null);
        
        i = Integer.valueOf(rs.getInt("NCHEST"));
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      
      createPlayer(name, uuid, table);
      getNChest(uuid, table);
    } 
    
    return i;
  }
  
  public Integer getEChest(String uuid, String table) {
    Integer i = Integer.valueOf(0);
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      try {
        ResultSet rs = getResult("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
        if (!rs.next() || Integer.valueOf(rs.getInt("ECHEST")) == null);
        
        i = Integer.valueOf(rs.getInt("ECHEST"));
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      
      createPlayer(name, uuid, table);
      getEChest(uuid, table);
    } 
    
    return i;
  }
  
  public Integer getNest(String uuid, String table) {
    Integer i = Integer.valueOf(0);
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      try {
        ResultSet rs = getResult("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
        if (!rs.next() || Integer.valueOf(rs.getInt("ONEST")) == null);
        
        i = Integer.valueOf(rs.getInt("ONEST"));
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      
      createPlayer(name, uuid, table);
      getEChest(uuid, table);
    } 
    
    return i;
  }
  
  public Integer getGeschenk(String uuid, String table) {
    Integer i = Integer.valueOf(0);
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      try {
        ResultSet rs = getResult("SELECT * FROM " + table + " WHERE UUID= '" + uuid + "'");
        if (!rs.next() || Integer.valueOf(rs.getInt("WGESCH")) == null);
        
        i = Integer.valueOf(rs.getInt("WGESCH"));
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    } else {
      
      createPlayer(name, uuid, table);
      getEChest(uuid, table);
    } 
    
    return i;
  }
  
  public void setCoins(String uuid, Integer coins, String table) {
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      update("UPDATE " + table + " SET COINS= '" + coins + "' WHERE UUID= '" + uuid + "';");
    } else {
      createPlayer(name, uuid, table);
      setCoins(uuid, coins, table);
    } 
  }

  
  public void setBooster(String uuid, Integer booster, String table) {
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      update("UPDATE " + table + " SET BOOSTER= '" + booster + "' WHERE UUID= '" + uuid + "';");
    } else {
      createPlayer(name, uuid, table);
      setCoins(uuid, booster, table);
    } 
  }

  
  public void setNChest(String uuid, Integer kisten, String table) {
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      update("UPDATE " + table + " SET NCHEST= '" + kisten + "' WHERE UUID= '" + uuid + "';");
    } else {
      createPlayer(name, uuid, table);
      setNChest(uuid, kisten, table);
    } 
  }

  
  public void setEChest(String uuid, Integer kisten, String table) {
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      update("UPDATE " + table + " SET ECHEST= '" + kisten + "' WHERE UUID= '" + uuid + "';");
    } else {
      createPlayer(name, uuid, table);
      setEChest(uuid, kisten, table);
    } 
  }

  
  public void setGeschenke(String uuid, Integer geschenke, String table) {
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      update("UPDATE " + table + " SET WGESCH= '" + geschenke + "' WHERE UUID= '" + uuid + "';");
    } else {
      createPlayer(name, uuid, table);
      setGeschenke(uuid, geschenke, table);
    } 
  }

  
  public void setNeste(String uuid, Integer neste, String table) {
    UUID id = UUID.fromString(uuid);
    String name = Bukkit.getOfflinePlayer(id).getName();
    if (existPlayerName(uuid, table)) {
      update("UPDATE " + table + " SET ONEST= '" + neste + "' WHERE UUID= '" + uuid + "';");
    } else {
      createPlayer(name, uuid, table);
      setNeste(uuid, neste, table);
    } 
  }
}
