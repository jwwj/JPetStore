package com.clps.demo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
/**
 * ������ܹ���
 * @author jwj
 *
 */
public class EncryptUtil {
	 public static final String KEY_MD5 = "MD5";   

	    /**
	     * MD5�����㷨
	     * @param inputStr
	     * @return ���ܺ��MD5�ַ���
	     */
	    public static  String  getResult(String inputStr){

	        BigInteger bigInteger=null;
	        
	        try {
	         MessageDigest md = MessageDigest.getInstance(KEY_MD5);   
	         byte[] inputData = inputStr.getBytes(); 
	         md.update(inputData);   
	         bigInteger = new BigInteger(md.digest());   
	        } catch (Exception e) {e.printStackTrace();}
	     
	        return bigInteger.toString(16);
	    }

}
