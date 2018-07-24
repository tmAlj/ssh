package com.wsd.test;

import com.wsd.dao.StudentDao;
import com.wsd.model.Student;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * jpa与spring整合测试
 * @author Administrator
 *
 */
public class Test {
    static ApplicationContext context;
    StudentDao dao;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Before
    public void before() {
        dao = context.getBean(StudentDao.class);
    }

    /**
     * 新增部门
     */
    @org.junit.Test
    public void fun(){
        Student stu = new Student();
        stu.setStuage(11);
        stu.setStuname("狗蛋");
        stu.setStusex(0);
        dao.save(stu);
    }
}
