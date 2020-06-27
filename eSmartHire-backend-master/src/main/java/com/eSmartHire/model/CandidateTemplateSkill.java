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
@Table(name = "candidate_template_skill")
public class CandidateTemplateSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_skill")
    private Integer ctSkill;

    @Column(name = "ct_skill_cand_temp_id")
    private Integer ctSkillCandTempId;

    @Column(name = "ct_skill_master_skill_id")
    private Integer ctSkillMasterSkillId;

    @Column(name = "ct_skill_type")
    private String ctSkillType;

    @Column(name = "ct_skill_experience")
    private Integer ctSkillExperience;

    @Column(name = "ct_skill_percentage")
    private Integer ctSkillPercentage;

    @Column(name = "ct_skill_level")
    private Integer ctSkillLevel;

    @Column(name = "ct_skil_is_deleted")
    private Boolean ctSkilIsDeleted;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "ct_skil_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
    private Date ctSkilCreatedDate;

	@UpdateTimestamp
	@LastModifiedDate
    @Column(name = "ct_skil_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date ctSkilLastUpdatedDate;

}