package org.wharagaradoo.dndbro.database;

import java.sql.*;
import java.util.Properties;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-29. */
public class PostgreClient {

  public static void main(String[] args) throws SQLException {
    String url = "jdbc:postgresql://ec2-54-247-74-131.eu-west-1.compute.amazonaws.com/d4k0ijecn0v13f";
    Properties props = new Properties();
    props.setProperty("user","pcnfcpkkjhsabh");
    props.setProperty("password","5050fb3377531c044fb1495f63b84e900e48c78e90a0a44eb44dc1cdcb5d888b");
    Connection conn = DriverManager.getConnection(url, props);

    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM characters");

    while (rs.next())
    {
      System.out.print("Column 1 returned ");
      System.out.println(rs.getString(1));
    }
    rs.close();
    st.close();
    conn.close();
  }
}
