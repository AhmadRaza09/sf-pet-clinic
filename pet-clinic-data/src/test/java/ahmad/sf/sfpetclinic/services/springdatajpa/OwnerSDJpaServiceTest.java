package ahmad.sf.sfpetclinic.services.springdatajpa;

import ahmad.sf.sfpetclinic.model.Owner;
import ahmad.sf.sfpetclinic.repositories.OwnerRepository;
import ahmad.sf.sfpetclinic.repositories.PetRepository;
import ahmad.sf.sfpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Ahmad";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();

        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        Mockito.when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> ownerSet = ownerSDJpaService.findAll();

        assertNotNull(ownerSet);

        assertEquals(2, ownerSet.size());
    }

    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        Mockito.when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner owner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(owner);

        Mockito.verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);

        Mockito.verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);

        Mockito.verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        Mockito.when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner ahmad = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, ahmad.getLastName());

        Mockito.verify(ownerRepository).findByLastName(any());
    }
}