package ahmad.sf.sfpetclinic.repositories;

import ahmad.sf.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
