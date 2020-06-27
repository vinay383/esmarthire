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
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "job_recruiter_id")
    private Integer jobRecruiterId;

    @Column(name = "job_master_location_city_id")
    private Integer jobMasterLocationCityId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_vacancy")
    private Integer jobVacancy;

    @Column(name = "job_seniority_level")
    private String jobSeniorityLevel;

    @Column(name = "job_employment_type")
    private String jobEmploymentType;

    @Column(name = "job_industry")
    private String jobIndustry;

    @Column(name = "job_function")
    private String jobFunction;

    @Column(name = "job_requirement")
    private String jobRequirement;

    @Column(name = "job_experience_required")
    private Integer jobExperienceRequired;

    @Column(name = "job_relevant_experience")
    private Integer jobRelevantExperience;

    @Column(name = "job_qualification_detail")
    private String jobQualificationDetail;

    @Column(name = "job_salary_bracket")
    private String jobSalaryBracket;

    @Column(name = "job_travel_required")
    private String jobTravelRequired;

    @Column(name = "job_shift_timing")
    private String jobShiftTiming;

    @Column(name = "job_age_limit")
    private String jobAgeLimit;

    @Column(name = "job_onboarding_time")
    private String jobOnboardingTime;

    @Column(name = "job_is_active")
    private Boolean jobIsActive;

    @Column(name = "job_is_deleted")
    private Boolean jobIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "job_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date jobCreatedDate;

    @UpdateTimestamp
	@LastModifiedDate
    @Column(name = "job_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date jobLastUpdatedDate;

}