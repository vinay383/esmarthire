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
@Table(name = "candidate_template_hobby")
public class CandidateTemplateHobby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_hobb_id")
    private Integer ctHobbId;

    @Column(name = "ct_hobb_cand_temp_id")
    private Integer ctHobbCandTempId;

    @Column(name = "ct_hobb_master_hobby_id")
    private Integer ctHobbMasterHobbyId;

    @Column(name = "ct_hobb_is_deleted")
    private Integer ctHobbIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "ct_hobb_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date ctHobbCreatedDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "ct_hobb_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctHobbLastUpdatedDate;

}