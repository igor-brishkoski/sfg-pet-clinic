package brishko.com.sfgpetclinic.bootstrap;

import brishko.com.sfgpetclinic.model.Owner;
import brishko.com.sfgpetclinic.model.PetType;
import brishko.com.sfgpetclinic.model.Vet;
import brishko.com.sfgpetclinic.services.OwnerService;
import brishko.com.sfgpetclinic.services.PetTypeService;
import brishko.com.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//because we're marking as a component, it becomes spring bean
// spring boot will execute this on boot
// and call the run method
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
        createPetTypes();
        createOwners();
        createVets();
    }

    //region Description
    private void createPetTypes() {
        PetType p1 = new PetType();
        p1.setName("Dog");
        petTypeService.save(p1);

        PetType p2 = new PetType();
        p2.setName("Cat");
        petTypeService.save(p2);

        PetType p3 = new PetType();
        p3.setName("Bird");
        petTypeService.save(p3);
    }
    //endregion

    //region Owner Data
    private void createOwners() {

        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Snow");

        Owner owner2 = new Owner();
        owner2.setFirstName("Ed");
        owner2.setLastName("Stark");

        Owner owner3 = new Owner();
        owner3.setFirstName("Arya");
        owner3.setLastName("Stark");

        Owner owner4 = new Owner();
        owner4.setFirstName("Robert");
        owner4.setLastName("Baratheon");

        ownerService.save(owner);
        ownerService.save(owner2);
        ownerService.save(owner3);
        ownerService.save(owner4);

        System.out.println("Saving Owners data...");
    }
    //endregion

    //region Vet Data
    private void createVets() {
        Vet vet = new Vet();
        vet.setFirstName("Jack");
        vet.setLastName("Sparrow");

        Vet vet2 = new Vet();
        vet2.setFirstName("Tony");
        vet2.setLastName("Stark");

        Vet vet3 = new Vet();
        vet3.setFirstName("Steve");
        vet3.setLastName("Rogers");

        vetService.save(vet);
        vetService.save(vet2);
        vetService.save(vet3);

        System.out.println("Saving Vets data...");
    }
    //endregion
}
