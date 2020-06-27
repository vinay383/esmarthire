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
@Table(name = "candidate_tool")
public class CandidateTool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_tool_id")
    private Integer candToolId;

    @Column(name = "cand_tool_candidate_id")
    private Integer candToolCandidateId;

    @Column(name = "cand_tool_master_tool_id")
    private Integer candToolMasterToolId;

    @Column(name = "cand_tool_is_deleted")
    private Boolean candToolIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "cand_tool_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date candToolCreatedDate;

    @UpdateTimestamp
	@LastModifiedDate
    @Column(name = "cand_tool_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candToolLastUpdatedDate;

}