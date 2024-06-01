package com.itheima;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private  static final Logger logger=  LoggerFactory.getLogger(LogTest.class);
    @Test
    public void testLog(){
        logger.info("计算开始");
        int sum = 0;
        try {
            int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
        } catch (Exception e) {
            logger.error("程序运行出错...");
        }
        logger.error("计算结果为: "+sum);
        logger.info("结束计算...");
        logger.debug("计算结果为："+sum);

    }

}
