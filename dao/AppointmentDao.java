/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjeevni.dao;

import com.sanjeevni.dbutil.DbConnection;
import com.sanjeevni.pojo.AppointmentPojo;
import com.sanjeevni.pojo.PatientPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AppointmentDao {
     public static boolean addAppointment(AppointmentPojo appt)throws SQLException{
     Connection conn=DbConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Insert into appointments values(?,?,?,?,?,?,?)");
     ps.setString(1,appt.getPatientId());
     ps.setString(2, appt.getPatientName());
     ps.setString(3,appt.getStatus());
     ps.setString(4, appt.getOdp());
     ps.setString(5, appt.getDateTime());
     ps.setString(6,appt.getDoctorName());
     ps.setString(7,appt.getMobileNo());
     
     return ps.executeUpdate()==1;
}
      public static List<AppointmentPojo> getAllPatientsByDoctorName(String doctorName)throws SQLException{
    Connection conn=DbConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select * from Appointments where doctor_name=? and status='REQUEST' order by doctor_name");
    ps.setString(1,doctorName);
    ResultSet rs=ps.executeQuery();
    List<AppointmentPojo>appList=new ArrayList<>();
    while(rs.next()){
    AppointmentPojo app=new AppointmentPojo();
    app.setPatientId(rs.getString("patient_id"));
    app.setPatientName(rs.getString("patient_name"));
    app.setOdp(rs.getString("opd"));
    app.setDoctorName(rs.getString("doctor_name"));
    app.setMobileNo(rs.getString("mobile_no"));
    app.setDateTime(rs.getString("date_time"));
    app.setStatus(rs.getString("status"));
    appList.add(app);   
    
    }
    return appList;
} 
        public static boolean updateStatus(AppointmentPojo app)throws SQLException{
     Connection conn=DbConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update appointments set status=?,date_time=? where patient_id=?" );
     ps.setString(1, app.getStatus());
     ps.setString(2,app.getDateTime());
     ps.setString(3, app.getPatientId());
     return ps.executeUpdate()==1;
 }
      public static List<AppointmentPojo> confirmAppointmentList(String docName)throws SQLException{
          Connection conn=DbConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("select * from appointments where status='CONFIRM' and doctor_name=? order by patient_id");
     ps.setString(1, docName);
     ResultSet rs=ps.executeQuery();
     List<AppointmentPojo> confList=new ArrayList();
     while(rs.next()){
         AppointmentPojo app=new AppointmentPojo();
             app.setPatientId(rs.getString("patient_id"));
    app.setPatientName(rs.getString("patient_name"));
    app.setOdp(rs.getString("opd"));
    app.setDateTime(rs.getString("date_time"));
    app.setStatus(rs.getString("status"));
    confList.add(app);
     }
     return confList;
      }
      public static boolean deletePatient(String patId)throws SQLException{
          Connection con=DbConnection.getConnection();
      PreparedStatement ps=con.prepareStatement("delete from appointments where patient_id=?");
      ps.setString(1, patId);
      int a=ps.executeUpdate();
      return a==1;
      }
    
}
