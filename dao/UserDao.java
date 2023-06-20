/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjeevni.dao;

import com.sanjeevni.pojo.User;
import com.sanjeevni.dbutil.DbConnection;
import com.sanjeevni.dbutil.PasswordEncryption;
import com.sanjeevni.pojo.ReceptionistPojo;
import com.sanjeevni.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class UserDao {
    public static String validategetUser(User user) throws SQLException{
     Connection conn=DbConnection.getConnection();
        System.out.println(conn);
     System.out.println(user.getPassword());
     System.out.println(user.getLoginId());
     System.out.println(PasswordEncryption.getDecryptedPassword(user.getPassword()));
     PreparedStatement ps=conn.prepareStatement("Select user_name from users where login_id=? and password=? and user_type=?");
         ps.setString(1, user.getLoginId());
         ps.setString(2,user.getPassword());
         ps.setString(3, user.getUserType());
         ResultSet rs=ps.executeQuery();
         String name=null;
         
        if(rs.next()){
             name=rs.getString("user_name");
         }
         return name;
    }
        public static void updateName(String currentName,String newName)throws SQLException{
           Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("update users set user_name=? where user_name=?");
        ps.setString( 1,newName);
        ps.setString(2, currentName);
        ps.executeUpdate();
        
    }
               public static boolean addUser(UserPojo user)throws SQLException{
           Connection con=DbConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?)");
           ps.setString(1,user.getLoginId());
           ps.setString(2,user.getUserName());
           ps.setString(3,user.getPassword());
           ps.setString(4, user.getUserType().toUpperCase());
           return ps.executeUpdate()==1;
       }
         public static boolean updateRecUser(UserPojo user)throws SQLException {
                Connection con=DbConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("update users set login_id=? ,password=? where user_name=?");
           ps.setString(1,user.getLoginId());
           ps.setString(2,user.getPassword());
           ps.setString(3, user.getUserName());
           return ps.executeUpdate()==1;
         }
            public static boolean deleteUser(String userName)throws SQLException{
           Connection con=DbConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("delete from users where user_name=?");
          ps.setString(1,userName);
          return 1==ps.executeUpdate();
            }
}
