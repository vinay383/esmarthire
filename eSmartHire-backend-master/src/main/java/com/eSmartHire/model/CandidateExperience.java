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
@Table(name = "candidate_experience")
public class CandidateExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_expe_id")
    private Integer candExpeId;

    @Column(name = "cand_expe_candidate_id")
    private Integer candExpeCandidateId;

    @Column(name = "cand_expe_title")
    private String candExpeTitle;

    @Column(name = "cand_expe_company")
    private String candExpeCompany;

    @Column(name = "cand_expe_from")
    private String candExpeFrom;

    @Column(name = "cand_expe_to")
    private String candExpeTo;

    @Column(name = "cand_expe_about")
    private String candExpeAbout;

    @Column(name = "cand_expe_is_deleted")
    private Boolean candExpeIsDeleted;
    
    @CreationTimestamp
    @CreatedDate
    @Column(name = "cand_expe_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date candExpeCreatedDate;
    
    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "cand_expe_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candExpeLastUpdatedDate;
    
 

}