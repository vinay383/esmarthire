package com.eSmartHire.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "master_company")
public class MasterCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comp_id")
	private Integer compId;

	@Column(name = "comp_name")
	private String compName;

	@Column(name = "comp_about")
	private String compAbout;

	@Column(name = "comp_logo_url")
	private String compLogoUrl;

	@Column(name = "comp_logo_filepath")
	private String compLogoFilepath;

	@Column(name = "comp_is_active")
	private Boolean compIsActive = true;

	@CreatedDate
	@CreationTimestamp
	@Column(name = "comp_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date compCreatedDate;

	@LastModifiedDate
	@UpdateTimestamp
	@Column(name = "comp_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
	private Date compLastUpdatedDate;
}