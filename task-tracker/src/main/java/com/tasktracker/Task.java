package com.tasktracker;

public class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Task(int id, String description, String status, String createdAt, String updatedAt) {
        this.id =id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setId(int newId){
        id = newId;
    }
    public void setDesc(String newDesc){
        description = newDesc;
    }
    public void setStatus(String newStatus){
        status = newStatus;
    }
    public void setCreatedAt(String newDate){
        createdAt = newDate;
    }
    public void setUpdatedAt(String newDate){
        updatedAt = newDate;
    }

    public int getId() {
        return id;
    }
    public String getDesc() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
}