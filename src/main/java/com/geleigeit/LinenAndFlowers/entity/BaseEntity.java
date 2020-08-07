package com.geleigeit.LinenAndFlowers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @JsonIgnore
    @Column(name = "updated_at")
    private Date updatedAt = null;

    @JsonIgnore
    @Column(name = "deleted_at")
    private Date deletedAt = null;

    public BaseEntity() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public Date getDeletedAt() {
        return this.deletedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}