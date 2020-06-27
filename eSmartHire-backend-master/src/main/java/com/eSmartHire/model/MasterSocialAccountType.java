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
@Table(name = "master_social_account_type")
public class MasterSocialAccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "soci_acco_type_id")
    private Integer sociAccoTypeId;

    @Column(name = "soci_acco_type_name")
    private String sociAccoTypeName;

    @Column(name = "soci_acco_type_url")
    private String sociAccoTypeUrl;

    @Column(name = "soci_acco_type_filepath")
    private String sociAccoTypeFilepath;

    @Column(name = "soci_acco_type_is_active")
    private Boolean sociAccoTypeIsActive;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "soci_acco_type_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date sociAccoTypeCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "soci_acco_type_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date sociAccoTypeLastUpdatedDate;

}