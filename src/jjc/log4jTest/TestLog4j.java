package jjc.log4jTest;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

/**
 * 测试log4j日志框架
 */
public class TestLog4j {
    //创建一个日志记录器
    private final static Logger logger = Logger.getLogger(TestLog4j.class);

    public static void log(){
        logger.warn("通过调用log方法进行记录");
    }

    public static void main(String[] args){
        //读取日志配置文件
        PropertyConfigurator.configure("resources/log4j.properties");
        //日志记录器进行日志记录。
        logger.fatal("致命信息");
        logger.error("错误信息");
        logger.warn("警告信息");
        logger.debug("调试信息");
        logger.info("通知信息");
        logger.trace("跟踪信息");
        System.out.println("不影响我运行");

        //测试多线程，查看记录的线程信息。
        for(int i=0; i<99; i++){
            Thread t = new Thread(TestLog4j::log);
            t.start();
        }

    }

}
