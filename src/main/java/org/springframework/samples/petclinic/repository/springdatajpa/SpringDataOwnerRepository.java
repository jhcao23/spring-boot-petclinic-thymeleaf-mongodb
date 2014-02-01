package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;

public interface SpringDataOwnerRepository extends OwnerRepository, Repository<Owner, Integer> {

}
