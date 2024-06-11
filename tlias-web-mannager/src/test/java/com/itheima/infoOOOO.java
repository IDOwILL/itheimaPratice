package com.itheima;

import com.itheima.controller.DeptController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Slf4j
public class infoOOOO {
    @Autowired
    private ApplicationContext ac;

    @Test
    public void getAutoInfo() {
        DeptController deptController1 = (DeptController) ac.getBean("deptController");
        log.info("deptController=>{}",deptController1);
        DeptController deptController2 = ac.getBean(DeptController.class);
        log.info("deptController=>{}",deptController2+"\r\n");
        DeptController deptController3 = ac.getBean("deptController", DeptController.class);
        log.info("deptController=>{}",deptController3);
    }

    @Test
    public void testScope() {
        for (int i = 0; i < 10; i++) {
            DeptController deptController = ac.getBean("deptController", DeptController.class);
            log.info("deptController+{}",deptController);
        }
    }
}
