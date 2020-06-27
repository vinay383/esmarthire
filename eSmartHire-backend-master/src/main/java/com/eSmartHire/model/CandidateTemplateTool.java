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
@Table(name = "candidate_template_tool")
public class CandidateTemplateTool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_tool_id")
    private Integer ctToolId;

    @Column(name = "ct_tool_cand_temp_id")
    private Integer ctToolCandTempId;

    @Column(name = "ct_tool_master_tool_id")
    private Integer ctToolMasterToolId;

    @Column(name = "ct_tool_certified")
    private Integer ctToolCertified;

    @Column(name = "ct_tool_experience")
    private Integer ctToolExperience;

    @Column(name = "ct_tool_percentage")
    private Integer ctToolPercentage;

    @Column(name = "ct_tool_level")
    private Integer ctToolLevel;

    @Column(name = "ct_tool_is_deleted")
    private Boolean ctToolIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "ct_tool_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date ctToolCreatedDate;

    @UpdateTimestamp
	@LastModifiedDate
    @Column(name = "ct_tool_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctToolLastUpdatedDate;

}