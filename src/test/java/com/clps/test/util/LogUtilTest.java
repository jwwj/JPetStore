package com.clps.test.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.clps.demo.util.LogUtil;

public class LogUtilTest {

	@Test
	public  void hello() {                              
//		LogUtil.logger.entry();   //trace�������Ϣ�������г�����ϣ������ĳ���������߳����߼���ʼ��ʱ����ã���logger.trace("entry")����һ����˼  
		LogUtil.logger.error("Did it again!");   //error�������Ϣ�������������������Ϣ  
		LogUtil.logger.info("����info��Ϣ");    //info�������Ϣ  
		LogUtil.logger.debug("����debug��Ϣ");  
		LogUtil.logger.warn("����warn��Ϣ");  
		LogUtil.logger.fatal("����fatal��Ϣ");  
		LogUtil.logger.log(Level.DEBUG, "����debug��Ϣ");   //��������ƶ�Level���͵ĵ��ã�˭����û�µ��������Ҳ��һ��Ŷ��  
//		LogUtil.logger.exit();    //��entry()��Ӧ�Ľ�����������logger.trace("exit");һ����˼  
	    }  
}
