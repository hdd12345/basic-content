package com.time.entity;

import java.io.Serializable;

public class GoodsType implements Serializable {
    private Integer gType;

    private String typeName;

    private Integer typeParent;

    private static final long serialVersionUID = 1L;

    public Integer getgType() {
        return gType;
    }

    public void setgType(Integer gType) {
        this.gType = gType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getTypeParent() {
        return typeParent;
    }

    public void setTypeParent(Integer typeParent) {
        this.typeParent = typeParent;
    }
}