package com.eSmartHire.repository;

import com.eSmartHire.model.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}