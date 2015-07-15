package com.scjohnson.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.scjohnson.objects.SugarAccount;

public class CategoryDAO {
  private static Logger log = Logger.getLogger(CategoryDAO.class);
  
  // getSP()
  public List<SugarAccount> getSP(String fn) {
    ConnectService c_obj = new ConnectService();
    Connection con = c_obj.DBConnect("sugarcrm","postgres","postgres");
    List<SugarAccount> ret = new ArrayList<SugarAccount>();
    
    // When calling a stored procedure, you have to use the following to
    // actually get the return into an iterable resultset.
    try{
      // You must be inside of a transaction for cursors to work
      con.setAutoCommit(false);
      String query = "SELECT "+fn+"();";
       // Procedure call.
      CallableStatement proc = con.prepareCall("{ ? = call getaccounts() }");
      proc.registerOutParameter(1, Types.OTHER);
      proc.execute();
      ResultSet rs = (ResultSet) proc.getObject(1);
      while (rs.next()) {
        SugarAccount acct = new SugarAccount();
        acct.setName(rs.getString("name"));
        acct.setIndustry(rs.getString("industry"));
        acct.setCountry(rs.getString("billing_address_country"));
        acct.setPhone(rs.getString("phone_office"));
        ret.add(acct);
      }
      rs.close();
      proc.close();
    } catch(Exception ex) {
      ex.printStackTrace(System.out);
      log.info("Exception caught in getSP() in CAtegoryDAO.java:: ");
    }
    log.info("Got the Result Set!!");
    return ret;
  }
  
  
  

}
