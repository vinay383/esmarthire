package com.eSmartHire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eSmartHire.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
