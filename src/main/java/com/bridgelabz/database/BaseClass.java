package com.bridgelabz.database;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class BaseClass {
        public static Connection con;
        @BeforeTest
        public Connection setUpConnection() throws SQLException {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CFP216","root",
                    "Mysql^131");
            return con;
        }

        @AfterTest
        public void tearDown() throws SQLException {
            con.close();
        }


}
