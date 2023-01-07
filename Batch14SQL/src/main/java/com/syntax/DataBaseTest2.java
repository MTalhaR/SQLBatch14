package com.syntax;

import java.sql.*;

public class DataBaseTest2 {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rSet = st.executeQuery("select firstname,lastname,age,city from person where city is not null");

            // ResultSetMetaData - object that contains info about the result table
            // info such as column names, no. of columns
            ResultSetMetaData metaData = rSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount() ; i++) {
                // looping through each column and getting column name
                String colName = metaData.getColumnName(i);
                System.out.print(colName + "  ");
            }
            System.out.println();
            // we want to loop through every row and every column

            // loops through row data in the resultset object
            while(rSet.next()){
                // for loop iterates over each column
                for (int i = 1; i <= metaData.getColumnCount() ; i++) {
                    // using metadata grabbing column names dynamically
                   String value = rSet.getString(metaData.getColumnName(i));
                   // printing value pf each column
                    System.out.print(value + " ");
                }
                // creating new line before moving to the next row
                System.out.println();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
