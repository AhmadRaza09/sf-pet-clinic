package ahmad.sf.sfpetclinic.services.map;

import ahmad.sf.sfpetclinic.model.Pet;
import ahmad.sf.sfpetclinic.services.CrudService;
import ahmad.sf.sfpetclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findALL();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
