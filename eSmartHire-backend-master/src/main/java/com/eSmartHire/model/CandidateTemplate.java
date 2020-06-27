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
@Table(name = "candidate_template")
public class CandidateTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_temp_id")
    private Integer candTempId;

    @Column(name = "cand_temp_user_id")
    private Integer candTempUserId;

    @Column(name = "cand_temp_master_template_id")
    private Integer candTempMasterTemplateId;

    @Column(name = "cand_temp_is_selected")
    private Boolean candTempIsSelected;

    @Column(name = "cand_temp_is_deleted")
    private Boolean candTempIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "cand_temp_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date candTempCreatedDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "cand_temp_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candTempLastUpdatedDate;

}