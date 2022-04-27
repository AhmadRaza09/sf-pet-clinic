package ahmad.sf.sfpetclinic.services;

import ahmad.sf.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

     Owner findByLastName(String lastName);
}
