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
@Table(name = "candidate_template_achievement")
public class CandidateTemplateAchievement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_achi_id")
    private Integer ctAchiId;

    @Column(name = "ct_achi_cand_temp_id")
    private Integer ctAchiCandTempId;

    @Column(name = "ct_achi_title")
    private String ctAchiTitle;

    @Column(name = "ct_achi_held_by")
    private String ctAchiHeldBy;

    @Column(name = "ct_achi_description")
    private String ctAchiDescription;

    @Column(name = "ct_achi_is_deleted")
    private Boolean ctAchiIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "ct_achi_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date ctAchiCreatedDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "ct_achi_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctAchiLastUpdatedDate;

}