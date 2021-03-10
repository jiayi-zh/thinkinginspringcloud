package com.bat.jyzh.business.mybatis.entity;

public class FaceAdapterPO {
    private Long id;

    private Long faceid;

    private String realid;

    private String createTime;

    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFaceid() {
        return faceid;
    }

    public void setFaceid(Long faceid) {
        this.faceid = faceid;
    }

    public String getRealid() {
        return realid;
    }

    public void setRealid(String realid) {
        this.realid = realid == null ? null : realid.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}