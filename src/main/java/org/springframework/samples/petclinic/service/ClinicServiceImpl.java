/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.jpa.Owner;
import org.springframework.samples.petclinic.model.jpa.Pet;
import org.springframework.samples.petclinic.model.jpa.PetType;
import org.springframework.samples.petclinic.model.jpa.Vet;
import org.springframework.samples.petclinic.model.jpa.Visit;
import org.springframework.samples.petclinic.model.mongodb.EventLog;
import org.springframework.samples.petclinic.repository.springdatajpa.OwnerRepository;
import org.springframework.samples.petclinic.repository.springdatajpa.PetRepository;
import org.springframework.samples.petclinic.repository.springdatajpa.PetTypeRepository;
import org.springframework.samples.petclinic.repository.springdatajpa.VetRepository;
import org.springframework.samples.petclinic.repository.springdatajpa.VisitRepository;
import org.springframework.samples.petclinic.repository.springdatamongodb.EventLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

/**
 * Mostly used as a facade for all Petclinic controllers
 *
 * @author Michael Isvy
 */
@Service
public class ClinicServiceImpl implements ClinicService {
	
	private PetRepository petRepository;
	private PetTypeRepository petTypeRepository;
	private VetRepository vetRepository;
	private OwnerRepository ownerRepository;	
	private VisitRepository visitRepository;
	@Autowired
	private EventLogRepository eventLogRepository;

	@Autowired
	public ClinicServiceImpl(PetRepository petRepository, PetTypeRepository petTypeRepository, VetRepository vetRepository, OwnerRepository ownerRepository, VisitRepository visitRepository) {
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
		this.vetRepository = vetRepository;
		this.ownerRepository = ownerRepository;
		this.visitRepository = visitRepository;
	}

	@Transactional(readOnly=true)
	public Collection<PetType> findPetTypes() throws DataAccessException {
		return Lists.newArrayList(petTypeRepository.findAll());
	}

	@Transactional(readOnly=true)
	public Owner findOwnerById(int id) throws DataAccessException {
		return ownerRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
		eventLogRepository.save(new EventLog("searchOwner::"+lastName, null, new Date()));
		return ownerRepository.findByLastName(lastName);
	}

	@Transactional
	public void saveOwner(Owner owner) throws DataAccessException {		
		ownerRepository.save(owner);
		eventLogRepository.save(new EventLog("saveOwner", null, new Date()));
	}
		
	@Transactional
	public void saveVisit(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}
	
	@Transactional(readOnly=true)
	public Pet findPetById(int id) throws DataAccessException {
		return petRepository.findOne(id);
	}

	@Transactional
	public void savePet(Pet pet) throws DataAccessException {
		petRepository.save(pet);
	}

	@Transactional(readOnly=true)
	public Collection<Vet> findVets() throws DataAccessException {
		return Lists.newArrayList(vetRepository.findAll());		
	}
	
}
