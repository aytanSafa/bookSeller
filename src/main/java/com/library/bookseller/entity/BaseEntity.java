package com.library.bookseller.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Date;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by",length = 10)
    private String createdBy;
    @Column(name = "updated_at",length = 10)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "status")
    private String updatedBy;



}
