package ahmad.sf.sfpetclinic.services;

import ahmad.sf.sfpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

     Owner findByLastName(String lastName);

     List<Owner> findAllByLastNameLike(String lastName);
}
