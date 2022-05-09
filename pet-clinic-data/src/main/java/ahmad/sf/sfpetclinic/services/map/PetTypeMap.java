package ahmad.sf.sfpetclinic.services.map;


import ahmad.sf.sfpetclinic.model.PetType;
import ahmad.sf.sfpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMap extends AbstractMapService<PetType, Long> implements PetTypeService {


    @Override
    public Set<PetType> findAll() {
        return super.findALL();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}