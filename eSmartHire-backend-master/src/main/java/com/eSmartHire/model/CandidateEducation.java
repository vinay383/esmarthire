package com.eSmartHire.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
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
@Table(name = "candidate_education")
public class CandidateEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_educ_id")
    private Integer candEducId;

    @Column(name = "cand_educ_candidate_id")
    private Integer candEducCandidateId;

    @Column(name = "cand_educ_institution")
    private String candEducInstitution;

    @Column(name = "cand_educ_university")
    private String candEducUniversity;

    @Column(name = "cand_educ_from")
    private String candEducFrom;

    @Column(name = "cand_educ_to")
    private String candEducTo;

    @Column(name = "cand_educ_is_deleted")
    private Boolean candEducIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "cand_educ_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date candEducCreatedDate;

	@UpdateTimestamp
	@LastModifiedDate
    @Column(name = "cand_educ_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candEducLastUpdatedDate;

    
}