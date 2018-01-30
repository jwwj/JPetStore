package com.clps.demo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
/**
 * 单向加密工具
 * @author jwj
 *
 */
public class EncryptUtil {
	 public static final String KEY_MD5 = "MD5";   

	    /**
	     * MD5加密算法
	     * @param inputStr
	     * @return 加密后的MD5字符串
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
