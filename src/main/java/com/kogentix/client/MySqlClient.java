package com.kogentix.client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlClient {

    public static Connection getConnection() {

        try {
            // Create MySql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://52.8.238.8:3306/etlaudit";

            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(myUrl, "kruti", "kruti123");
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object> select(String tableName) {

        try {

            Connection con = MySqlClient.getConnection();
            Statement stmt = con.createStatement();

            List<Object> result = new ArrayList<>();
            result.add("requestid|starttime|endtime|status");
            String columnValue="";

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    columnValue += rs.getString(i) + " | ";
                }
                result.add(columnValue.replaceAll(" | $", ""));
                columnValue = "";

            }
            con.close();

            return result;
        } catch (SQLException e) {
            List<Object> list = new ArrayList<>();
            list.add(new Exception());
            return list;
        }
    }


    public String insert(String tableName, String values) {

        String col = "";
        String val = "";


        String[] arrOfStr = values.split(",");

        for (String a : arrOfStr) {
            col += a.split("=")[0] + ",";
            val += "'" + a.split("=")[1] + "'" + ",";
        }

        col = col.replaceAll(",$", "");
        val = val.replaceAll(",$", "");

        String insertst = "insert into " + tableName + "(" + col + ")" + " values" + "(" + val + ")";

        try {
            Connection con = MySqlClient.getConnection();
            Statement stmt = con.createStatement();
            Integer res = stmt.executeUpdate(insertst);
            con.close();

            String  noOfRecords = "";
            if (res >= 0) {
                noOfRecords += (res + " record inserted");
            }

            return noOfRecords;

        } catch (SQLException e) {
            return (e.getMessage());

        }

    }
}
