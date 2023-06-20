/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjeevni.dao;

import com.sanjeevni.dbutil.DbConnection;
import com.sanjeevni.pojo.ReceptionistPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ReceptionistDao {
        public static void updateName(String currentName,String newName)throws SQLException{
           Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("update  Receptionists set receptionist_name=? where receptionist_name=?");
        ps.setString( 1,newName);
        ps.setString(2, currentName);
        ps.executeUpdate();
        
    }
    public static void deleteReceptionist(String rname)throws SQLException {
         Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("delete from receptionists where receptionist_name=?");
        ps.setString( 1,rname);
        ps.executeUpdate();
        
    }
       public static String getNewReceptionistId()throws SQLException{
           Connection con=DbConnection.getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("Select max(Receptionist_id) from receptionists");
           rs.next();
           int RecId=101;
           String id=rs.getString(1);
           if(id!=null){
               String num=id.substring(3);
               RecId=Integer.parseInt(num)+1;
               
           }
           return "REC"+RecId;
           
       }
          public static boolean addReceptionist(ReceptionistPojo rec)throws SQLException{
           Connection con=DbConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("insert into receptionists values(?,?,?)");
           ps.setString(1,rec.getReceptionistId());
           ps.setString(2,rec.getReceptionistname());
           ps.setString(3,rec.getGender());
           return ps.executeUpdate()==1;
       }
         public static boolean updateReceptionist(ReceptionistPojo rec)throws SQLException{
               Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("update  Receptionists set gender=? where receptionist_id=?");
        ps.setString( 1,rec.getReceptionistname());
        ps.setString(2, rec.getGender());
        ps.setString(3,rec.getReceptionistId());
        return 1==ps.executeUpdate();
         }
         public static List<String> getRecIdList()throws SQLException {
             Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select receptionist_id from receptionists");
        List<String> list=new ArrayList();
        while(rs.next()){
            String recId=rs.getString("receptionist_id");
            list.add(recId);
        }
        return list;
         }
         public static String getRecName(String recId)throws SQLException {
              Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select receptionist_name from receptionists where receptionist_id=?");
        ps.setString(1,recId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getString("receptionist_name");
         }
         public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException{
             Connection con=DbConnection.getConnection();
             PreparedStatement ps=con.prepareStatement("select * from receptionists");
             ResultSet rs=ps.executeQuery();
             List<ReceptionistPojo> recList=new ArrayList();
             while(rs.next()){
                 ReceptionistPojo rec=new ReceptionistPojo();
                 rec.setReceptionistId(rs.getString("receptionist_id"));
                 rec.setReceptionistname(rs.getString("receptionist_name"));
                 rec.setGender(rs.getString("gender"));
                 recList.add(rec);
             }
             return recList;
         }
         public static boolean deleteReceptionistbyId(String recId)throws SQLException{
               Connection con=DbConnection.getConnection();
          String recName=getRecName(recId);
          boolean userDelete=UserDao.deleteUser(recName);
        PreparedStatement ps2=con.prepareStatement("delete from receptionists where receptionist_id=?");
        ps2.setString( 1,recId);
        boolean recDelete =ps2.executeUpdate()==1;
        if(userDelete && recDelete){
            return true;
        }else{
            return false;
        }
         }
}
