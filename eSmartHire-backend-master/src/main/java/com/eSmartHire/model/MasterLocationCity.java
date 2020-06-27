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
@Table(name = "master_location_city")
public class MasterLocationCity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_city_id")
    private Integer locationCityId;

    @Column(name = "location_city_name")
    private String locationCityName;

    @Column(name = "location_city_is_deleted")
    private Boolean locationCityIsDeleted;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "location_city_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date locationCityCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "location_city_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date locationCityLastUpdatedDate;

}