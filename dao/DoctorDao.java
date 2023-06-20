/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjeevni.dao;

import static com.sanjeevni.dao.ReceptionistDao.getRecName;
import com.sanjeevni.dbutil.DbConnection;
import com.sanjeevni.pojo.DoctorPojo;
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
public class DoctorDao {
    public static void updateName(String currentName,String newName)throws SQLException{
           Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("update  doctors set doctor_name=? where doctor_name=?");
        ps.setString( 1,newName);
        ps.setString(2, currentName);
        ps.executeUpdate();
        
    }
       public static void deleteDoctor(String rname)throws SQLException {
         Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("delete from doctors where doctor_name=?");
        ps.setString( 1,rname);
        ps.executeUpdate();
        
    }
       public static boolean addDoctor(DoctorPojo doc)throws SQLException{
           Connection con=DbConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("insert into doctors values(?,?,?,?,?,?,?)");
           ps.setString(1,doc.getDocId());
           ps.setString(2,doc.getDocName());
           ps.setString(3, doc.getEmailId());
           ps.setString(4, doc.getContactNo());
           ps.setString(5, doc.getQualifications());
           ps.setString(6,doc.getGender());
           ps.setString(7, doc.getSpecialist());
           return ps.executeUpdate()==1;
       }
       public static String getNewDocId()throws SQLException{
           Connection con=DbConnection.getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("Select max(doctor_id) from doctors");
           rs.next();
           int docId=101;
           String id=rs.getString(1);
           if(id!=null){
               String num=id.substring(3);
               docId=Integer.parseInt(num)+1;
               
           }
           return "DOC"+docId;
           
       }
       public static List<String> getAllDoctors()throws SQLException{
           Connection con=DbConnection.getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select doctor_id from doctors");
           List<String> doctorList=new ArrayList<>();
           while(rs.next()){
               doctorList.add(rs.getString(1));
           }
           return doctorList;
       }
                public static String getDocName(String docId)throws SQLException {
              Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select doctor_name from doctors where doctor_id=?");
        ps.setString(1,docId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getString("doctor_name");
         }
        public static boolean deleteDoctorById(String docId)throws SQLException{
           Connection con=DbConnection.getConnection();
          String docName=getDocName(docId);
          boolean userDelete=UserDao.deleteUser(docName);
        PreparedStatement ps2=con.prepareStatement("delete from doctors where doctor_id=?");
        ps2.setString( 1,docId);
        boolean docDelete =ps2.executeUpdate()==1;
        if(userDelete && docDelete){
            return true;
        }else{
            return false;
        }
 
            
        
    }
        public static List<DoctorPojo> getAllDoctorsDetails()throws SQLException{
               Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from Doctors");
        List<DoctorPojo> docList=new ArrayList<>();
        while(rs.next()){
            DoctorPojo doc=new DoctorPojo();
            doc.setDocId(rs.getString("doctor_name"));
            doc.setDocName(rs.getString("doctor_name"));
            doc.setContactNo(rs.getString("contact_no"));
            doc.setEmailId(rs.getString("Email_id"));
            doc.setGender(rs.getString("gender"));
            doc.setSpecialist(rs.getString("specialist"));
            doc.setQualifications(rs.getString("Qualification"));
            docList.add(doc);
        }
        return docList;
        }
        public static String getDoctorNameById(String docId)throws SQLException{
  
                Connection conn=DbConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select doctor_name from doctors where doctor_id=?");
    ps.setString(1,docId);
    ResultSet rs=ps.executeQuery();
    rs.next();
    return rs.getString(1);
    
 } 
        

    
}
