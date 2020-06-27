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
@Table(name = "candidate_template_profile_social_link")
public class CandidateTemplateProfileSocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ctp_soci_link_id")
    private Integer ctpSociLinkId;

    @Column(name = "ctp_soci_link_ct_profile_id")
    private Integer ctpSociLinkCtProfileId;

    @Column(name = "ctp_soci_link_master_social_account_type_id")
    private Integer ctpSociLinkMasterSocialAccountTypeId;

    @Column(name = "ctp_soci_link_url")
    private String ctpSociLinkUrl;

    @Column(name = "ctp_soci_link_is_deleted")
    private Boolean ctpSociLinkIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "ctp_soci_link_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date ctpSociLinkCreatedDate;

    @UpdateTimestamp
	@LastModifiedDate
    @Column(name = "ctp_soci_link_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctpSociLinkLastUpdatedDate;

}