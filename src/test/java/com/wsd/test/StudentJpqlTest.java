package com.wsd.test;

import com.wsd.dao.StudentDao;
import com.wsd.model.Student;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by tm on 2018/7/22.
 * JPQL查询测试类
 */
public class StudentJpqlTest {

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
     *
     */
    @org.junit.Ignore
    public void fun(){
        List<Student> stuList = dao.queryStuageAndStuname(12,"张三");
        for (Student stu : stuList
                ) {
            System.out.println("jpqlxxxxxxxxxxxxxxxxxx"+stu.getStuname());
        }
    }

    /**
     *  or
     */
    @org.junit.Ignore
    public void fun1(){
        List<Student> stuList = dao.queryStuageOrStuname(12,"张三");
        for (Student stu : stuList
                ) {
            System.out.println("jpqlxxxxxxxxxxxxxxxxxx"+stu.getStuname());
        }
    }

    /**
     *  between
     */
    @org.junit.Test
    public void fun2(){
        List<Student> stuList = dao.queryStuageBetween(12,17);
        for (Student stu : stuList
                ) {
            System.out.println("jpqlxxxxxxxxxxxxxxxxxx"+stu.getStuname());
        }
    }
}
