
package com.wsd.model;

import javax.persistence.*;
import java.util.List;


/**
 * Created by tm on 2018/7/22.
 * 课程表实体类
 */
@Entity
public class Course {
    private int couid;
    private String couname;
    private List<Score> score;
    private List<Teacher> teacher;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "couid")
    public int getCouid() {
        return couid;
    }

    public void setCouid(int couid) {
        this.couid = couid;
    }

    @Basic
    @Column(name = "couname")
    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname;
    }

    /*配置课程与老师多对多关系*/
    @ManyToMany(mappedBy="course",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    public List<Teacher> getTeacher() {
        return teacher;
    }
    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    /*配置课程与成绩一对多关系*/
    @OneToMany(mappedBy="course",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    public List<Score> getScore() {
        return score;
    }
    public void setScore(List<Score> score) {
        this.score = score;
    }
}

