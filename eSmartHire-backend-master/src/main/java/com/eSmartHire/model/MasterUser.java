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
@Table(name = "master_user")
public class MasterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_first_name")
    private String userFirstName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "user_email_id")
    private String userEmailId;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_contact_number")
    private Integer userContactNumber;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_date_of_birth")
    private String userDateOfBirth;

    @Column(name = "user_picture_url")
    private String userPictureUrl;

    @Column(name = "user_picture_filepath")
    private String userPictureFilepath;

    @Column(name = "user_is_verified")
    private Boolean userIsVerified;

    @Column(name = "user_is_active")
    private Boolean userIsActive;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "user_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date userCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "user_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date userLastUpdatedDate;

}