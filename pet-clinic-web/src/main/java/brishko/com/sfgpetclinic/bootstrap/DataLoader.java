package brishko.com.sfgpetclinic.bootstrap;

import brishko.com.sfgpetclinic.model.*;
import brishko.com.sfgpetclinic.services.OwnerService;
import brishko.com.sfgpetclinic.services.PetTypeService;
import brishko.com.sfgpetclinic.services.SpecialtiesService;
import brishko.com.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//because we're marking as a component, it becomes spring bean
// spring boot will execute this on boot
// and call the run method
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dogType = new PetType();
        dogType.setName("Dog");
        petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("Cat");
        petTypeService.save(catType);

        PetType birdType = new PetType();
        birdType.setName("Bird");
        petTypeService.save(birdType);

        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Snow");
        owner.setAddress("Address 1");
        owner.setCity("City 1");
        owner.setTelephone("5556667777");

        Pet dog = new Pet();
        dog.setName("Johny");
        dog.setPetType(dogType);
        dog.setOwner(owner);
        dog.setBirthDate(LocalDate.now());
        owner.getPets().add(dog);

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ed");
        owner2.setLastName("Stark");
        owner2.setAddress("Address 2");
        owner2.setCity("City 2");
        owner2.setTelephone("5556667777");

        Pet cat = new Pet();
        cat.setName("Siva");
        cat.setPetType(catType);
        cat.setOwner(owner2);
        cat.setBirthDate(LocalDate.now());
        owner2.getPets().add(cat);

        Pet cat2 = new Pet();
        cat2.setName("Zelda");
        cat2.setPetType(catType);
        cat2.setOwner(owner2);
        cat2.setBirthDate(LocalDate.now());
        owner2.getPets().add(cat2);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Arya");
        owner3.setLastName("Stark");
        owner3.setAddress("Address 3");
        owner3.setCity("City 3");
        owner3.setTelephone("5556667777");

        Pet bird = new Pet();
        bird.setName("Parrot");
        bird.setBirthDate(LocalDate.now());
        bird.setPetType(birdType);
        bird.setOwner(owner3);
        owner3.getPets().add(bird);

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Robert");
        owner4.setLastName("Baratheon");
        owner4.setAddress("Address 4");
        owner4.setCity("City 4");
        owner4.setTelephone("5556667777");

        Pet dog4 = new Pet();
        dog4.setName("Mayhem");
        dog4.setPetType(dogType);
        dog4.setOwner(owner4);
        dog4.setBirthDate(LocalDate.now());
        owner4.getPets().add(dog);

        ownerService.save(owner4);

        System.out.println("Saving Owners data...");

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        specialtiesService.save(dentistry);

        Vet vet = new Vet();
        vet.setFirstName("Jack");
        vet.setLastName("Sparrow");
        vet.getSpecialties().add(radiology);
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Tony");
        vet2.setLastName("Stark");
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Steve");
        vet3.setLastName("Rogers");
        vet3.getSpecialties().add(dentistry);
        vetService.save(vet3);

        System.out.println("Saving Vets data...");

        for (Owner o : ownerService.findAll()) {
            System.out.print("Owner = " + o.getFirstName() + " " + o.getLastName());
            System.out.print(" | Pets: ");
            for (Pet p : o.getPets()) {
                System.out.print(p.getPetType().getName() + " - " + p.getName() + " | ");
            }
            System.out.println();
        }

        for(Vet v: vetService.findAll()) {
            System.out.print("Vet "+v.getFirstName() + " | specailties = ");
            for(Specialty s: v.getSpecialties()) {
                System.out.print(s.getDescription()+", ");
            }
            System.out.println();
        }
    }
}
