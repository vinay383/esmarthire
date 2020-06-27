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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "candidate_template_certificate")
public class CandidateTemplateCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_cert_id")
    private Integer ctCertId;

    @Column(name = "ct_cert_cand_temp_id")
    private Integer ctCertCandTempId;

    @Column(name = "ct_cert_name")
    private String ctCertName;

    @Column(name = "ct_cert_credential_id")
    private String ctCertCredentialId;

    @Column(name = "ct_cert_from")
    private String ctCertFrom;

    @Column(name = "ct_cert_to")
    private String ctCertTo;

    @Column(name = "ct_cert_url")
    private String ctCertUrl;

    @Column(name = "ct_cert_is_deleted")
    private Boolean ctCertIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "ct_cert_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date ctCertCreatedDate;

    @UpdateTimestamp
    @CreatedDate
    @Column(name = "ct_cert_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctCertLastUpdatedDate;

}