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
@Table(name = "master_template")
public class MasterTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "temp_id")
    private Integer tempId;

    @Column(name = "temp_name")
    private String tempName;

    @Column(name = "temp_rating")
    private Integer tempRating;

    @Column(name = "temp_description")
    private String tempDescription;

    @Column(name = "temp_url")
    private String tempUrl;

    @Column(name = "temp_filepath")
    private String tempFilepath;

    @Column(name = "temp_is_active")
    private Boolean tempIsActive;

    @Column(name = "temp_is_deleted")
    private Boolean tempIsDeleted;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "temp_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date tempCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "temp_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date tempLastUpdatedDate;

}