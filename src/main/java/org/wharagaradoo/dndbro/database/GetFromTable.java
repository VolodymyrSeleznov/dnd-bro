// package org.wharagaradoo.dndbro.database;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.Iterator;
// import java.util.List;
// import java.util.Properties;

// public class GetFromTable {

//     public static ResultSet getFromQuerry(String querry) throws SQLException 
//     {
//         String cli = "jdbc:postgresql://ec2-54-247-74-131.eu-west-1.compute.amazonaws.com/d4k0ijecn0v13f";
//         Properties props = new Properties();
//         props.setProperty("user","pcnfcpkkjhsabh");
//         props.setProperty("password","5050fb3377531c044fb1495f63b84e900e48c78e90a0a44eb44dc1cdcb5d888b");
//         Connection conn = DriverManager.getConnection(cli, props);

//         Statement st = conn.createStatement();
//         ResultSet rs = st.executeQuery(querry);

//         List<Object> result = new List<>();
        
//         while (rs.next()) {
//             result.add();
//         }

//         // rs.close();
//         st.close();
//         conn.close();

//         return rs;
//     }
// }