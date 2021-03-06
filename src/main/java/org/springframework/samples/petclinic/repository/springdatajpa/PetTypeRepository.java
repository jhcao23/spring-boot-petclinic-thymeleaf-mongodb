package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.jpa.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Integer> {


    /**
     * Retrieve all <code>PetType</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>PetType</code>s
     */
//    List<PetType> findPetTypes() throws DataAccessException;

}
