package com.eSmartHire.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class JobInterviewProcess {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "j_inte_proc_id")
	private Integer jInteProcId;

	@Column(name = "j_inte_proc_job_id")
	private Integer jInteProcJobId;

	@Column(name = "j_inte_proc_name")
	private String jInteProcName;

	@Column(name = "j_inte_proc_is_active")
	private Boolean jInteProcIsActive;

	@Column(name = "j_inte_proc_is_deleted")
	private Boolean jInteProcIsDeleted;

	@CreationTimestamp
	@CreatedDate
	@Column(name = "j_inte_proc_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false,insertable = false)
	private Date jInteProcCreatedDate;

	@UpdateTimestamp
	@LastModifiedDate
	@Column(name = "j_inte_proc_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
	private Date jInteProcLastUpdatedDate;

}
