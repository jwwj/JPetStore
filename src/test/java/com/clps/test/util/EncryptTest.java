package com.clps.test.util;


import org.junit.Test;

import com.clps.demo.util.EncryptUtil;

public class EncryptTest {

	/**
	 * ���Լ����㷨
	 */
	@Test
	public void MD5() {
		 try {
             String inputStr = "�򵥼���8888888888888888888";   
             System.out.println(EncryptUtil.getResult(inputStr).length());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
