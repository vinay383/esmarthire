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
@Table(name = "candidate_template_profile")
public class CandidateTemplateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_prof_id")
    private Integer ctProfId;

    @Column(name = "ct_prof_cand_temp_id")
    private Integer ctProfCandTempId;

    @Column(name = "ct_prof_first_name")
    private String ctProfFirstName;

    @Column(name = "ct_prof_last_name")
    private String ctProfLastName;

    @Column(name = "ct_prof_location")
    private String ctProfLocation;

    @Column(name = "ct_prof_contact_number")
    private Integer ctProfContactNumber;

    @Column(name = "ct_prof_email")
    private String ctProfEmail;

    @Column(name = "ct_prof_about")
    private String ctProfAbout;

    @Column(name = "ct_prof_international_exposure")
    private String ctProfInternationalExposure;

    @Column(name = "ct_prof_portfolio_link")
    private String ctProfPortfolioLink;

    @Column(name = "ct_prof_is_deleted")
    private Boolean ctProfIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "ct_prof_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date ctProfCreatedDate;

    @UpdateTimestamp
	@LastModifiedDate
    @Column(name = "ct_prof_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctProfLastUpdatedDate;

}