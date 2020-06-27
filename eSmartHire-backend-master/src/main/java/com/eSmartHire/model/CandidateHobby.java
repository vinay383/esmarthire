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
@Table(name = "candidate_hobby")
@EntityListeners(AuditingEntityListener.class)
public class CandidateHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_hobb_id")
    private Integer candHobbId;

    @Column(name = "cand_hobb_candidate_id")
    private Integer candHobbCandidateId;

    @Column(name = "cand_hobb_master_hobby_id")
    private Integer candHobbMasterHobbyId;

    @Column(name = "cand_hobb_is_deleted")
    private Boolean candHobbIsDeleted;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "cand_hobb_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date candHobbCreatedDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "cand_hobb_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)    
    private Date candHobbLastUpdatedDate;

}