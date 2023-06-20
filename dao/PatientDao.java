/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjeevni.dao;

import com.sanjeevni.dbutil.DbConnection;
import com.sanjeevni.pojo.DoctorPojo;
import com.sanjeevni.pojo.PatientPojo;
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
public class PatientDao {
    
       public static String getNewPatId()throws SQLException{
           Connection con=DbConnection.getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("Select max(patient_id) from patients");
           rs.next();
           int patId=101;
           String id=rs.getString(1);
           if(id!=null){
               String num=id.substring(3);
               patId=Integer.parseInt(num)+1;
               
           }
           return "PAT"+patId;
           
       }
         public static boolean addPatient(PatientPojo pat)throws SQLException{
           Connection con=DbConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("insert into patients values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1,pat.getPatientId());
           ps.setString(2,pat.getFirstName());
           ps.setString(3,pat.getLastName());
           ps.setInt(4, pat.getAge());
           ps.setString(5, pat.getGender());
           ps.setString(6, pat.getMarriedStatus());
           ps.setString(7,pat.getAddresss());
           ps.setString(8, pat.getCity());
           ps.setString(9,pat.getMobileNO());
           ps.setDate(10,pat.getpDate());
           ps.setInt(11, pat.getOtp());
           ps.setString(12, pat.getOdp());
           ps.setString(13, pat.getDoctorId());
           ps.setString(14, pat.getStatus());
           return ps.executeUpdate()==1;
       }
     public static List<PatientPojo> getAllPatientDetails()throws SQLException{
    Connection conn=DbConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select * from patients order by patient_id");
    List<PatientPojo>patList=new ArrayList<>();
    while(rs.next()){
    PatientPojo pat=new PatientPojo();
    pat.setPatientId(rs.getString("patient_id"));
    pat.setFirstName(rs.getString("first_name"));
    pat.setLastName(rs.getString("last_name"));
    pat.setAge(rs.getInt("age"));
    pat.setGender(rs.getString("gender"));
    pat.setMarriedStatus(rs.getString("m_status"));
    pat.setAddresss(rs.getString("address"));
    pat.setCity(rs.getString("city"));
    pat.setMobileNO(rs.getString("mobile_no"));
    pat.setpDate(rs.getDate("p_date"));
    pat.setOdp(rs.getString("opd"));
    pat.setStatus(rs.getString("status"));
    pat.setDoctorId(rs.getString("doctor_id"));
    patList.add(pat);   
    
    }
    return patList;
} 
  public static List<PatientPojo> getAllPatientsByDoctorId(String doctorId)throws SQLException{
    Connection conn=DbConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select * from patients where doctor_id=? and status='REQUEST' order by patient_id");
    ps.setString(1,doctorId);
    ResultSet rs=ps.executeQuery();
    List<PatientPojo>patList=new ArrayList<>();
    while(rs.next()){
    PatientPojo pat=new PatientPojo();
    pat.setPatientId(rs.getString("patient_id"));
    pat.setFirstName(rs.getString("first_name")+" "+rs.getString("last_name"));
    pat.setpDate(rs.getDate("p_date"));
    pat.setOdp(rs.getString("odp"));
    patList.add(pat);   
    
    }
    return patList;
} 
  public static boolean updateStatus(String patientId)throws SQLException{
     Connection conn=DbConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update patients set status='CONFIRM' where patient_id=?" );
     ps.setString(1, patientId);
     return ps.executeUpdate()==1;
     
     
 }
  public static List<String> allPatientId() throws SQLException {
        Connection conn=DbConnection.getConnection();
     Statement st=conn.createStatement();
     ResultSet rs=st.executeQuery("select patient_id from patients");
     List<String> patIdList=new ArrayList();
     while(rs.next()){
         String patId=rs.getString("patient_id");
         patIdList.add(patId);
     }
     return patIdList;
  }
  public static boolean UpdatePatient(PatientPojo pat)throws SQLException{
      Connection con=DbConnection.getConnection();
      PreparedStatement ps=con.prepareStatement("update patients set OPD=? ,doctor_Id=? , age=? ,city=?, address=? , last_name=? , first_name=? , gender=? , mobile_no=? , m_status=? ,p_date=? where patient_id=?");
        ps.setString(1,pat.getOdp());
        ps.setString(2,pat.getDoctorId());
        ps.setInt(3,pat.getAge());
        ps.setString(4,pat.getCity());
        ps.setString(5,pat.getAddresss());
        ps.setString(6,pat.getLastName());
        ps.setString(7,pat.getFirstName());
        ps.setString(8,pat.getGender());
        ps.setString(9,pat.getMobileNO());
        ps.setString(10,pat.getMarriedStatus());
        ps.setDate(11,pat.getpDate());
        ps.setString(12,pat.getPatientId());
        
        return ps.executeUpdate()==1;
        
    }
  public static PatientPojo getPatientDetailById(String patId)throws SQLException{
      Connection con=DbConnection.getConnection();
      PreparedStatement ps=con.prepareStatement("select * from patients where patient_id=?");
      ps.setString(1, patId);
      ResultSet rs=ps.executeQuery();
      rs.next();
    PatientPojo pat=new PatientPojo();
    pat.setFirstName(rs.getString("first_name"));
    pat.setLastName(rs.getString("last_name"));
    pat.setAge(rs.getInt("age"));
    pat.setGender(rs.getString("gender"));
    pat.setMarriedStatus(rs.getString("m_status"));
    pat.setAddresss(rs.getString("address"));
    pat.setCity(rs.getString("city"));
    pat.setMobileNO(rs.getString("mobile_no"));
    pat.setpDate(rs.getDate("p_date"));
    pat.setOdp(rs.getString("opd"));
    pat.setStatus(rs.getString("m_Status"));
    pat.setDoctorId(rs.getString("doctor_id"));
    
    return pat;
  }
  public static boolean deletePatient(String patId)throws SQLException{
      Connection con=DbConnection.getConnection();
      PreparedStatement ps=con.prepareStatement("delete from patients where patient_id=?");
      ps.setString(1, patId);
      int a=ps.executeUpdate();
      boolean deleteApp=AppointmentDao.deletePatient(patId);
      boolean deletePat=a==1;
      if(deleteApp && deletePat){
          return true;
      }
      return false;
  }
}
