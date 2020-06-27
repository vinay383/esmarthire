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
@Table(name = "candidate_template_education")
public class CandidateTemplateEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_educ_id")
    private Integer ctEducId;

    @Column(name = "ct_educ_cand_temp_id")
    private Integer ctEducCandTempId;

    @Column(name = "ct_educ_institution")
    private String ctEducInstitution;

    @Column(name = "ct_educ_standard")
    private String ctEducStandard;

    @Column(name = "ct_educ_university")
    private String ctEducUniversity;

    @Column(name = "ct_educ_from")
    private String ctEducFrom;

    @Column(name = "ct_educ_to")
    private String ctEducTo;

    @Column(name = "ct_educ_percentage")
    private Integer ctEducPercentage;

    @Column(name = "ct_educ_project")
    private String ctEducProject;

    @Column(name = "ct_educ_is_deleted")
    private Boolean ctEducIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "ct_educ_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date ctEducCreatedDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "ct_educ_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctEducLastUpdatedDate;

}