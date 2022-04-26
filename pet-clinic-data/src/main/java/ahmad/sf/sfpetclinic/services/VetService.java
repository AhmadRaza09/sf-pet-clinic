package ahmad.sf.sfpetclinic.services;

import ahmad.sf.sfpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findALL();
}
