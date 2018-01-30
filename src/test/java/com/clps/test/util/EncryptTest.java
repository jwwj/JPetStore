package com.clps.test.util;


import org.junit.Test;

import com.clps.demo.util.EncryptUtil;

public class EncryptTest {

	/**
	 * 测试加密算法
	 */
	@Test
	public void MD5() {
		 try {
             String inputStr = "简单加密8888888888888888888";   
             System.out.println(EncryptUtil.getResult(inputStr).length());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
