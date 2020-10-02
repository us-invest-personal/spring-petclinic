package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "diseases")
public class Disease extends NamedEntity{
	@Column(length=1024)     // Needed in some environments for strings longer than 255 characters
	private String description; 
}
