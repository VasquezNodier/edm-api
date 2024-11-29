package com.halliburton.edm_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.halliburton.edm_api.exeption.DuplicateResourceException;
import com.halliburton.edm_api.exeption.ResourceNotFoundException;
import com.halliburton.edm_api.model.Well;
import com.halliburton.edm_api.repository.WellRepository;

@Service
public class WellService {
	
	private WellRepository wellRepository;
	
	public WellService(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }
	
	public Well desbloquear(String well_id, Well wellDetails) {
//		// TODO Auto-generated method stub
//		return null;
		
		Well well = buscarPorId(well_id);
		if(well.getIs_readonly().equals(wellDetails.getIs_readonly())) {
			throw new DuplicateResourceException("Tiene el mismo valor en BD: " + wellDetails.getIs_readonly());
		}
		
		well.setIs_readonly(wellDetails.getIs_readonly());
		
		return wellRepository.save(well);
	}

	public Well buscarPorId(String well_id) {
	    return wellRepository.findById(well_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Pozo no encontrado con id: " + well_id));
	}

	public List<Well> buscarPorNombre(String name) {
		return wellRepository.findByWellCommonName(name);
	}

	public List<Well> listarTodos() {
		return wellRepository.findAll();
	}

}
