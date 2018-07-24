package com.wsd.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tm on 2018/7/22.
 * 班级表实体类
 */
@Entity
@Table(name = "class", schema = "jpa", catalog = "")
public class Clazz {
    private int claid;
    private String claname;
    private List<Student> student;
    private Leader leader;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "claid")
    public int getClaid() {
        return claid;
    }

    public void setClaid(int claid) {
        this.claid = claid;
    }

    @Basic
    @Column(name = "claname")
    public String getClaname() {
        return claname;
    }

    public void setClaname(String claname) {
        this.claname = claname;
    }

    /*配置班级与班主任一对一关系*/
   @OneToOne(mappedBy="clazz")
   public Leader getLeader() { return leader; }
    public void setLeader(Leader leader) { this.leader = leader; }

    /*配置班级与学生一对多关系*/
    @OneToMany(mappedBy="clazz",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    public List<Student> getStudent() {
        return student;
    }
    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
