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
@Table(name = "recruiter_work")
public class RecruiterWork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recr_work_id")
    private Integer recrWorkId;

    @Column(name = "recr_work_recruiter_id")
    private Integer recrWorkRecruiterId;

    @Column(name = "recr_work_master_company_id")
    private Integer recrWorkMasterCompanyId;

    @Column(name = "recr_work_is_active")
    private Boolean recrWorkIsActive;

    @Column(name = "recr_work_is_deleted")
    private Boolean recrWorkIsDeleted;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "recr_work_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date recrWorkCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "recr_work_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date recrWorkLastUpdatedDate;

}