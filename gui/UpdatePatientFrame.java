/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjeevni.gui;

import com.sanjeevni.dao.DoctorDao;
import com.sanjeevni.dao.PatientDao;
import com.sanjeevni.pojo.PatientPojo;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
/**
 *
 * @author LENOVO
 */
public class UpdatePatientFrame extends javax.swing.JFrame {

    /**
     * Creates new form UpdatePatientFrame
     */
    private List<String> doctorIdList;
    private List<String> patIdList;
    private PatientPojo patient;
    private  java.sql.Date dt;
    private String datestr;
    private SimpleDateFormat  sdf;
    public UpdatePatientFrame() {
        initComponents();
            setLocationRelativeTo(null);
        lblBackground.add(lblHeading);
        lblHeading.setBounds(360, 20, 600, 50);
    setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\SanjeevaniApplication\\src\\com\\sanjeevni\\icons\\icon.png"));
        loadDoctorId();
        loadPatientId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcDocId = new javax.swing.JComboBox<>();
        txtFirstName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcGender = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtMobileNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jcStatus = new javax.swing.JComboBox<>();
        txtOdp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcPatId = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblBackground = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(236, 249, 255));

        jPanel2.setBackground(new Color(180, 228, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Patient Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24))); // NOI18N

        txtAge.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Age");

        txtCity.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("City");

        txtAddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Address");

        jcDocId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jcDocId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcDocIdActionPerformed(evt);
            }
        });

        txtFirstName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("First Name");

        txtLastName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Last Name");

        jcGender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Gender");

        txtMobileNo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Phone No");

        txtDate.setEditable(false);
        txtDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        jcStatus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jcStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "Unmarried", "Divorsed" }));
        jcStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcStatusActionPerformed(evt);
            }
        });

        txtOdp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Marital Status");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("ODP");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Date");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Doctor ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Patient ID");

        jcPatId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jcPatId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPatIdActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new Color(180, 228, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new Color(236, 249, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(47, 88, 205), 2));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sanjeevni/icons/images (2).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap())
        );

        btnUpdate.setBackground(new Color(47, 88, 205));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setBackground(new Color(47, 88, 205));
        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new Color(47, 88, 205));
        btnLogout.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLogout.setText("Logout");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnLogout))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCity)
                                    .addComponent(txtOdp)
                                    .addComponent(txtAge)
                                    .addComponent(jcDocId, 0, 193, Short.MAX_VALUE)
                                    .addComponent(jcPatId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFirstName)
                                        .addComponent(txtLastName)
                                        .addComponent(jcGender, javax.swing.GroupLayout.Alignment.LEADING, 0, 169, Short.MAX_VALUE)
                                        .addComponent(txtMobileNo))))
                            .addComponent(txtAddress))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jcDocId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jcPatId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jcStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel15.setText("Update Patient");

        jPanel5.setBackground(new Color(180, 228, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(47, 88, 205), 2));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sanjeevni/icons/HomePageBG1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBackground)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBackground)
                .addContainerGap())
        );

        lblHeading.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lblHeading.setForeground(new Color(47, 88, 205));
        lblHeading.setText("SANJEEVNI APPLICATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(lblHeading)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void jcDocIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcDocIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcDocIdActionPerformed

    private void jcStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcStatusActionPerformed

    private void jcPatIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPatIdActionPerformed
        // TODO add your handling code here:
        try{
            String patId=jcPatId.getSelectedItem().toString();
            PatientPojo pat=PatientDao.getPatientDetailById(patId);
            
            txtOdp.setText(pat.getOdp());
            txtFirstName.setText(pat.getFirstName());
            txtLastName.setText(pat.getLastName());
              Date today=new Date();
         sdf=new SimpleDateFormat("dd-MMM-yyyy");
        datestr=sdf.format(today);
        txtDate.setText(datestr);
        try{
        java.util.Date d1=sdf.parse(datestr);
         long ms=d1.getTime();
          dt=new java.sql.Date(ms);
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null,"DATABASE ERROR","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
           
        txtCity.setText(pat.getCity());
            txtAge.setText(String.valueOf(pat.getAge()));
            txtAddress.setText(pat.getAddresss());
            txtMobileNo.setText(pat.getMobileNO());
        String gender=pat.getGender();
        jcGender.setSelectedItem(gender);
        String mStatus=pat.getStatus();
        jcStatus.setSelectedItem(mStatus);
        
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"DB Error:"+ex.getMessage());
             JOptionPane.showMessageDialog(null,"DATABASE ERROR","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jcPatIdActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        boolean valid=validateInputs();
        if(!valid){
//             JOptionPane.showMessageDialog(null,"PLEASE FILL ALL THE FIELDS","Error",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        patient=new PatientPojo();
        patient.setFirstName(txtFirstName.getText());
        patient.setLastName(txtLastName.getText());
        patient.setAddresss(txtAddress.getText());
        patient.setOdp(txtOdp.getText());
        patient.setMobileNO(txtMobileNo.getText());
        patient.setCity(txtCity.getText());
        patient.setGender(jcGender.getSelectedItem().toString());
        patient.setMarriedStatus(jcStatus.getSelectedItem().toString());
        patient.setDoctorId(jcDocId.getSelectedItem().toString());
        patient.setPatientId(jcPatId.getSelectedItem().toString());
        patient.setpDate(dt);
        try{
                int age=Integer.parseInt(txtAge.getText().trim());
                   patient.setAge(age);
            boolean result=PatientDao.UpdatePatient(patient);
            if(result){
                JOptionPane.showMessageDialog(null,"PATIENT UPDATED SUCCESSFULLY");
            }else{
                 JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG","Error",JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"DATABASE ERROR","Error",JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
        }catch(NumberFormatException ex){
              JOptionPane.showMessageDialog(null,"INVALID AGE","Error",JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new ReceptionistOptionsFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdatePatientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePatientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePatientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePatientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdatePatientFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> jcDocId;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JComboBox<String> jcPatId;
    private javax.swing.JComboBox<String> jcStatus;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMobileNo;
    private javax.swing.JTextField txtOdp;
    // End of variables declaration//GEN-END:variables

    private void loadDoctorId() {
           try{
            doctorIdList=DoctorDao.getAllDoctors();
            for(String docId:doctorIdList){
                jcDocId.addItem(docId);
            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"DATABASE ERROR","Error",JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
            
        }
    }

    private void loadPatientId() {
        try{
            patIdList=PatientDao.allPatientId();
            for(String patId:patIdList){
                jcPatId.addItem(patId);
            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"DATABASE ERROR","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }
        private boolean isContactNoValid() {
           
      char[]mob=txtMobileNo.getText().toCharArray();
      for(char ch:mob){
          if(Character.isDigit(ch)==false)
              return false;
      }
      if(txtMobileNo.getText().length()==10)
            return true;
      return false;
  }

    private boolean validateInputs() {
        boolean ans=true;
        if(!isContactNoValid()){
             JOptionPane.showMessageDialog(null,"INVALID MOBILE NO","Error",JOptionPane.ERROR_MESSAGE);
           ans= false;
        }
             if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtAddress.getText().isEmpty()|| txtCity.getText().isEmpty())
        {
             JOptionPane.showMessageDialog(null,"PLEASE FILL ALL THE FIELDS","Error",JOptionPane.ERROR_MESSAGE);
            ans= false;
        }
        return ans;
    }
}
