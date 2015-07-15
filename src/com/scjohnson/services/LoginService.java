package com.scjohnson.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginService {

  /**
   * uniqueUser(email) - Queries the database and checks to see if the user login is unique. 
   *   This is done via email.
   * @param email The user email to check for uniqueness.
   */
  public boolean uniqueUser(String str) {
    ConnectService c_obj = new ConnectService();
    Connection con = c_obj.DBConnect();
    try {
      //String query = "SELECT COUNT(*) FROM user_logins WHERE email='"+str+"';";
      String query = "SELECT COUNT(*) FROM user_data WHERE bubble_name='"+str+"';";
      Statement st = (Statement) con.createStatement();
      ResultSet rs = st.executeQuery(query);
      
      rs.next();
      String result = rs.getString(1);
      if(result.equals("0")) {
        st.close();    
        return true;
      }
      st.close();
      return false;
    } 
    catch(Exception ex) {
      System.out.println("Caught in uniqueUser");
      ex.printStackTrace();
    }
    return true;
  }
  
  /**
   * registerUser(username, email, password) - Adds the user's information to the user-logins table in the db.
   * @param username User's username.
   * @param email User's email address.
   * @param password User's password.
   */
  public void registerUser(String username, String email, String password) {
    ConnectService c_obj = new ConnectService();
    Connection con = c_obj.DBConnect();
    try {
      String query = "INSERT into user_logins (name, email, password) "
          + "VALUES ('"+username+"','"+email+"','"+password+"');";
      Statement st = (Statement) con.createStatement();
      st.executeUpdate(query);
      st.close();
    } 
    catch(Exception ex) {
      System.out.println("Caught in registerUser");
      ex.printStackTrace();
    }
  }
  
  /**
   * registerUser(username, email, password) - Adds the user's information to the user-logins table in the db.
   * @param username User's username.
   * @param email User's email address.
   * @param password User's password.
   */
  public void registerUser(String a, String b, String c, String d, 
      String e, String f, String g, String h, String i) {
    ConnectService c_obj = new ConnectService();
    Connection con = c_obj.DBConnect();
    try {
      String query = "INSERT into user_data (bubble_name, creator, bubble_num_moments, widget_nbu_views,"
          + " total_video_views, visits, views_per_visits, average_watch_time, percentage_mobile) "
          + "VALUES ('"+a+"','"+b+"','"+c+"','"+d+
          "','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"');";
      Statement st = (Statement) con.createStatement();
      st.executeUpdate(query);
      st.close();
    } 
    catch(Exception ex) {
      System.out.println("Caught in registerUser");
      ex.printStackTrace();
    }
  }
  
}
