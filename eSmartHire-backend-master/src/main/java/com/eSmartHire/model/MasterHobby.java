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

@Table(name = "master_hobby")
public class MasterHobby {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hobb_id")
	private Integer hobbId;

	@Column(name = "hobb_name")
	private String hobbName;

	@Column(name = "hobb_is_active")
	private Boolean hobbIsActive;

	@CreatedDate
	@CreationTimestamp
	@Column(name = "hobb_created_date",  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date hobbCreatedDate;

	@LastModifiedDate
	@UpdateTimestamp
	@Column(name = "hobb_last_updated_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
	private Date hobbLastUpdatedDate;

}