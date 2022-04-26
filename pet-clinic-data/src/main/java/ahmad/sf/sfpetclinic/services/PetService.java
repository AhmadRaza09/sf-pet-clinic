package ahmad.sf.sfpetclinic.services;

import ahmad.sf.sfpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findALL();
}
