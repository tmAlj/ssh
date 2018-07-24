package com.wsd.dao;

import com.wsd.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by tm on 2018/7/22.
 * 学生dao
 */
@Repository
public interface StudentDao extends PagingAndSortingRepository<Student,Integer> {
    //预定义and
    List<Student> findByStuageAndStuname(int stuage, String stuname);
    //JPQL
    @Query("from Student s where s.stuage = ?1 and s.stuname = ?2")
    List<Student> queryStuageAndStuname(int stuage, String stuname);

    //预定义or
    List<Student> findByStuageOrStuname(int stuage, String stuname);
    //JPQL
    @Query("from Student s where s.stuage = ?1 or s.stuname = ?2")
    List<Student> queryStuageOrStuname(int stuage, String stuname);

    //预定义between
    List<Student> findByStuageBetween(int stuage1, int stuage2);
    //JPQL
    @Query("from Student s where s.stuage between ?1 and ?2")
    List<Student> queryStuageBetween(int stuage1, int stuage2);

}
