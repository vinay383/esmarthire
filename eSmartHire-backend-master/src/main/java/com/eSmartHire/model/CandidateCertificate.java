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

@Table(name = "candidate_certificate")
public class CandidateCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_cert_id")
    private Integer candCertId;

    @Column(name = "cand_cert_candidate_id")
    private Integer candCertCandidateId;

    @Column(name = "cand_cert_name")
    private String candCertName;

    @Column(name = "cand_cert_description")
    private String candCertDescription;

    @Column(name = "cand_cert_is_deleted")
    private Boolean candCertIsDeleted;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "cand_cert_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date candCertCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "cand_cert_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candCertLastUpdatedDate;

}