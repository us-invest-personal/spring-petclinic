package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Diagnose;
import org.springframework.samples.petclinic.repository.DiagnoseRepository;
import org.springframework.stereotype.Service;

@Service
public class DiagnoseService {
	@Autowired
	private DiagnoseRepository repo;
	
	
	public Collection<Diagnose> findAll(){
		return repo.findAll();
	}
	
	public Collection<Diagnose> findByPetIde(int petId){
		return repo.findByPetId(petId);
	}

}
