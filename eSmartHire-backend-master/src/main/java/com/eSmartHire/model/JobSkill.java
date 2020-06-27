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
@Table(name = "job_skill")
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "j_skil_id")
    private Integer jSkilId;

    @Column(name = "j_skil_job_id")
    private Integer jSkilJobId;

    @Column(name = "j_skil_master_skill_id")
    private Integer jSkilMasterSkillId;

    @Column(name = "j_skil_is_active")
    private Boolean jSkilIsActive;

    @Column(name = "j_skil_is_deleted")
    private Boolean jSkilIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "j_skil_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date jSkilCreatedDate;

    @UpdateTimestamp
	@LastModifiedDate
    @Column(name = "j_skil_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date jSkilLastUpdatedDate;

}