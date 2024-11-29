package com.halliburton.edm_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.halliburton.edm_api.model.Well;
import com.halliburton.edm_api.service.WellService;

@RestController
@RequestMapping("/api/v1/well")
public class WellController {
	
	@Autowired
	private WellService wellService; 
	
	@GetMapping
	public List<Well> listarPozos(){
		return wellService.listarTodos();
	}
	
	@GetMapping("/{well_id}")
	public Well obtenerPozoPorId(String well_id){
		return wellService.buscarPorId(well_id);
	}
	
	@GetMapping("/name/{well_name}")
	public List<Well> obtenerPozosPorNombre(String well_name){
		return wellService.buscarPorNombre(well_name);
	}

}
