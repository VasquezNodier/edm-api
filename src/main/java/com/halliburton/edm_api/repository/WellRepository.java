package com.halliburton.edm_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halliburton.edm_api.model.Well;

@Repository
public interface WellRepository extends JpaRepository<Well, String> {
	
	Optional<Well> findById(String well_id);
	List<Well> findByWellCommonName(String name);
	
}
