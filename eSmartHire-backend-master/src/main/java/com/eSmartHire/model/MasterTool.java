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
@Table(name = "master_tool")
public class MasterTool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tool_id")
    private Integer toolId;

    @Column(name = "tool_name")
    private String toolName;

    @Column(name = "tool_url")
    private String toolUrl;

    @Column(name = "tool_filepath")
    private String toolFilepath;

    @Column(name = "tool_is_active")
    private Boolean toolIsActive;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "tool_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date toolCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "tool_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable=true)
    private Date toolLastUpdatedDate;

}