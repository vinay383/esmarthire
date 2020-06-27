package com.eSmartHire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eSmartHire.model.MasterUser;

public interface MasterUserRepository extends JpaRepository<MasterUser, Integer>{
	Optional<MasterUser> findByUserEmailId(String userName);
}
