package ahmad.sf.sfpetclinic.services.map;

import ahmad.sf.sfpetclinic.model.Vet;
import ahmad.sf.sfpetclinic.services.CrudService;

import java.util.Set;

public class VerServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findALL();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
