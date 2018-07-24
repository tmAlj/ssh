package com.wsd.model;

import javax.persistence.*;

/**
 * Created by tm on 2018/7/22.
 * 授课实体类
 */

@Entity
public class Teach {
    private int teacid;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "teacid")

    public int getTeacid() {
        return teacid;
    }

    public void setTeacid(int teacid) {
        this.teacid = teacid;
    }
}

