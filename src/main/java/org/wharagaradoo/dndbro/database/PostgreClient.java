package org.wharagaradoo.dndbro.database;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/** @author Created by Vladimir Seleznov <v.e.seleznov@gmail.com> on 2018-12-29. */
public class PostgreClient {

  public static List<Map<String, Object>> getQueryResult(@Language("SQL") String query) {

    return getQueryResult(query, null);
  }

  public static List<Map<String, Object>> getQueryResult(
      @Language("SQL") String query, Object... params) {
    Connection conn = null;
    List<Map<String, Object>> maps = null;
    QueryRunner run = new QueryRunner();
    String url =
        "jdbc:postgresql://ec2-54-247-74-131.eu-west-1.compute.amazonaws.com/d4k0ijecn0v13f";
    Properties props = new Properties();
    props.setProperty("user", "pcnfcpkkjhsabh");
    props.setProperty(
        "password", "5050fb3377531c044fb1495f63b84e900e48c78e90a0a44eb44dc1cdcb5d888b");
    try {
      conn = DriverManager.getConnection(url, props);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {

      maps = run.query(conn, query, new MapListHandler(), params);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

      try {
        DbUtils.close(conn);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return maps;
  }
}
