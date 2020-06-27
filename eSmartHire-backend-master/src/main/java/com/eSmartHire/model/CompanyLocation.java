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
@Table(name = "company_location")
public class CompanyLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comp_loca_id")
    private Integer compLocaId;

    @Column(name = "comp_loca_master_company_id")
    private Integer compLocaMasterCompanyId;

    @Column(name = "comp_loca_location")
    private String compLocaLocation;

    @Column(name = "comp_loca_is_deleted")
    private Boolean compLocaIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "comp_loca_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date compLocaCreatedDate;

    @UpdateTimestamp
	@LastModifiedDate
    @Column(name = "comp_loca_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date compLocaLastUpdatedDate;

}