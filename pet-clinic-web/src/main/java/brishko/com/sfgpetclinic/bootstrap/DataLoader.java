package brishko.com.sfgpetclinic.bootstrap;

import brishko.com.sfgpetclinic.model.Owner;
import brishko.com.sfgpetclinic.model.Vet;
import brishko.com.sfgpetclinic.services.OwnerService;
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

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        //region Owner Data
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("John");
        owner.setLastName("Snow");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ed");
        owner2.setLastName("Stark");

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Arya");
        owner3.setLastName("Stark");

        Owner owner4 = new Owner();
        owner4.setId(4L);
        owner4.setFirstName("Robert");
        owner4.setLastName("Baratheon");

        ownerService.save(owner);
        ownerService.save(owner2);
        ownerService.save(owner3);
        ownerService.save(owner4);
        //endregion

        System.out.println("Saving Owners data...");

        //region Vet Data
        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Jack");
        vet.setLastName("Sparrow");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Tony");
        vet2.setLastName("Stark");

        Vet vet3 = new Vet();
        vet3.setId(3L);
        vet3.setFirstName("Steve");
        vet3.setLastName("Rogers");

        vetService.save(vet);
        vetService.save(vet2);
        vetService.save(vet3);
        //endregion

        System.out.println("Saving Vets data...");
    }
}
