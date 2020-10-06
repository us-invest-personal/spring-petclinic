package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Disease;
import org.springframework.samples.petclinic.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {
	
	@Autowired
	DiseaseRepository diseaseRepo;
	
	public Collection<Disease> findAll(){
		return diseaseRepo.findAll();
	}
}
