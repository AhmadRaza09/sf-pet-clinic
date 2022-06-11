package ahmad.sf.sfpetclinic.repositories;

import ahmad.sf.sfpetclinic.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    @Query("SELECT DISTINCT owner FROM Owner owner left join  owner.pets WHERE owner.lastName LIKE :lastName% ")
    @Transactional(readOnly = true)
    List<Owner> findAllByLastNameLike(String lastName);
}
