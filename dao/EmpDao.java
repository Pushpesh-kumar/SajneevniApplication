/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjeevni.dao;

import com.sanjeevni.dbutil.DbConnection;
import com.sanjeevni.pojo.EmpPojo;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class EmpDao {
    public static String getNextEmpId() throws SQLException{
        Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select max(emp_id) from employees");
        rs.next();
        String str=rs.getString(1);
        int  empId=101;
        if(str!=null){
            String id=str.substring(1);
            empId=Integer.parseInt(id);
            empId++;
        }
        String newId="E"+empId;
        return newId;
        
    }
    public static  boolean addEmployee(EmpPojo emp) throws SQLException{
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1,emp.getEmpId());
        ps.setString(2, emp.getEmpName());
        ps.setString(3, emp.getEmpDepartment());
        ps.setDouble(4, emp.getEmpSal());
        int a=ps.executeUpdate();
        return a==1;
    }
    public static List<String> getAllEmpId() throws SQLException{
        Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select emp_id from employees order by emp_id");
        List<String> empIdList=new ArrayList<String>();
        
        while(rs.next()){
            empIdList.add(rs.getString(1));
        }
        return empIdList;
        
    }
    public static EmpPojo getEmpDetails(String empId) throws SQLException{
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from employees where emp_id=? order by emp_id");
        ps.setString(1,empId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        EmpPojo emp=new EmpPojo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
        return emp;
    }
    public static boolean updateEmployee(EmpPojo emp) throws SQLException{
        updateName(emp);
           Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("update employees set emp_name=? , emp_salary=? where emp_id=?");
      ps.setString(1, emp.getEmpName());
     ps.setDouble(2, emp.getEmpSal());
     ps.setString(3, emp.getEmpId());
     return ps.executeUpdate()==1;
        
    }

    private static void updateName(EmpPojo emp)throws SQLException {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select emp_name from employees where emp_id=?");
        ps.setString( 1,emp.getEmpId());
        ResultSet rs=ps.executeQuery();
        rs.next();
        String currentName=rs.getString(1);
        UserDao.updateName(currentName,emp.getEmpName());
        if(emp.getEmpDepartment().equalsIgnoreCase("Receptionist")){
            ReceptionistDao.updateName(currentName,emp.getEmpName());
           
        }
        else if(emp.getEmpDepartment().equalsIgnoreCase("Doctor")){
        DoctorDao.updateName(currentName,emp.getEmpName());
    }
    }
        public static List<EmpPojo> getAllEmpDetials() throws SQLException{
        Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from employees order by emp_id");
        List<EmpPojo> empList=new ArrayList<>();
        while(rs.next()){
            EmpPojo emp=new EmpPojo();
            emp.setEmpId(rs.getString(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpDepartment(rs.getString(3));
            emp.setEmpSal(rs.getDouble(4));
            empList.add(emp);
        }
             for(EmpPojo e:empList){
        }
        return empList;
        
    }
        public static boolean deleteEmployee(String empId)throws SQLException{
            Connection con=DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from employees where emp_id=?");
            ps.setString(1, empId);
            String empdepart=getEmpDepartment(empId);
            String empName=getEmpName(empId);
            if(empdepart.equalsIgnoreCase("Receptionist")){
                ReceptionistDao.deleteReceptionist(empName);
            }else if(empdepart.equalsIgnoreCase("Doctor")){
                DoctorDao.deleteDoctor(empName);
            }
           UserDao.deleteUser(empName);
           return ps.executeUpdate()==1;
        }
     public static String getEmpDepartment(String empid)throws SQLException {
         Connection con=DbConnection.getConnection();
         PreparedStatement ps=con.prepareStatement("Select emp_department from employees where emp_id=?");
         ps.setString(1, empid);
         ResultSet rs=ps.executeQuery();
         rs.next();
         String empDepart=rs.getString(1);
         return empDepart;
     }

    private static String getEmpName(String empId)throws SQLException {
        
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select emp_name from employees where emp_Id=?");
        ps.setString( 1,empId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }
    public static Map<String,String> getUnregisterDoctors()throws SQLException{
        Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select emp_id,emp_name from employees where emp_department='DOCTOR' and emp_name not in(select user_name from users where user_type='DOCTOR')order by emp_id");
        Map<String,String> unRegDocList=new HashMap();
        while(rs.next()){
            String id=rs.getString(1);
            String name=rs.getString(2);
            unRegDocList.put(id,name);
        }
        return unRegDocList;
        
    }
       public static Map<String,String> getUnregisterReceptionists()throws SQLException{
        Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select emp_id,emp_name from employees where emp_department='RECEPTIONIST' and emp_name not in(select user_name from users where user_type='RECEPTIONIST')order by emp_id");
        Map<String,String> unRegReceptionistList=new HashMap();
        while(rs.next()){
            String id=rs.getString("emp_id");
            String name=rs.getString("emp_name");
            unRegReceptionistList.put(id,name);
        }
        return unRegReceptionistList;
    }
}
