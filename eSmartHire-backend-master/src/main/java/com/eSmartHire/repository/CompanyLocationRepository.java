package com.eSmartHire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eSmartHire.model.CompanyLocation;

public interface CompanyLocationRepository extends JpaRepository<CompanyLocation, Integer> {

	//CompanyLocation updateById(Integer compLocaId);
}
