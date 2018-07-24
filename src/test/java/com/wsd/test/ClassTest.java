package com.wsd.test;

import com.wsd.dao.ClassDao;
import com.wsd.model.Clazz;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tm on 2018/7/23.
 * 班级测试类
 */
public class ClassTest {

    static ApplicationContext context;
    ClassDao claDao;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Before
    public void before() {
        claDao = context.getBean(ClassDao.class);
    }

    /**
     *  新增班级
     */
    @org.junit.Ignore
    public void fun(){
        Clazz clazz = new Clazz();
        clazz.setClaname("八班");
        claDao.save(clazz);
    }

    /**
     *  删除班级
     */
    @org.junit.Ignore
    public void fun1(){
        claDao.delete(4);
       // claDao.deleteAll();删除所有
    }

    /**
     *  查询班级
     */
    @org.junit.Ignore
    public void fun2(){
        Iterable<Clazz> clazzes= claDao.findAll();
        for (Clazz clazz : clazzes
             ) {
            System.out.println(clazz.getClaname());
        }
    }

    /**
     *  查询总记录
     */
    @org.junit.Ignore
    public void fun3(){
        System.out.println(claDao.count());
    }

    /**
     * 查询单个班级
     */
    @org.junit.Ignore
    public void fun4(){
        System.out.println(claDao.findOne(1));
    }

    /**
     * 判断是否存在某个班级
     */
    @org.junit.Test
    public void fun5(){
        System.out.println(claDao.exists(1));
    }
}
