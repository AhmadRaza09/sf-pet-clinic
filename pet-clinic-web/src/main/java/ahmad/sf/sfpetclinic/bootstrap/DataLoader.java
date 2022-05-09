package ahmad.sf.sfpetclinic.bootstrap;

import ahmad.sf.sfpetclinic.model.Owner;
import ahmad.sf.sfpetclinic.model.Pet;
import ahmad.sf.sfpetclinic.model.PetType;
import ahmad.sf.sfpetclinic.model.Speciality;
import ahmad.sf.sfpetclinic.model.Vet;
import ahmad.sf.sfpetclinic.services.OwnerService;
import ahmad.sf.sfpetclinic.services.PetTypeService;
import ahmad.sf.sfpetclinic.services.SpecialityService;
import ahmad.sf.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Ahmad");
        owner1.setLastName("Raza");
        owner1.setAddress("123");
        owner1.setCity("Multan");
        owner1.setTelephone("12345");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Ahmad");
        owner2.setLastName("Fareed");
        owner2.setAddress("1234");
        owner2.setCity("Lahore");
        owner2.setTelephone("1234556");

        Pet FionasCat = new Pet();
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner2);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Just Cat");

        owner2.getPets().add(mikesPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Vet Ahmad");
        vet1.setLastName("Raza");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Vet Ahmad");
        vet2 .setLastName("Fareed");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets......");
    }
}
