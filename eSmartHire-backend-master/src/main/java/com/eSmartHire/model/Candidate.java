package com.eSmartHire.model;

import java.sql.Date;
//import java.util.List;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import com.sun.el.stream.Optional;

//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
//@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cand_id")
    private Integer candId;

    @Column(name = "cand_user_id")
    private Integer candUserId;

    @Column(name = "cand_about")
    private String candAbout;

    @Column(name = "cand_address_permanent")
    private String candAddressPermanent;

    @Column(name = "cand_address_current")
    private String candAddressCurrent;

    @Column(name = "cand_passport_number")
    private Integer candPassportNumber;

    @Column(name = "cand_international_exposure")
    private String candInternationalExposure;

    @Column(name = "cand_notice_period")
    private Integer candNoticePeriod;

    @Column(name = "cand_preferred_location")
    private String candPreferredLocation;

    @Column(name = "cand_current_ctc_pa")
    private Integer candCurrentCtcPa;

    @Column(name = "cand_salary_in_hand")
    private Integer candSalaryInHand;

    @Column(name = "cand_expected_ctc_pa")
    private Integer candExpectedCtcPa;

    @Column(name = "cand_job_status")
    private Boolean candJobStatus;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "cand_created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false,insertable = false)
    private Date candCreatedDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "cand_last_updated_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false)
    private Date candLastUpdatedDate;
    
    /*@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Candidate> candidate;
*/
}