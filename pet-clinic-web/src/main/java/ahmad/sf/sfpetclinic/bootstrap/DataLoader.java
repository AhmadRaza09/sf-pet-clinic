package ahmad.sf.sfpetclinic.bootstrap;

import ahmad.sf.sfpetclinic.model.Owner;
import ahmad.sf.sfpetclinic.model.PetType;
import ahmad.sf.sfpetclinic.model.Vet;
import ahmad.sf.sfpetclinic.services.OwnerService;
import ahmad.sf.sfpetclinic.services.PetTypeService;
import ahmad.sf.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Ahmad");
        owner1.setLastName("Raza");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Ahmad");
        owner2.setLastName("Fareed");

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Vet Ahmad");
        vet1.setLastName("Raza");

        vetService.save(vet1);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Vet Ahmad");
        vet2 .setLastName("Fareed");

        vetService.save(vet2);

        System.out.println("Loaded Vets......");




    }
}
