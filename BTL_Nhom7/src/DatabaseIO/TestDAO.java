/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseIO;

import Model.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrloc
 */
public class TestDAO {


    public TestDAO() {
    }

    public ArrayList<Test> getFullListTest() {
        ArrayList<Test> list = new ArrayList<>();
        String SqlQuery = "SELECT * FROM dbo.Test";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareStatement(SqlQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Test test = new Test();
                test.setTest_ID(rs.getInt("Test_ID"));
                test.setTest_Name(rs.getString("Test_Name"));
                test.setTime(rs.getInt("Time"));
                test.setLevel(rs.getInt("Level_ID"));
                test.setStatus(rs.getBoolean("Status"));
                list.add(test);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Test getTest(int Test_ID){
        Test test = null;
        String SqlQuery = "SELECT * FROM dbo.Test WHERE Test_ID = ?";
        try {
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareStatement(SqlQuery);
            ps.setInt(1, Test_ID);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    test = new Test();
                    test.setTest_ID(rs.getInt("Test_ID"));
                    test.setTest_Name(rs.getString("Test_Code"));
                    test.setTime(rs.getInt("Time"));
                    test.setLevel(rs.getInt("Level_ID"));
                    test.setStatus(rs.getBoolean("Status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;
    }
    public int getMaxIdTest(){
        int max = 0;
        String sqlQuerry = "SELECT MAX(Test_ID) AS Max FROM Test WHERE Status = 1";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuerry);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                max = rs.getInt("Max");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return max;
    }
    public boolean insertTest(Test t){
        boolean isInsert = false;
        String sqlQuerry = "Insert into Test values (?,?,?,?)";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(sqlQuerry);
            ps.setString(1, t.getTest_Name());
            ps.setInt(2, t.getTime());
            ps.setInt(3, t.getLevel());
            ps.setBoolean(4, t.isStatus());
            
            int rs = ps.executeUpdate();
            if(rs == 1){
                isInsert = true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            isInsert = false;
        }
        return isInsert;
    }
    public boolean deleteTestById(int id){
        boolean isDelete = false;
        String query = "DELETE FROM Test WHERE Test_ID = ?";
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(query);
            ps.setInt(1, id);
            
            int rs = ps.executeUpdate();
            if(rs == 1){
                isDelete = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            isDelete = false;
        }
        return isDelete;
    }
    public boolean activeTestById(int id,boolean status){
        String query = "EXEC ActiveTestById ?,?";
        boolean isEdited = false;
        try{
            PreparedStatement ps = DataProvider.getInstance().Connection().prepareCall(query);
            ps.setInt(1, id);
            ps.setBoolean(2, status);
            
            int rs = ps.executeUpdate();
            if(rs==1)
                isEdited = true;
        }
        catch(SQLException e){
            e.printStackTrace();
            isEdited = false;
        }
        return isEdited;
    }
}
