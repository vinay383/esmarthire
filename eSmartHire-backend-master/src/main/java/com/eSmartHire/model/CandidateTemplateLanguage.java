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
@Table(name = "candidate_template_language")
public class CandidateTemplateLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ct_lang_id")
	private Integer ctLangId;

	@Column(name = "ct_lang_cand_temp_id")
	private Integer ctLangCandTempId;

	@Column(name = "ct_lang_master_language_id")
	private Integer ctLangMasterLanguageId;

	@Column(name = "ct_lang_certified")
	private Integer ctLangCertified;

	@Column(name = "ct_lang_rate")
	private Integer ctLangRate;

	@Column(name = "ct_lang_native")
	private Integer ctLangNative;

	@Column(name = "ct_lang_is_deleted")
	private Boolean ctLangIsDeleted;

	@CreationTimestamp
	@CreatedDate
	@Column(name = "ct_lang_created_date",insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private Date ctLangCreatedDate;

	@UpdateTimestamp
	@LastModifiedDate
	@Column(name = "ct_lang_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
	private Date ctLangLastUpdatedDate;

}