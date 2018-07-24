package com.wsd.model;

import javax.persistence.*;


/**
 * Created by tm on 2018/7/22.
 * 成绩表实体类
 */
@Entity
public class Score {
    private Double scores;
    private int scoid;
    private Student student;
    private Course course;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "scoid")
    public int getScoid() { return scoid; }

    public void setScoid(int scoid) { this.scoid = scoid; }

    @Basic
    @Column(name = "scores")
    public Double getScores() {
        return scores;
    }

    public void setScores(Double scores) {
        this.scores = scores;
    }

    /*配置成绩与学生多对一关系*/
    @ManyToOne()//多对一
    @JoinColumn(name="score",insertable=false,updatable=false)//外键需要该设置，不然会报错
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    /*配置成绩与课程多对一关系*/
    @ManyToOne()//多对一
    @JoinColumn(name="score",insertable=false,updatable=false)//外键需要该设置，不然会报错
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
}

