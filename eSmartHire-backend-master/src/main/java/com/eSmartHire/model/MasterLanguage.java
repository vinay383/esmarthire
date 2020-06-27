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
@Table(name = "master_language")
public class MasterLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lang_id")
    private Integer langId;

    @Column(name = "lang_name")
    private String langName;

    @Column(name = "lang_is_active")
    private Boolean langIsActive;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "lang_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date langCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "lang_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date langLastUpdatedDate;

}