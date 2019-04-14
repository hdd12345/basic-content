package com.time.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer rType;

    private String rName;

    private static final long serialVersionUID = 1L;

    public Integer getrType() {
        return rType;
    }

    public void setrType(Integer rType) {
        this.rType = rType;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }
}