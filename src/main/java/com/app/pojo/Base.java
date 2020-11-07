package com.app.pojo;
// Generated Sep 17, 2020 2:55:05 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Base generated by hbm2java
 */
public class Base  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String short_name;
     private Integer active;
     private Date createdTime;
     private Date lastUpdate;
     private String sizes;

    public Base() {
    }

    public Base(String name, String short_name, Integer active, Date createdTime, Date lastUpdate, String sizes) {
       this.name = name;
       this.short_name = short_name;
       this.active = active;
       this.createdTime = createdTime;
       this.lastUpdate = lastUpdate;
       this.sizes = sizes;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getShort_name() {
        return this.short_name;
    }
    
    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }
    public Integer getActive() {
        return this.active;
    }
    
    public void setActive(Integer active) {
        this.active = active;
    }
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getSizes() {
        return this.sizes;
    }
    
    public void setSizes(String sizes) {
        this.sizes = sizes;
    }




}

