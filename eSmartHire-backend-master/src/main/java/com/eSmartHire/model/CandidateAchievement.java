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
@Table(name = "candidate_achievement")
public class CandidateAchievement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_achi_id")
    private Integer candAchiId;

    @Column(name = "cand_achi_candidate_id")
    private Integer candAchiCandidateId;

    @Column(name = "cand_achi_name")
    private String candAchiName;

    @Column(name = "cand_achi_held_by")
    private String candAchiHeldBy;

    @Column(name = "cand_achi_is_deleted")
    private Boolean candAchiIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "cand_achi_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date candAchiCreatedDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "cand_achi_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candAchiLastUpdatedDate;

}