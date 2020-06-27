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
@Table(name = "candidate_skill")
public class CandidateSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_skil_id")
    private Integer candSkilId;

    @Column(name = "cand_skil_candidate_id")
    private Integer candSkilCandidateId;

    @Column(name = "cand_skil_master_skill_id")
    private Integer candSkilMasterSkillId;

    @Column(name = "cand_skil_percentage")
    private Integer candSkilPercentage;

    @Column(name = "cand_skil_is_deleted")
    private Boolean candSkilIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "cand_skil_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false)
    private Date candSkilCreatedDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "cand_skil_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candSkilLastUpdatedDate;

}