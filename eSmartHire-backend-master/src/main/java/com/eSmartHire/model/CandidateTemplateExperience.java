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
@Table(name = "candidate_template_experience")
public class CandidateTemplateExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_expe_id")
    private Integer ctExpeId;

    @Column(name = "ct_expe_cand_temp_id")
    private Integer ctExpeCandTempId;

    @Column(name = "ct_expe_title")
    private String ctExpeTitle;

    @Column(name = "ct_expe_company")
    private String ctExpeCompany;

    @Column(name = "ct_expe_from")
    private String ctExpeFrom;

    @Column(name = "ct_expe_to")
    private String ctExpeTo;

    @Column(name = "ct_expe_about")
    private String ctExpeAbout;

    @Column(name = "ct_expe_achievement")
    private String ctExpeAchievement;

    @Column(name = "ct_expe_is_deleted")
    private Boolean ctExpeIsDeleted;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "ct_expe_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date ctExpeCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "ct_expe_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctExpeLastUpdatedDate;

}