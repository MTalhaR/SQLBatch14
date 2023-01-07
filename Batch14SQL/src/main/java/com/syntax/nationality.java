package com.syntax;

import java.sql.*;

public class nationality {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            //1. connection to the database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created");
            //2. create a statement object to send sql queries
            Statement st = con.createStatement();

            //.3 using statement object we are sending query and database return
            // an object of resultset (table with rows and column)

            ResultSet rset= st.executeQuery("Select * from ohrm_nationality");

            while(rset.next()){
               String id = rset.getString("id");
               String Name = rset.getString("Name");
                System.out.println(id + " " + Name);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
