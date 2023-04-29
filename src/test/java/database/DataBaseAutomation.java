package database;


import com.bridgelabz.database.BaseClass;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


    public class  DataBaseAutomation extends BaseClass {
        @Test
        public void getTableData_Success() throws SQLException {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * From Employee");
            while (rs.next()){
                int empId = rs.getInt(1);
                String empName = rs.getString(2);
                String empEmail = rs.getString(3);
                int empAge = rs.getInt(4);
                String empCity = rs.getString(5);

                System.out.println(empId +" "+empName+" "+empEmail+" "+empAge+" "+empCity);
            }
        }

        @Test
        public void insertIntoTable_Success() throws SQLException {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?,?)");

            pst.setInt(1,162);
            pst.setString(2, "Bunny");
            pst.setString(3,"bob1@yopmail.com");
            pst.setInt(4,24);
            pst.setString(5, "Dubai");

            pst.executeUpdate();
            getTableData_Success();
        }

        @Test
        public void updateIntoTable_Success() throws SQLException {
            PreparedStatement pst = con.prepareStatement("Update Employee SET EmpName = ? WHERE EmpId = ?");
            pst.setString(1,"DTY");
            pst.setInt(2, 117);
            pst.executeUpdate();
            getTableData_Success();
        }

        @Test
        public void extractSpecificData() throws SQLException {
            PreparedStatement pst = con.prepareStatement("SELECT * From Employee where EmpId = ?");
            pst.setInt(1, 102);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int empId = rs.getInt(1);
                String empName = rs.getString(2);
                String empEmail = rs.getString(3);
                int empAge = rs.getInt(4);
                String empCity = rs.getString(5);

                System.out.println(empId +" "+empName+" "+empEmail+" "+empAge+" "+empCity);
            }}
            @Test
            public void DeleteTheDataIntoTable() throws SQLException
            {
            PreparedStatement pst = con.prepareStatement("DELETE From Employee where EmpId = 116");
                pst.executeUpdate();
                getTableData_Success();
            }
        @Test
        public void AlterModifyTheTable() throws SQLException{
            PreparedStatement pst = con.prepareStatement("ALTER TABLE Employee MODIFY EmpName VARCHAR(40) ");
            pst.executeUpdate();
            getTableData_Success();
        }
        @Test
        public void AlterAddColumnsIntoTheTable() throws SQLException
        {
            PreparedStatement pst = con.prepareStatement("ALTER TABLE Employee ADD (EmpSalary INT,EmpDepartment VARCHAR(40))");
            pst.executeUpdate();
            getTableData_Success();
        }
        @Test
        public void AlterDropColumnsInTheTable() throws SQLException
        {
            PreparedStatement pst = con.prepareStatement("ALTER TABLE Employee DROP COLUMN EmpSalary");
            pst.executeUpdate();
            getTableData_Success();


        }
        @Test
        public void AlterDropColumn2InTheTable() throws SQLException
        {
            PreparedStatement pst = con.prepareStatement("ALTER TABLE Employee DROP COLUMN EmpDepartment");
            pst.executeUpdate();
            getTableData_Success();


        }
    }



