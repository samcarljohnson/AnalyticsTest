package com.scjohnson.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectService {
  
  private final String def_db = "postgres";
  private final String def_url = "jdbc:postgresql:";
  private final String def_driver = "org.postgresql.Driver";
  private final String def_user = "postgres";
  private final String def_pwd = "postgres";
  
  /**
   * DBConnect() - simply connect to the database.
   * @return Connection object to the database.
   */
  public Connection DBConnect() {
    String db = def_db;
    String url = def_url;
    String driver = def_driver;
    String user = def_user;
    String password = def_pwd;
    Connection con = null;
      try {
        Class.forName(driver);
        con = (Connection) DriverManager.getConnection(url + db, user, password);
        if (con == null) {
          System.out.println("Connection cannot be established");
          System.exit(0);
        }
      } catch (Exception ex) {
          System.out.println("Caught in DBConnect");
          ex.printStackTrace();
      }
      return con;
  }
  
  /**
   * DBConnect() - Connect to the database with certain parameters.
   * @return Connection object to the database.
   * String db_name The name of the database to connect to.
   * String usr The username to use in connection.
   * String pwd The password for 'usr'.
   */
  public Connection DBConnect(String db_name, String usr, String pwd) {
    String db = db_name;
    String url = def_url;
    String driver = def_driver;
    String user = usr;
    String password = pwd;
    Connection con = null;
      try {
        Class.forName(driver);
        con = (Connection) DriverManager.getConnection(url + db, user, password);
        if (con == null) {
          System.out.println("Connection cannot be established");
          System.exit(0);
        }
      } catch (Exception ex) {
          System.out.println("Caught in DBConnect");
          ex.printStackTrace();
      }
      return con;
  }

}
