package com.wsd.model;

import javax.persistence.*;


/**
 * Created by tm on 2018/7/22.
 * 班主任表实体类
 */

@Entity
public class Leader {
    private int leaid;
    private String leaname;
    private String leasex;
    private Clazz clazz;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "leaid")
    public int getLeaid() {
        return leaid;
    }

    public void setLeaid(int leaid) {
        this.leaid = leaid;
    }

    @Basic
    @Column(name = "leaname")
    public String getLeaname() {
        return leaname;
    }

    public void setLeaname(String leaname) {
        this.leaname = leaname;
    }

    @Basic
    @Column(name = "leasex")
    public String getLeasex() {
        return leasex;
    }

    public void setLeasex(String leasex) {
        this.leasex = leasex;
    }

    /*配置班主任与班级一对一关系*/
    @OneToOne
    @JoinColumn(name="leader")
    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}

