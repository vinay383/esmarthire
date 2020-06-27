package com.eSmartHire.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "master_skill")
public class MasterSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skil_id")
    private Integer skilId;

    @Column(name = "skil_name")
    private String skilName;

    @Column(name = "skil_is_active")
    private Boolean skilIsActive;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "skil_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date skilCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "skil_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date skilLastUpdatedDate;

}