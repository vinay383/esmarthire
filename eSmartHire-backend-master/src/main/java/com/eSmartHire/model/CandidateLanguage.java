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
@Table(name = "candidate_language")
public class CandidateLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_lang_id")
    private Integer candLangId;

    @Column(name = "cand_lang_candidate_id")
    private Integer candLangCandidateId;

    @Column(name = "cand_lang_master_lang_id")
    private Integer candLangMasterLangId;

    @Column(name = "cand_lang_percentage")
    private Integer candLangPercentage;

    @Column(name = "cand_lang_is_deleted")
    private Boolean candLangIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "cand_lang_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false)
    private Date candLangCreatedDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "cand_lang_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candLangLastUpdatedDate;

}