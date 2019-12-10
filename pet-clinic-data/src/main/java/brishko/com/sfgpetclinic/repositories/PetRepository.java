package brishko.com.sfgpetclinic.repositories;

import brishko.com.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
