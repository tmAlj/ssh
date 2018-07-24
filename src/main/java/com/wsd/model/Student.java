package com.wsd.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tm on 2018/7/22.
 * 学生表实体类
 */
@Entity
public class Student {
    private int stuid;
    private String stuname;
    private Integer stuage;
    private Integer stusex;
    private Clazz clazz;
    private List<Score> score;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "stuid")
    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    @Basic
    @Column(name = "stuname")
    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    @Basic
    @Column(name = "stuage")
    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }

    @Basic
    @Column(name = "stusex")
    public Integer getStusex() {
        return stusex;
    }

    public void setStusex(Integer stusex) {
        this.stusex = stusex;
    }

    /*配置学生与成绩一对多关系*/
    @OneToMany(mappedBy="student",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    public List<Score> getScore() {
        return score;
    }
    public void setScore(List<Score> score) {
        this.score = score;
    }

    /*配置学生与班级多对一关系*/
    @ManyToOne()//多对一
    @JoinColumn(name="student")//外键
    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
