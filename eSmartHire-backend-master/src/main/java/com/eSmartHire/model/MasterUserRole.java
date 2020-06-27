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
@Table(name = "master_user_role")
public class MasterUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ur_id")
    private Integer urId;

    @Column(name = "ur_user_id")
    private Integer urUserId;

    @Column(name = "ur_role_id")
    private Boolean urRoleId;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "ur_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date urCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "ur_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date urLastUpdatedDate;

}