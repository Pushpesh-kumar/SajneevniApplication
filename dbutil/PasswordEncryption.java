/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjeevni.dbutil;
import java.util.Base64;

/**
 *
 * @author LENOVO
 */
public class PasswordEncryption {
    
    public static String getEncryptedPassword(String pwd){
        Base64.Encoder en;//Base64 is outer class and Encoder is a inner class 
        en = Base64.getEncoder();
       
        
//        pwd="pass";
       byte [] byt= pwd.getBytes();
       String enpwd= en.encodeToString(byt);
       return enpwd;
    }
    public static String getDecryptedPassword(String dpwd){
        byte[] decodedBytes = Base64.getDecoder().decode(dpwd);
        String newpass=new String(decodedBytes);
        return newpass;
    }
    
}
