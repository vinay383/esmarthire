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
@Table(name = "master_plan")
public class MasterPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_id")
    private Integer planId;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "plan_benefit")
    private String planBenefit;

    @Column(name = "plan_price")
    private Integer planPrice;

    @Column(name = "plan_duration")
    private Integer planDuration;

    @Column(name = "plan_is_active")
    private Boolean planIsActive;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "plan_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP,insertable = false, updatable = false")
    private Date planCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "plan_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date planLastUpdatedDate;

}