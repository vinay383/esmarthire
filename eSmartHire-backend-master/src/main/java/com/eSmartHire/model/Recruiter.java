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
@Table(name = "recruiter")
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recr_id")
    private Integer recrId;

    @Column(name = "recr_master_plan_id")
    private Integer recrMasterPlanId;

    @Column(name = "recr_company_name")
    private String recrCompanyName;

    @Column(name = "recr_address")
    private String recrAddress;

    @Column(name = "recr_job_title")
    private String recrJobTitle;

    @Column(name = "recr_company_website")
    private String recrCompanyWebsite;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "recr_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date recrCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "recr_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date recrLastUpdatedDate;

}