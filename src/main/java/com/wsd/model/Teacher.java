package com.wsd.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tm on 2018/7/22.
 * 教师实体类
 */

@Entity
public class Teacher {
    private int teaid;
    private String teaname;
    private Integer teasex;
    private List<Course> course;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "teaid")
    public int getTeaid() {
        return teaid;
    }

    public void setTeaid(int teaid) {
        this.teaid = teaid;
    }

    @Basic
    @Column(name = "teaname")
    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    @Basic
    @Column(name = "teasex")
    public Integer getTeasex() {
        return teasex;
    }

    public void setTeasex(Integer teasex) {
        this.teasex = teasex;
    }

    /*配置老师与课程多对多关系*/
    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
        //为中间表，以及中间表中的外键
        @JoinTable(
                name="teach",
                joinColumns={@JoinColumn(name="teaid")},
                inverseJoinColumns={@JoinColumn(name="stuid")}
        )
    public List<Course> getCourse() {
        return course;
    }
    public void setCourse(List<Course> course) {
        this.course = course;
    }
}

